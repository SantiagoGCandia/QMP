package servicioMeteorologico;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static servicioMeteorologico.ProbabilidadLluvia.*;

public class ServicioMeteorologicoAW implements ServicioMeteorologico {

  private Duration periodoDeValidez;
  private AccuWeatherAPI api;
  private HashMap<String, RespuestaClima> ultimasRespuestas;

  public ServicioMeteorologicoAW(AccuWeatherAPI api, Duration periodoDeValidez) {
    this.api = api;
    this.periodoDeValidez = periodoDeValidez;
    this.ultimasRespuestas = new HashMap<>();
  }


  public EstadoTiempo obtenerClima(String ciudad){
    if (!this.ultimasRespuestas.containsKey(ciudad) || this.ultimasRespuestas.get(ciudad).expiro()) {
      ultimasRespuestas.put(ciudad, new RespuestaClima(consultarApi(ciudad), validoHasta()));
    }
    return this.ultimasRespuestas.get(ciudad).getEstado();
  }

  private EstadoTiempo consultarApi(String ciudad) {
    Map<String, Object> rtaAPI = this.api.getWeather(ciudad).get(0);
    Map<String, Object> tempF = (Map<String, Object>) rtaAPI.get("Temperature");
    Integer temperaturaCelcius = (((Integer) tempF.get("Value"))-32)*(5/9);
    ProbabilidadLluvia probabilidadLluvia = (double) rtaAPI.get("PrecipitationProbability") > 0.8 ? ALTA : BAJA;
    return new EstadoTiempo(temperaturaCelcius, probabilidadLluvia);
  }

  private LocalDateTime validoHasta() {
    return LocalDateTime.now().plus(this.periodoDeValidez);
  }
}
