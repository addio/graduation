package com.oe.student.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.Experiment;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface ExperimentDao {

    IPage<Experiment> getExperimentsByCourseId(Long courseId, Integer current, Integer size);

    void addExperiment(Experiment experiment);

    void updateExperiment(Experiment experiment);

    void deleteExperimentByCourseId(Long courseId);

    void deleteById(Long id);

    Experiment getExperimentById(Long id);
}
