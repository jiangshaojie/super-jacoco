package com.xiaoju.basetech.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectVersionInfo {
    private int id;
    private int projectId;
    private String version;
    private Date createTime;
}
