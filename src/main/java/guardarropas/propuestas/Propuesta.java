package guardarropas.propuestas;

import guardarropas.Guardarropas;
import prendas.Prenda;

public abstract class Propuesta {

  private Prenda laPrenda;
  private Guardarropas elGuardarropas;
  private Boolean estaAceptada;

  public Propuesta(Guardarropas unGuardarropas, Prenda unaPrenda){
    laPrenda = unaPrenda;
    elGuardarropas = unGuardarropas;
  }

  public Prenda getLaPrenda() {
    return laPrenda;
  }

  public Guardarropas getElGuardarropas() {
    return elGuardarropas;
  }

  public void aceptarPropuesta(){
    estaAceptada = true;
    hacer();
  }

  public void rechazarPropuesta(){
    estaAceptada = false;
  }

  public void hacer(){}

  public void deshacer(){rechazarPropuesta();}

}
