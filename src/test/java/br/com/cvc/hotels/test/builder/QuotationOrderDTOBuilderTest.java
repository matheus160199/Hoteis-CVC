package br.com.cvc.hotels.test.builder;

import java.time.LocalDate;

import br.com.cvc.hotels.dto.QuotationOrderDTO;

public class QuotationOrderDTOBuilderTest {

	public QuotationOrderDTO build(final LocalDate checkIn, final LocalDate checkOut, final int adults, final int child) {
		return new QuotationOrderDTO(checkIn, checkOut, adults, child);
	}
}
