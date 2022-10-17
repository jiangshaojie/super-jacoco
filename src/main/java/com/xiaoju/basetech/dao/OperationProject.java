package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.ProjectInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OperationProject {
    @Insert("insert into project_info (name,create_time) values (#{name},#{date})")
    int insertProject(String name, Date date);

    @Select("select * from project_info")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "create_time", property = "createTime")})
    List<ProjectInfo> queryProject();

    @Select("select * from project_info where name=#{name}")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "create_time", property = "createTime")})
    List<ProjectInfo> queryProjectByName(String name);

}


