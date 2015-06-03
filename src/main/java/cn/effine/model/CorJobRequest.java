package cn.effine.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 岗位申请 */
public class CorJobRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int usrId;
	private int jobId;
	private String qualityModel;
	private String skillModel;
	private String applyTime;
	private int status;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsrId() {
		return this.usrId;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getQualityModel() {
		return this.qualityModel;
	}

	public void setQualityModel(String qualityModel) {
		this.qualityModel = qualityModel;
	}

	public String getSkillModel() {
		return this.skillModel;
	}

	public void setSkillModel(String skillModel) {
		this.skillModel = skillModel;
	}

	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}