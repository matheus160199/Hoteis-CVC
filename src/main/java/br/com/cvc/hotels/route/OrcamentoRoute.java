package br.com.cvc.hotels.route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.hotels.dto.PedidoOrcamentoDTO;
import br.com.cvc.hotels.model.Orcamento;
import br.com.cvc.hotels.service.OrcamentoService;

@RestController
@RequestMapping(value = "/orcamento", produces = "application/json")
public class OrcamentoRoute {

	@Autowired
	private OrcamentoService orcamentoService;
	
	@GetMapping("/city/new/{cityId}")
	public List<Orcamento> newOrcamentoByCity(@PathVariable(required = true) final int cityId, @RequestBody final PedidoOrcamentoDTO dto) {
		return orcamentoService.newOrcamentoByCity(dto, cityId);
	}
	
	@GetMapping("/hotel/new/{hotelId}")
	public Orcamento newOrcamentoByHotel(@PathVariable(required = true) final int hotelId, @RequestBody final PedidoOrcamentoDTO dto) {
		return orcamentoService.newOrcamentoByHotel(dto, hotelId);
	}
}
