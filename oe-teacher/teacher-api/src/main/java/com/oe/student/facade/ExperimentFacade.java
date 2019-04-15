package com.oe.student.facade;

import com.oe.student.exception.OeException;
import com.oe.student.vo.ExperimentVo;
import com.oe.student.vo.PageVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface ExperimentFacade {
    PageVo<ExperimentVo> getExperimentsByCourseId(String studentId, String courseId, Integer current, Integer size) throws OeException;
}
