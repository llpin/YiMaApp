package com.common.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by linlipin on 18/3/8.
 */

public class ContractRequest implements Serializable {
//    private Long draftUserId;
//
//    public Long getDraftUserId() {
//        return draftUserId;
//    }
//
//    public void setDraftUserId(Long draftUserId) {
//        this.draftUserId = draftUserId;
//    }

    Set<String> codeList;

    public ContractRequest() {
        codeList = new HashSet<>();
    }

    public Set<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(Set<String> codeList) {
        this.codeList = codeList;
    }
}
