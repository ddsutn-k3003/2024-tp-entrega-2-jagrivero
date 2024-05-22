package ar.edu.utn.dds.k3003.app;
import io.javalin.*;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.edu.utn.dds.k3003.clients.ViandasProxy;
import ar.edu.utn.dds.k3003.clients.LogisticaProxy;
import ar.edu.utn.dds.k3003.controller.ColaboradorController;
import ar.edu.utn.dds.k3003.facades.dtos.Constants;

public class WebApp {
	
	public static void main(String[] args) {
	    ObjectMapper objectMapper = createObjectMapper();
	    var fachada = new Fachada();
	    fachada.setLogisticaProxy(new LogisticaProxy(objectMapper));
	    fachada.setViandasProxy(new ViandasProxy(objectMapper));
	    //TODO VERIFICAR
		Integer port = Integer.parseInt( System.getenv().getOrDefault("port", "8080"));
		Javalin app = Javalin.create().start(port);
		ColaboradorController colaboradorController= new ColaboradorController(fachada);
		System.out.println("La webApp esta en el puerto "+ port + ".");
		app.post("/colaboradores", colaboradorController::agregar);
		app.get("/colaboradores/{id}", colaboradorController::recuperar);
		app.patch("/colaboradores/{id}", colaboradorController::formasDeColaborar);
		app.get("/colaboradores/{id}/puntos", colaboradorController::puntos);
		app.put("/formula", colaboradorController::coeficientes);
	}
	public static ObjectMapper createObjectMapper() {
	    var objectMapper = new ObjectMapper();
	    objectMapper.registerModule(new JavaTimeModule());
	    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    var sdf = new SimpleDateFormat(Constants.DEFAULT_SERIALIZATION_FORMAT, Locale.getDefault());
	    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	    objectMapper.setDateFormat(sdf);
	    return objectMapper;
	 }
}
