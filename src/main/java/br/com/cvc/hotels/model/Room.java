package br.com.cvc.hotels.model;

import com.google.gson.annotations.Expose;

import br.com.cvc.hotels.dto.QuotationOrderDTO;
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
	private PriceDetail priceDetail;
	
	public Room() {}
	
	public Room(final RoomDTO room, final QuotationOrderDTO quotation) {
		this.id = room.getRoomID();
		this.categoryName = room.getCategoryName();
		this.priceDetail = new PriceDetail(room, quotation);
		
	}
}
