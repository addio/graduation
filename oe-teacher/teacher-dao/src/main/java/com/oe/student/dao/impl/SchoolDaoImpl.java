package com.oe.student.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oe.student.dao.SchoolDao;
import com.oe.student.entity.School;
import com.oe.student.mapper.SchoolMapper;
import org.apache.commons.lang3.StringUtils;
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
public class SchoolDaoImpl implements SchoolDao {
    @Autowired
    private SchoolMapper schoolMapper;


    @Override
    public IPage<School> getSchools(School school, Integer current, Integer size) {

        LambdaQueryWrapper<School> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(school.getSchoolName())) {
            wrapper.like(School::getSchoolName, school.getSchoolName());
        }
        if (school.getSchoolId() != null) {
            wrapper.eq(School::getSchoolId, school.getSchoolId());
        }
        IPage<School> page = new Page<>(current, size);
        return schoolMapper.selectPage(page, wrapper);
    }

}