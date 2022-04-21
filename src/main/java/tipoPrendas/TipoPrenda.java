package tipoPrendas;

import categorias.Categoria;

public enum TipoPrenda {
  ZAPATOS(Categoria.CALZADO),
  CAMISA_MANGAS_CORTAS(Categoria.SUPERIOR),
  PANTALON(Categoria.INFERIOR),
  ANTEOJOS(Categoria.ACCESORIO);

  private final Categoria categoria;

  public Categoria getCategoria() {
    return categoria;
  }

  TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }
}
