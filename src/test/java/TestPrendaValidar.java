import categorias.Categoria;
import exepcionesPrenda.ExcepcionPrendaNoTieneCorrespondencia;
import exepcionesPrenda.ExcepcionPrendaIncompleta;
import materialesPrenda.Tela;
import prendas.Borrador;
import prendas.Prenda;
import tipoPrendas.TipoPrenda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import utils.ColorRGB;


public class TestPrendaValidar {

  Borrador borradorCamisaMangasCortas = new Borrador();
  Borrador jean = new Borrador();
  Borrador zapatos = new Borrador();

  @BeforeEach // Para futuros testeos en caso de ser necesarias prendas ya inicializadas
  public void init() {
    borradorCamisaMangasCortas.setTipo(TipoPrenda.CAMISA_MANGAS_CORTAS);
    borradorCamisaMangasCortas.setCategoria(Categoria.SUPERIOR);
    borradorCamisaMangasCortas.setTela(Tela.ALGODON);
    borradorCamisaMangasCortas.setColorPrimario(new ColorRGB(255,0,0));
    borradorCamisaMangasCortas.setColorSecundario(new ColorRGB(255,255,255));
    borradorCamisaMangasCortas.setTemperaturaMaxima(null);
    borradorCamisaMangasCortas.setEsParaProbabilidadLluvia(null);

    jean.setTipo(TipoPrenda.PANTALON);
    jean.setCategoria(Categoria.INFERIOR);
    jean.setTela(Tela.JEAN);
    jean.setColorPrimario(new ColorRGB(255,0,0));
    jean.setColorSecundario(new ColorRGB(255,255,255));
    jean.setTemperaturaMaxima(null);
    jean.setEsParaProbabilidadLluvia(null);

    zapatos.setTipo(TipoPrenda.ZAPATOS);
    zapatos.setCategoria(Categoria.CALZADO);
    zapatos.setTela(Tela.CUERO);
    zapatos.setColorPrimario(new ColorRGB(255,0,0));
    zapatos.setColorSecundario(new ColorRGB(255,255,255));
    zapatos.setTemperaturaMaxima(null);
    zapatos.setEsParaProbabilidadLluvia(null); }

  @Test
  public void prendaConCategoriaNoCorrespondiente() {
    // Tambien sirve el test unitario del metodo prendaValida
    //Prenda.prendaValida(TipoPrenda.Zapatos, Categoria.Superior, "Cuero", "Negro");
    //Prenda camisaMangasCortas = new Prenda(TipoPrenda.CamisaMangasCortas, Categoria.INFERIOR, "Algodon", null, null);
    Assertions.assertThrows(ExcepcionPrendaNoTieneCorrespondencia.class, () -> {
      borradorCamisaMangasCortas.setCategoria(Categoria.INFERIOR);
      borradorCamisaMangasCortas.crearPrenda();
    });
  }

  @Test
  public void prendaIncompleta() {
    // Tambien sirve el test unitario del metodo prendaValida
    //Prenda.prendaValida(TipoPrenda.Zapatos, Categoria.Calzado, "Cuero", null);
    //Prenda camisaMangasCortas = new Prenda(TipoPrenda.CamisaMangasCortas, Categoria.SUPERIOR, "Algodon", null, null);
    Assertions.assertThrows(ExcepcionPrendaIncompleta.class, () -> {
      borradorCamisaMangasCortas.setColorPrimario(null);
      borradorCamisaMangasCortas.crearPrenda();
    });
  }

  @Test
  public void prendaNoCumpleNingunaCondicion() {
    // Tambien sirve el test unitario del metodo prendaValida
    //Prenda.prendaValida(TipoPrenda.Zapatos, Categoria.Superior, "Cuero", "Negro");
    //Prenda camisaMangasCortas = new Prenda(TipoPrenda.CamisaMangasCortas, Categoria.INFERIOR, "Algodon", null, null);
    Assertions.assertThrows(RuntimeException.class, () -> {
      borradorCamisaMangasCortas.setCategoria(Categoria.INFERIOR);
      borradorCamisaMangasCortas.setColorPrimario(null);
      borradorCamisaMangasCortas.crearPrenda();
    });}

  @Test
  public void prendaCumpleCondiciones() {
    Assertions.assertEquals(borradorCamisaMangasCortas.crearPrenda().getClass(), Prenda.class);
  }

}
