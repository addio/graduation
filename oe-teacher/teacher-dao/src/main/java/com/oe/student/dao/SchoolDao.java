package com.oe.student.dao;

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
public interface SchoolDao {

    IPage<School> getSchools(School school, Integer current, Integer size);
}
