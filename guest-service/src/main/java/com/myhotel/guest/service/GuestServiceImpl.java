package com.myhotel.guest.service;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhotel.guest.entity.Guest;
import com.myhotel.guest.model.GuestDTO;
import com.myhotel.guest.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addGuest(GuestDTO dto) {
		 repository.save(convertToEntity(dto));
	}

	@Override
	public GuestDTO findByGuestId(Integer guestId) {
		Optional<Guest> optional = repository.findById(guestId);
		GuestDTO dto = null;
		if (optional.isPresent()) {
			dto = convertTODTO(optional.get());
			return dto;
		} else
			return dto;

	}

	@Override
	public void deleteGuest(Integer guestId) {
		 repository.deleteById(guestId);

	}

	private Guest convertToEntity(GuestDTO dto) {
		Guest entity = modelMapper.map(dto, Guest.class);
		return entity;

	}

	private GuestDTO convertTODTO(Guest entity) {
		GuestDTO dto = modelMapper.map(entity, GuestDTO.class);
		return dto;
	}

	@Override
	public void updateGuest(@Valid GuestDTO body) {
		repository.save(convertToEntity(body));
		
	}

	@Override
	public GuestDTO updateGuestbyId(Integer guestId, String name, String proof, String stayHistory, String address,
			Long mobileNumber) {
		GuestDTO dto =null;
		Guest entity =null;
		Optional<Guest> optional = repository.findById(guestId);
		if(optional.isPresent()) {
			 entity = new Guest(guestId, name, proof, address, stayHistory, mobileNumber);
			repository.save(entity);
			return convertTODTO(entity);
		}
		else {
			return dto;
		}
		
		
	}

}
