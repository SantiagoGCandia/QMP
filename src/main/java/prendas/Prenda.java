package prendas;

import categorias.*;
import exepciones.ExcepcionPrendaNoTieneCorrespondencia;
import exepciones.ExcepcionPrendaIncompleta;
import materialesPrenda.Material;
import servicioMeteorologico.ProbabilidadLluvia;
import tipoPrendas.*;
import utils.ColorRGB;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Prenda {

  String descripcion;
  TipoPrenda tipo;
  Categoria categoria;
  Material material;
  ColorRGB colorPrimario;
  ColorRGB colorSecundario;
  private Integer temperaturaMaxima;
  private Integer temperaturaMinima;
  private List<ProbabilidadLluvia> esParaProbabilidad;

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  Prenda(TipoPrenda tipoPrenda, Categoria categoria, Material material, ColorRGB colorPrimario, ColorRGB colorSecundario,
         Integer temperaturaMaxima, Integer temperaturaMinima, List<ProbabilidadLluvia> esParaProbabilidad) {
    this.tipo = tipoPrenda;
    this.categoria = categoria;
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.temperaturaMaxima = temperaturaMaxima;
    this.temperaturaMinima = temperaturaMinima;
    this.esParaProbabilidad = esParaProbabilidad;
  }

  static public void validarPrenda(TipoPrenda tipoPrenda, Categoria categoria, String material, String colorPrimario) {
    List<Object> caracteristicas = Arrays.asList(tipoPrenda, categoria, material, colorPrimario);

    if (!categoria.equals(tipoPrenda.getCategoria())) {
      throw new ExcepcionPrendaNoTieneCorrespondencia("No es correspondiente la categoria de la prenda con su tipo.");
    }
    if (caracteristicas.stream().anyMatch(Objects::isNull)) { //Objects.isNull(p)
      throw new ExcepcionPrendaIncompleta("Faltan datos para completar la prenda.");
    }
  }

  public boolean esAptoParaProbabilidadLluvia(ProbabilidadLluvia humedad) {
    return this.esParaProbabilidad.contains(humedad);
  }

  public boolean esAptoParaTemperatura(Integer temperatura) {
    return (this.temperaturaMaxima >= temperatura) && (temperatura >= this.temperaturaMinima);
  }
}

