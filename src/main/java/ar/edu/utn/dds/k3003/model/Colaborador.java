package ar.edu.utn.dds.k3003.model;

import ar.edu.utn.dds.k3003.facades.dtos.FormaDeColaborarEnum;
import ar.edu.utn.dds.k3003.model.exceptions.SomeDomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ar.edu.utn.dds.k3003.model.exceptions.SomeDomainException;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Colaborador {
    private Long idColaborador = null;
    private String nombreColaborador;
    private List<FormaDeColaborarEnum> formasDeColaborar;
    public Colaborador(String nombreColaborator,List<FormaDeColaborarEnum> formashion){
        this.formasDeColaborar = formashion;
        this.nombreColaborador = nombreColaborator;
    }
	public void setFormasDeColaborar(List<FormaDeColaborarEnum> formasNuevas) {
		this.formasDeColaborar = formasNuevas; 
	}
	public void setIdColaborador(Long idNuevo) {
		this.idColaborador = idNuevo;
	}
	public Long getIdColaborador() {
		// TODO Auto-generated method stub
		return idColaborador;
	}
	public String getNombreColaborador() {
		// TODO Auto-generated method stub
		return this.nombreColaborador;
	}
	public List<FormaDeColaborarEnum> getFormasDeColaborar() {
		// TODO Auto-generated method stub
		return this.formasDeColaborar;
	} 
}

