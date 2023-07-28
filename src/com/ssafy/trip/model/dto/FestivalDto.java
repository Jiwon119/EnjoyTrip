package com.ssafy.trip.model.dto;

public class FestivalDto {
	
	private Long num;
	private String metropolitanName;
	private String basicOrganicName;
	private String festivalName;
	private String festivalType;
	private String period;
	private String festivalDestination;
	
	public FestivalDto(Long num, String metropolitanName, String basicOrganicName, String festivalName,
			String festivalType, String period, String festivalDestination) {
		super();
		this.num = num;
		this.metropolitanName = metropolitanName;
		this.basicOrganicName = basicOrganicName;
		this.festivalName = festivalName;
		this.festivalType = festivalType;
		this.period = period;
		this.festivalDestination = festivalDestination;
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
	 * @return the festivalName
	 */
	public String getFestivalName() {
		return festivalName;
	}


	/**
	 * @param festivalName the festivalName to set
	 */
	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
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
	 * @return the festivalDestination
	 */
	public String getFestivalDestination() {
		return festivalDestination;
	}


	/**
	 * @param festivalDestination the festivalDestination to set
	 */
	public void setFestivalDestination(String festivalDestination) {
		this.festivalDestination = festivalDestination;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FestivalDto [num=").append(num).append(", metropolitanName=").append(metropolitanName)
				.append(", basicOrganicName=").append(basicOrganicName).append(", festivalName=").append(festivalName)
				.append(", festivalType=").append(festivalType).append(", period=").append(period)
				.append(", festivalDestination=").append(festivalDestination).append("]");
		return builder.toString();
	}
	
	
}
