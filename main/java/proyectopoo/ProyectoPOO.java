/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyectopoo;


import Modelos.Usuario;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dorian Ignacio Canales Esteban
 *         Vicente Joaquin Herrera Meza
 *         Ignacio Esteban Villalobos Jeria
 */

/**
 * Con la opcion 1 va a leer el archivo de texto y lo agrega a una lista
 * Con la opcion 2 va a imprimir los elementos leidos del txt
 * 
 */

public class ProyectoPOO {
    
   
    public static void main() throws  FileNotFoundException {
        int opcion1;
        Usuario user=new Usuario();
        Scanner Entrada=new Scanner(System.in);
        Scanner rut = new Scanner(System.in);

        System.out.println("""
                ------------------------
                |  BIENVENIDO A CBOOM  |
                ------------------------
                """);
        do{
            System.out.println("""
                ¿QUE DESEA HACER?
                1- LEER CSV USUARIOS
                2- USUARIO
                3- DIETA
                4- RUTINA
                0- SALIR DEL PROGRAMA
                """);
            opcion1=Entrada.nextInt();

            //CRUD
            switch(opcion1){
                case 1:
                    user.leerUsuario();
                    break;
                case 2:
                    user.options();
                    break;
                case 3:
                    System.out.print("Escriba el rut del usuario que desea modificar : ");
                    user.actualizarDatos(rut.nextLine());
                    break;
                case 4:
                    System.out.print ("Escriba el rut del usuario que desea eliminar : ");
                    if(user.eliminarDatos(rut.nextLine())){
                        System.out.print("""
                                        ------------------------
                                        |  USUARIO ELIMINADO   |
                                        ------------------------
                                        """);
                    }else{
                        System.out.print("""
                                        ------------------------------
                                        |          ¡¡ERROR!!         |
                                        | NO SE HA ENCONTRADO EL RUT |
                                        |      INTENTE MÁS TARDE     |
                                        ------------------------------
                                        """);
                    }
                    break;
                case 5:
                   user.agregarUsuario();
                    break;
                case 0:
                    System.out.println("""


                            ----------------------------------------------
                            |                 GRACIAS                    |
                            ----------------------------------------------

                            """);
                    break;
                default:
                    System.out.println("""
                            ----------------------------------------------
                            |                 ¡¡ERROR!!                  |
                            |    ¡¡LA OPCION INGRESADA NO ES VALIDA!!    |
                            |  COMPRUEBE EL VALOR INGRESADO Y REINTENTE  |
                            ----------------------------------------------""");
                    break;
            }
        }while(opcion1!=0);

        
    }
}
