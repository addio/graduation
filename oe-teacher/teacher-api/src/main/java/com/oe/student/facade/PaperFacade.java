package com.oe.student.facade;

import com.oe.student.exception.OeException;
import com.oe.student.vo.PaperVo;

/**
 * <p>
 * 学生完成的内容 服务类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public interface PaperFacade {
    void addPaper(PaperVo paperVo) throws OeException;

    void updatePaper(PaperVo paperVo) throws OeException;

    PaperVo getPaper(String studentId, String experimentId) throws OeException;

}
