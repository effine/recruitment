package cn.effine.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 面试 */
public class CorJobReqInvitation implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int corId;
	private int usrId;
	private int jobId;
	private String title;
	private String faceTime;
	private String faceAddress;
	private String faceDetail;
	private String createdTime;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCorId() {
		return corId;
	}

	public void setCorId(int corId) {
		this.corId = corId;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFaceTime() {
		return this.faceTime;
	}

	public void setFaceTime(String faceTime) {
		this.faceTime = faceTime;
	}

	public String getFaceAddress() {
		return this.faceAddress;
	}

	public void setFaceAddress(String faceAddress) {
		this.faceAddress = faceAddress;
	}

	public String getFaceDetail() {
		return this.faceDetail;
	}

	public void setFaceDetail(String faceDetail) {
		this.faceDetail = faceDetail;
	}

	public String getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
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