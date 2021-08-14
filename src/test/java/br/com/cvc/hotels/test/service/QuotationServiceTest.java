package br.com.cvc.hotels.test.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.cvc.hotels.dto.HotelDTO;
import br.com.cvc.hotels.dto.QuotationOrderDTO;
import br.com.cvc.hotels.model.Quotation;
import br.com.cvc.hotels.service.QuotationService;

@RunWith(MockitoJUnitRunner.class)
public class QuotationServiceTest {

	@Mock
	private HotelDTO hotelDTO;
	
	@Mock
	private QuotationOrderDTO quotationOrderDTO;
	
	@Mock
	private Quotation quotation;
	
	@InjectMocks
	private QuotationService service;
}
