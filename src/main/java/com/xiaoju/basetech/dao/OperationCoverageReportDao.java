package com.xiaoju.basetech.dao;

import com.xiaoju.basetech.entity.CoverageReportEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationCoverageReportDao {
    @Select("select * from diff_coverage_report where round_id==#{roundId} and 0<request_status<200}")
    @Results({@Result(id = true, column = "id", property = "id")})
    CoverageReportEntity queryByRoundId(int roundId);

    @Update("update diff_coverage_report set request_status=#{status} where round_id==#{roundId} and 0<request_status<200")
    int updateByRoundId(int id, int status);
}
