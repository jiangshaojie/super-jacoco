package com.xiaoju.basetech.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.xiaoju.basetech.entity.*;
import com.xiaoju.basetech.job.CodeCoverageScheduleJob;
import com.xiaoju.basetech.service.CodeCovService;
import com.xiaoju.basetech.service.ManageDataService;
import com.xiaoju.basetech.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/manage")
public class ManageDataController {
    @Autowired
    ManageDataService manageDataService;
    @Autowired
    CodeCoverageScheduleJob codeCoverageScheduleJob;
    @Autowired
    CodeCovService codeCovService;

    @RequestMapping(value = "/insertProject")
    @ResponseBody
    public HttpResult<Object> insertProject(@RequestBody String param) {
        ProjectInfo projectInfo = new Gson().fromJson(param, ProjectInfo.class);
        log.info("insertProject req: {}", param);
        HttpResult httpResult = manageDataService.insertProject(projectInfo);
        log.info("insertProject result: {}", new Gson().toJson(httpResult));
        return httpResult;

    }

    @RequestMapping(value = "/insert-project-version")
    @ResponseBody
    public HttpResult<Object> insertProjectVersion(@RequestBody String param) {
        ProjectVersionInfo projectVersionInfo = new Gson().fromJson(param, ProjectVersionInfo.class);
        log.info("insertProject req: {}", param);
        HttpResult httpResult = manageDataService.insertProjectVersion(projectVersionInfo);
        log.info("insertProject result: {}", new Gson().toJson(httpResult));
        return httpResult;

    }

    @RequestMapping(value = "/insert-project-version-round")
    @ResponseBody
    public HttpResult<Object> insertProjectVersionRound(@RequestBody String param) {
        ProjectVersionRoundsInfo projectVersionRoundsInfo = new Gson().fromJson(param, ProjectVersionRoundsInfo.class);
        log.info("insertProject req: {}", param);
        HttpResult httpResult = manageDataService.insertProjectVersionRound(projectVersionRoundsInfo);
        log.info("insertProject result: {}", new Gson().toJson(httpResult));
        return httpResult;

    }

    @RequestMapping(value = "/test-plan-state")
    @ResponseBody
    public HttpResult<Object> setTestPlanState(@RequestBody TestPlanRequest testPlanRequest) {
        HttpResult httpResult = manageDataService.setTestPlanTaskState(testPlanRequest);
        return httpResult;
    }

    @RequestMapping(value = "/test-plan-pause")
    @ResponseBody
    public HttpResult<Object> setTestPlanPause(@RequestBody TestPlanRequest testPlanRequest) {
        HttpResult httpResult = manageDataService.setTestPlanPause(testPlanRequest);
        return httpResult;
    }

    @RequestMapping(value = "/create-task")
    @ResponseBody
    public HttpResult<Object> createTask(@RequestBody CreateTaskRequest createTaskRequest) {
        HttpResult httpResult = manageDataService.createTask(createTaskRequest);
        return httpResult;
    }

    @RequestMapping(value = "/manual-trigger-task")
    @ResponseBody
    public HttpResult<Object> triggerTask(@RequestBody CreateTaskRequest createTaskRequest) {
        codeCoverageScheduleJob.calculateEnvCov();
        return HttpResult.success();
    }

    @RequestMapping(value = "/getEnvCoverResult")
    @ResponseBody
    public HttpResult<Object> getEnvCoverResult(@RequestBody TestPlanRequest testPlanRequest) {
        CoverageReportEntity coverageReport = manageDataService.getEnvCoverResult(testPlanRequest);
        String uuid = coverageReport.getUuid();
        if (uuid == null) {
            return HttpResult.build(false, "任务不存在，请检查请求信息");
        }
        return HttpResult.success(codeCovService.getCoverResult(uuid));
    }
}
