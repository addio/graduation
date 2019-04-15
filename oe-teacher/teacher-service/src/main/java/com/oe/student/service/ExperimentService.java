package com.oe.student.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.Experiment;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface ExperimentService {
    IPage<Experiment> getExperimentsByCourseId(Long courseId, Integer current, Integer size);
}
