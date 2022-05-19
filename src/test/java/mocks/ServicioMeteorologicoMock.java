package mocks;

import servicioMeteorologico.EstadoTiempo;
import servicioMeteorologico.ProbabilidadLluvia;
import servicioMeteorologico.ServicioMeteorologico;

public class ServicioMeteorologicoMock implements ServicioMeteorologico {

  private EstadoTiempo estado;

  public ServicioMeteorologicoMock(Integer temp, ProbabilidadLluvia probabilidadLluvia){
    this.estado = new EstadoTiempo(temp, probabilidadLluvia);
  }

  public EstadoTiempo obtenerClima(String ciudad){
    EstadoTiempo estado;
    switch (ciudad){
      case "BSAS" : estado = new EstadoTiempo(20, ProbabilidadLluvia.ALTA);
      case "CBA" : estado = new EstadoTiempo(27, ProbabilidadLluvia.BAJA);
      case "CABA" : estado = new EstadoTiempo(23, ProbabilidadLluvia.ALTA);
      default : estado = this.estado;
    }
    return  estado;
  }

}

