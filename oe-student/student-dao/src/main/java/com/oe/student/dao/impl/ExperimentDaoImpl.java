package com.oe.student.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oe.student.dao.ExperimentDao;
import com.oe.student.entity.Experiment;
import com.oe.student.mapper.ExperimentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Repository
public class ExperimentDaoImpl implements ExperimentDao {

    @Autowired
    private ExperimentMapper experimentMapper;

    @Override
    public IPage<Experiment> getExperimentsByCourseId(Long courseId, Integer current, Integer size) {
        LambdaQueryWrapper<Experiment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Experiment::getCourseId, courseId);
        Page<Experiment> page = new Page<>(current, size);
        return experimentMapper.selectPage(page, wrapper);
    }

    @Override
    public void addExperiment(Experiment experiment) {

    }

    @Override
    public void updateExperiment(Experiment experiment) {

    }
}
