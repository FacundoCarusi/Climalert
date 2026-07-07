package ar.edu.utn.ba.ddsi.climalert.models.entities;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class Clima {
    private double temperatura;
    private int humedad;
    private LocalDateTime hora;

    public Clima(double temperatura, int humedad, LocalDateTime hora) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.hora = hora;
    }

    public boolean requiereAlerta(){
        return this.temperatura > 35 && this.humedad > 60;
    }
}
