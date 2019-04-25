package com.oe.student.impl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.dao.ExperimentDao;
import com.oe.student.entity.Experiment;
import com.oe.student.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Service
public class ExperimentServiceImpl implements ExperimentService {

    @Autowired
    private ExperimentDao experimentDao;

    @Override
    public IPage<Experiment> getExperimentsByCourseId(Long courseId, Integer current, Integer size) {
        return experimentDao.getExperimentsByCourseId(courseId, current, size);
    }

    @Override
    public void deleteExperimentByCourseId(Long courseId) {
        experimentDao.deleteExperimentByCourseId(courseId);
    }

    @Override
    public void addExperiment(Experiment experiment) {
        experimentDao.addExperiment(experiment);
    }

    @Override
    public void updateExperiment(Experiment experiment) {
        experimentDao.updateExperiment(experiment);
    }

    @Override
    public void deleteExperiment(Long experimentId) {
        experimentDao.deleteById(experimentId);
    }

    @Override
    public Experiment getExperimentById(Long experimentId) {
        return experimentDao.getExperimentById(experimentId);
    }


}
