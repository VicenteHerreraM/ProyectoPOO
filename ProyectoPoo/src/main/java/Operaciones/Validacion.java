package Operaciones;

import com.sun.source.tree.AssertTree;
import org.apache.commons.validator.routines.EmailValidator;

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
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

    public boolean isName(String name){
        Pattern pattern = Pattern.compile ("^[A-Za-z ]+$");
        Matcher matcher = pattern.matcher (name);
        if(name.length()>35||!(matcher.matches()))
        {
            JOptionPane.showMessageDialog(null, "¡¡¡NOMBRE NO VÁLIDO!!! VERIFIQUE QUE EL NOMBRE SON SOLO LETRAS", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
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
            JOptionPane.showMessageDialog(null, "EMAIL NO VÁLIDO", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    public boolean isValidDate(String date){
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20|21|22)\\d\\d$";
        return Pattern.matches(regex, date);
    }

    public boolean isStrongPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{12,16}$";
        if(!Pattern.matches(regex, password))
        {
            JOptionPane.showMessageDialog(null, "Contraseña no fuerte, verifique que tenga números y carácteres especiales", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean validarRUT (String rut) {

        if (rut.length() != 10 || rut.charAt(8) != '-') {
            return false;
        }

        String numero = rut.substring(0, 8);
        char digito = rut.charAt(9);

        int num;
        try {
            num = Integer.parseInt(numero, 10); // Usar la base 10
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El String no es un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Calcular el dígito verificador usando el algoritmo de la página web
        int suma = 0;
        int factor = 2;
        while (num > 0) {
            suma += (num % 10) * factor;
            num /= 10;
            factor++;
            if (factor > 7) {
                factor = 2;
            }
        }
        int resto = suma % 11; // El resto de dividir la suma por 11
        int verificador;
        if (resto == 0) { // Si el resto es cero, el verificador es cero
            verificador = 0;
        } else if (resto == 1) { // Si el resto es uno, el verificador es K
            verificador = Character.getNumericValue('K'); // Convertir la letra K en un número
        } else { // En cualquier otro caso, el verificador es 11 menos el resto
            verificador = 11 - resto;
        }

        return verificador == Character.getNumericValue(digito);
    }
}

