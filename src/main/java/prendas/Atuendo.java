package prendas;

import servicioMeteorologico.ProbabilidadLluvia;

import java.util.List;

public class Atuendo {

  List<Prenda> prendas;

  public Atuendo(List<Prenda> prendas) {
    this.prendas = prendas;
  }

  List<Prenda> getPrendas() {
    return prendas;
  }

  public Boolean esAptoParaProbabilidadLluvia(ProbabilidadLluvia humedad){
    return prendas.stream().allMatch(p -> p.esAptoParaProbabilidadLluvia(humedad));
  }

  public Boolean esAptoParaTemperatura(Integer temp){
    return prendas.stream().allMatch(p -> p.esAptoParaTemperatura(temp));
  }
}