package com.oe.student.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 学生完成的内容
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public class PaperVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String paperId;

    private String experimentId;

    private String studentId;

    private String experimentTitle;

    /**
     * 实验要求
     */
    private String experimentClaim;

    private String experimentPurpose;

    private List<StepVo> experimentSteps;

    private String experimentFeeling;

    private Integer experimentStatus;


    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public void setExperimentSteps(List<StepVo> experimentSteps) {
        this.experimentSteps = experimentSteps;
    }

    public String getExperimentFeeling() {
        return experimentFeeling;
    }

    public void setExperimentFeeling(String experimentFeeling) {
        this.experimentFeeling = experimentFeeling;
    }

    public Integer getExperimentStatus() {
        return experimentStatus;
    }

    public void setExperimentStatus(Integer experimentStatus) {
        this.experimentStatus = experimentStatus;
    }
}
