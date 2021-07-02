package ir.bourna.komeil.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.bourna.komeil.models.Enums.TicketStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    public Ticket() {
    }

    public Ticket(User user , String content){
        this.user = user;
        this.content = content;
        this.ticketStatus = TicketStatus.Question;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
