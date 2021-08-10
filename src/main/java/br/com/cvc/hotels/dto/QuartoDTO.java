package br.com.cvc.hotels.dto;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuartoDTO {

	@Expose
	private int roomID;
	
	@Expose
	private String category;
	
	@Expose
	private PriceDTO price;
}
