package br.com.cvc.hotels.dto;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceDTO {

	@Expose
	private double adult;
	
	@Expose
	private double child;
}
