package com.berryjelly.ticket_service.model.businessobject;

import com.berryjelly.ticket_service.model.businessobject.constants.TicketStatus;

public class TicketBo {

    private String resourceId;
    private AuditMetaDataBo meta;
    private TicketStatus status;
    private String title;
    private String description;
    private Long estimatedEffort;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public AuditMetaDataBo getMeta() {
        return meta;
    }

    public void setMeta(AuditMetaDataBo meta) {
        this.meta = meta;
    }

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
