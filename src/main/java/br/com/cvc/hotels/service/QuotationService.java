package br.com.cvc.hotels.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.hotels.dto.QuotationOrderDTO;
import br.com.cvc.hotels.model.Quotation;

@Service
public class QuotationService {

	@Autowired
	private HotelService hotelService;

	public List<Quotation> newQuotationByCity(final QuotationOrderDTO dto, final int cityId) {
		List<Quotation> quotations = new ArrayList<>();
		hotelService.findHotelsByCity(cityId).forEach(h -> {
			quotations.add(new Quotation(h, dto));
		});
		return quotations;
	}

	public Quotation newQuotationByHotel(final QuotationOrderDTO dto, final int hotelId) {
		return new Quotation(hotelService.findHotelById(hotelId).get(0), dto);
	}
}
