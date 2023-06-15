/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import Operaciones.Validacion;

public class Usuario {

    /**
     * ATRIBUTOS
     */
    private String mail, password, name, lastName, rut;
    private float height, weight;
    private int typeDiet, typeRoutine;
    private Date birthdate;
    private ArrayList<Usuario> users = new ArrayList<>();

    public Usuario() {

    }

    public Usuario(String mail, String password, String name, String lastName, String rut, float height, float weight, int typeDiet, int typeRoutine, Date birthdate) {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.rut = rut;
        this.height = height;
        this.weight = weight;
        this.typeDiet = typeDiet;
        this.typeRoutine = typeRoutine;
        this.birthdate = birthdate;
    }

    /************
     *   GET    *
     ************/

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRut() {
        return rut;
    }

    public int getTypeDiet() {
        return typeDiet;
    }

    public int getTypeRoutine() {
        return typeRoutine;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public ArrayList<Usuario> getUsers() {
        return users;
    }

    /************
     *   SET    *
     ************/

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setTypeDiet(int typeDiet) {
        this.typeDiet = typeDiet;
    }

    public void setTypeRoutine(int typeRoutine) {
        this.typeRoutine = typeRoutine;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }

}