package ar.com.proyecto2.edithpernia.concesionario.entidades;

import java.text.DecimalFormat;

import ar.com.proyecto2.edithpernia.concesionario.interfaces.IVendible;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter 
@AllArgsConstructor 

public abstract class Vehiculo  implements IVendible, Comparable<Vehiculo>{

    private String marca;
    private String modelo;
    private double precio;

    @Override 
    public String informarNombre(){
        return marca + " "+ modelo;

    }

    @Override 
    public String formatearPrecio() {
        DecimalFormat formato = new DecimalFormat("$#,##0.00");
        return formato.format(precio);
    }

    @Override 
    public int compareTo(Vehiculo otro) {
        String esteVehiculo = this.marca + "," + this.modelo + "," + this.precio;
        String otroVehiculo = otro.marca + "," + this.modelo + "," + otro.precio;
        return esteVehiculo.compareTo(otroVehiculo);
    }

}
