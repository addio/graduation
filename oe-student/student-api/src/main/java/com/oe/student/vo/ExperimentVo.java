package com.oe.student.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public class ExperimentVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String experimentId;

    private String courseId;

    private String experimentTitle;

    /**
     * 实验要求
     */
    private String experimentClaim;

    private String experimentAnalysis;

    private String experimentPurpose;

    private List<StepVo> experimentSteps;

    private int experimentStatus;

    public int getExperimentStatus() {
        return experimentStatus;
    }

    public void setExperimentStatus(int experimentStatus) {
        this.experimentStatus = experimentStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
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

    public List<StepVo> getExperimentSteps() {
        return experimentSteps;
    }

    public String getExperimentAnalysis() {
        return experimentAnalysis;
    }

    public void setExperimentAnalysis(String experimentAnalysis) {
        this.experimentAnalysis = experimentAnalysis;
    }

    public void setExperimentSteps(List<StepVo> experimentSteps) {
        this.experimentSteps = experimentSteps;
    }
}
