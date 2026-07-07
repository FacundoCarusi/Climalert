package ar.edu.utn.ba.ddsi.climalert.services.impl;

import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.climalert.services.IEmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarAlerta(Clima clima) {

        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setTo(
                "admin@clima.com",
                "emergencias@clima.com",
                "meteorologia@clima.com"
        );

        mensaje.setSubject("Alerta climática");

        mensaje.setText(
                "Se detectaron condiciones climáticas críticas.\n\n" +
                        "Temperatura: " + clima.getTemperatura() + " °C\n" +
                        "Humedad: " + clima.getHumedad() + " %\n" +
                        "Fecha y hora: " + clima.getHora()
        );

        mailSender.send(mensaje);
    }
}