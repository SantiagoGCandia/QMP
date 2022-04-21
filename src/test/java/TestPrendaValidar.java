import categorias.Categoria;
import exepcionesPrenda.ExcepcionPrendaNoTieneCorrespondencia;
import exepcionesPrenda.ExcepcionPrendaIncompleta;
import tipoPrendas.TipoPrenda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;



public class TestPrendaValidar {

  @BeforeEach // Para futuros testeos en caso de ser necesarias prendas ya inicializadas
  public void init() {
    Prenda zapatos = new Prenda(TipoPrenda.ZAPATOS, Categoria.CALZADO, "Cuero", "Negro", null);
    Prenda pantalon = new Prenda(TipoPrenda.PANTALON, Categoria.INFERIOR, "Jean", "Azul", null);
    Prenda camisaMangasCortas = new Prenda(TipoPrenda.CAMISA_MANGAS_CORTAS, Categoria.SUPERIOR, "Algodon", "Rojo", "Blanco");
  }

  @Test
  public void prendaConCategoriaNoCorrespondiente() {
    // Tambien sirve el test unitario del metodo prendaValida
    //Prenda.prendaValida(TipoPrenda.Zapatos, Categoria.Superior, "Cuero", "Negro");
    //Prenda camisaMangasCortas = new Prenda(TipoPrenda.CamisaMangasCortas, Categoria.INFERIOR, "Algodon", null, null);
    Assertions.assertThrows(ExcepcionPrendaNoTieneCorrespondencia.class, () -> new Prenda(TipoPrenda.CAMISA_MANGAS_CORTAS, Categoria.INFERIOR, "Algodon", null, null));
  }

  @Test
  public void prendaIncompleta() {
    // Tambien sirve el test unitario del metodo prendaValida
    //Prenda.prendaValida(TipoPrenda.Zapatos, Categoria.Calzado, "Cuero", null);
    //Prenda camisaMangasCortas = new Prenda(TipoPrenda.CamisaMangasCortas, Categoria.SUPERIOR, "Algodon", null, null);
    Assertions.assertThrows(ExcepcionPrendaIncompleta.class, () -> new Prenda(TipoPrenda.CAMISA_MANGAS_CORTAS, Categoria.SUPERIOR, "Algodon", null, null));
  }

  @Test
  public void prendaNoCumpleNingunaCondicion() {
    // Tambien sirve el test unitario del metodo prendaValida
    //Prenda.prendaValida(TipoPrenda.Zapatos, Categoria.Superior, "Cuero", "Negro");
    //Prenda camisaMangasCortas = new Prenda(TipoPrenda.CamisaMangasCortas, Categoria.INFERIOR, "Algodon", null, null);
    Assertions.assertThrows(RuntimeException.class, () -> new Prenda(TipoPrenda.CAMISA_MANGAS_CORTAS, Categoria.INFERIOR, "Algodon", null, null));
  }

  @Test
  public void prendaCumpleCondiciones() {
    Prenda camisaMangasCortas = new Prenda(TipoPrenda.CAMISA_MANGAS_CORTAS, Categoria.SUPERIOR, "Algodon", "Rojo", "Blanco");
    Assertions.assertEquals(camisaMangasCortas.getClass(), Prenda.class);
  }

}
