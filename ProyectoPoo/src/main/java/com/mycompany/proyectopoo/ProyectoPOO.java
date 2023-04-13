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
            System.out.println("5- Actualizar");
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
                    user.modificarDatos();
                    break;
                case 4:
                    user.eliminarDatos(user.getUsers());
                    break;
                case 5:
                    //user.actualizarDatos();
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
