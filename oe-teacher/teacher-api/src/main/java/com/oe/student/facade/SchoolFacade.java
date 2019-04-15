package com.oe.student.facade;

import com.oe.student.vo.PageVo;
import com.oe.student.vo.SchoolVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface SchoolFacade {

    PageVo<SchoolVo> getSchools(SchoolVo schoolVo);
}
