package Modelos;

import java.util.ArrayList;

public class Routine extends TypesRoutines{
    public Routine() {

    }

    public Routine(int idRoutines, String nameRoutines, ArrayList<String> typeRoutine) {
        super(idRoutines, nameRoutines, typeRoutine);
    }

    @Override
    boolean CreateRoutines() {
        return false;
    }

    @Override
    boolean DeleteRoutines() {
        return false;
    }

    @Override
    void PrintRoutines() {

    }

    @Override
    public int getIdRoutines() {
        return super.getIdRoutines();
    }

    @Override
    public String getNameRoutines() {
        return super.getNameRoutines();
    }

    @Override
    public ArrayList<String> getTypeRoutine() {
        return super.getTypeRoutine();
    }

    @Override
    public void setIdRoutines(int idRoutines) {
        super.setIdRoutines(idRoutines);
    }

    @Override
    public void setNameRoutines(String nameRoutines) {
        super.setNameRoutines(nameRoutines);
    }

    @Override
    public void setTypeRoutine(ArrayList<String> typeRoutine) {
        super.setTypeRoutine(typeRoutine);
    }
}