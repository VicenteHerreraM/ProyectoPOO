/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.time.LocalDate;

/**
 *
 * @author vice
 */
public class Usuario {

    /**
     *  ATRIBUTOS
     * */
    private String mail, password, name, lastName, rut , typeDiet , typeRoutine;
    private float height , weight;
    private int age;
    File fileName = new File("src/test/java/casosDePrueba.txt");
    Scanner infoUser = new Scanner(fileName);                            //SCANNER
    public ArrayList<Usuario> users = new ArrayList<Usuario>();

    public Usuario() throws FileNotFoundException{
        this.infoUser = new Scanner(fileName);
    }
    public Usuario(String mail, String password, String name, String lastName, String rut, float height, int age, float weight, String typeDiet, String typeRoutine) throws FileNotFoundException {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.rut = rut;
        this.height = height;
        this.age = age;
        this.weight = weight;
        this.typeDiet = typeDiet;
        this.typeRoutine = typeRoutine;
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

    public String getTypeDiet() {
        return typeDiet;
    }

    public String getTypeRoutine() {
        return typeRoutine;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
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

    public void setTypeDiet(String typeDiet) {
        this.typeDiet = typeDiet;
    }

    public void setTypeRoutine(String typeRoutine) {
        this.typeRoutine = typeRoutine;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }

    /**
     *  F(X) Verificar MAIL
     * */
    public boolean verificarMail(String mail) {
        char arroba = '@';
        for (int i = 0; i < mail.length(); i++) {
            if (mail.charAt(i) == arroba) {
                return true;
            }

        }
        return false;
    }

    /**
     *      VOID CREAR USUARIO
     * */

    //Actualmente solo lee strings sin espacios

    public void crearUsuario() {
        try{
        while(infoUser.hasNext()){
            String[] part = infoUser.next().split(";");
            String mailT = part[0];
            String passwordT = part[1];
            String nameT = part[2];
            String lastNameT = part[3];
            String rutT = part[4];
            float heightT = Float.parseFloat(part[5]);
            int ageT = Integer.parseInt(part[6]);
            float weightT = Float.parseFloat(part[7]);
            String typeDietT = part[8];
            String typeRoutineT = part[9];

            Usuario user = new Usuario(mailT,passwordT,nameT,lastNameT,rutT,heightT,ageT,weightT,typeDietT,typeRoutineT);
            users.add(user);
        }
        infoUser.close();

        }catch(Exception e){
            System.out.println("No se han encontrado datos");
        }
    }
    public void imprimirDatos(ArrayList<Usuario> users){
        int i=1;
        for (Usuario user : users) {
            System.out.println("\n------------------------------------------\n"
                              +"Usuario N "+i+"\n"
                              +"Nombre: "+ user.getName()+" "+user.getLastName()+"\n"
                              +"Mail: "+ user.getMail()+"\n"
                              +"Password: "+ user.getPassword()+"\n"
                              +"Rut: "+ user.getRut()+"\n"
                              +"Edad: "+ user.getAge()+"\n"
                              +"Altura: "+ user.getHeight()+"\n"
                              +"Peso: "+ user.getWeight()+"\n"
                              +"Dieta: "+ user.getTypeDiet()+"\n"
                              +"Rutina: "+ user.getTypeRoutine()+"\n"
                              +"------------------------------------------\n");
            i++;
        }
    }
    public void modificarDatos(){
    }
    
    //En teoria elimina el elemento, pero si encuentra al usuario, este tira error y se cae el programa.
    //En caso de no encontrarlo, vuelve exitosamente al menu de antes.
    //Solo esta encontrando el primer usuario
    public void eliminarDatos(ArrayList<Usuario> users){
        int i = 0;
        Scanner rut = new Scanner(System.in);
        System.out.println("Ingrese el rut del usuario que desee eliminar");
        String rutUsuario = rut.nextLine();
        //public ArrayList<Usuario> users = new  ArrayList<Usuario>;
        for (Usuario user : users){
            if(rutUsuario.equals(user.getRut())){
                users.remove(i);
                System.out.println("El usuario ha sido eliminado");
            }else{
                System.out.println("No se ha encontrado el usuario para eliminar\n");
                break;
                
            
            }
        i++;
        }
    }

}



    /*
            AGREE USER IDEA

        public void CrearDatos()throws FileNotFoundException{

            String correoElectronico;
            String password;
            String nombre;
            String apellido;
            char Rut;

            System.out.println("Ingrese un correo electronico y una contrasenya para crear tu cuenta");
            System.out.println("Correo electronico");
            mail = datosUsuario.nextLine();
            if(verificarMail(mail) == true){
                System.out.println("El correo es valido");
                System.out.println(mail);
            }else{
                System.out.println("El correo NO es valido");
            }
            password = datosUsuario.nextLine();
            nombre = datosUsuario.nextLine();
            apellido = datosUsuario.nextLine();
            Rut = datosUsuario.nextLine();

            DatosIngresados.add(new Usuario(correoElectronico , password , nombre , apellido , Rut));
        }
    */


