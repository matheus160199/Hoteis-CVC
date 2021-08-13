package br.com.cvc.hotels.model;

import com.google.gson.annotations.Expose;

import br.com.cvc.hotels.dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceDetail {

	@Expose
	private double pricePerDayAdult;
	
	@Expose
	private double pricePerDayChild;
	
	public PriceDetail() {}

	public PriceDetail(final RoomDTO roomDTO) {
		this.pricePerDayAdult = roomDTO.getPrice().getAdult();
		this.pricePerDayChild = roomDTO.getPrice().getChild();
	}
}
