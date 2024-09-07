package br.org.iredeam.data.commons;

public abstract class GenericDto {
    private Long entityId;
    private String createdAt;


    protected GenericDto() {
    }

    protected GenericDto(Long entityId, String createdAt) {
        this.entityId = entityId;
        this.createdAt = createdAt;

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

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
