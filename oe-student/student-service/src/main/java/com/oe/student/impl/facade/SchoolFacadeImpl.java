package com.oe.student.impl.facade;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oe.student.entity.School;
import com.oe.student.facade.SchoolFacade;
import com.oe.student.service.SchoolService;
import com.oe.student.vo.PageVo;
import com.oe.student.vo.SchoolVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangwj
 * @data 2019/4/9
 */
@Component
public class SchoolFacadeImpl implements SchoolFacade {

    @Autowired
    private SchoolService schoolService;

    @Override
    public PageVo<SchoolVo> getSchools(SchoolVo schoolVo) {
        School school = new School();
        if (StringUtils.isNotBlank(schoolVo.getSchoolId())) {
            school.setSchoolId(Long.parseLong(schoolVo.getSchoolId()));
        }
        if (StringUtils.isNotBlank(schoolVo.getSchoolName())) {
            school.setSchoolName(schoolVo.getSchoolName());
        }
        IPage<School> page = schoolService.getSchools(school, schoolVo.getCurrent(), schoolVo.getSize());
        PageVo<SchoolVo> pageVo = new PageVo<>();
        pageVo.setSize(page.getSize());
        pageVo.setTotal(page.getTotal());
        pageVo.setCurrent(page.getCurrent());
        List<School> records = page.getRecords();
        List<SchoolVo> nRecords = new ArrayList<>((int) page.getSize());
        records.forEach(e -> {
            SchoolVo vo = new SchoolVo();
            vo.setSchoolId(e.getSchoolId().toString());
            vo.setSchoolName(e.getSchoolName());
            vo.setSchoolInfo(e.getSchoolInfo());
            nRecords.add(vo);
        });
        pageVo.setRecords(nRecords);
        return pageVo;
    }
}
