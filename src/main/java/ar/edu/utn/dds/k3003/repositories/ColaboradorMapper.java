package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.facades.dtos.ColaboradorDTO;
import ar.edu.utn.dds.k3003.model.Colaborador;

public class ColaboradorMapper {

    public ColaboradorDTO map(Colaborador colaborador){
        ColaboradorDTO colaboradorDTO = new ColaboradorDTO(colaborador.getNombreColaborador(),colaborador.getFormasDeColaborar());
        colaboradorDTO.setId(colaborador.getIdColaborador());
        return colaboradorDTO;
    }
    public Colaborador map(ColaboradorDTO colaboradorDTO){
        Colaborador colaboradorNuevo = new Colaborador(colaboradorDTO.getNombre(),colaboradorDTO.getFormas());
        colaboradorNuevo.setIdColaborador(colaboradorDTO.getId());
        return colaboradorNuevo;
    }
}