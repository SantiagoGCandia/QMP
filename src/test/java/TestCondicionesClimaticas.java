import categorias.Categoria;
import exepciones.ExcepcionNoHayPrendasParaAtuendo;
import guardarropas.Guardarropas;
import materialesPrenda.*;
import org.junit.jupiter.api.BeforeEach;
import prendas.Borrador;
import prendas.Prenda;
import servicioMeteorologico.ProbabilidadLluvia;
import servicioMeteorologico.ServicioMeteorologico;
import mocks.ServicioMeteorologicoMock;
import tipoPrendas.TipoPrenda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import prendas.Atuendo;
import utils.ColorRGB;
import vestuaristas.Vestuarista;

import java.util.Arrays;


public class TestCondicionesClimaticas {

  Borrador camisaMangasCortas = new Borrador();
  Borrador jean = new Borrador();
  Borrador zapatos = new Borrador();
  Guardarropas ropero;


  @BeforeEach
  public void init() {
    ropero = new Guardarropas(null);
    camisaMangasCortas.setTipo(TipoPrenda.CAMISA_MANGAS_CORTAS);
    camisaMangasCortas.setCategoria(Categoria.SUPERIOR);
    camisaMangasCortas.setTela(Tela.ALGODON);
    camisaMangasCortas.setColorPrimario(new ColorRGB(255,0,0));
    camisaMangasCortas.setColorSecundario(new ColorRGB(255,255,255));
    camisaMangasCortas.setTemperaturaMaxima(null);
    camisaMangasCortas.setEsParaProbabilidadLluvia(null);

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


  @Test// QMP IV
  void atuendoNoAptoParaTemperatura(){
    camisaMangasCortas.setTemperaturaMaxima(32);
    camisaMangasCortas.setTemperaturaMinima(17);
    camisaMangasCortas.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA));
    jean.setTemperaturaMaxima(25);
    jean.setTemperaturaMinima(0);
    jean.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA));
    zapatos.setTemperaturaMaxima(20);
    zapatos.setTemperaturaMinima(0);
    zapatos.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA));

    ServicioMeteorologico api = new ServicioMeteorologicoMock(15, ProbabilidadLluvia.BAJA);

    Prenda c = camisaMangasCortas.crearPrenda();
    Prenda j = jean.crearPrenda();
    Prenda z = zapatos.crearPrenda();
    Atuendo atuendo1 = new Atuendo(Arrays.asList(c, j, z));

    ropero.agregarPrenda(c);
    ropero.agregarPrenda(j);
    ropero.agregarPrenda(z);

    Vestuarista modista = new Vestuarista(api);

    Assertions.assertFalse(atuendo1.esAptoParaTemperatura(15));
    Assertions.assertThrows(ExcepcionNoHayPrendasParaAtuendo.class, () -> modista.sugerirAtuendo("Una ciudad", ropero).isPresent());

  }

  @Test// QMP IV
  void atuendoNoAptoParaHumedad(){
    camisaMangasCortas.setTemperaturaMaxima(32);
    camisaMangasCortas.setTemperaturaMinima(17);
    camisaMangasCortas.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA));
    jean.setTemperaturaMaxima(25);
    jean.setTemperaturaMinima(0);
    jean.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA, ProbabilidadLluvia.ALTA));
    zapatos.setTemperaturaMaxima(20);
    zapatos.setTemperaturaMinima(0);
    zapatos.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA, ProbabilidadLluvia.ALTA));

    ServicioMeteorologico api = new ServicioMeteorologicoMock(20, ProbabilidadLluvia.ALTA);

    Prenda c = camisaMangasCortas.crearPrenda();
    Prenda j = jean.crearPrenda();
    Prenda z = zapatos.crearPrenda();
    Atuendo atuendo1 = new Atuendo(Arrays.asList(c, j, z));

    ropero.agregarPrenda(c);
    ropero.agregarPrenda(j);
    ropero.agregarPrenda(z);

    Vestuarista modista = new Vestuarista(api);

    Assertions.assertFalse(atuendo1.esAptoParaProbabilidadLluvia(ProbabilidadLluvia.ALTA));
    Assertions.assertThrows(ExcepcionNoHayPrendasParaAtuendo.class, () -> modista.sugerirAtuendo("Una ciudad", ropero));
  }

  @Test// QMP IV
  void atuendoAptoParaTiempo(){
    camisaMangasCortas.setTemperaturaMaxima(32);
    camisaMangasCortas.setTemperaturaMinima(17);
    camisaMangasCortas.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA));
    jean.setTemperaturaMaxima(25);
    jean.setTemperaturaMinima(0);
    jean.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA));
    zapatos.setTemperaturaMaxima(20);
    zapatos.setTemperaturaMinima(0);
    zapatos.setEsParaProbabilidadLluvia(Arrays.asList(ProbabilidadLluvia.BAJA));

    ServicioMeteorologico api = new ServicioMeteorologicoMock(20, ProbabilidadLluvia.BAJA);

    Prenda c = camisaMangasCortas.crearPrenda();
    Prenda j = jean.crearPrenda();
    Prenda z = zapatos.crearPrenda();
    Atuendo atuendo1 = new Atuendo(Arrays.asList(c, j, z));

    ropero.agregarPrenda(c);
    ropero.agregarPrenda(j);
    ropero.agregarPrenda(z);

    Vestuarista modista = new Vestuarista(api);

    Assertions.assertTrue(atuendo1.esAptoParaTemperatura(20));
    Assertions.assertTrue(modista.sugerirAtuendo("Una ciudad", ropero).isPresent());
  }

}
