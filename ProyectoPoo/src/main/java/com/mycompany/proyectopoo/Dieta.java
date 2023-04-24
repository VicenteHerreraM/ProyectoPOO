package com.mycompany.proyectopoo;

import java.util.Arrays;
import java.util.List;

public class Dieta {
    private String tipo;
    private List<String> recetas;

    public Dieta() {
    }

    public String getTipo() {
        return tipo;
    }

    public List<String> getRecetas() {
        return recetas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRecetas(List<String> recetas) {
        this.recetas = recetas;
    }

    public Dieta(String tipo,List<String> recetas) {
        this.tipo = tipo;

        switch (tipo) {
            case "Mediterranea":
                this.recetas = Arrays.asList("Ensalada griega", "Pescado a la parrilla con verduras");
                break;
            case "Vegetariana":
                this.recetas = Arrays.asList("Lentejas con arroz integral", "Tortilla de espinacas");
                break;
            case "Vegana":
                this.recetas = Arrays.asList("Hamburguesa de lentejas", "Arroz con verduras al curry");
                break;
            case "Baja en carbohidratos":
                this.recetas = Arrays.asList("Omelet con queso, espinaca y tocino", "Ensalada de atun con lechuga");
                break;
            case "Baja en grasas":
                this.recetas = Arrays.asList("Salmon al horno con arroz integral", "Tortilla de huevo con espinacas, cebolla y pimiento");
                break;
            case "Cetogenica":
                this.recetas = Arrays.asList("Huevos revueltos con aguacate y tocino", "Hamburguesa con queso cheddar, lechuga y aguacate");
                break;
            case "Paleo":
                this.recetas = Arrays.asList("Ensalada de pollo a la parrilla con aguacate, tomate y lechuga", "Tortilla de huevo con espinacas y champiñones");
                break;
            default:
                this.recetas = Arrays.asList("Pan con queso","Fiedos con salsa de tomate y carne molida");
                break;
        }
    }
    public void imprimirRecetas(){
        recetas.forEach(receta -> System.out.println( "\t\t- " + receta));

    }
}