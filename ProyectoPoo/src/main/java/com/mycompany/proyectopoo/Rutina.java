package com.mycompany.proyectopoo;

import java.util.Arrays;
import java.util.List;

public class Rutina{
    private String tipo;
    private List<String> rutinas;
    private int idRutina;

    public Rutina() {
    }

    public Rutina(String tipo, List<String> rutinas, int idRutina) {
        this.tipo = tipo;
        this.rutinas = rutinas;
        this.idRutina = idRutina;
    }

    public String getTipo() {
        return tipo;
    }

    public List<String> getRutinas() {
        return rutinas;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRutinas(List<String> rutinas) {
        this.rutinas = rutinas;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public Rutina(String tipo) {
        this.tipo = tipo;

        switch (tipo) {
            case "Full Body":
                this.rutinas = Arrays.asList("Se entrena todo el cuerpo, 3 veces a la semana, con un maximo de 2 ejercicios por grupo muscular");
                break;
            case "Empuje jalon":
                this.rutinas = Arrays.asList("Se entrena 4 o 5 veces a la semana, un dia se centra en los ejercicios de empuje y otro dia se centra en los ejercicios de tiron");
                break;
            case "Torso Pierna":
                this.rutinas = Arrays.asList("Se entrena 4 veces a la semana, 2 dias el tren superior y 2 dias el tren inferior");
                break;
            case "HITT":
                this.rutinas = Arrays.asList("Entrenamientos intensos y cortos (20mins), dando el 100%");
                break;
            case "Cardio":
                this.rutinas = Arrays.asList("");
                break;
            default:
                this.rutinas = Arrays.asList("");
                break;
        }
    }


}