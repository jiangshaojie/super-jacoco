package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.PackageDetailCoverage;
import org.apache.ibatis.annotations.Insert;

public interface operationPackageDetailCoverage {
    @Insert("INSERT INTO t_user\n" +
            "        (id, name, password)\n" +
            "        VALUES\n" +
            "        <foreach collection =\"userList\" item=\"user\" separator =\",\">\n" +
            "            (#{packageDetailCoverage.name}, #{packageDetailCoverage.lineCoverage}" +
            ", #{packageDetailCoverage.branchCoverage})\n" +
            "        </foreach >")
    void insertPackageDetailCoverage(PackageDetailCoverage packageDetailCoverage);
}
