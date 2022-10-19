package com.xiaoju.basetech.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectVersionRoundsInfo {
    private int id;
    private int versionId;
    private int round;
    private Date createTime;
}
