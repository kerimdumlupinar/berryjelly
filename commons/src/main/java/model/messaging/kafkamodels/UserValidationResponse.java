package model.messaging.kafkamodels;

import java.util.List;

public class UserValidationResponse {
    String requestId;

    List<Long> userIds;
    List<Long> validUserIds;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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
