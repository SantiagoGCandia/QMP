package servicioMeteorologico;

import java.time.LocalDateTime;

public class RespuestaClima {

  EstadoTiempo estado;
  LocalDateTime validez;

  public RespuestaClima(EstadoTiempo estado, LocalDateTime validez) {
    this.validez=validez;
    this.estado=estado;
  }

  public boolean expiro() {
    return this.validez.isAfter(LocalDateTime.now());
  }

  public EstadoTiempo getEstado() {
    return this.estado;
  }
}
