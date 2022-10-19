package com.xiaoju.basetech.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateTaskRequest extends EnvCoverRequest {
    @NotBlank(message = "project不能为空")
    private String project;
    @NotBlank(message = "version不能为空")
    private String version;
//    @NotBlank(message = "round不能为空")
//    private int roundId;
}
