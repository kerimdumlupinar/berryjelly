package com.berryjelly.ticket_service.model.apimodel;

import java.util.List;

public record TicketAssignmentRequest(String ticketResourceId, List<Long> assignedUserIds) {
}
