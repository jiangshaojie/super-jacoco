package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.CoverageReportEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationCoverageReportDao {
    @Select("select * from diff_coverage_report where round_id=#{roundId} and (0<request_status<200 or request_status=300)")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "job_record_uuid", property = "uuid"),
            @Result(column = "giturl", property = "gitUrl"),
            @Result(column = "base_version", property = "baseVersion"),
            @Result(column = "now_version", property = "nowVersion"),
            @Result(column = "type", property = "type"),
            @Result(column = "request_status", property = "requestStatus"),
            @Result(column = "diffmethod", property = "diffMethod"),
            @Result(column = "err_msg", property = "errMsg"),
            @Result(column = "report_url", property = "reportUrl"),
            @Result(column = "line_coverage", property = "lineCoverage"),
            @Result(column = "branch_coverage", property = "branchCoverage"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "now_local_path", property = "nowLocalPath"),
            @Result(column = "base_local_path", property = "baseLocalPath"),
            @Result(column = "sub_module", property = "subModule"),
//            @Result(column = "id", property = "codePath"),
//            @Result(column = "id", property = "envType"),
//            @Result(column = "id", property = "reportFile"),
            @Result(column = "from", property = "from"),
            @Result(column = "log_file", property = "logFile"),
            @Result(column = "round_id", property = "roundId")}
    )
    CoverageReportEntity queryByRoundId(int roundId);

    @Update("update diff_coverage_report set request_status=#{status} where round_id=#{roundId} and 0<request_status<200")
    int updateByRoundId(int roundId, int status);
}
