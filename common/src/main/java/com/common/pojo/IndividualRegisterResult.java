package com.common.pojo;

import com.common.pojo.params.ResultModel;

/**
 * Created by linlipin on 18/3/11.
 */

public class IndividualRegisterResult extends ResultModel {
    private Long individualId;
    private Long userId;

    public Long getIndividualId() {
        return individualId;
    }

    public void setIndividualId(Long individualId) {
        this.individualId = individualId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
