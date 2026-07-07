package ar.edu.utn.ba.ddsi.climalert.services;

import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;

public interface IEmailService {
    void enviarAlerta(Clima clima);
}
