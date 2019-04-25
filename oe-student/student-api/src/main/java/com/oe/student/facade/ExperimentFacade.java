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
    PageVo<ExperimentVo> getStudentExperimentsByCourseId(String studentId, String courseId, Integer current, Integer size) throws OeException;

    PageVo<ExperimentVo> getTeacherExperimentsByCourseId(String courseId, Integer current, Integer size) throws OeException;

    void addExperiment(ExperimentVo experimentVo) throws OeException;

    void updateExperiment(ExperimentVo experimentVo) throws OeException;

    void deleteExperiment(String experimentId) throws OeException;

    ExperimentVo getExperimentAnalysis(String experimentId) throws OeException;


}
