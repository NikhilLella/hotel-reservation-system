package com.myhotel.guest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestDTO {
	private Integer id;
	private String name;
	private String proof;
	private String address;
	private String stayHistory;
	private Long mobilenumber;

}
