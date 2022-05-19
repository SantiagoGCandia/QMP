package prendas;

import categorias.Categoria;
import exepcionesPrenda.ExcepcionPrendaIncompleta;
import exepcionesPrenda.ExcepcionPrendaNoTieneCorrespondencia;
import materialesPrenda.Material;
import materialesPrenda.Tela;
import materialesPrenda.Trama;
import servicioMeteorologico.ProbabilidadLluvia;
import tipoPrendas.TipoPrenda;
import utils.ColorRGB;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Borrador {

  private TipoPrenda tipo;
  private Categoria categoria;
  private Tela tela;
  private Trama trama;
  private Trama tramaPorDefecto = Trama.LISA;
  private ColorRGB colorPrimario;
  private ColorRGB colorSecundario;
  private Integer temperaturaMaxima;
  private Integer temperaturaMinima;
  private  List<ProbabilidadLluvia> esParaProbabilidadLluvia;

  public void setTipo(TipoPrenda tipo) {
    this.tipo = tipo;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public void setTela(Tela tela) {
    this.tela = tela;
  }

  public void setTrama(Trama trama) {
    this.trama = trama;
  }

  public void setColorPrimario(ColorRGB colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void setColorSecundario(ColorRGB colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTemperaturaMaxima(Integer temperatura) {
    this.temperaturaMaxima = temperatura;
  }

  public void setTemperaturaMinima(Integer temperatura) {
    this.temperaturaMinima = temperatura;
  }

  public void setEsParaProbabilidadLluvia(List<ProbabilidadLluvia> esParaProbabilidadLluvia) {
    this.esParaProbabilidadLluvia = esParaProbabilidadLluvia;
  }

  public void validarPrenda() {
    List<Object> caracteristicas = Arrays.asList(tipo, categoria, tela, colorPrimario);
    Boolean tieneDatos = caracteristicas.stream().noneMatch(p -> Objects.isNull(p));
    Boolean correspondeCategoria = categoria.equals(tipo.getCategoria());
    Boolean correspondeTela = tipo.validarTela(tela);
    // Podria ser una clase validacion o algo similar como se hizo en la clase anterior con las validaciones pero es de una entrega anterior
    if (!tieneDatos) {
      throw new ExcepcionPrendaIncompleta("No cumple los requisitos para ser una prenda valida. Debe completar los datos.");
    }
    if (!correspondeCategoria) {
      throw new ExcepcionPrendaNoTieneCorrespondencia("No cumple los requisitos para ser una prenda valida. Debe elegir una categoria correspondiente al tipo de prenda.");
    }
    if (!correspondeTela) {
      throw new ExcepcionPrendaNoTieneCorrespondencia("No cumple los requisitos para ser una prenda valida. Debe elegir una tela correspondiente al tipo de prenda");
    }
  }

  public Prenda crearPrenda(){
    validarPrenda();
    Trama tramaFinal = trama != null ? trama : tramaPorDefecto;
    Material material= new Material(tela, tramaFinal);

    return new Prenda(tipo, categoria, material, colorPrimario, colorSecundario, temperaturaMaxima, temperaturaMinima, esParaProbabilidadLluvia);
  }

}
