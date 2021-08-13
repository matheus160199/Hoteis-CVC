package br.com.cvc.hotels.filter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.cvc.hotels.dto.QuotationOrderDTO;

@Component
public class QuotationFilter {

	public static void validateQuotationOrder(final QuotationOrderDTO dto) {
		
		if (dto.getCheckOutDate().isBefore(dto.getCheckInDate()) || dto.getCheckOutDate().isEqual(dto.getCheckInDate()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Submit a valid date!");
		if (dto.getNumberOfAdults() <= 0 || dto.getNumberOfChildren() < 0) 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Submit a number of people!");
	}
}
