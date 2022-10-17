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
    @Insert("insert into project_version_rounds_info (version_id ,round_id,create_time) values (#{versionId},#{roundId},#{date})")
    int insertProjectVersionRound(int versionId, int roundId, Date date);

    @Select("select * from project_version_rounds_info")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "version_id", property = "versionId"),
            @Result(column = "round_id", property = "roundId"),
            @Result(column = "create_time", property = "createTime")})
    List<ProjectVersionRoundsInfo> queryProjectVersionRounds();
}
