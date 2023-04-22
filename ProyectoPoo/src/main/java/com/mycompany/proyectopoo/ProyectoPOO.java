/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectopoo;

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

    public static void main(String[] args) throws FileNotFoundException {
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
            System.out.println("¿QUE DESEA HACER?");
            System.out.println("1- Crear Cuenta");
            System.out.println("2- Imprimir");
            System.out.println("3- Modificar");
            System.out.println("4- Eliminar");
            System.out.println("5- Agregar");
            System.out.println("0- Salir del programa");
            opcion1=Entrada.nextInt();

            //CRUD
            switch(opcion1){
                case 1:
                    user.crearUsuario();
                    break;
                case 2:
                    user.imprimirDatos(user.getUsers());
                    break;
                case 3:
                    System.out.println("Escriba el rut para identificarlo");
                    String rutPorBuscar = rut.nextLine();
                    user.actualizarDatos(rutPorBuscar);
                    break;
                case 4:
                    System.out.println("Escriba el rut del usuario que desea eliminar");
                    String rutUsuario = rut.nextLine();
                    if(user.eliminarDatos(rutUsuario) == true){
                        System.out.println("El usuario ha sido eliminado");
                    }else{
                        System.out.println("No se ha encontrado el usuario, porfavor, verifique el rut");
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
