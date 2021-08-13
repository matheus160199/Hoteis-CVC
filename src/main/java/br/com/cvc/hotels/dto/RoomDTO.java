package br.com.cvc.hotels.dto;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomDTO {

	@Expose
	private int roomID;
	
	@Expose
	private String categoryName;
	
	@Expose
	private PriceDTO price;
	
	public double getAdultPrice() {
		return this.getPrice().getAdult();
	}
	
	public double getChildPrice() {
		return this.getPrice().getChild();
	}
}
