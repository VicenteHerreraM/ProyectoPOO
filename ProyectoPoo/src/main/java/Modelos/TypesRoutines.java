package Modelos;

import java.util.ArrayList;

public abstract class TypesRoutines{
    protected int idRoutines;
    protected String nameRoutines;
    protected ArrayList<String> typeRoutine;
    abstract boolean CreateRoutines();
    abstract boolean DeleteRoutines();
    abstract void PrintRoutines();

    public int getIdRoutines() {
        return idRoutines;
    }

    public String getNameRoutines(){
        return nameRoutines;
    }

    public ArrayList<String> getTypeRoutine() {
        return typeRoutine;
    }

    public void setIdRoutines(int idRoutines) {
        this.idRoutines = idRoutines;
    }

    public void setNameRoutines(String nameRoutines) {
        this.nameRoutines = nameRoutines;
    }

    public void setTypeRoutine(ArrayList<String> typeRoutine) {
        this.typeRoutine = typeRoutine;
    }
}
