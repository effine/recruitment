package cn.effine.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 岗位 */
public class CorJob implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int corId;
	private int knoId;
	private int regionId;
	private int educationId;
	private String name;
	private String department;
	private int type;
	private int lowestMonthSalary;
	private int highestMonthSalary;
	private int isTomember;
	private int isFoodPill;
	private String lure;
	private String description;
	private int sortIndex;
	private int status;
	private String publishedTime;
	private String address;
	private String refreshTime;

	public int getId() {
		return id;
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

	public int getKnoId() {
		return knoId;
	}

	public void setKnoId(int knoId) {
		this.knoId = knoId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLowestMonthSalary() {
		return lowestMonthSalary;
	}

	public void setLowestMonthSalary(int lowestMonthSalary) {
		this.lowestMonthSalary = lowestMonthSalary;
	}

	public int getHighestMonthSalary() {
		return highestMonthSalary;
	}

	public void setHighestMonthSalary(int highestMonthSalary) {
		this.highestMonthSalary = highestMonthSalary;
	}

	public int getIsTomember() {
		return isTomember;
	}

	public void setIsTomember(int isTomember) {
		this.isTomember = isTomember;
	}

	public int getIsFoodPill() {
		return isFoodPill;
	}

	public void setIsFoodPill(int isFoodPill) {
		this.isFoodPill = isFoodPill;
	}

	public String getLure() {
		return lure;
	}

	public void setLure(String lure) {
		this.lure = lure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(String refreshTime) {
		this.refreshTime = refreshTime;
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