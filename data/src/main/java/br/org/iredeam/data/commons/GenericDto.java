package br.org.iredeam.data.commons;

import java.util.Date;

public abstract  class GenericDto {
    private Long entityId;
    private String createdAt;
    private Date updatedAt;

    private Date deleted;

    protected GenericDto(){
    }

    protected GenericDto(Long entityId, String createdAt, Date updatedAt, Date deleted) {
        this.entityId = entityId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted = deleted;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String  createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
