package com.common.pojo;

import com.common.pojo.entity.Individual;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/4/28.
 */

public class ProductContractIndividual extends BaseModel {
    private Individual individual;

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }
}
