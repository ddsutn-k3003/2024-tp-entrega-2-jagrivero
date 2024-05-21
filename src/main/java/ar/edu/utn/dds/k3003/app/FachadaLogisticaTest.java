package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.facades.FachadaHeladeras;
import ar.edu.utn.dds.k3003.facades.FachadaLogistica;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.RutaDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;
import ar.edu.utn.dds.k3003.facades.exceptions.TrasladoNoAsignableException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class FachadaLogisticaTest implements FachadaLogistica {
    @Override
    public RutaDTO agregar(RutaDTO rutaDTO) {
        return null;
    }

    @Override
    public TrasladoDTO buscarXId(Long aLong) throws NoSuchElementException {
        return null;
    }

    @Override
    public TrasladoDTO asignarTraslado(TrasladoDTO trasladoDTO) throws TrasladoNoAsignableException {
        return null;
    }

    @Override
    public List<TrasladoDTO> trasladosDeColaborador(Long aLong, Integer integer, Integer integer1) {
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
        return traslados.stream().filter(t-> Objects.equals(t.getColaboradorId(), aLong)).toList();
    }

    @Override
    public void setHeladerasProxy(FachadaHeladeras fachadaHeladeras) {

    }

    @Override
    public void setViandasProxy(FachadaViandas fachadaViandas) {

    }

    @Override
    public void trasladoRetirado(Long aLong) {

    }

    @Override
    public void trasladoDepositado(Long aLong) {

    }
}
