package exepcionesPrenda;

public class ExcepcionPrendaIncompleta extends RuntimeException {
  public ExcepcionPrendaIncompleta(String msg) {
    super(msg);
  }
}
