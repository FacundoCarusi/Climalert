package ar.edu.utn.ba.ddsi.climalert.models.repositories.impl;

import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.climalert.models.repositories.IClimaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClimaRepository implements IClimaRepository {

    private final List<Clima> registros = new ArrayList<>();

    public void guardar(Clima clima) {
        registros.add(clima);
    }

    public Optional<Clima> obtenerUltimo() {
        if (registros.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(registros.getLast());
    }

    public List<Clima> obtenerTodos() {
        return List.copyOf(registros);
    }
}