package com.oe.student.impl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.dao.SchoolDao;
import com.oe.student.entity.School;
import com.oe.student.service.SchoolService;
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
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;


    @Override
    public IPage<School> getSchools(School school, Integer current, Integer size) {
        return schoolDao.getSchools(school, current, size);
    }
}
