package ir.bourna.komeil.DTO.Response;

import ir.bourna.komeil.models.User;

public class TicketOutSql {

    private User user;
    private long count;

    public TicketOutSql(User user, long count) {
        this.user = user;
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
