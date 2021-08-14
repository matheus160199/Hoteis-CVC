package br.com.cvc.hotels.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.cvc.hotels.dto.HotelDTO;
import br.com.cvc.hotels.dto.QuotationOrderDTO;
import br.com.cvc.hotels.model.Quotation;
import br.com.cvc.hotels.service.HotelService;
import br.com.cvc.hotels.service.QuotationService;
import br.com.cvc.hotels.test.builder.HotelDTOBuilderTest;
import br.com.cvc.hotels.test.builder.QuotationOrderDTOBuilderTest;

@RunWith(MockitoJUnitRunner.class)
public class QuotationServiceTest {

	@Mock
	private QuotationOrderDTO quotationOrderDTO;
	
	@Mock
	private Quotation quotation;
	
	@InjectMocks
	private QuotationService service;

	@Mock
	private HotelService hotelService;
	
	private List<HotelDTO> hotels = new ArrayList<>();
	
	@Before
	public void init() {
		this.hotels.add(new HotelDTOBuilderTest().build());
		this.quotationOrderDTO = new QuotationOrderDTOBuilderTest().build(LocalDate.now(), LocalDate.now().plusDays(1), 2, 1);
	}
	
	@Test
	public void validateNewQuotationByCity() {
		when(hotelService.findHotelsByCity(0)).thenReturn(this.hotels);
		List<Quotation> quotation =  service.newQuotationByCity(this.quotationOrderDTO, 0);
		assertNotNull(quotation);
		assertEquals(0, this.hotels.get(0).getId());
	}
	
	@Test
	public void validateNewQuotationByHotel() {
		when(hotelService.findHotelById(0)).thenReturn(this.hotels);
		Quotation quotation =  service.newQuotationByHotel(this.quotationOrderDTO, 0);
		assertNotNull(quotation);
		assertEquals(0, this.hotels.get(0).getId());
	}
}
