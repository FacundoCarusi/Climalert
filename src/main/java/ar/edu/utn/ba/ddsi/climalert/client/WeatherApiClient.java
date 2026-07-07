package ar.edu.utn.ba.ddsi.climalert.client;

import ar.edu.utn.ba.ddsi.climalert.dto.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiClient {

    private final RestClient restClient;
    private final String apiKey;
    private final String location;

    public WeatherApiClient(
            @Value("${weather.api.url}") String baseUrl,
            @Value("${weather.api.key}") String apiKey,
            @Value("${weather.api.location}") String location
    ) {
        this.restClient = RestClient.create(baseUrl);
        this.apiKey = apiKey;
        this.location = location;
    }

    public WeatherApiResponse obtenerClimaActual() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)
                        .queryParam("q", location)
                        .build())
                .retrieve()
                .body(WeatherApiResponse.class);
    }
}