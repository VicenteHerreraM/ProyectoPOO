package Interfaces;

import java.util.ArrayList;

public abstract class TipoDeRutinas{
    protected int id;
    protected String nombre;
    protected ArrayList<String> tiposDeRutina;
    abstract boolean Crear();
    abstract boolean Eliminar();

    public int getId() {
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<String> getTiposDeRutina() {
        return tiposDeRutina;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTiposDeRutina(ArrayList<String> tiposDeRutina) {
        this.tiposDeRutina = tiposDeRutina;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
