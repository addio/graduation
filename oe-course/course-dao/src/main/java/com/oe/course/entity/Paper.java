package com.oe.course.entity;

import java.io.Serializable;

/**
 * <p>
 * 学生完成的内容
 * </p>
 *
 * @author wangwenjie
 * @since 2019-04-01
 */
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long paperId;

    private Long experimentId;

    private Long studentId;

    private String experimentTitle;

    /**
     * 实验要求
     */
    private String experimentClaim;

    private String experimentPurpose;

    private String experimentSteps;

    private String experimentFeeling;

    private Integer experimentStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
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

    public String getExperimentSteps() {
        return experimentSteps;
    }

    public void setExperimentSteps(String experimentSteps) {
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
