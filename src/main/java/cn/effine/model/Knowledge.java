package cn.effine.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 知识分类 */
public class Knowledge implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String knoName;
	private String englishName;
	private String logoUrl;
	private String bigLogoUrl;
	private String description;
	private int sortIndex;
	private int isOntop;
	private int status;
	private String operationTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKnoName() {
		return knoName;
	}

	public void setKnoName(String knoName) {
		this.knoName = knoName;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getBigLogoUrl() {
		return bigLogoUrl;
	}

	public void setBigLogoUrl(String bigLogoUrl) {
		this.bigLogoUrl = bigLogoUrl;
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

	public int getIsOntop() {
		return isOntop;
	}

	public void setIsOntop(int isOntop) {
		this.isOntop = isOntop;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	/**
	 * englishName.
	 * 
	 * @return the englishName
	 */

	public String getEnglishName() {
		return englishName;
	}

	/**
	 * englishName.
	 * 
	 * @param englishName
	 *            the englishName to set
	 */

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
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