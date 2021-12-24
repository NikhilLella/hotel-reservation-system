package com.myhotel.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Hotel_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "address")
	private String address;
	
	@Column(name="room_type")
	private String roomType;
	
	
	@Column(name = "is_available")
	private Boolean isAvailable;
	
	@Column(name ="price")
	private Long cost;
	
	
	@Column(name ="contact_no")
	private String phoneNumber;
	

}
