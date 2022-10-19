package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.ProjectVersionRoundsInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OperationProjectVersionRoundsInfo {
    @Insert("insert into project_version_rounds_info (version_id ,round,create_time) values (#{versionId},#{round},#{date})")
    int insertProjectVersionRound(int versionId, int round, Date date);

    @Select("select * from project_version_rounds_info")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "version_id", property = "versionId"),
            @Result(column = "round", property = "round"),
            @Result(column = "create_time", property = "createTime")})
    List<ProjectVersionRoundsInfo> queryProjectVersionRounds();

    @Select("select * from project_version_rounds_info where version_id=#{versionId} and round=#{round}")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "version_id", property = "versionId"),
            @Result(column = "round", property = "round"),
            @Result(column = "create_time", property = "createTime")})
    ProjectVersionRoundsInfo queryProjectVersionRoundsByVersionIdAndRoundId(int versionId, int round);

    @Select("select * from project_version_rounds_info where version_id=#{versionId}")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "version_id", property = "versionId"),
            @Result(column = "round", property = "round"),
            @Result(column = "create_time", property = "createTime")})
    ProjectVersionRoundsInfo queryProjectVersionRoundsByVersionId(int versionId);
}
