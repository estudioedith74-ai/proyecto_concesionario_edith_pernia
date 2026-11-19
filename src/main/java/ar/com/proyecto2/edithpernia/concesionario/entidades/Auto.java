package ar.com.proyecto2.edithpernia.concesionario.entidades;

import lombok.Getter;

@Getter 
public class Auto extends Vehiculo {

    private int puertas;

    public Auto(String marca, String modelo, double precio, int puertas) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }

    @Override 
    public String toString () {
        return "Marca: " + getMarca()
                + " // Modelo: " + getModelo()
                + " // Puertas: " + puertas
                + " // Precio: " + formatearPrecio();

    }
 
   

}
