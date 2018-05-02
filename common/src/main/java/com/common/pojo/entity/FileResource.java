package com.common.pojo.entity;

import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/4/27.
 */

public class FileResource extends BaseModel {
    private String name;
    private String url;
    private String contentType;
    private String md5Hex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMd5Hex() {
        return md5Hex;
    }

    public void setMd5Hex(String md5Hex) {
        this.md5Hex = md5Hex;
    }
}
