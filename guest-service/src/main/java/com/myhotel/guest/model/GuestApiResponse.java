package com.myhotel.guest.model;



import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(Include.NON_NULL)
public class GuestApiResponse<T> {

	private T data;
	private HttpStatus status;
	private ErrorResponse error;
	
}
