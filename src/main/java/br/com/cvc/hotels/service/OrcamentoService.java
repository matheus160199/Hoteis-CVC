package br.com.cvc.hotels.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.hotels.dto.PedidoOrcamentoDTO;
import br.com.cvc.hotels.model.Orcamento;

@Service
public class OrcamentoService {

	@Autowired
	private HotelService hotelService;

	public List<Orcamento> newOrcamentoByCity(final PedidoOrcamentoDTO dto, final int cityId) {
		List<Orcamento> orcamentos = new ArrayList<>();
		hotelService.findHotelsByCity(cityId).forEach(h -> {
			orcamentos.add(new Orcamento(h, dto));
		});
		return orcamentos;
	}

	public Orcamento newOrcamentoByHotel(final PedidoOrcamentoDTO dto, final int hotelId) {
		return new Orcamento(hotelService.findHotelById(hotelId).get(0), dto);
	}
}
