package com.xiaoju.basetech.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: gaoweiwei_v
 * @time: 2019/7/29 2:29 PM
 */

@Data
public class CoveragePackageReportEntity {

    private Integer id;
    private Integer diffCoverageReportId;
    private String detail;
}