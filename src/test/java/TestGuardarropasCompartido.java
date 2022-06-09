import categorias.Categoria;
import exepciones.ExcepcionUsuarioSinAccesoGuardarropas;
import guardarropas.Guardarropas;
import guardarropas.propuestas.Propuesta;
import materialesPrenda.Tela;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prendas.Borrador;
import tipoPrendas.TipoPrenda;
import usuarios.Persona;
import utils.ColorRGB;

public class TestGuardarropasCompartido {

  Persona yo = new Persona();
  Persona otraPersona = new Persona();
  Persona laBruja = new Persona();
  Guardarropas miRoperoSinLeon = new Guardarropas(yo);
  Borrador jean = new Borrador();
  Borrador zapatos = new Borrador();


  @BeforeEach
  public void init() {
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
    zapatos.setEsParaProbabilidadLluvia(null);
  }

  @Test
  void compartoMiRopero(){
    miRoperoSinLeon.compartirGuardarropas();
    miRoperoSinLeon.compartirCon(otraPersona);
    Assertions.assertTrue(miRoperoSinLeon.getPersonasConAcceso().contains(otraPersona));
    Assertions.assertThrows(ExcepcionUsuarioSinAccesoGuardarropas.class, () -> miRoperoSinLeon.validarAcceso(laBruja));
  }

  @Test
  void meHacenUnaBuenaPropuestaYLaAcepto(){
    miRoperoSinLeon.compartirGuardarropas();
    miRoperoSinLeon.compartirCon(otraPersona);
    Assertions.assertTrue(miRoperoSinLeon.getPersonasConAcceso().contains(otraPersona));
    miRoperoSinLeon.recomendarAgregarPrenda(jean.crearPrenda(), otraPersona);
    miRoperoSinLeon.recomendarAgregarPrenda(zapatos.crearPrenda(), otraPersona);
    miRoperoSinLeon.getRecomendaciones().forEach(Propuesta::aceptarPropuesta);
    Assertions.assertEquals(2, miRoperoSinLeon.getPrendas().size());
  }

  @Test
  void meHacenUnaBuenaPropuestaYLaAceptoPeroMeArrepiento(){
    miRoperoSinLeon.compartirGuardarropas();
    miRoperoSinLeon.compartirCon(otraPersona);
    Assertions.assertTrue(miRoperoSinLeon.getPersonasConAcceso().contains(otraPersona));
    miRoperoSinLeon.recomendarAgregarPrenda(jean.crearPrenda(), otraPersona);
    miRoperoSinLeon.recomendarAgregarPrenda(zapatos.crearPrenda(), otraPersona);
    miRoperoSinLeon.getRecomendaciones().forEach(Propuesta::aceptarPropuesta);
    miRoperoSinLeon.getRecomendaciones().forEach(Propuesta::deshacer);
    Assertions.assertEquals(0, miRoperoSinLeon.getPrendas().size());
  }
}
