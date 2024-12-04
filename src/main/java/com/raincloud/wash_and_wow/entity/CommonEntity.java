package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CommonEntity {

    @Column(name = "entity_id", nullable = false)
    private int entityId;

    public CommonEntity() {
    }

    public CommonEntity(int entityId) {
        this.entityId = entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getEntityId() {
        return entityId;
    }

    @Override
    public String toString() {
        return "CommonEntity{" +
                "entityId=" + entityId +
                '}';
    }
}