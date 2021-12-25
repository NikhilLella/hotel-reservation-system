package com.myhotel.guest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.myhotel.guest.exception.GuestServiceException;
import com.myhotel.guest.model.ErrorResponse;
import com.myhotel.guest.model.GuestApiResponse;
import com.myhotel.guest.model.GuestDTO;
import com.myhotel.guest.service.GuestService;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;

@RestController

@Slf4j

public class GuestController implements GuestApi {

	@Autowired
	private GuestService service;

	@Bean
	private Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@Override
	public ResponseEntity<GuestApiResponse<GuestDTO>> addGuest(@Valid GuestDTO body) {
		log.info("POST :inside add Guest method");
		try {
			service.addGuest(body);
			GuestApiResponse<GuestDTO> response = new GuestApiResponse<GuestDTO>(null, HttpStatus.CREATED, null);

			return new ResponseEntity<GuestApiResponse<GuestDTO>>(response, HttpStatus.CREATED);

		} catch (Exception e) {
			throw new GuestServiceException("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<GuestApiResponse<GuestDTO>> findByGuestId(Integer guestId) {
		log.info("GET : Inside find by guest Id");
		try {
			GuestApiResponse<GuestDTO> response = null;
			ErrorResponse error = null;
			GuestDTO dto = service.findByGuestId(guestId);
			if (dto != null) {
				response = new GuestApiResponse<GuestDTO>(dto, HttpStatus.OK, error);

				return new ResponseEntity<GuestApiResponse<GuestDTO>>(response, HttpStatus.OK);
			} else {
				error = new ErrorResponse();
				error.setErrorCode(HttpStatus.NOT_FOUND.value());
				error.setErrorMessage("No Details found. Please enter a valid guest Id");
				response = new GuestApiResponse<GuestDTO>(dto, HttpStatus.NOT_FOUND, error);
				return new ResponseEntity<GuestApiResponse<GuestDTO>>(response, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			throw new GuestServiceException("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@Override
	public ResponseEntity<GuestApiResponse<Void>> deleteGuest(Integer guestId) {
		log.info(" DELETE : Inside delete guest method ");
		try {

			service.deleteGuest(guestId);
			GuestApiResponse<Void> response = new GuestApiResponse<Void>(null, HttpStatus.NO_CONTENT, null);
			return new ResponseEntity<GuestApiResponse<Void>>(response, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new GuestServiceException("Please supply valid guest Id", HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<GuestApiResponse<Void>> updateGuest(@Valid GuestDTO body) {
		log.info("PUT : Inside updat Guest Method");
		try {
			service.updateGuest(body);
			GuestApiResponse<Void> response = new GuestApiResponse<Void>(null, HttpStatus.NO_CONTENT, null);

			return new ResponseEntity<GuestApiResponse<Void>>(response, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new GuestServiceException("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<GuestApiResponse<GuestDTO>> updateGuestbyId(Integer guestId, String name, String proof,
			String stayHistory, String address, Long mobileNumber) {

		try {
			GuestApiResponse<GuestDTO> response = null;
			ErrorResponse error = null;
			GuestDTO dto = service.updateGuestbyId(guestId, name, proof, stayHistory, address, mobileNumber);
			if (dto != null) {
				response = new GuestApiResponse<GuestDTO>(dto, HttpStatus.OK, error);
				return new ResponseEntity<GuestApiResponse<GuestDTO>>(response, HttpStatus.OK);
			} else {
				error = new ErrorResponse();
				error.setErrorCode(HttpStatus.NOT_FOUND.value());
				error.setErrorMessage("No Details matched to update. Please enter a valid guest Id");
				response = new GuestApiResponse<GuestDTO>(dto, HttpStatus.NOT_FOUND, error);
				return new ResponseEntity<GuestApiResponse<GuestDTO>>(response, HttpStatus.NOT_FOUND);

			}
		} catch (Exception e) {

		}
		return null;
	}

	
}
