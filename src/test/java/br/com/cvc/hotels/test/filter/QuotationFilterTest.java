package br.com.cvc.hotels.test.filter;

import java.time.LocalDate;

import static br.com.cvc.hotels.filter.QuotationFilter.validateQuotationOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import br.com.cvc.hotels.dto.QuotationOrderDTO;
import br.com.cvc.hotels.test.builder.QuotationOrderDTOBuilderTest;

@RunWith(MockitoJUnitRunner.class)
public class QuotationFilterTest {
	
	@Mock
	private QuotationOrderDTO quotationOrderDTO;
	
	@Test(expected = ResponseStatusException.class)
	public void validateCheckoutBeforeCheckIn() {
		this.quotationOrderDTO = new QuotationOrderDTOBuilderTest().build(LocalDate.now(), LocalDate.now().minusDays(1), 2, 1);
		validateQuotationOrder(quotationOrderDTO);
	}
	
	@Test(expected = ResponseStatusException.class)
	public void validateCheckoutEqualCheckIn() {
		this.quotationOrderDTO = new QuotationOrderDTOBuilderTest().build(LocalDate.now(), LocalDate.now(), 2, 1);
		validateQuotationOrder(quotationOrderDTO);
	}
	
	@Test(expected = ResponseStatusException.class)
	public void validateInvalidNumberOfAdults() {
		this.quotationOrderDTO = new QuotationOrderDTOBuilderTest().build(LocalDate.now(), LocalDate.now().plusDays(1), 0, 1);
		validateQuotationOrder(quotationOrderDTO);
	}
	
	@Test(expected = ResponseStatusException.class)
	public void validateNegativeNumberOfPeople() {
		this.quotationOrderDTO = new QuotationOrderDTOBuilderTest().build(LocalDate.now(), LocalDate.now().plusDays(1), -1, -1);
		validateQuotationOrder(quotationOrderDTO);
	}
}
