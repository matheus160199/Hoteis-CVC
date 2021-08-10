package br.com.cvc.hotels.dto;

import java.time.LocalDate;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrcamentoDTO {
	
	@Expose
	private int cityId;
	
	@Expose
	private LocalDate checkInDate;
	
	@Expose
	private LocalDate checkOutDate;
	
	@Expose
	private int numberOfAdults;
	
	@Expose
	private int numberOfChildren;
}
