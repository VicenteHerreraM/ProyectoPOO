/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import Operaciones.Validacion;

/**
 *
 * @author vice
 */
public class Usuario {

    /**
     *  ATRIBUTOS
     * */
    private String mail, password, name, lastName, rut;
    private float height , weight;
    private int age, typeDiet, typeRoutine;

    private Hashtable<Integer, Usuario> users = new Hashtable<Integer,Usuario>();

    Usuario usuario;

    Validacion validar = new Validacion();

    Scanner entrada = new Scanner(System.in);

    public Usuario(){
    }
    public Usuario(String mail, String password, String name, String lastName, String rut, float height, int age, float weight, int typeDiet, int typeRoutine) throws FileNotFoundException {
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

    public int getAge() {
        return age;
    }

    public Hashtable<Integer,Usuario> getUsers() {
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsers(Hashtable<Integer, Usuario> users) {
        this.users = users;
    }

    /**
     *
     *      VOID MENÚ USUARIO
     *
     * */

    public void options() throws FileNotFoundException {
        int opcion;
            do{
                System.out.print("""
                                    ¿QUE DESEA HACER EN USUARIO?
                                    1.- CREAR
                                    2.- MODIFICAR
                                    3.- ELIMINAR
                                    4.- MOSTRAR
                                    0.- RETROCEDER
                                """);
                opcion= validar.ValidarEntero();
                switch (opcion){
                    case 1->usuario.agregarUsuario();
                    case 2->usuario.actualizarDatos( getRut());
                    case 3->usuario.eliminarDatos(getRut());
                    case 4->usuario.imprimirDatos();
                    case 0->{

                    }
                    default -> System.out.print("""
                                        ------------------------------
                                        |          ¡¡ERROR!!         |
                                        | HA INGRESADO UN OPCIÓN NO  |
                                        |            VÁLIDA          |
                                        ------------------------------
                                        """);
                }
            }while (opcion!=0);
    }

    /**
     *      VOID CREAR USUARIO
     * */

    public void agregarUsuario() throws FileNotFoundException {

    }


    public void imprimirDatos(){

    }


    public void actualizarDatos(String rut){

    }


    public boolean eliminarDatos(String rut){        

        return false;
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


