package ar.edu.utn.dds.k3003.model.exceptions;

import ar.edu.utn.dds.k3003.model.Colaborador;
import lombok.Getter;

@Getter
public class SomeDomainException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final Colaborador anAttribute;

  public SomeDomainException(String message, Colaborador anAttribute) {
    this.anAttribute = anAttribute;
  }
}
