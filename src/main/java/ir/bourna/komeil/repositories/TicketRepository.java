package ir.bourna.komeil.repositories;

import ir.bourna.komeil.DTO.Response.TicketOutSql;
import ir.bourna.komeil.models.Ticket;
import ir.bourna.komeil.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket , Long> {
    List<Ticket> findAllByUser(User user);
    @Query("SELECT new ir.bourna.komeil.DTO.Response.TicketOutSql(t.user, count (t)) FROM Ticket t GROUP BY t.user.id" )
    List<TicketOutSql> listofTicket();
}
