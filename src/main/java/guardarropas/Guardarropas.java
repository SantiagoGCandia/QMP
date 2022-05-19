package guardarropas;



import prendas.Atuendo;
import prendas.Prenda;


import java.util.ArrayList;
import java.util.List;


public class Guardarropas {


 private String nombreGuardarropas;
 private String descripcion;

 private List<Prenda> prendas = new ArrayList<>();


 public List<Prenda> getPrendas() {
  return prendas;
 }

 public void agregarPrenda(Prenda prenda){
  prendas.add(prenda);
 }

 public void quitarPrenda(Prenda prenda){
  prendas.remove(prenda);
 }


}
