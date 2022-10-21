package com.xiaoju.basetech.entity;

import lombok.Data;

import java.util.Date;


@Data
public class PackageDetailCoverage {
    private String name;
    private String lineCoverage;
    private String branchCoverage;
    private Date createTime;
    private Date updateTime;
}
