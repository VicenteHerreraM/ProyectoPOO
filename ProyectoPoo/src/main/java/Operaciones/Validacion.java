package Operaciones;

import com.sun.source.tree.AssertTree;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validacion{
    public Scanner Entrada=new Scanner(System.in);

    public Validacion(){

    }
    public void Mensaje(String texto){
        System.out.println(texto);
    }
    public int isInteger(){
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

    public String isName(){
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

    public float isDouble(){

        float Cadena;
        try{
            Cadena=Entrada.nextFloat();
            return Cadena;

        }catch(Exception e){
            Mensaje("Este dato no es válido");
        }
        return -1;

    }

    public String isAlphanumeric(){
        String cadena=Entrada.next();
        if(cadena.matches("[A-Za-z0-9]*"))
            return cadena;
        else
            Mensaje("Dato no válido");

        return null;
    }

    public boolean isValidEmail(String email) {
        try{
            if(EmailValidator.getInstance().isValid(email)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean isValidDate(String date){
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20|21|22)\\d\\d$";
        return Pattern.matches(regex, date);
    }

    public static boolean isStrongPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{12,16}$";
        return Pattern.matches(regex, password);
    }
}

