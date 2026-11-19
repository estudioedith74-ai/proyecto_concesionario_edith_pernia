package ar.com.proyecto2.edithpernia.concesionario.tests;

import ar.com.proyecto2.edithpernia.concesionario.gestion.Concesionaria;

public class TestConcesionaria {
    public static void main(String[] args) {

        Concesionaria concesionaria = new Concesionaria();
        concesionaria.cargarVehiculos();
        concesionaria.imprimirReporte();

    }

}
