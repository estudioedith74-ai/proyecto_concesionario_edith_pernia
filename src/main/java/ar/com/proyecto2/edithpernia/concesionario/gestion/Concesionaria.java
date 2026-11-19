package ar.com.proyecto2.edithpernia.concesionario.gestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.com.proyecto2.edithpernia.concesionario.entidades.Auto;
import ar.com.proyecto2.edithpernia.concesionario.entidades.Moto;
import ar.com.proyecto2.edithpernia.concesionario.entidades.Vehiculo;
import lombok.Getter;

@Getter
public class Concesionaria {

    private static final String SEPARADOR = "=============================";

    private final List<Vehiculo> vehiculos = new ArrayList<>();

    public void cargarVehiculos() {
        vehiculos.add(new Auto("Peugeot", "206", 200000, 4));
        vehiculos.add(new Moto("Honda", "Titan", 60000, 125));
        vehiculos.add(new Auto("Peugeot", "208", 250000, 5));
        vehiculos.add(new Moto("Yamaha", "YBR", 80500.50, 160));
    }

    public void imprimirReporte() {
        System.out.println();
        System.out.println();
        imprimirListado();
        imprimirSeparador();
        imprimirVehiculoMasCaro();
        imprimirVehiculoMasBarato();
        imprimirVehiculosPorLetra("Y");
        imprimirSeparador();
        imprimirPorPrecioDescendente();
        imprimirSeparador();
        imprimirOrdenNatural();
        System.out.println();
        System.out.println();
    }

    

    public Vehiculo obtenerVehiculoMasCaro() {
        return vehiculos
                .stream()
                .max(Comparator.comparing(Vehiculo::getPrecio))
                .get();
    }

    public Vehiculo obtenerVehiculoMasBarato() {
        return vehiculos
                .stream()
                .min(Comparator.comparing(Vehiculo::getPrecio))
                .get();
    }

    public List<Vehiculo> buscarVehiculosPorLetra(String letra) {
        return vehiculos
                .stream()
                .filter(v -> v.getModelo().toLowerCase().contains(letra.toLowerCase()))
                .toList();
    }
    
    private void imprimirListado() {
        vehiculos.forEach(System.out::println);
    }

    private void imprimirVehiculoMasCaro() {
        Vehiculo masCaro = obtenerVehiculoMasCaro();
        System.out.println("Vehículo más caro: " + masCaro.informarNombre());
    }

    private void imprimirVehiculoMasBarato() {
        Vehiculo masBarato = obtenerVehiculoMasBarato();
        System.out.println("Vehículo más barato: " + masBarato.informarNombre());
    }

    private void imprimirVehiculosPorLetra(String letra) {
        List<Vehiculo> vehiculosConLetra = buscarVehiculosPorLetra(letra);
        vehiculosConLetra.forEach(v -> System.out.println("Vehículo que contiene en el modelo la letra '" + letra + "': "
                + v.informarNombre() + " " + v.formatearPrecio()));
    }

    private void imprimirPorPrecioDescendente() {
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        vehiculos
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio).reversed())
                .forEach(v -> System.out.println(v.informarNombre()));
    }

    private void imprimirOrdenNatural() {
        System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");
        vehiculos
                .stream()
                .sorted()
                .forEach(System.out::println);
    }

    private void imprimirSeparador() {
        System.out.println();
        System.out.println(SEPARADOR);
        System.out.println();
    }
}
