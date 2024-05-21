package ar.edu.utn.dds.k3003.repositories;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import ar.edu.utn.dds.k3003.model.Colaborador;

public class ColaboradorRepository {
        private static AtomicLong seqId = new AtomicLong();
        private Collection<Colaborador> colaboradores;

        public ColaboradorRepository() {
            this.colaboradores = new ArrayList<>();
        }

        public Colaborador save(Colaborador colaborador) {
            if (Objects.isNull(colaborador.getIdColaborador())) {
                colaborador.setIdColaborador(seqId.getAndIncrement());
                this.colaboradores.add(colaborador);
            }
            return colaborador;
        }

        public Colaborador findById(Long id) {
            Optional<Colaborador> first = this.colaboradores.stream().filter(x -> x.getIdColaborador().equals(id)).findFirst();
            return first.orElseThrow(() -> new NoSuchElementException(
                    String.format("No hay un colaborador de id: %s", id)
            ));
        }
}
