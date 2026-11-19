package ar.com.proyecto2.edithpernia.concesionario.entidades;

import lombok.Getter;

@Getter 
public class Moto extends Vehiculo {

  private int cilindrada;

  public Moto(String marca, String modelo, double precio, int cilindrada) {
    super(marca, modelo, precio);
    this.cilindrada = cilindrada;
  }
  @Override 
  public String toString () {
    return  "Marca: " + getMarca()
            + " // Modelo: " + getModelo()
            + " // Cilindrada: " + cilindrada + "c"
            + " // Precio: " + formatearPrecio();
        
     
  
    }

   

}
