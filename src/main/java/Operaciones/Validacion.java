package Operaciones;

import com.sun.source.tree.AssertTree;
import org.apache.commons.validator.routines.EmailValidator;
import javax.swing.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion{
    public Scanner Entrada=new Scanner(System.in);

    public Validacion(){

    }
    
    public int isPositiveInteger(String numero) {
        if(numero.isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UNA ALTURA", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            int num =Integer.parseInt(numero);
            if(num>300){
                JOptionPane.showMessageDialog(null, "ALTURA NO VÁLIDA\n formato de cm: 123", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(num<0){
                JOptionPane.showMessageDialog(null, "ALTURA NO VÁLIDA\ningrese una altura mayor a 40 centímetros y en formato de cm: 123", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return num;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ALTURA NO VÁLIDA\ningrese una altura mayor a 0 y en formato de cm: 123", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public boolean isName(String name){
        Pattern pattern = Pattern.compile ("^[A-Za-z ]+$");
        Matcher matcher = pattern.matcher (name);
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UN NOMBRE O APELLIDO", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(name.length()>35||!(matcher.matches())){
            JOptionPane.showMessageDialog(null, "¡¡¡NOMBRE O APELLIDO NO VÁLIDO!!!\n VERIFIQUE QUE EL NOMBRE SEAN SOLO LETRAS", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return true;
        }
    }

    public Double isDouble(String numero) throws ParseException {
        double num=0;
        if(numero.isEmpty()){
                JOptionPane.showMessageDialog(null, "INGRESE UN PESO", "Error", JOptionPane.ERROR_MESSAGE);
                return num;
        }
        num = Double.parseDouble(numero.replace(',', '.'));
        if(num<=2.0||num>635){
                JOptionPane.showMessageDialog(null, "PESO NO VÁLIDO\ningrese un peso mayor a 2.0 y en formato de kg: 11,11 ó 11.11", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return num;
    }

    public boolean isValidEmail(String email) {
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UN CORREO\nINGRESA UN CORREO", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try{
            if(EmailValidator.getInstance().isValid(email)){
                return true;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "EMAIL NO VÁLIDO", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null, "EMAIL NO VÁLIDO", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public int isValidDate(Date date){
        try{
            Instant instant= date.toInstant();
            LocalDate localDate = LocalDate.ofInstant(instant,ZoneId.systemDefault());
            LocalDate localNow = LocalDate.now();
            Period period = Period.between(localDate, localNow);
            int years=period.getYears();
            if(years>=120){
                JOptionPane.showMessageDialog(null, "FECHA NO VÁLIDA", "Error", JOptionPane.ERROR_MESSAGE); 
            }else if(years<=4){
                JOptionPane.showMessageDialog(null, "FECHA NO VÁLIDA\nsólo para mayores de 4 anyos", "Error", JOptionPane.ERROR_MESSAGE); 
            }
            return years;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "FECHA NO VÁLIDA\nsólo para mayores de 4 anyos", "Error", JOptionPane.ERROR_MESSAGE); 
            return 0;
        }
    }

    public boolean isStrongPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[¿?¡!.,@#$%^&*]).{12,16}$";
        if(password.isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UNA CONTRASEÑA", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(password.length()<12){
            JOptionPane.showMessageDialog(null, "CONTRASEÑA DEMASIADO CORTA", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (password.length()>16) {
            JOptionPane.showMessageDialog(null, "CONTRASEÑA DEMASIADO LARGA", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(!Pattern.matches(regex, password)){
            JOptionPane.showMessageDialog(null, "CONTRASEÑA NO VÁLIDA\nDebe tener al menos un/a: mayúscula, minúscula, número y caracter especial como ¿?¡!.,@#$%^&*", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean validarRUT (String rut) {

        if(rut.isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UN RUT\nINGRESA UN RUT\nejemplo: 11222333-4", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if (rut.length() != 10 || rut.charAt(8) != '-') {
            JOptionPane.showMessageDialog(null, "RUT NO VALIDO\nejemplo: 11222333-4", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String numero = rut.substring(0, 8);
        char digito = rut.charAt(9);

        int num;
        try {
            num = Integer.parseInt(numero, 10); // Usar la base 10
        } catch (NumberFormatException e) {
            return false;
        }

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
        if(verificador != Character.getNumericValue(digito)){
            JOptionPane.showMessageDialog(null, "RUT NO VALIDO\nejemplo: 11222333-4", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return verificador == Character.getNumericValue(digito);
    }
}

