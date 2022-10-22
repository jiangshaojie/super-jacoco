package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.PackageDetailCoverage;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OperationPackageDetailCoverage {
    @Insert("INSERT INTO coverage_detail_report\n" +
            "        (name, line_coverage, branch_coverage,round_id,,create_time,update_time)\n" +
            "        VALUES\n" +
            "        <foreach collection =\"packageDetailCoverageList\" item=\"packageDetailCoverage\" separator =\",\">\n" +
            "            (#{packageDetailCoverage.name}, #{packageDetailCoverage.lineCoverage}" +
            ", #{packageDetailCoverage.branchCoverage}),#{packageDetailCoverage.diffCoverageReportId}," +
            "#{packageDetailCoverage.createTime},#{packageDetailCoverage.updateTime}\n" +
            "        </foreach >" +
            "ON DUPLICATE KEY UPDATE" +
            "line_coverage=VALUES(line_coverage)" +
            "branch_coverage=VALUES(branch_coverage)" +
            "update_time=VALUES(update_time)")
    void insertPackageDetailCoverage(List<PackageDetailCoverage> packageDetailCoverageList);
}
