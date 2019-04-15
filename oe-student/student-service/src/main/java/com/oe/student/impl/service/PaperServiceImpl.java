package com.oe.student.impl.service;


import com.oe.student.dao.PaperDao;
import com.oe.student.entity.Paper;
import com.oe.student.service.PaperService;
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
public class PaperServiceImpl  implements PaperService {

    @Autowired
    private PaperDao paperDao;
    @Override
    public void addPaper(Paper paper) {
        paperDao.addPaper(paper);
    }

    @Override
    public void updatePaper(Paper paper) {
        paperDao.updatePaper(paper);
    }

    @Override
    public Paper getPaper(Long studentId, Long experimentId) {
        return paperDao.getPaper(studentId,experimentId);
    }
}
