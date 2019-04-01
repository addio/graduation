package com.oe.course.service;


import com.oe.course.entity.School;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface SchoolService {

    School selectSchool(Long schoolId);
}
