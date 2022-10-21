package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.PackageDetailCoverage;
import org.apache.ibatis.annotations.Insert;

public interface operationPackageDetailCoverage {
    @Insert("INSERT INTO t_user\n" +
            "        (name, line_coverage, branch_coverage,round_id,,create_time,update_time)\n" +
            "        VALUES\n" +
            "        <foreach collection =\"userList\" item=\"user\" separator =\",\">\n" +
            "            (#{packageDetailCoverage.name}, #{packageDetailCoverage.lineCoverage}" +
            ", #{packageDetailCoverage.branchCoverage}),#{packageDetailCoverage.diffCoverageReportId}," +
            "#{packageDetailCoverage.createTime},#{packageDetailCoverage.updateTime}\n" +
            "        </foreach >")
    void insertPackageDetailCoverage(PackageDetailCoverage packageDetailCoverage);
}
