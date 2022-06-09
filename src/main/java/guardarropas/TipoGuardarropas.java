package guardarropas;

import prendas.Prenda;
import usuarios.Persona;

public abstract class TipoGuardarropas {
  Guardarropas elGuardarropas;

  public TipoGuardarropas(Guardarropas unGuardarropas){
    elGuardarropas=unGuardarropas;
  }


  public void compartirA(Persona unaPersona){}

  public void quitarAcceso(Persona unaPersona){}

  public void recomendarAgregarPrenda(Prenda unaPrenda){}

  public void recomendarBorrarPrenda(Prenda unaPrenda){}
}
