package br.com.cvc.hotels.service;

import static br.com.cvc.hotels.config.RetrofitUtil.createRepository;

import java.io.IOException;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.cvc.hotels.dto.HotelDTO;
import br.com.cvc.hotels.repository.CvcAPIRepository;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class HotelService {
	
	@Cacheable(value = "hotels", key = "#cityId")
	public List<HotelDTO> findHotelsByCity(final int cityId) {
		evictHotelsCache();
		Response<List<HotelDTO>> response = request(createCvcRepository().findHotelsByCity(cityId));
		verifyIfHotelExists(response);
		return response.body();
	}

	@Cacheable(value = "hotels", key = "#hotelId")
	public List<HotelDTO> findHotelById(final int hotelId) {
		evictHotelsCache();
		Response<List<HotelDTO>> response = request(createCvcRepository().findHotelById(hotelId));
		verifyIfHotelExists(response);
		return response.body();
	}
	
	private CvcAPIRepository createCvcRepository() {
		return createRepository("https://cvcbackendhotel.herokuapp.com", CvcAPIRepository.class);
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
		if (response.body().isEmpty())
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}
	
	@CacheEvict(value = "hotels", allEntries = true)
	private void evictHotelsCache(){}
}
