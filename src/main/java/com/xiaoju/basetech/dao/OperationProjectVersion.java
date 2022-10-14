package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.ProjectInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationProjectVersion {
    @Insert("insert into project_version_info (project_id,version) values (#{projectId,version})")
    int insertProjectVersion(int projectId, int version);

    @Select("select * from project_version_info")
    List<ProjectInfo> queryProjectVersion();

}
