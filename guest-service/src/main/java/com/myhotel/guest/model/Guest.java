package com.myhotel.guest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="guest_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Guest {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="proof")
	private String proof;
	
	@Column(name="address")
	private String address;
	
	@Column(name="stay_history")
	private String stayHistory;
	
	@Column(name="mobile_no")
	private Long mobileNumber;

	
}
