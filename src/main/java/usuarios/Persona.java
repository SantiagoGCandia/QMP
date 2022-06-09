package usuarios;

import guardarropas.Guardarropas;

import java.util.Arrays;
import java.util.List;

public class Persona {

  List<Guardarropas> misGuardarropas;

  public Persona(){
    misGuardarropas= Arrays.asList(new Guardarropas(this));
  }



}
