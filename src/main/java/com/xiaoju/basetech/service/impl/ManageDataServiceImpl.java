package com.xiaoju.basetech.service.impl;

import com.xiaoju.basetech.dao.OperationProject;
import com.xiaoju.basetech.dao.OperationProjectVersion;
import com.xiaoju.basetech.dao.OperationProjectVersionRoundsInfo;
import com.xiaoju.basetech.entity.HttpResult;
import com.xiaoju.basetech.entity.ProjectInfo;
import com.xiaoju.basetech.entity.ProjectVersionInfo;
import com.xiaoju.basetech.entity.ProjectVersionRoundsInfo;
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
    @Autowired
    OperationProjectVersionRoundsInfo operationProjectVersionRoundsInfo;

    @Override
    public HttpResult<Object> insertProject(ProjectInfo projectInfo) {
        ProjectInfo projectInfo1 = operationProject.queryProjectByName(projectInfo.getName());
        if (projectInfo1 != null) {
            return HttpResult.build(false, "项目名重复，新增项目失败", projectInfo1);
        }
        int re = operationProject.insertProject(projectInfo.getName(), new Timestamp(System.currentTimeMillis()));
        if (re > 0) {
            return HttpResult.success(operationProject.queryProjectByName(projectInfo.getName()));
        }
        return HttpResult.build(false, "失败");
    }

    @Override
    public HttpResult<Object> insertProjectVersion(ProjectVersionInfo projectVersionInfo) {
        ProjectVersionInfo projectVersionInfo1 = operationProjectVersion.queryProjectVersionByProjectIdAndVersion(projectVersionInfo.getProjectId(), projectVersionInfo.getVersion());
        if (projectVersionInfo1 != null) {
            return HttpResult.build(false, "版本号已存在", projectVersionInfo1);
        }
        int re = operationProjectVersion.insertProjectVersion(projectVersionInfo.getProjectId(),
                projectVersionInfo.getVersion(), new Timestamp(System.currentTimeMillis()));
        if (re > 0) {
            return HttpResult.success(operationProjectVersion.queryProjectVersionByProjectIdAndVersion(projectVersionInfo.getProjectId(), projectVersionInfo.getVersion()));
        }
        return HttpResult.build(false, "失败");
    }

    @Override
    public HttpResult insertProjectVersionRound(ProjectVersionRoundsInfo projectVersionRoundsInfo) {
        try {
            int re = operationProjectVersionRoundsInfo.insertProjectVersionRound(projectVersionRoundsInfo.getVersionId(), projectVersionRoundsInfo.getRoundId(), new Timestamp(System.currentTimeMillis()));
            if (re > 0) {
                return HttpResult.success();
            }
        } catch (Exception e) {
            log.info("{} 添加 {}失败", projectVersionRoundsInfo.getVersionId(), projectVersionRoundsInfo.getRoundId());
        }
        return HttpResult.build(false, "添加测试轮次失败", "检查测试轮次是否存在");
    }
}
