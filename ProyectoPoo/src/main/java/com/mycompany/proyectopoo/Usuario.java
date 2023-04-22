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
    
    
    //Agrega al usuario exitosamente a la lista,sin embargo, por alguna razon se salta la linea para registrar la dieta
    
    public void agregarUsuario() throws FileNotFoundException {
	String mail, password, name, lastName, rut , typeDiet , typeRoutine;
	float height , weight; 
	int age;

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese su correo electronico");
        mail = entrada.nextLine();
        
        System.out.println("Ingrese contraseña");
        password = entrada.nextLine();
        
        System.out.println("Ingrese Nombre");
        name = entrada.nextLine();
        
        System.out.println("Ingrese Apellido");
        lastName = entrada.nextLine();
        
        System.out.println("Ingrese Rut");
        rut = entrada.nextLine();
        
        System.out.println("Ingrese Altura");
        height = entrada.nextFloat();

        System.out.println("Ingrese Peso");
        weight = entrada.nextFloat();

        System.out.println("Ingrese Edad");
        age = entrada.nextInt();

        System.out.println("Ingrese Tipo de dieta");
        typeDiet = entrada.nextLine(); //Por alguna razon, esta es la linea de codigo la ingresa vacia
        
        System.out.println("Ingrese Tipo de rutina");
        typeRoutine = entrada.nextLine();
        
        users.add(new Usuario(mail , password, name , lastName , rut , height , age , weight , typeDiet , typeRoutine));
        
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
    
    public int obtenerPosicionUsuario(String rut){
        for (int i = 0 ; i < users.size() ; i++){
            if(rut.equals(users.get(i).rut)){
                return i;
            }
        }
       return 0;     
    }
    
    //Entra en bucle si logra accedar al menu mostrado.
    //falta terminar esta funcion.
    public void actualizarDatos(String rut){
        
        Scanner opciones = new Scanner(System.in);
        Scanner alfanumerico = new Scanner(System.in);
        Scanner numDecimal = new Scanner(System.in);
        Scanner numEnteros = new Scanner(System.in);
        int opcion = opciones.nextInt();
        
        int pos = obtenerPosicionUsuario(rut);
            do{
                System.out.println("¿Que dato desea modificar?");
                System.out.println("1- Correo electronico");
                System.out.println("2- Contraseña");
                System.out.println("3- Edad");
                System.out.println("4- Peso");
                System.out.println("5- Altura");
                System.out.println(pos);
                

            switch(opcion){
                case 1:
                    System.out.println("Escriba su nuevo correo electronico");
                    users.set(pos, this).setMail(alfanumerico.nextLine());
                    break;
                    }
            default:
                break;
                }while (opcion != 0);        
            
        }
        
//Elimina a cualquier usuario de la lista, sin embargo, a veces tiene problemas en actualizar la lista si le pides imprimirla inmediatamente despues de eliminar un dato por alguna razon
    public boolean eliminarDatos(String rut){        
        for(int i = 0 ; i < users.size() ; i++){
            if(rut.equals(users.get(i).rut)){
                users.remove(i);
                return true;
            }
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


