package br.com.cvc.hotels.test.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.cvc.hotels.dto.HotelDTO;
import br.com.cvc.hotels.dto.PriceDTO;
import br.com.cvc.hotels.dto.RoomDTO;

public class HotelDTOBuilderTest {

	public HotelDTO build() {
		return new HotelDTO(0, "Hotel test", 10, "City test", buildRooms());
	}
	
	private List<RoomDTO> buildRooms(){
		List<RoomDTO> rooms = new ArrayList<>();
		rooms.add(new RoomDTO(0, "Standard", new PriceDTO(100, 50)));
		return rooms;
	}
}
