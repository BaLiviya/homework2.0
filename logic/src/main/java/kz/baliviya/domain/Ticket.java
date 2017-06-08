package kz.baliviya.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "ticket")
    private List<TicketInOrder> ticketInOrders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<TicketInOrder> getTicketInOrders() {
        return ticketInOrders;
    }

    public void setTicketInOrders(List<TicketInOrder> ticketInOrders) {
        this.ticketInOrders = ticketInOrders;
    }
}
