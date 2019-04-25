package com.oe.student.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.School;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface SchoolService {

    IPage<School> getSchools(School school, Integer current, Integer size);
}
