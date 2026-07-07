package ar.edu.utn.ba.ddsi.climalert.scheduler;

import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.climalert.services.impl.ClimaService;
import ar.edu.utn.ba.ddsi.climalert.services.impl.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {

    private final ClimaService climaService;
    private final EmailService emailService;

    public ClimaScheduler(ClimaService climaService , EmailService emailService) {
        this.climaService = climaService;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 300000)
    public void actualizarClima() {
        climaService.consultarYGuardarClima();
    }

    @Scheduled(fixedRate = 60000)
    public void analizarClima() {
        climaService.obtenerUltimoClima()
                .filter(Clima::alertaPendiente)
                .ifPresent(clima -> {
                    emailService.enviarAlerta(clima);
                    clima.marcarAlertaEnviada();
                });
    }
}