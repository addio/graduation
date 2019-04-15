package com.oe.student.service;


import com.oe.student.entity.Paper;

/**
 * <p>
 * 学生完成的内容 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface PaperService {

    void addPaper(Paper paper);

    void updatePaper(Paper paper);

    Paper getPaper(Long studentId, Long experimentId);
}
