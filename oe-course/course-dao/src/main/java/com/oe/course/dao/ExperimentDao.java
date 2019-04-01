package com.oe.course.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.course.entity.Experiment;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface ExperimentDao {

    IPage<Experiment> selectExperimentsByCourseId(Long courseId);

    void addExperiment(Experiment experiment);

    void updateExperiment(Experiment experiment);
}
