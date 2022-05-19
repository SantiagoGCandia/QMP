package tipoPrendas;

import categorias.Categoria;
import materialesPrenda.Tela;

import java.util.Arrays;
import java.util.List;

public enum TipoPrenda {
  ZAPATOS(Categoria.CALZADO, Arrays.asList(Tela.CUERO,Tela.ALGODON)),
  CAMISA_MANGAS_CORTAS(Categoria.SUPERIOR, Arrays.asList(Tela.NYLON,Tela.ALGODON)),
  PANTALON(Categoria.INFERIOR, Arrays.asList(Tela.ALGODON, Tela.JEAN, Tela.CUERO, Tela.NYLON)),
  ANTEOJOS(Categoria.ACCESORIO, null);

  private final Categoria categoria;

  private List<Tela> telasHabilitadas;

  TipoPrenda(Categoria categoria, List<Tela> telas) {
    this.categoria = categoria;
    this.telasHabilitadas = telas;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Boolean validarTela(Tela tela){
    return telasHabilitadas.contains(tela);
  }
}
