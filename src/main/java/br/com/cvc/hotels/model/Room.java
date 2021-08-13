package br.com.cvc.hotels.model;

import java.time.Period;

import com.google.gson.annotations.Expose;

import br.com.cvc.hotels.dto.PedidoOrcamentoDTO;
import br.com.cvc.hotels.dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {

	@Expose
	private int id;
	
	@Expose
	private String categoryName;
	
	@Expose
	private double totalPrice;
	
	@Expose
	private PriceDetail priceDetail;
	
	public Room() {}
	
	public Room(final RoomDTO roomDTO, final PedidoOrcamentoDTO pedidoOrcamentoDTO) {
		this.id = roomDTO.getRoomID();
		this.categoryName = roomDTO.getCategoryName();
		this.totalPrice = this.caculateTotalPrice(pedidoOrcamentoDTO, roomDTO);
		this.priceDetail = new PriceDetail(roomDTO);
		
	}
	
	private double caculateTotalPrice(final PedidoOrcamentoDTO pedidoOrcamentoDTO, final RoomDTO roomDTO) { //extrair cada linha para um metodo
		int qtdDays = Period.between(pedidoOrcamentoDTO.getCheckInDate(), pedidoOrcamentoDTO.getCheckOutDate()).getDays();
		double adultTotalPrice = (pedidoOrcamentoDTO.getNumberOfAdults() * roomDTO.getPrice().getAdult()) * qtdDays; //criar metodo para buscar adult direto
		double childTotalPrice = (pedidoOrcamentoDTO.getNumberOfChildren() * roomDTO.getPrice().getChild()) * qtdDays;
		return (adultTotalPrice + childTotalPrice)/0.7; //verificar casas decimais

	}
}
