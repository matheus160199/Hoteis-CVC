package br.com.cvc.hotels.dto;

import java.util.List;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelDTO {

	@Expose
	private int id;
	
	@Expose
	private String name;
	
	@Expose
	private int cityCode;
	
	@Expose
	private String cityName;
	
	@Expose
	private List<RoomDTO> rooms;
}
