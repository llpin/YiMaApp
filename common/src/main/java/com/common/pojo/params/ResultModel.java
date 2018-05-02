package com.common.pojo.params;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linlipin on 18/3/8.
 */

public class ResultModel implements Serializable {
    private String code;
    private String message;

//    Map<String, Object> params = new HashMap<>();
    List<String> errors = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public Map<String, Object> getParams() {
//        return params;
//    }
//
//    public void setParams(Map<String, Object> params) {
//        this.params = params;
//    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
