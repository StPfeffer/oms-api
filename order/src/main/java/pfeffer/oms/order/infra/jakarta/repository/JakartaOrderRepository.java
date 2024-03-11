package pfeffer.oms.order.infra.jakarta.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaChannel;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaChannelRepository;
import pfeffer.oms.order.domain.dtos.OrderDTO;
import pfeffer.oms.order.domain.entities.OrderBO;
import pfeffer.oms.order.domain.exceptions.OrderException;
import pfeffer.oms.order.domain.mappers.OrderMapper;
import pfeffer.oms.order.domain.repositories.IOrderDataBaseRepository;
import pfeffer.oms.order.domain.repositories.IOrderRepository;
import pfeffer.oms.order.infra.jakarta.mappers.JakartaOrderMapper;
import pfeffer.oms.order.infra.jakarta.model.JakartaOrder;

import java.util.List;

@Service
public class JakartaOrderRepository extends SimpleJpaRepository<JakartaOrder, Long> implements IOrderDataBaseRepository, IOrderRepository {

    private final EntityManager em;

    private final JakartaChannelRepository channelRepository;

    @Autowired
    public JakartaOrderRepository(EntityManager em, JakartaChannelRepository channelRepository) {
        super(JakartaOrder.class, em);
        this.em = em;
        this.channelRepository = channelRepository;
    }

    @Override
    public OrderBO persist(OrderBO bo) {
        OrderDTO order = this.findByOrderIdAndChannelId(bo.getOrderId(), bo.getChannelId());

        if (order != null) {
            throw OrderException.ALREADY_EXISTS;
        }

        JakartaOrder entity = JakartaOrderMapper.toEntity(bo);

        this.populateAdditionalAttributes(entity, bo);

        em.persist(entity);
        em.flush();

        return JakartaOrderMapper.toDomain(entity);
    }

    @Override
    public OrderDTO findByOrderIdAndChannelId(String orderId, String channelId) {
        TypedQuery<JakartaOrder> query = em.createQuery("SELECT e FROM JakartaOrder e WHERE e.orderId = :orderId AND e.channel.channelId = :channelId", JakartaOrder.class)
                .setParameter("orderId", orderId)
                .setParameter("channelId", channelId);

        try {
            return OrderMapper.toDTO(JakartaOrderMapper.toDomain(query.getSingleResult()));
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<OrderDTO> listAllByChannelId(String channelId) {
        List<JakartaOrder> orders = this.listAllEntityByChannelId(channelId);

        try {
            return orders.stream()
                    .map(JakartaOrderMapper::toDomain).toList()
                    .stream()
                    .map(OrderMapper::toDTO).toList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<JakartaOrder> listAllEntityByChannelId(String channelId) {
        TypedQuery<JakartaOrder> query = em.createQuery("SELECT e FROM JakartaOrder e WHERE e.channel.channelId = :channelId", JakartaOrder.class)
                .setParameter("channelId", channelId);

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public JakartaOrder findEntityByOrderIdAndChannelId(String orderId, String channelId) {
        return this.findEntityByOrderIdAndChannelId(orderId, channelId, false);
    }

    public JakartaOrder findEntityByOrderIdAndChannelId(String orderId, String channelId, boolean exception) {
        TypedQuery<JakartaOrder> query = em.createQuery("SELECT e FROM JakartaOrder e WHERE e.orderId = :orderId AND e.channel.channelId = :channelId", JakartaOrder.class)
                .setParameter("orderId", orderId)
                .setParameter("channelId", channelId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            if (exception) {
                throw OrderException.NOT_FOUND;
            }

            return null;
        }
    }

    private void populateAdditionalAttributes(JakartaOrder order, OrderBO bo) {
        JakartaChannel channel = channelRepository.findEntityByChannelId(bo.getChannelId(), true);
        order.setChannel(channel);
    }

}
