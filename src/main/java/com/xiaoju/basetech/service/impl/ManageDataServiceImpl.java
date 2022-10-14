package com.xiaoju.basetech.service.impl;

import com.xiaoju.basetech.dao.OperationProject;
import com.xiaoju.basetech.dao.OperationProjectVersion;
import com.xiaoju.basetech.entity.HttpResult;
import com.xiaoju.basetech.entity.ProjectInfo;
import com.xiaoju.basetech.entity.ProjectVersionInfo;
import com.xiaoju.basetech.service.ManageDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@Slf4j
public class ManageDataServiceImpl implements ManageDataService {
    @Autowired
    OperationProject operationProject;
    @Autowired
    OperationProjectVersion operationProjectVersion;

    @Override
    public HttpResult<Object> insertProject(ProjectInfo projectInfo) {
        int re = operationProject.insertProject(projectInfo.getName(), new Timestamp(System.currentTimeMillis()));
        if (re > 0) {
            return HttpResult.success();
        }
        return HttpResult.build(false, "失败");
    }

    @Override
    public HttpResult<Object> insertProjectVersion(ProjectVersionInfo projectVersionInfo) {

        int re = operationProjectVersion.insertProjectVersion(projectVersionInfo.getProjectId(),
                projectVersionInfo.getVersion(), new Timestamp(System.currentTimeMillis()));
        if (re > 0) {
            return HttpResult.success();
        }
        return HttpResult.build(false, "失败");
    }
}
