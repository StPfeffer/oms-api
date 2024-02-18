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
import pfeffer.oms.order.domain.dtos.OrderDTO;
import pfeffer.oms.order.domain.entities.OrderBO;
import pfeffer.oms.order.domain.exceptions.OrderException;
import pfeffer.oms.order.domain.mappers.OrderMapper;
import pfeffer.oms.order.domain.repositories.IOrderDataBaseRepository;
import pfeffer.oms.order.domain.repositories.IOrderRepository;
import pfeffer.oms.order.infra.jakarta.mappers.JakartaOrderMapper;
import pfeffer.oms.order.infra.jakarta.model.JakartaOrder;

@Service
public class JakartaOrderRepository extends SimpleJpaRepository<JakartaOrder, Long> implements IOrderDataBaseRepository, IOrderRepository {

    private final EntityManager em;

    private final JakartaLocationRepository locationRepository;

    private final JakartaChannelRepository channelRepository;

    @Autowired
    public JakartaOrderRepository(EntityManager em, JakartaLocationRepository locationRepository, JakartaChannelRepository channelRepository) {
        super(JakartaOrder.class, em);
        this.em = em;
        this.locationRepository = locationRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public OrderBO persist(OrderBO bo) {
        OrderDTO order = this.findOrderByOrderIdAndChannelId(bo.getOrderId(), bo.getChannelId());

        if (order != null) {
            throw new OrderException("There is already a order registered with the provided orderId for the specified channelId", 400);
        }

        JakartaOrder entity = JakartaOrderMapper.toEntity(bo);

        this.populateAdditionalAttributes(entity, bo);

        em.persist(entity);
        em.flush();

        return JakartaOrderMapper.toDomain(entity);
    }

    @Override
    public OrderDTO findOrderByOrderIdAndChannelId(String orderId, String channelId) {
        TypedQuery<JakartaOrder> query = em.createQuery("SELECT e FROM JakartaOrder e WHERE e.orderId = :orderId AND e.channel.channelId = :channelId", JakartaOrder.class)
                .setParameter("orderId", orderId)
                .setParameter("channelId", channelId);

        try {
            return OrderMapper.toDTO(JakartaOrderMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

    private void populateAdditionalAttributes(JakartaOrder order, OrderBO bo) {
        JakartaLocation location = locationRepository.findJakartaLocationByLocationId(bo.getLocationId(), true);
        order.setLocation(location);

        JakartaChannel channel = channelRepository.findJakartaChannelByChannelId(bo.getChannelId(), true);
        order.setChannel(channel);
    }

}
