package br.com.cvc.hotels.service;

import static br.com.cvc.hotels.config.RetrofitUtil.createRepository;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.cvc.hotels.dto.HotelDTO;
import br.com.cvc.hotels.repository.CvcAPIRepository;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class HotelService {
	
	public List<HotelDTO> findHotelsByCity(final int cityId) {
		Call<List<HotelDTO>> call = createRepository("https://cvcbackendhotel.herokuapp.com", CvcAPIRepository.class).findHotelsByCity(cityId);
		Response<List<HotelDTO>> response = request(call);
		verifyIfHotelExists(response);
		return response.body();
	}

	public List<HotelDTO> findHotelById(final int hotelId) {
		Call<List<HotelDTO>> call = createRepository("https://cvcbackendhotel.herokuapp.com", CvcAPIRepository.class).findHotelById(hotelId);
		Response<List<HotelDTO>> response = request(call);
		verifyIfHotelExists(response);
		return response.body();
	}

	private Response<List<HotelDTO>> request(Call<List<HotelDTO>> call) {
		try {
			return call.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void verifyIfHotelExists(final Response<List<HotelDTO>> response) {
		if (response.body().isEmpty()) //isPresent
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}
}
