package exepcionesPrenda;

public class ExcepcionPrendaNoTieneCorrespondencia extends RuntimeException {
  public ExcepcionPrendaNoTieneCorrespondencia(String msg) {
    super(msg);
  }
}
