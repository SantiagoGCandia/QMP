package vestuaristas;

import categorias.Categoria;
import exepcionesPrenda.ExcepcionNoHayPrendasParaAtuendo;
import guardarropas.Guardarropas;
import prendas.Atuendo;
import prendas.Prenda;
import servicioMeteorologico.EstadoTiempo;
import servicioMeteorologico.ProbabilidadLluvia;
import servicioMeteorologico.ServicioMeteorologico;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Vestuarista {
  private ServicioMeteorologico servicioMeteorologico;

  public Vestuarista(ServicioMeteorologico servicioMeteorologico){
    this.servicioMeteorologico=servicioMeteorologico;
  }

  public Optional<Atuendo> sugerirAtuendo(String ciudad, Guardarropas guardarropas){
    EstadoTiempo estadoTiempo = this.servicioMeteorologico.obtenerClima(ciudad);
    return
        generarAtuendo(guardarropas, estadoTiempo.temperatura, estadoTiempo.probabilidadLluvia)
        .stream().findAny();
  }

  //Se hace para que genere un solo atuendo, no esta hecho para las combinaciones. Ademas se ignoran los accesorios.
  private List<Atuendo> generarAtuendo(Guardarropas guardarropas, Integer temperatura, ProbabilidadLluvia probabilidadLluvia) {
    List<Prenda> prendas = guardarropas.getPrendas();

    List<Prenda> prendasUsables = prendas.stream()
        .filter(prenda ->
            prenda.esAptoParaTemperatura(temperatura))
        .filter(prenda ->
            prenda.esAptoParaProbabilidadLluvia(probabilidadLluvia))
        .collect(Collectors.toList());

    //Prenda accesorio = prendasUsables.stream().filter(prenda -> prenda.getCategoria().equals(Categoria.ACCESORIO)).findAny()
    //    .orElseThrow(() -> new ExcepcionNoHayPrendasParaAtuendo("No hay accesorios accesorios para generar atuendo"));
    Prenda superior = prendasUsables.stream().filter(prenda -> prenda.getCategoria().equals(Categoria.SUPERIOR)).findAny()
        .orElseThrow(() -> new ExcepcionNoHayPrendasParaAtuendo("No hay prendas superiores  para generar atuendo"));
    Prenda inferior = prendasUsables.stream().filter(prenda -> prenda.getCategoria().equals(Categoria.INFERIOR)).findAny()
        .orElseThrow(() -> new ExcepcionNoHayPrendasParaAtuendo("No hay prendas inferiores para generar atuendo"));
    Prenda calzado = prendasUsables.stream().filter(prenda -> prenda.getCategoria().equals(Categoria.CALZADO)).findAny()
        .orElseThrow(() -> new ExcepcionNoHayPrendasParaAtuendo("No hay calzados para generar atuendo"));

    return Arrays.asList(new Atuendo(Arrays.asList(superior, inferior, calzado)));

  }


}
