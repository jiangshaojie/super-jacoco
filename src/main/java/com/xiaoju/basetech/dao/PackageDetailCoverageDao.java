package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.PackageDetailCoverage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageDetailCoverageDao {
    void insertPackageDetailCoverage(@Param("packageDetailCoverageList") List<PackageDetailCoverage> packageDetailCoverageList);
}
