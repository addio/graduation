package com.oe.course.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.course.entity.Paper;

/**
 * <p>
 * 学生完成的内容 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface PaperDao {
    void addPaper(Paper paper);

    void updatePaper(Paper paper);

    IPage<Paper> selectPaper(Long userId, Long experimentId);
}
