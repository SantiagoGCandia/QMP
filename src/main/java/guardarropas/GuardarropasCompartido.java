package guardarropas;

import guardarropas.propuestas.AgregarPrenda;
import guardarropas.propuestas.BorrarPrenda;
import prendas.Prenda;
import usuarios.Persona;

public class GuardarropasCompartido extends TipoGuardarropas {
  public GuardarropasCompartido(Guardarropas unGuardarropas) {
    super(unGuardarropas);
  }

  @Override
  public void compartirA(Persona unaPersona) {
    elGuardarropas.getPersonasConAcceso().add(unaPersona);
  }

  @Override
  public void quitarAcceso(Persona unaPersona) {
    elGuardarropas.getPersonasConAcceso().remove(unaPersona);
  }

  @Override
  public void recomendarAgregarPrenda(Prenda unaPrenda) {
    elGuardarropas.agregarRecomendacion(new AgregarPrenda(elGuardarropas, unaPrenda));
  }

  @Override
  public void recomendarBorrarPrenda(Prenda unaPrenda) {
    elGuardarropas.agregarRecomendacion(new BorrarPrenda(elGuardarropas, unaPrenda));
  }
}
