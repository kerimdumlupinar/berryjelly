package com.berryjelly.ticket_service.model.entity;

import com.berryjelly.ticket_service.model.businessobject.constants.TicketStatus;
import jakarta.persistence.*;
import model.entity.BaseEntity;

@Entity
@Table(name = "TICKET")
public class TicketEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    private String title;

    private String description;

    private Long estimatedEffort;


    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEstimatedEffort() {
        return estimatedEffort;
    }

    public void setEstimatedEffort(Long estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }
}
