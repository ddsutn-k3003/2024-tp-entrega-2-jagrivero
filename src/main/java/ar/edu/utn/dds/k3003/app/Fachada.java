package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.facades.FachadaLogistica;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.ColaboradorDTO;
import ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum;
import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;
import ar.edu.utn.dds.k3003.model.Colaborador;
import ar.edu.utn.dds.k3003.repositories.ColaboradorMapper;
import ar.edu.utn.dds.k3003.repositories.ColaboradorRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
@Setter
public class Fachada implements ar.edu.utn.dds.k3003.facades.FachadaColaboradores {
    
    private ColaboradorRepository colaboradorRepository;
    private ColaboradorMapper colaboradorMapper;
    private FachadaViandas fachadaViandas;
    private FachadaLogistica fachadaLogistica;
    private Double coeficientePesosDonados = 0.5;
    private Double coeficienteViandasDistribuidas = 1.0;
    private Double coeficienteViandasDonadas = 1.5;
    private Double coeficienteTarjetasRepartidas = 2.0;
    private Double coeficienteHeladerasActivas = 5.0;

    @Override
    public void setLogisticaProxy(FachadaLogistica fachadaLogistica) {
        this.fachadaLogistica = fachadaLogistica;
    }

    @Override
    public void setViandasProxy(FachadaViandas fachadaViandas) {
        this.fachadaViandas = fachadaViandas;
    }

    public Fachada(){
        this.colaboradorMapper = new ColaboradorMapper();
        this.colaboradorRepository = new ColaboradorRepository();
    }

    @Override
    public ColaboradorDTO agregar(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = new Colaborador(colaboradorDTO.getNombre(),colaboradorDTO.getFormas());
        colaborador = this.colaboradorRepository.save(colaborador);
        return this.colaboradorMapper.map(colaborador);
    }
    
    @Override
    public ColaboradorDTO buscarXId(Long idColaborador) throws NoSuchElementException {
        Colaborador auxiliar = this.colaboradorRepository.findById(idColaborador);
        return this.colaboradorMapper.map(auxiliar);
    }

    @Override
    public Double puntos(Long idColaborador) throws NoSuchElementException {
        //HAY QUE HACER
        Colaborador colaborador = this.colaboradorRepository.findById(idColaborador);
        LocalDateTime tiempo = LocalDateTime.now();
        List<ViandaDTO> viandasDonadas = this.fachadaViandas.viandasDeColaborador(colaborador.getIdColaborador(),/*tiempo.getMonthValue()*/1,tiempo.getYear());//NO SE COMO PONER LO DE LOS MESES Y ANIOS
        List<TrasladoDTO> trasladosRealizados = this.fachadaLogistica.trasladosDeColaborador(colaborador.getIdColaborador(),/*tiempo.getMonthValue()*/1,tiempo.getYear()); // IDEM ANTERIOR
        Double puntos = (Double)(double)viandasDonadas.size()*this.coeficienteViandasDonadas;
        puntos = puntos + (Double)(double)trasladosRealizados.size()* this.coeficienteViandasDistribuidas;
        puntos = puntos + (Double) this.coeficientePesosDonados * 0.0;  
        puntos = puntos + (Double) this.coeficienteTarjetasRepartidas * 0.0; 
        puntos = puntos + (Double) this.coeficienteHeladerasActivas * 1.0 * 0.0;
        return puntos;
        //No tengo en claro de donde sacar lo pesos donados y los meses activos etc
    }

    @Override
    public ColaboradorDTO modificar(Long idColaborador, List<FormaDeColaborarEnum> formasNuevas) throws NoSuchElementException {
        Colaborador auxiliar = this.colaboradorRepository.findById(idColaborador);
        auxiliar.setFormasDeColaborar(formasNuevas);
        return this.colaboradorMapper.map(auxiliar);
    }

    @Override
    public void actualizarPesosPuntos(Double pesosDonados, Double viandasDistribuidas, Double viandasDonadas, Double tarjetasRepartidas, Double heladerasActivas) {
        this.coeficientePesosDonados = pesosDonados;
        this.coeficienteViandasDistribuidas = viandasDistribuidas;
        this.coeficienteViandasDonadas = viandasDonadas;
        this.coeficienteHeladerasActivas = heladerasActivas;
        this.coeficienteTarjetasRepartidas = tarjetasRepartidas;
    }

	public Object getFachadaLogistica() {
		// TODO Auto-generated method stub
		return this.fachadaLogistica;
	}
	public Object getFachadaViandas() {
		// TODO Auto-generated method stub
		return this.fachadaViandas;
	}

	public Double getCoeficientePesosDonados() {
		// TODO Auto-generated method stub
		return this.coeficientePesosDonados;
	}
	public Double getCoeficienteViandasDonadas() {
		// TODO Auto-generated method stub
		return this.coeficienteViandasDonadas;
	}
	public Double getCoeficienteViandasDistribuidas() {
		// TODO Auto-generated method stub
		return this.coeficienteViandasDistribuidas;
	}
	public Double getCoeficienteTarjetasRepartidas() {
		// TODO Auto-generated method stub
		return this.coeficienteTarjetasRepartidas;
	}
	public Double getCoeficienteHeladerasActivas() {
		// TODO Auto-generated method stub
		return this.coeficienteHeladerasActivas;
	}
}
