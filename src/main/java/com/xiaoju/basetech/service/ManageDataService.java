package com.xiaoju.basetech.service;

import com.xiaoju.basetech.entity.HttpResult;
import com.xiaoju.basetech.entity.ProjectInfo;
import com.xiaoju.basetech.entity.ProjectVersionInfo;

public interface ManageDataService {
    HttpResult<Object> insertProject(ProjectInfo projectInfo);
    HttpResult<Object> insertProjectVersion(ProjectVersionInfo projectVersionInfo);
}
