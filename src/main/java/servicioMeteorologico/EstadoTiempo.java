package servicioMeteorologico;

public class EstadoTiempo {
  public Integer temperatura;
  public ProbabilidadLluvia probabilidadLluvia;

  public EstadoTiempo(Integer temperatura, ProbabilidadLluvia probabilidadLluvia){
    this.probabilidadLluvia = probabilidadLluvia;
    this.temperatura=temperatura;
  }
}
