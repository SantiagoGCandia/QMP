import categorias.*;
import exepcionesPrenda.ExcepcionPrendaNoTieneCorrespondencia;
import exepcionesPrenda.ExcepcionPrendaIncompleta;
import tipoPrendas.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Prenda {

  String descripcion;
  TipoPrenda tipo;
  Categoria categoria;
  String material;
  String colorPrimario;
  String colorSecundario;

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  Prenda(TipoPrenda tipoPrenda, Categoria categoria, String material, String colorPrimario, String colorSecundario) {
    validarPrenda(tipoPrenda, categoria, material, colorPrimario);
    this.tipo = tipoPrenda;
    this.categoria = categoria;
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
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
}

