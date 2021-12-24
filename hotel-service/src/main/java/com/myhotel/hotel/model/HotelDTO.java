package com.myhotel.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
	
	private Integer id;
	private String name;
	private String location;
	private String address;
	private String roomType;
	private Boolean isAvailable;
	private Long cost;
	private String phoneNumber;
	
}
