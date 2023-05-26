package proyectopoo;

import java.util.Arrays;
import java.util.List;

public class Rutina{
    private String tipo;
    private List<String> rutinas;
    private int idRutina;

    public Rutina() {
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

    public Rutina(String tipo, List<String> rutinas, int idRutina) {
        this.tipo = tipo;

        switch (tipo) {
            case "Full Body":
                this.rutinas = Arrays.asList("Sentadilla 15x3", "Press de banca 12x4","Crunch 20x5");
                this.idRutina = 1;
                break;
            case "Empuje jalon":
                this.rutinas = Arrays.asList("Press de banca 12x4", "Paralelas 10x3","Aperturas con polea 8x5");
                this.idRutina = 2;
                break;
            case "Torso Pierna":
                this.rutinas = Arrays.asList("Sentadillas 15x5","Crunch 20x5","Zancadas 20x4");
                this.idRutina = 3;
                break;
            case "HITT":
                this.rutinas = Arrays.asList("Burpee 2 min","Sentadilla 1 min 30 sec","Crunch 2 min 30 sec");
                this.idRutina = 4;
                break;
            case "Cardio":
                this.rutinas = Arrays.asList("Sentadilla 15x3","Burpee 15x4","Bicicleta Estática 10 min");
                this.idRutina = 5;
                break;
            default:
                this.rutinas = Arrays.asList("Flexiones 15x4","Sentadillas 20x5","Plancha 1 min","");
                this.idRutina = 6;
                break;
        }
    }
    public void imprimirRutina(){
        rutinas.forEach(rutina -> System.out.println( "\t\t- " + rutina));

    }


}