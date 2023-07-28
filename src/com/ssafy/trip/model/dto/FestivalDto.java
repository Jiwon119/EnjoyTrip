package com.ssafy.trip.model.dto;

public class FestivalDto {
	
	private Long num;
	private String metropolitanName;
	private String basicOrganicName;
	private String festivalType;
	private String period;
	private String festivalHostingMethod;
	
	public FestivalDto(Long num, String metropolitanName, String basicOrganicName, 
			String festivalType, String period,
			String festivalHostingMethod) {
		super();
		this.num = num;
		this.metropolitanName = metropolitanName;
		this.basicOrganicName = basicOrganicName;
		this.festivalType = festivalType;
		this.period = period;
		this.festivalHostingMethod = festivalHostingMethod;
	}

	/**
	 * @return the num
	 */
	public Long getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(Long num) {
		this.num = num;
	}

	/**
	 * @return the metropolitanName
	 */
	public String getMetropolitanName() {
		return metropolitanName;
	}

	/**
	 * @param metropolitanName the metropolitanName to set
	 */
	public void setMetropolitanName(String metropolitanName) {
		this.metropolitanName = metropolitanName;
	}

	/**
	 * @return the basicOrganicName
	 */
	public String getBasicOrganicName() {
		return basicOrganicName;
	}

	/**
	 * @param basicOrganicName the basicOrganicName to set
	 */
	public void setBasicOrganicName(String basicOrganicName) {
		this.basicOrganicName = basicOrganicName;
	}

	/**
	 * @return the festivalType
	 */
	public String getFestivalType() {
		return festivalType;
	}

	/**
	 * @param festivalType the festivalType to set
	 */
	public void setFestivalType(String festivalType) {
		this.festivalType = festivalType;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @return the festivalHostingMethod
	 */
	public String getFestivalHostingMethod() {
		return festivalHostingMethod;
	}

	/**
	 * @param festivalHostingMethod the festivalHostingMethod to set
	 */
	public void setFestivalHostingMethod(String festivalHostingMethod) {
		this.festivalHostingMethod = festivalHostingMethod;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FestivalDto [num=").append(num).append(", metropolitanName=").append(metropolitanName)
				.append(", basicOrganicName=").append(basicOrganicName).append(", festivalType=").append(festivalType)
				.append(", period=").append(period).append(", festivalHostingMethod=").append(festivalHostingMethod)
				.append("]");
		return builder.toString();
	}
	
}
