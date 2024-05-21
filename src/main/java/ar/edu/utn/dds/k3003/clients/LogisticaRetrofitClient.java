package ar.edu.utn.dds.k3003.clients;

import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LogisticaRetrofitClient {
	@GET("traslados/{id}")
	 Call<TrasladoDTO> get(@Path("id") Long id);
}
