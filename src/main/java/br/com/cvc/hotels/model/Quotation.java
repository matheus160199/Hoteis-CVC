package br.com.cvc.hotels.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import br.com.cvc.hotels.dto.HotelDTO;
import br.com.cvc.hotels.dto.QuotationOrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quotation {

	@Expose
	private int id;
	
	@Expose
	private String city;
	
	@Expose
	private String name;
	
	@Expose
	private List<Room> rooms = new ArrayList<>();
	
	public Quotation() {}
	
	public Quotation(final HotelDTO hotel, final QuotationOrderDTO quotation) {
		this.id = hotel.getId();
		this.city = hotel.getCityName();
		this.name = hotel.getName();
		hotel.getRooms().forEach(r -> {
			this.rooms.add(new Room(r, quotation));
		});
	}
}
