# Climalert

Aplicación desarrollada con Java y Spring Boot para el monitoreo
periódico de condiciones climáticas y el envío automático de alertas por
correo electrónico ante condiciones críticas.

[Ver Consigna](https://drive.google.com/file/d/1NYqF9x4ASOMIKjcMdg4kTi17yzCS91WA/view)
## Funcionalidades

-   Consulta periódica de datos climáticos mediante WeatherAPI.
-   Registro histórico de mediciones en memoria durante la ejecución.
-   Análisis automático del último registro climático disponible.
-   Generación de alertas cuando la temperatura supera los 35 °C y la
    humedad supera el 60 %.
-   Envío automático de alertas por correo electrónico mediante SMTP.

## Tecnologías utilizadas

-   Java 21
-   Spring Boot
-   Spring Scheduling
-   Spring Mail
-   RestClient
-   Maven
-   WeatherAPI

## Flujo de la aplicación

    WeatherAPI
        ↓
    WeatherApiClient
        ↓
    WeatherApiResponse (DTO)
        ↓
    ClimaService
        ↓
    ClimaRepository (memoria)
        ↓
    ClimaScheduler
        ↓
    EmailService
        ↓
    SMTP

## Configuración

La aplicación requiere las siguientes variables de entorno:

  Variable            Descripción
  ------------------- --------------------------------------------------
  `WEATHER_API_KEY`   API Key de WeatherAPI,
  `MAIL_USERNAME`     Cuenta utilizada para enviar correos,
  `MAIL_PASSWORD`     Contraseña de aplicación para autenticación SMTP

No se deben almacenar credenciales directamente en el repositorio.

## Ejecución

Con las variables de entorno configuradas:

    ./mvnw spring-boot:run

En Windows:

    .\mvnw.cmd spring-boot:run

También puede ejecutarse directamente `ClimalertApplication.java` desde
el IDE.

## Procesos programados

La aplicación ejecuta dos tareas automáticas:

-   Cada 5 minutos consulta WeatherAPI y almacena la medición obtenida.
-   Cada 1 minuto analiza la última medición almacenada y, si se cumplen
    las condiciones críticas, genera una alerta por correo electrónico.

## Condición de alerta

    temperatura > 35 && humedad > 60

## Persistencia

Los datos climáticos se almacenan en memoria durante la ejecución de la
aplicación. Al reiniciar el proceso, el historial almacenado se elimina.

## Autor

Facundo Carusi
