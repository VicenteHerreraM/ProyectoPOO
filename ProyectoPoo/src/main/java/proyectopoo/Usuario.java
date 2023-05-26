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

                    };
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

    //Actualmente solo lee strings sin espacios

    public void leerUsuario(){

    }

    public void agregarUsuario() throws FileNotFoundException {
        String mail, password, name, lastName, rut;
        float height , weight;
        int age, typeDiet, typeRoutine;
        Usuario user = new Usuario();

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese su correo electronico: ");
        mail = entrada.nextLine();
        if(user.verificarMail(mail)){
            System.out.print("\nIngrese contraseña :");
            password = entrada.nextLine();

            System.out.print("\nIngrese Nombre :");
            name = entrada.nextLine();

            System.out.println("\nIngrese Apellido :");
            lastName = entrada.nextLine();

            System.out.println("\nIngrese Rut :");
            rut = entrada.nextLine();

            System.out.println("\nIngrese Altura :");
            height = entrada.nextFloat();

            System.out.println("\nIngrese Peso :");
            weight = entrada.nextFloat();

            System.out.println("\nIngrese Edad :");
            age = entrada.nextInt();

            System.out.print("\nIngrese Tipo de dieta :");
            typeDiet = entrada.next();

            System.out.print("\nIngrese Tipo de rutina :");
            typeRoutine = entrada.next();

            users.add(new Usuario(mail , password, name , lastName , rut , height , age , weight , typeDiet , typeRoutine));
            System.out.print("""
                            ------------------------------
                            |   AGREGADO CORRECTAMENTE!! |
                            ------------------------------
                            """);
        }else{
            System.out.print("""
                            ------------------------------
                            |   ¡¡ CORREO NO VÁLIDO !!   |
                            |      INTENTE MÁS TARDE     |
                            ------------------------------
                            """);
        }
        

    }


    public void imprimirDatos(){
        int i=1;
        Dieta dieta;
        Rutina rutina;
        for (Usuario user : users) {
            List<String>receta=new ArrayList<>();
            List<String>rutine=new ArrayList<>();
            int id = 0;
            dieta = new Dieta(user.getTypeDiet(), receta);
            rutina = new Rutina(user.getTypeRoutine(),rutine,id);
            System.out.println("------------------------------------------\n"
                              +"Usuario N "+i+"\n"
                              +"Nombre: "+ user.getName()+" "+user.getLastName()+"\n"
                              +"Mail: "+ user.getMail()+"\n"
                              +"Password: "+ user.getPassword()+"\n"
                              +"Rut: "+ user.getRut()+"\n"
                              +"Edad: "+ user.getAge()+"\n"
                              +"Altura: "+ user.getHeight()+"\n"
                              +"Peso: "+ user.getWeight()+"\n"
                              +"Dieta: "+ user.getTypeDiet());
            dieta.imprimirRecetas();
            System.out.print("\nRutina: "+ user.getTypeRoutine()+"\n");
            rutina.imprimirRutina();
            System.out.println("------------------------------------------");
            i++;
        }
    }


    public void actualizarDatos(String rut){

        Scanner opciones = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        int opcion;
        boolean flag = false;

        for(Usuario user: users){
            if(user.getRut().equals(rut)){
                flag = true;
                do{
                    System.out.println("¿Que dato desea modificar?");
                    System.out.println("1- Correo electronico");
                    System.out.println("2- Contraseña");
                    System.out.println("3- Edad");
                    System.out.println("4- Peso");
                    System.out.println("5- Altura");
                    System.out.println("0- Volver al menu anterior");
                    opcion = opciones.nextInt();

                    switch(opcion){
                        case 1:
                            System.out.print("Nuevo correo electronico : ");
                            user.setMail(entrada.nextLine());
                            break;
                        case 2:
                            System.out.print("Nueva contraseña : ");
                            user.setPassword(entrada.nextLine());
                            break;
                        case 3:
                            System.out.print("Nueva edad : ");
                            user.setAge(entrada.nextInt());
                            break;
                        case 4:
                            System.out.print("Nuevo Peso : ");
                            user.setWeight(entrada.nextFloat());
                            break;
                        case 5:
                            System.out.print("Nueva altura: ");
                            user.setHeight(entrada.nextFloat());
                            break;
                        default:
                            System.out.print("""
                                        ------------------------------
                                        |          ¡¡ERROR!!         |
                                        | HA INGRESADO UN OPCIÓN NO  |
                                        |            VÁLIDA          |
                                        ------------------------------
                                        """);
                            break;

                    }
                    do{
                        System.out.print("""
                                       ¿DESEA HACER ALGO MÁS?
                                        
                                       1- SI
                                       0- NO
                                        """);
                        opcion=entrada.nextInt();
                    }while(opcion>1||opcion<0);
                }while (opcion != 0);
            }
        }
        if(!flag){
            System.out.print("""
                                        ------------------------------
                                        |          ¡¡ERROR!!         |
                                        |     RUT NO ENCONTRADO      |
                                        ------------------------------
                                        """);
        }


    }


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


