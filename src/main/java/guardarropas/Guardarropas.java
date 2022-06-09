package guardarropas;



import exepciones.ExcepcionUsuarioSinAccesoGuardarropas;
import guardarropas.propuestas.Propuesta;
import prendas.Atuendo;
import prendas.Prenda;
import usuarios.Persona;


import java.util.ArrayList;
import java.util.List;


public class Guardarropas {

 private Persona duenio;
 private List<Persona> personasConAcceso;
 private TipoGuardarropas tipoGuardarropas;
 private String nombreGuardarropas;
 private String descripcion;
 private List<Prenda> prendas = new ArrayList<>();
 private List<Propuesta> recomendaciones = new ArrayList<>();

 public Guardarropas(Persona duenio){
  this.duenio=duenio;
 }

 public List<Persona> getPersonasConAcceso() {
  return personasConAcceso;
 }

 public List<Prenda> getPrendas() {
  return prendas;
 }

 public void agregarPrenda(Prenda prenda){
  prendas.add(prenda);
 }

 public void quitarPrenda(Prenda prenda){
  prendas.remove(prenda);
 }

 public void agregarRecomendacion(Propuesta unaPropuesta){recomendaciones.add(unaPropuesta);}

 public List<Propuesta> getRecomendaciones() {
  return recomendaciones;
 }

 public void compartirCon(Persona unaPersona){
  tipoGuardarropas.compartirA(unaPersona);
 }

 public void quitarAccesoA(Persona unaPersona){
  tipoGuardarropas.quitarAcceso(unaPersona);
 }

 public void compartirGuardarropas(){
  tipoGuardarropas= new GuardarropasCompartido(this);
  personasConAcceso = new ArrayList<>();
 }

 public void privatizarGuardarropas(){
  tipoGuardarropas= new GuardarropasPrivado(this);
  personasConAcceso = null;
 }

 public void validarAcceso(Persona unaPersona){
  // <-- Podria estar en la clase TipoGuardarropas -->
  if(unaPersona!=duenio && !personasConAcceso.contains(unaPersona)){
   throw new ExcepcionUsuarioSinAccesoGuardarropas("Usted no tiene acceso a este guardarropas.");
  }
 }

 public void recomendarAgregarPrenda(Prenda unaPrenda, Persona unaPersona){
  validarAcceso(unaPersona);
  tipoGuardarropas.recomendarAgregarPrenda(unaPrenda);
 }

 public void recomendarBorrarPrenda(Prenda unaPrenda, Persona unaPersona){
  validarAcceso(unaPersona);
  tipoGuardarropas.recomendarBorrarPrenda(unaPrenda);
 }

}
