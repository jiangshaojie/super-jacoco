package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.ProjectVersionRoundsInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationProjectVersionRoundsInfo {
    @Insert("insert into project_version_rounds_info (version ,round) values (#{version},#{round})")
    int insertProjectVersionRound(int version, int round);

    @Select("select * from project_version_rounds_info")
    List<ProjectVersionRoundsInfo> queryProjectVersionRounds();
}
