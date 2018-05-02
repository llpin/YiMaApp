package com.common.pojo.entity;

import com.common.pojo.entity.base.RsaModel;

/**
 * Created by linlipin on 18/4/27.
 */

public class OrganizationRsa extends RsaModel {
    private Long organizationId;
    private Organization organization;

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
