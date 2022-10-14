package com.xiaoju.basetech.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.xiaoju.basetech.entity.HttpResult;
import com.xiaoju.basetech.entity.ProjectInfo;
import com.xiaoju.basetech.entity.ProjectVersionInfo;
import com.xiaoju.basetech.service.ManageDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping(value = "/manage")
public class ManageDataController {
    @Autowired
    ManageDataService manageDataService;

    @RequestMapping(value = "/insertProject")
    @ResponseBody
    public HttpResult<Object> insertProject(@RequestBody String param) {
        ProjectInfo projectInfo = new Gson().fromJson(param, ProjectInfo.class);
        log.info("insertProject req: {}", param);
        HttpResult httpResult = manageDataService.insertProject(projectInfo);
        log.info("insertProject result: {}", httpResult.toString());
        return httpResult;

    }
    @RequestMapping(value = "/insert-project-version")
    @ResponseBody
    public HttpResult<Object> insertProjectVersion(@RequestBody String param) {
        ProjectVersionInfo projectVersionInfo = new Gson().fromJson(param, ProjectVersionInfo.class);
        log.info("insertProject req: {}", param);
        HttpResult httpResult = manageDataService.insertProjectVersion(projectVersionInfo);
        log.info("insertProject result: {}", httpResult.toString());
        return httpResult;

    }
}
