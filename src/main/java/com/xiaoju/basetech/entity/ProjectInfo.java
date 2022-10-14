package com.xiaoju.basetech.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectInfo {
    private int id;
    private String name;
    private Date createTime;
}
