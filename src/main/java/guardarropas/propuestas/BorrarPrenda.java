package guardarropas.propuestas;

import guardarropas.Guardarropas;
import prendas.Prenda;

public class BorrarPrenda extends Propuesta{
  public BorrarPrenda(Guardarropas elGuardarropas, Prenda unaPrenda) {
    super(elGuardarropas, unaPrenda);
  }


  @Override
  public void hacer(){
    this.getElGuardarropas().quitarPrenda(this.getLaPrenda());
  }

  @Override
  public void deshacer(){
    this.getElGuardarropas().agregarPrenda(this.getLaPrenda());
    super.deshacer();
  }



}