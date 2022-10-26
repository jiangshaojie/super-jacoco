package com.xiaoju.basetech.service;

import com.xiaoju.basetech.entity.*;

public interface ManageDataService {
    HttpResult<Object> insertProject(ProjectInfo projectInfo);
    HttpResult<Object> insertProjectVersion(ProjectVersionInfo projectVersionInfo);

    HttpResult insertProjectVersionRound(ProjectVersionRoundsInfo projectVersionRoundsInfo);

    HttpResult createTask(CreateTaskRequest createTaskRequest);

    HttpResult setTestPlanTaskState(TestPlanRequest testPlanRequest);

    HttpResult setTestPlanPause(TestPlanRequest testPlanRequest);

    CoverageReportEntity getEnvCoverResult(TestPlanRequest testPlanRequest);
}
