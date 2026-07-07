package ar.edu.utn.ba.ddsi.climalert.models.repositories;

import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;

import java.util.List;
import java.util.Optional;

public interface IClimaRepository {
    void guardar (Clima clima);
    Optional<Clima> obtenerUltimo ();
    List<Clima> obtenerTodos ();

}
