package com.common.pojo.entity;

import com.common.base.enums.AuditStateEnum;
import com.common.pojo.PlatformMainType;
import com.common.pojo.entity.KeyPair;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class User extends BaseModel {
    private String globalId;
    private String username;
    private String password;
    private String doPassword;

    private Boolean enabled = false;

    private AuditStateEnum auditState = AuditStateEnum.SUBMITTED;

    private KeyPair keyPair;

    private PlatformMainType platformMainType;

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDoPassword() {
        return doPassword;
    }

    public void setDoPassword(String doPassword) {
        this.doPassword = doPassword;
    }

    public PlatformMainType getPlatformMainType() {
        return platformMainType;
    }

    public void setPlatformMainType(PlatformMainType platformMainType) {
        this.platformMainType = platformMainType;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }
}
