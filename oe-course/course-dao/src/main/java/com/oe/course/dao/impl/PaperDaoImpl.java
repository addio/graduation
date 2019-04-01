package com.oe.course.dao.impl;


import com.oe.course.dao.PaperDao;
import com.oe.course.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生完成的内容 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Service
public class PaperDaoImpl implements PaperDao {

    @Autowired
    private PaperMapper paperMapper;


}
