package ar.edu.utn.ba.ddsi.climalert.services.impl;

import ar.edu.utn.ba.ddsi.climalert.client.WeatherApiClient;
import ar.edu.utn.ba.ddsi.climalert.dto.WeatherApiResponse;
import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.climalert.models.repositories.IClimaRepository;
import ar.edu.utn.ba.ddsi.climalert.services.IClimaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClimaService implements IClimaService {

    private final WeatherApiClient weatherApiClient;
    private final IClimaRepository climaRepository;

    public ClimaService(
            WeatherApiClient weatherApiClient,
            IClimaRepository climaRepository
    ) {
        this.weatherApiClient = weatherApiClient;
        this.climaRepository = climaRepository;
    }

    public void consultarYGuardarClima() {

        WeatherApiResponse response =
                weatherApiClient.obtenerClimaActual();

        Clima clima = new Clima(
                response.current().temperatura(),
                response.current().humedad(),
                LocalDateTime.now()
        );

        climaRepository.guardar(clima);
    }

    public Optional<Clima> obtenerUltimoClima() {
        return climaRepository.obtenerUltimo();
    }
}