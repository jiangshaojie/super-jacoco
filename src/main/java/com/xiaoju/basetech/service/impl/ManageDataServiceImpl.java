package com.xiaoju.basetech.service.impl;

import com.google.gson.Gson;
import com.xiaoju.basetech.dao.OperationProject;
import com.xiaoju.basetech.dao.OperationProjectVersion;
import com.xiaoju.basetech.dao.OperationProjectVersionRoundsInfo;
import com.xiaoju.basetech.entity.*;
import com.xiaoju.basetech.service.CodeCovService;
import com.xiaoju.basetech.service.ManageDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class ManageDataServiceImpl implements ManageDataService {
    @Autowired
    OperationProject operationProject;
    @Autowired
    OperationProjectVersion operationProjectVersion;
    @Autowired
    OperationProjectVersionRoundsInfo operationProjectVersionRoundsInfo;
    @Autowired
    CodeCovService codeCovService;

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
        ProjectVersionInfo projectVersionInfo1 = operationProjectVersion
                .queryProjectVersionByProjectIdAndVersion(projectVersionInfo.getProjectId(), projectVersionInfo.getVersion());
        if (projectVersionInfo1 != null) {
            return HttpResult.build(false, "版本号已存在", projectVersionInfo1);
        }
        int re = operationProjectVersion.insertProjectVersion(projectVersionInfo.getProjectId(),
                projectVersionInfo.getVersion(), new Timestamp(System.currentTimeMillis()));
        if (re > 0) {
            return HttpResult.success(operationProjectVersion
                    .queryProjectVersionByProjectIdAndVersion(projectVersionInfo.getProjectId(), projectVersionInfo.getVersion()));
        }
        return HttpResult.build(false, "失败");
    }

    @Override
    public HttpResult insertProjectVersionRound(ProjectVersionRoundsInfo projectVersionRoundsInfo) {
        try {
            int re = operationProjectVersionRoundsInfo
                    .insertProjectVersionRound(projectVersionRoundsInfo.getVersionId()
                            , projectVersionRoundsInfo.getRound(), new Timestamp(System.currentTimeMillis()));
            if (re > 0) {
                return HttpResult.success(operationProjectVersionRoundsInfo
                        .queryProjectVersionRoundsByVersionIdAndRoundId(projectVersionRoundsInfo.getVersionId(),
                                projectVersionRoundsInfo.getRound()));
            }
        } catch (Exception e) {
            log.info("失败：", e);
            log.info("{} 添加 {}失败", projectVersionRoundsInfo.getVersionId(), projectVersionRoundsInfo.getRound());
        }
        return HttpResult.build(false, "添加测试轮次失败",
                operationProjectVersionRoundsInfo.queryProjectVersionRoundsByVersionIdAndRoundId(
                        projectVersionRoundsInfo.getVersionId(), projectVersionRoundsInfo.getRound()));
    }

    @Override
    public HttpResult createTask(CreateTaskRequest createTaskRequest) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        createTaskRequest.setUuid(uuid);
        ProjectInfo projectInfo = operationProject.queryProjectByName(createTaskRequest.getProject());
        ProjectVersionInfo projectVersionInfo = operationProjectVersion
                .queryProjectVersionByProjectIdAndVersion(projectInfo.getId(), createTaskRequest.getVersion());
        ProjectVersionRoundsInfo projectVersionRoundsInfo = operationProjectVersionRoundsInfo
                .queryProjectVersionRoundsByVersionIdAndRoundId(projectVersionInfo.getId(),createTaskRequest.getRound());
        if (projectVersionRoundsInfo == null) {
            return HttpResult.build(false, "任务创建失败检查项目版本测试轮次");
        }
        createTaskRequest.setRoundId(projectVersionRoundsInfo.getId());
        EnvCoverRequest envCoverRequest = new Gson().fromJson(new Gson().toJson(createTaskRequest), EnvCoverRequest.class);
        codeCovService.triggerEnvCov(envCoverRequest);
        return HttpResult.success();
    }
}
