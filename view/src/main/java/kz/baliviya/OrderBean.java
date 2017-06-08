package kz.baliviya;


import kz.baliviya.domain.Order;
import kz.baliviya.domain.Ticket;
import kz.baliviya.ejb.OrdersManagerBean;
import kz.baliviya.ejb.TicketManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class OrderBean implements Serializable {

    @EJB
    private OrdersManagerBean ordersManagerBean;

    @EJB
    private TicketManagerBean ticketManagerBean;

    private Order order;

    private String name;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void createOrder(){
        if (order == null) {
            order = ordersManagerBean.createOrder();
        }
    }

    public void createTicket() {
        ticketManagerBean.createTicket(name, quantity);
    }

    public List<Ticket> getTikets() {
        return ticketManagerBean.getTickets();
    }

    public void addTicket(Ticket ticket) {
        if (order == null) {
            return;
        }
        ordersManagerBean.addToOrder(ticket.getId(),order.getId(),1);
    }

    public List<Ticket> getTicketsInOrder() {
        if (order == null) {
            return Collections.emptyList();
        }

        return ordersManagerBean.getTicketsInOrder(order.getId());
    }
}
