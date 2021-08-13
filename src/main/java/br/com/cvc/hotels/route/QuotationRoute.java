package br.com.cvc.hotels.route;

import static br.com.cvc.hotels.filter.QuotationFilter.validateQuotationOrder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.hotels.dto.QuotationOrderDTO;
import br.com.cvc.hotels.model.Quotation;
import br.com.cvc.hotels.service.QuotationService;

@RestController
@RequestMapping(value = "/quotation", produces = "application/json")
public class QuotationRoute {

	@Autowired
	private QuotationService quotationService;
	
	@GetMapping("/city/new/{cityId}")
	public List<Quotation> newQuotationByCity(@PathVariable(required = true) final int cityId, @RequestBody final QuotationOrderDTO dto) {
		validateQuotationOrder(dto);
		return quotationService.newQuotationByCity(dto, cityId);
	}
	
	@GetMapping("/hotel/new/{hotelId}")
	public Quotation newQuotationByHotel(@PathVariable(required = true) final int hotelId, @RequestBody final QuotationOrderDTO dto) {
		validateQuotationOrder(dto);
		return quotationService.newQuotationByHotel(dto, hotelId);
	}
}
