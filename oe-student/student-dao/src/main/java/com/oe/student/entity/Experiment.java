package com.oe.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public class Experiment implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ID_WORKER)
    private Long experimentId;

    private Long courseId;

    private String experimentTitle;

    /**
     * 实验要求
     */
    private String experimentClaim;

    private String experimentPurpose;

    private String experimentSteps;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getExperimentTitle() {
        return experimentTitle;
    }

    public void setExperimentTitle(String experimentTitle) {
        this.experimentTitle = experimentTitle;
    }

    public String getExperimentClaim() {
        return experimentClaim;
    }

    public void setExperimentClaim(String experimentClaim) {
        this.experimentClaim = experimentClaim;
    }

    public String getExperimentPurpose() {
        return experimentPurpose;
    }

    public void setExperimentPurpose(String experimentPurpose) {
        this.experimentPurpose = experimentPurpose;
    }

    public String getExperimentSteps() {
        return experimentSteps;
    }

    public void setExperimentSteps(String experimentSteps) {
        this.experimentSteps = experimentSteps;
    }
}
