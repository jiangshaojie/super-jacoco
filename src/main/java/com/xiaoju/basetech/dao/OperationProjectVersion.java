package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.ProjectInfo;
import com.xiaoju.basetech.entity.ProjectVersionInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OperationProjectVersion {
    @Insert("insert into project_version_info (project_id,version,create_time) values (#{projectId},#{version},#{date})")
    int insertProjectVersion(int projectId, int version, Date date);

    @Select("select * from project_version_info")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "project_id", property = "projectId"),
            @Result(column = "version", property = "version"),
            @Result(column = "create_time", property = "createTime")})
    List<ProjectVersionInfo> queryProjectVersion();

}
