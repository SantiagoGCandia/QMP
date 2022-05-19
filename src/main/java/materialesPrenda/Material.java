package materialesPrenda;

public class Material {

  Trama trama = Trama.LISA;
  Tela tela;

  public Material(Tela tela, Trama trama){
    this.trama=trama;
    this.tela=tela;
  }

  public Trama getTrama() {
    return trama;
  }

  public Tela getTela() {
    return tela;
  }

}
