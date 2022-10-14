package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.ProjectInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationProject {
    @Insert("insert into project_info (name) values (#{name})")
    int insertProject(String name);

    @Select("select * from project_info")
    List<ProjectInfo> queryProject();

}
