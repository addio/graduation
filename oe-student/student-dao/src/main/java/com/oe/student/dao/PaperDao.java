package com.oe.student.dao;

import com.oe.student.entity.Paper;

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

    void deletePaper(Long paperId);

    Paper getPaper(Long userId, Long experimentId);
}
