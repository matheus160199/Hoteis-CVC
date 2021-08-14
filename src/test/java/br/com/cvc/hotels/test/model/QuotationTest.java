package br.com.cvc.hotels.test.model;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.cvc.hotels.dto.HotelDTO;
import br.com.cvc.hotels.dto.QuotationOrderDTO;
import br.com.cvc.hotels.model.Quotation;
import br.com.cvc.hotels.test.builder.HotelDTOBuilderTest;
import br.com.cvc.hotels.test.builder.QuotationOrderDTOBuilderTest;

@RunWith(MockitoJUnitRunner.class)
public class QuotationTest {

	@Mock
	private HotelDTO hotelDTO;
	
	@Mock
	private QuotationOrderDTO quotationOrderDTO;
	
	@Mock
	private Quotation quotation;
	
	@Before
	public void init() {
		this.hotelDTO = new HotelDTOBuilderTest().build();
		this.quotationOrderDTO = new QuotationOrderDTOBuilderTest().build(LocalDate.now(), LocalDate.now().plusDays(1), 2, 1);
	}
}
