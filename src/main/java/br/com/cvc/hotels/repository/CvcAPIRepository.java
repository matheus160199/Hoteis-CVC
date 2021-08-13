package br.com.cvc.hotels.repository;

import java.util.List;

import br.com.cvc.hotels.dto.HotelDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CvcAPIRepository {

	@GET("/hotels/avail/{city_id}")
	Call<List<HotelDTO>> findHotelsByCity(@Path("city_id") final int cityId);
	
	@GET("/hotels/{hotel_id}")
	Call<List<HotelDTO>> findHotelById(@Path("hotel_id") final int hotelId);

}
