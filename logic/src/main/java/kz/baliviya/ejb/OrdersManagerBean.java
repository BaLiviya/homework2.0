package kz.baliviya.ejb;


import kz.baliviya.domain.Order;
import kz.baliviya.domain.Ticket;
import kz.baliviya.domain.TicketInOrder;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Stateless
@LocalBean
public class OrdersManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Order createOrder() {
        Order order = new Order();
        entityManager.persist(order);

        return order;
    }

    public boolean addToOrder(long ticketId, long orderId, int quantity) {
        Ticket ticket = entityManager.find(Ticket.class, ticketId);
        if (ticket == null) {
            return false;
        }

        Order order = entityManager.find(Order.class, orderId);
        if (order == null) {
            return false;
        }

        TicketInOrder ticketInOrder = new TicketInOrder();
        ticketInOrder.setOrder(order);
        ticketInOrder.setTicket(ticket);
        ticketInOrder.setQuantity(quantity);
        entityManager.persist(ticketInOrder);

        return true;
    }

    public List<Ticket> getTicketsInOrder(long orderId){
        Order order = entityManager.find(Order.class, orderId);
        if (order == null) {
            return Collections.emptyList();
        }

        List<TicketInOrder> ticketInOrders = order.getTicketInOrders();
        List<Ticket> result = new ArrayList<>();
        for (TicketInOrder ticketInOrder: ticketInOrders) {
            result.add(ticketInOrder.getTicket());
        }

        return result;
    }
}
