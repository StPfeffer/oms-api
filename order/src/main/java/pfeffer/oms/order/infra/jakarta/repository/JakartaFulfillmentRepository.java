package pfeffer.oms.order.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaLocation;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaChannelRepository;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaLocationRepository;
import pfeffer.oms.order.domain.dtos.FulfillmentDTO;
import pfeffer.oms.order.domain.entities.FulfillmentBO;
import pfeffer.oms.order.domain.exceptions.FulfillmentException;
import pfeffer.oms.order.domain.mappers.FulfillmentMapper;
import pfeffer.oms.order.domain.repositories.IFulfillmentRepository;
import pfeffer.oms.order.domain.repositories.IFulfillmentDataBaseRepository;
import pfeffer.oms.order.infra.jakarta.mappers.JakartaFulfillmentMapper;
import pfeffer.oms.order.infra.jakarta.model.JakartaFulfillment;
import pfeffer.oms.order.infra.jakarta.model.JakartaOrder;

import java.util.List;

@Service
public class JakartaFulfillmentRepository extends SimpleJpaRepository<JakartaFulfillment, Long> implements IFulfillmentDataBaseRepository, IFulfillmentRepository {

    private final EntityManager em;

    private final JakartaOrderRepository orderRepository;

    private final JakartaChannelRepository channelRepository;

    private final JakartaLocationRepository locationRepository;

    @Autowired
    public JakartaFulfillmentRepository(EntityManager em, JakartaOrderRepository orderRepository, JakartaChannelRepository channelRepository, JakartaLocationRepository locationRepository) {
        super(JakartaFulfillment.class, em);
        this.em = em;
        this.orderRepository = orderRepository;
        this.channelRepository = channelRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public FulfillmentBO persist(FulfillmentBO bo) {
        FulfillmentDTO fulfillment = this.findByOrderIdChannelIdFulfillmentId(bo.getOrderId(), bo.getChannelId(), bo.getFulfillmentId());

        if (fulfillment != null) {
            throw FulfillmentException.ALREADY_EXISTS;
        }

        JakartaFulfillment entity = JakartaFulfillmentMapper.toEntity(bo);

        this.populateAdditionalAttributes(entity, bo);

        em.persist(entity);
        em.flush();

        return JakartaFulfillmentMapper.toDomain(entity);
    }

    @Override
    public FulfillmentDTO findByOrderIdChannelIdFulfillmentId(String orderId, String channelId, String fulfillmentId) {
        TypedQuery<JakartaFulfillment> query = em.createQuery("SELECT e FROM JakartaFulfillment e WHERE e.order.orderId = :orderId AND e.channel.channelId = :channelId AND e.fulfillmentId = :fulfillmentId", JakartaFulfillment.class)
                .setParameter("orderId", orderId)
                .setParameter("channelId", channelId)
                .setParameter("fulfillmentId", fulfillmentId);

        try {
            return FulfillmentMapper.toDTO(JakartaFulfillmentMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<FulfillmentDTO> listAllByOrderIdAndChannelid(String orderId, String channelId) {
        TypedQuery<JakartaFulfillment> query = em.createQuery("SELECT e FROM JakartaFulfillment e WHERE e.order.orderId = :orderId AND e.channel.channelId = :channelId", JakartaFulfillment.class)
                .setParameter("orderId", orderId)
                .setParameter("channelId", channelId);

        try {
            return query.getResultList()
                    .stream()
                    .map(JakartaFulfillmentMapper::toDomain)
                    .toList()
                    .stream()
                    .map(FulfillmentMapper::toDTO)
                    .toList();
        } catch (NoResultException e) {
            return null;
        }
    }

    private void populateAdditionalAttributes(JakartaFulfillment fulfillment, FulfillmentBO bo) {
        JakartaChannel channel = channelRepository.findJakartaChannelByChannelId(bo.getChannelId(), true);
        fulfillment.setChannel(channel);

        JakartaLocation location = locationRepository.findEntityByLocationId(bo.getLocationId(), true);
        fulfillment.setLocation(location);

        JakartaOrder order = orderRepository.findEntityByOrderIdAndChannelId(bo.getOrderId(), bo.getChannelId(), true);
        fulfillment.setOrder(order);
    }

}
