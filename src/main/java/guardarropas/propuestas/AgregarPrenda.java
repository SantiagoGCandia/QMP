package guardarropas.propuestas;

import guardarropas.Guardarropas;
import prendas.Prenda;

public class AgregarPrenda extends Propuesta{
  public AgregarPrenda(Guardarropas guardarropas, Prenda unaPrenda) {
    super(guardarropas, unaPrenda);
  }

  @Override
  public void hacer(){
    this.getElGuardarropas().agregarPrenda(this.getLaPrenda());
  }

  @Override
  public void deshacer(){
    this.getElGuardarropas().quitarPrenda(this.getLaPrenda());
    super.deshacer();
  }
}
