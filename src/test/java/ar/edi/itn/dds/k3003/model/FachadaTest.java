package ar.edi.itn.dds.k3003.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ar.edu.utn.dds.k3003.app.*;
import ar.edu.utn.dds.k3003.facades.FachadaLogistica;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.ColaboradorDTO;
import ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum;
/*import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;
import ar.edu.utn.dds.k3003.model.Colaborador;
import ar.edu.utn.dds.k3003.repositories.ColaboradorMapper;
import ar.edu.utn.dds.k3003.repositories.ColaboradorRepository;
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FachadaTest {

  Fachada fachadaColaborador = new Fachada();
  FachadaViandaTest fachadaViandaTest = new FachadaViandaTest();
  FachadaLogisticaTest fachadaLogisticaTest = new FachadaLogisticaTest();

  @BeforeEach
  void setUp() {

  }

  @Test
  void testSetLogisticaProxy() {
    fachadaColaborador.setLogisticaProxy(fachadaLogisticaTest);
    var result = fachadaColaborador.getFachadaLogistica();
    assertEquals(fachadaLogisticaTest,result);
  }
  @Test
  void testSetViandaProxy(){
    fachadaColaborador.setViandasProxy(fachadaViandaTest);
    var result = fachadaColaborador.getFachadaViandas();
    assertEquals(fachadaViandaTest,result);
  }
  @Test
  void testAgregar(){
    List<FormaDeColaborarEnum> formas = new ArrayList<>();
    formas.add(FormaDeColaborarEnum.TRANSPORTADOR);
    formas.add(FormaDeColaborarEnum.DONADOR);
    formas.add(FormaDeColaborarEnum.TRANSPORTADOR);
    ColaboradorDTO colaboradorDTO = new ColaboradorDTO("Juan Perez", formas);
    var result = fachadaColaborador.agregar(colaboradorDTO);
    assertEquals(colaboradorDTO.getFormas(),result.getFormas());
    assertEquals("Juan Perez",result.getNombre());
  }
  @Test
  void testBuscarXId(){
    List<FormaDeColaborarEnum> formas1 = new ArrayList<>();
    formas1.add(FormaDeColaborarEnum.TRANSPORTADOR);
    ColaboradorDTO colaboradorDTO = new ColaboradorDTO("Diego Maradona", formas1);
    colaboradorDTO = fachadaColaborador.agregar(colaboradorDTO);
    //agrego un colaborador
    formas1.clear();
    formas1.add(FormaDeColaborarEnum.DONADOR);
    colaboradorDTO = new ColaboradorDTO("Lionel Messi", formas1);
    colaboradorDTO = fachadaColaborador.agregar(colaboradorDTO);
    // agrego otro colaborador
    formas1.add(FormaDeColaborarEnum.TRANSPORTADOR);
    colaboradorDTO = new ColaboradorDTO("Angel Di Maria", formas1);
    colaboradorDTO = fachadaColaborador.agregar(colaboradorDTO);
    //agrego otro colaborador, cuyos datos busco corroborar
    var result = fachadaColaborador.buscarXId(4L);
    assertEquals("Angel Di Maria", result.getNombre());
    assertEquals(formas1, result.getFormas());
  }

  @Test
  void testPuntos(){
    //implemento en las fachadas de Vianda y Logistica los metodos viandasDeColaborador y traslados de colaborador
    //la implementacion, retornara una lista de DTOs filtrada por id del colaborador
    //los DTOs y la lista a filtrar se crean dentro de la fachada y se filtran con un filter comun
    //no es la implementación correspondiente, pero la misma excede a este modulo.
    ColaboradorDTO colaboradordto = new ColaboradorDTO("Manuel Rodriguez", new ArrayList<>());
    colaboradordto = fachadaColaborador.agregar(colaboradordto);
    fachadaColaborador.actualizarPesosPuntos(0.5, 1.0,1.5,2.0,5.0);
    fachadaColaborador.setLogisticaProxy(new FachadaLogisticaTest());
    fachadaColaborador.setViandasProxy(new FachadaViandaTest());
    
    var result = fachadaColaborador.puntos(colaboradordto.getId());
    assertEquals(7.5, result); // tengo que hacer el calculo
  }

  @Test
  void testModificar(){
      List<FormaDeColaborarEnum> formas = new ArrayList<>();
      formas.add(FormaDeColaborarEnum.TRANSPORTADOR);
      ColaboradorDTO colaboradorDTO = new ColaboradorDTO("Mario Kempes", formas );
      colaboradorDTO = fachadaColaborador.agregar(colaboradorDTO);
      formas.clear();
      formas.add(FormaDeColaborarEnum.DONADOR);
      fachadaColaborador.modificar(colaboradorDTO.getId(), formas);
      assertEquals(colaboradorDTO.getFormas(),formas);
  }

  @Test
  void testActualizarPesosPuntos(){
    fachadaColaborador.actualizarPesosPuntos(0.8, 12.5,3.4,0.6,5.0);
    assertEquals(fachadaColaborador.getCoeficientePesosDonados(),0.8);
    assertEquals(fachadaColaborador.getCoeficienteViandasDistribuidas(),12.5);
    assertEquals(fachadaColaborador.getCoeficienteViandasDonadas(),3.4);
    assertEquals(fachadaColaborador.getCoeficienteTarjetasRepartidas(),0.6);
    assertEquals(fachadaColaborador.getCoeficienteHeladerasActivas(),5.0);
  }

}
