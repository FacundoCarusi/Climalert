package ar.edu.utn.ba.ddsi.climalert.models.entities;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class Clima {
    private double temperatura;
    private int humedad;
    private LocalDateTime hora;
    private boolean enviada;

    public Clima(double temperatura, int humedad, LocalDateTime hora) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.hora = hora;
        this.enviada = false;
    }

    public boolean requiereAlerta(){
        return this.temperatura > 35 && this.humedad > 60;
    }

    public boolean alertaPendiente() {
        return requiereAlerta() && !enviada;
    }

    public void marcarAlertaEnviada() {
        this.enviada = true;
    }
}
