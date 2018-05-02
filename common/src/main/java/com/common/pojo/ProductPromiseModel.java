package com.common.pojo;

import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/3.
 */

public class ProductPromiseModel extends BaseModel {

    private String theme;
    private String name;
    private String content;
    private Long organizationId;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
