package br.com.cvc.hotels.dto;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceDTO {

	@Expose
	private int adult;
	
	@Expose
	private int child;
}
