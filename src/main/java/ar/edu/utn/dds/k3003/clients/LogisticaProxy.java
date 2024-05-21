package ar.edu.utn.dds.k3003.clients;

import ar.edu.utn.dds.k3003.facades.FachadaHeladeras;
import ar.edu.utn.dds.k3003.facades.FachadaLogistica;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.RutaDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;
import ar.edu.utn.dds.k3003.facades.exceptions.TrasladoNoAsignableException;
import io.javalin.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class LogisticaProxy implements FachadaLogistica {

	private final String endpoint;
	private final LogisticaRetrofitClient service;
	public LogisticaProxy(ObjectMapper objectMapper) {
	    var env = System.getenv();
	    this.endpoint = env.getOrDefault("URL_TRASLADOS", "http://localhost:8082/");
	    var retrofit =
	    		new Retrofit.Builder()
	            .baseUrl(this.endpoint)
	            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
	            .build();
	    this.service = retrofit.create(LogisticaRetrofitClient.class);
	}
	
	@Override
	public RutaDTO agregar(RutaDTO ruta) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TrasladoDTO buscarXId(Long trasladoId) {
		Response<TrasladoDTO> execute;
		try {
			execute = service.get(trasladoId).execute();
			if (execute.isSuccessful()) {
			   return execute.body();
			}
			if (execute.code() == HttpStatus.NOT_FOUND.getCode()) {
			   throw new NoSuchElementException("no se encontro el traslado " + trasladoId);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    throw new RuntimeException("Error conectandose con el componente Traslados");
	}
	
	@Override
	public TrasladoDTO asignarTraslado(TrasladoDTO traslado) throws TrasladoNoAsignableException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TrasladoDTO> trasladosDeColaborador(Long colaboradorId, Integer mes, Integer anio) {
		 List<TrasladoDTO> traslados = new ArrayList<>();
	        TrasladoDTO traslado1 = new TrasladoDTO("",1,1);
	        traslado1.setColaboradorId(5L);
	        traslados.add(traslado1);
	        TrasladoDTO traslado2 = new TrasladoDTO("",1,1);
	        traslado2.setColaboradorId(1L);
	        traslados.add(traslado2);
	        TrasladoDTO traslado3 = new TrasladoDTO("",1,1);
	        traslado3.setColaboradorId(2L);
	        traslados.add(traslado3);
	        TrasladoDTO traslado4 = new TrasladoDTO("",1,1);
	        traslado4.setColaboradorId(5L);
	        traslados.add(traslado4);
	        TrasladoDTO traslado5 = new TrasladoDTO("",1,1);
	        traslado5.setColaboradorId(5L);
	        traslados.add(traslado5);
	        TrasladoDTO traslado6 = new TrasladoDTO("",1,1);
	        traslado6.setColaboradorId(6L);
	        traslados.add(traslado6);
	        return traslados.stream().filter(t-> Objects.equals(t.getColaboradorId(), colaboradorId)).toList();
	}
	@Override
	public void setViandasProxy(FachadaViandas fachadaViandas) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void trasladoRetirado(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void trasladoDepositado(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setHeladerasProxy(FachadaHeladeras fachadaHeladeras) {
		// TODO Auto-generated method stub
		
	}
}