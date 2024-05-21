package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.facades.FachadaHeladeras;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoViandaEnum;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class FachadaViandaTest implements FachadaViandas {


    @Override
    public ViandaDTO agregar(ViandaDTO viandaDTO) {
        return null;
    }

    @Override
    public ViandaDTO modificarEstado(String s, EstadoViandaEnum estadoViandaEnum) throws NoSuchElementException {
        return null;
    }

    @Override
    public List<ViandaDTO> viandasDeColaborador(Long id, Integer mes, Integer anio) throws NoSuchElementException {
        List<ViandaDTO> viandas = new ArrayList<>();
        ViandaDTO vianda1 = new ViandaDTO("", LocalDateTime.of(2109, 03, 28,5,5),EstadoViandaEnum.PREPARADA,5L,1);
        viandas.add(vianda1);
        ViandaDTO vianda2 = new ViandaDTO("", LocalDateTime.of(2109, 03, 28,5,5),EstadoViandaEnum.PREPARADA,1L,1);
        viandas.add(vianda2);
        ViandaDTO vianda3 = new ViandaDTO("", LocalDateTime.of(2109, 03, 28,5,5),EstadoViandaEnum.PREPARADA,2L,1);
        viandas.add(vianda3);
        ViandaDTO vianda4 = new ViandaDTO("", LocalDateTime.of(2109, 03, 28,5,5),EstadoViandaEnum.PREPARADA,5L,1);
        viandas.add(vianda4);
        ViandaDTO vianda5 = new ViandaDTO("", LocalDateTime.of(2109, 03, 28,5,5),EstadoViandaEnum.PREPARADA,5L,1);
        viandas.add(vianda5);
        ViandaDTO vianda6 = new ViandaDTO("", LocalDateTime.of(2109, 03, 28,5,5),EstadoViandaEnum.PREPARADA,6L,1);
        viandas.add(vianda6);
        return viandas.stream().filter(t-> Objects.equals(t.getColaboradorId(), id)).toList();
    }

    @Override
    public ViandaDTO buscarXQR(String s) throws NoSuchElementException {
        return null;
    }

    @Override
    public void setHeladerasProxy(FachadaHeladeras fachadaHeladeras) {

    }

    @Override
    public boolean evaluarVencimiento(String s) throws NoSuchElementException {
        return false;
    }

    @Override
    public ViandaDTO modificarHeladera(String s, int i) {
        return null;
    }
}
