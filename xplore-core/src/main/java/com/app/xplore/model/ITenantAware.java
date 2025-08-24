package com.app.xplore.model;

public interface ITenantAware {
    String getTenantId();
    void setTenantId(String tenantId);
}
