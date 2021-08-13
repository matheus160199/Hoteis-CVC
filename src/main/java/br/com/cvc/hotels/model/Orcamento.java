package br.com.cvc.hotels.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import br.com.cvc.hotels.dto.HotelDTO;
import br.com.cvc.hotels.dto.PedidoOrcamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Orcamento {

	@Expose
	private int id;
	
	@Expose
	private String city;
	
	@Expose
	private String name;
	
	@Expose
	private List<Room> rooms = new ArrayList<>();
	
	public Orcamento() {}
	
	public Orcamento(final HotelDTO hotelDTO, final PedidoOrcamentoDTO pedidoOrcamentoDTO) {
		this.id = hotelDTO.getId();
		this.city = hotelDTO.getCityName();
		this.name = hotelDTO.getName();
		hotelDTO.getRooms().forEach(r -> {
			this.rooms.add(new Room(r, pedidoOrcamentoDTO));
		});
	}
}
