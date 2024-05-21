package ar.edu.utn.dds.k3003.controller;


import java.util.Arrays;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.ColaboradorDTO;
import ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum;
import io.javalin.http.Context;

public class ColaboradorController {
	private final Fachada fachada;
	public ColaboradorController(Fachada fachada) {
		super();
		this.fachada = fachada;
	}	
	//TODO ESTE DE ABAJO
	public void puntos(@NotNull Context contexto) {
		var id = Long.parseLong(contexto.pathParam("id"));
		var puntosCalculados = this.fachada.puntos(id);
	    contexto.json(puntosCalculados);
	} 
	//TODO ESTE DE ABAJO
	
	public void coeficientes(@NotNull Context contexto) {
	        Formula formula = contexto.bodyAsClass(Formula.class);
	        double pesosDonados = Double.parseDouble(formula.pesosDonados);
	        double viandasDistribuidas = Double.parseDouble(formula.viandasDistribuidas);
	        double viandasDonadas = Double.parseDouble(formula.viandasDonadas);
	        double tarjetasRepartidas = Double.parseDouble(formula.tarjetasRepartidas);
	        double heladerasActivas = Double.parseDouble(formula.heladerasActivas);

	        this.fachada.actualizarPesosPuntos(pesosDonados, viandasDistribuidas, viandasDonadas, tarjetasRepartidas, heladerasActivas);
	        contexto.result("Coeficientes actualizados correctamente");
	        contexto.status(200);
	}
	//TODO ESTE DE ABAJO
	public void formasDeColaborar(@NotNull Context contexto) {
		var id = Long.parseLong(contexto.pathParam("id"));
		List<FormaDeColaborarEnum> formasDeColaborarNuevas =Arrays.asList(contexto.bodyAsClass(FormaDeColaborarEnum[].class));
		this.fachada.modificar( id, formasDeColaborarNuevas);
		contexto.result("Formas de colaborar actualizadas correctamente para el id: " + id);
		contexto.status(200);
	}
	public void recuperar(@NotNull Context contexto) {
		var id = Long.parseLong(contexto.pathParam("id"));
		var colaboradorRecuperado = this.fachada.buscarXId(id);
	    contexto.json(colaboradorRecuperado);
	}
	public void agregar(@NotNull Context contexto) {
		var trasladoDTO = this.fachada.agregar(contexto.bodyAsClass(ColaboradorDTO.class));
	    contexto.json(trasladoDTO);
	}
}
