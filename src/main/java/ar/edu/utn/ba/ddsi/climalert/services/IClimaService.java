package ar.edu.utn.ba.ddsi.climalert.services;

import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;

import java.util.Optional;

public interface IClimaService {
    void consultarYGuardarClima();
    Optional<Clima> obtenerUltimoClima();
}
