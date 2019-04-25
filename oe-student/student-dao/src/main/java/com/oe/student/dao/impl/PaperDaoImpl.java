package com.oe.student.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oe.student.dao.PaperDao;
import com.oe.student.entity.Paper;
import com.oe.student.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 学生完成的内容 服务实现类
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
@Repository
public class PaperDaoImpl implements PaperDao {

    @Autowired
    private PaperMapper paperMapper;


    @Override
    public void addPaper(Paper paper) {
        paperMapper.insert(paper);
    }

    @Override
    public void updatePaper(Paper paper) {
        paperMapper.updateById(paper);
    }

    @Override
    public void deletePaper(Long paperId) {
        paperMapper.deleteById(paperId);
    }

    @Override
    public Paper getPaper(Long studentId, Long experimentId) {
        LambdaQueryWrapper<Paper> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Paper::getExperimentId, experimentId)
                .eq(Paper::getStudentId, studentId)
                .gt(Paper::getExperimentStatus, -1);
        return paperMapper.selectOne(wrapper);
    }
}
