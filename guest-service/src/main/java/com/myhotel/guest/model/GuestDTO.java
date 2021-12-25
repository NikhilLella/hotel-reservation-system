package com.myhotel.guest.model;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class GuestDTO {
	
	private Integer id;
	@NotNull(message = "name cannot be empty")
	private String name;
	private String proof;
	private String address;
	private String stayHistory;
	private Long mobileNumber;

}
