package com.common.pojo.entity;

import com.common.base.enums.DirectionTypeEnum;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class IDImage extends BaseModel {
    private FileResource fileResource;
    private DirectionTypeEnum directionType;

    public FileResource getFileResource() {
        return fileResource;
    }

    public void setFileResource(FileResource fileResource) {
        this.fileResource = fileResource;
    }

    public DirectionTypeEnum getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionTypeEnum directionType) {
        this.directionType = directionType;
    }
}
