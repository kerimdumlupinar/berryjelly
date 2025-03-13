package model.messaging.kafkamodels;

import java.util.List;

public class TicketAssignedV1 {
    String ticketResourceId;
    List<Long> userIds;

    List<Long> validUserIds;

    public String getTicketResourceId() {
        return ticketResourceId;
    }

    public void setTicketResourceId(String ticketResourceId) {
        this.ticketResourceId = ticketResourceId;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public List<Long> getValidUserIds() {
        return validUserIds;
    }

    public void setValidUserIds(List<Long> validUserIds) {
        this.validUserIds = validUserIds;
    }
}
