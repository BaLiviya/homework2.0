package kz.baliviya.ejb;

import kz.baliviya.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class TicketManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Ticket createTicket(String name, int quantity) {
        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setQuantity(quantity);
        entityManager.persist(ticket);

        return ticket;
    }

    public List<Ticket> getTickets() {
        TypedQuery<Ticket> query = entityManager.createQuery("select c from Ticket c",Ticket.class);
        return query.getResultList();
    }
}
