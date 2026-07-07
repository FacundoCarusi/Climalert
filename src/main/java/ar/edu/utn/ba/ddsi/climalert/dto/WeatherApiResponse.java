package ar.edu.utn.ba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeatherApiResponse(Current current) {

    public record Current(
            @JsonProperty("temp_c") double temperatura,
            @JsonProperty("humidity") int humedad
    ) {
    }
}