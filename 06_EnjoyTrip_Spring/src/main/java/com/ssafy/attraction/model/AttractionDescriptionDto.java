package com.ssafy.attraction.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttractionDescriptionDto {

	private int contentId;
	private String homepage;
	private String overview;
	private String telname;

}
