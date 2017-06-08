package kz.baliviya.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zakaz")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "order")
    private List<TicketInOrder> ticketInOrders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<TicketInOrder> getTicketInOrders() {
        return ticketInOrders;
    }

    public void setTicketInOrders(List<TicketInOrder> ticketInOrders) {
        this.ticketInOrders = ticketInOrders;
    }
}
