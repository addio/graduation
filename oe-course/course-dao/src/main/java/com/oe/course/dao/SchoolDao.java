package com.oe.course.dao;

import com.oe.course.entity.School;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface SchoolDao {
    School selectSchool(Long schoolId);
}
