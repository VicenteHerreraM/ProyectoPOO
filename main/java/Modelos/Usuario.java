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
     *  ATRIBUTOS
     * */
    private String mail, password, name, lastName, rut;
    private float height , weight;
    private int typeDiet, typeRoutine;
    private Date birthdate;
    private ArrayList<Usuario> users = new ArrayList<>();

    Usuario usuario;

    Validacion validar = new Validacion();

    Scanner entrada = new Scanner(System.in);

    public Usuario(){

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
                opcion= validar.isInteger();
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
        Scanner input = new Scanner(System.in);
        String rut , mail, password , name , lastName;
        float altura, peso;
        int tipoDieta , tipoRutina;
        Date birthdate;
        birthdate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int i;
        System.out.println("Antes de agregar a un usuario, necesito un rut\n");
        System.out.println("Ingrese el rut del usuario\n");
        rut = input.nextLine();
        //(String mail, String password, String name, String lastName, String rut, float height, float weight, int typeDiet, int typeRoutine, Date birthdate)
        for(i = 0 ; i < users.size() ; i++){
            if(users.get(i).getRut().equals(rut)){
                System.out.println("Usuario no encontrado, porfavor ingrese los correspondientes datos\n");
                System.out.println("Ingrese Correo Electronico\n");
                mail = input.next();
                System.out.println("Ingrese Contraseña\n");
                password = input.next();
                System.out.println("Ingrese Nombre\n");
                name = input.next();
                System.out.println("Ingrese Apellido\n");
                lastName = input.next();
                System.out.println("Ingrese Altura\n");
                altura = input.nextFloat();
                System.out.println("Ingrese Peso\n");
                peso = input.nextFloat();
                System.out.println("Ingrese Tipo de Dieta\n");
                tipoDieta = input.nextInt();
                System.out.println("Ingrese Tipo de Rutina\n");
                tipoRutina = input.nextInt();
                System.out.println("Ingrese Año de nacimiento\n");

                users.add(new Usuario(rut, mail , password , name , lastName , altura , peso , tipoDieta , tipoRutina  , birthdate));


            }else{
                System.out.println("Este usuario ya esta registrado");

            }
        }
    }


    public void imprimirDatos(){

    }


    public void actualizarDatos(String rut){

    }


    public boolean eliminarDatos(String rut){        
        int i;
        for(i = 0 ; i < users.size() ; i++){

        }
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


