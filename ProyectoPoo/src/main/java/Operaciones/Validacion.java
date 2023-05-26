package Operaciones;

import java.util.Scanner;

public class Validacion{
    public Scanner Entrada=new Scanner(System.in);

    public Validacion(){

    }
    public void Mensaje(String texto){
        System.out.println(texto);
    }
    public int ValidarEntero(){
        int Cadena=-1;
        do{
            try{
                Cadena=Entrada.nextInt();
                return Cadena;

            }catch(Exception e){
                Mensaje("Dato no válido "+e.toString());
            }

        }while(Cadena<0 || Cadena==0);


        return Cadena;
    }

    public String ValidarNombres(){
        String Cadena=null;
        do{
            try{
                Cadena=Entrada.next();
            }catch(Exception e){
                Mensaje("Este dato no es válido");
            }
        }while(Cadena==null || !(Cadena.matches("[A-Za-z]*")));

        return Cadena;
    }

    public double ValidarDouble(){

        double Cadena;
        try{
            Cadena=Entrada.nextDouble();
            return Cadena;

        }catch(Exception e){
            Mensaje("Este dato no es válido");
        }
        return -1;

    }

    public String ValidarAlfanumerico(){
        String cadena=Entrada.next();
        if(cadena.matches("[A-Za-z0-9]*"))
            return cadena;
        else
            Mensaje("Dato no válido");

        return null;
    }

    public boolean verificarMail(String mail) {
        char arroba = '@';
        for (int i = 0; i < mail.length(); i++) {
            if (mail.charAt(i) == arroba) {
                return true;
            }

        }
        return false;
    }
    public String ValidarFecha(){
        return null;
    }

}

