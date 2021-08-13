package br.com.cvc.hotels.model;

import java.time.Period;

import com.google.gson.annotations.Expose;

import br.com.cvc.hotels.dto.QuotationOrderDTO;
import br.com.cvc.hotels.dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceDetail {
	
	@Expose
	private double totalPrice;

	@Expose
	private double pricePerDayAdult;
	
	@Expose
	private double pricePerDayChild;
	
	public PriceDetail() {}

	public PriceDetail(final RoomDTO room, final QuotationOrderDTO quotation) {
		this.totalPrice = this.caculateTotalPrice(quotation, room);
		this.pricePerDayAdult = room.getAdultPrice();
		this.pricePerDayChild = room.getChildPrice();
	}
	
	private double caculateTotalPrice(final QuotationOrderDTO quotation, final RoomDTO room) { 
		int qtdDays = Period.between(quotation.getCheckInDate(), quotation.getCheckOutDate()).getDays();
		return Math.round((calculateAdultPrice(quotation, room, qtdDays) + calculateChildPrice(quotation, room, qtdDays))/0.7); 
	}

	private double calculateChildPrice(final QuotationOrderDTO quotation, final RoomDTO room, int qtdDays) {
		return (quotation.getNumberOfChildren() * room.getChildPrice()) * qtdDays;
	}

	private double calculateAdultPrice(final QuotationOrderDTO quotation, final RoomDTO room, int qtdDays) {
		return (quotation.getNumberOfAdults() * room.getAdultPrice()) * qtdDays;
	}
}
