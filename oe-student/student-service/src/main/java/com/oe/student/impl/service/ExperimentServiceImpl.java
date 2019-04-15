package com.oe.student.impl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.dao.ExperimentDao;
import com.oe.student.entity.Experiment;
import com.oe.student.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Service
public class ExperimentServiceImpl  implements ExperimentService {

    @Autowired
    private ExperimentDao experimentDao;
    @Override
    public IPage<Experiment> getExperimentsByCourseId(Long courseId, Integer current, Integer size) {
        return experimentDao.getExperimentsByCourseId(courseId, current, size);
    }
}
