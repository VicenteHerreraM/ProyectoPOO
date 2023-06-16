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
    public void Mensaje(String texto){
        System.out.println(texto);
    }
    public int isPositiveInteger(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return 0;
        }
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

    public Double isDouble(String numero) throws ParseException {
        NumberFormat nfUS = NumberFormat.getInstance(Locale.US);
        NumberFormat nfFR = NumberFormat.getInstance(Locale.FRANCE);
        double num=0;
        try {
            num = nfUS.parse(numero).doubleValue();
        } catch (ParseException e) {
            num = nfFR.parse(numero).doubleValue();
        }
        return num;
    }

    public boolean isValidEmail(String email) {
        try{
            if(EmailValidator.getInstance().isValid(email)){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
    public int isValidDate(Date date){
        try{
            Instant instant= date.toInstant();
            LocalDate localDate = LocalDate.ofInstant(instant,ZoneId.systemDefault());
            LocalDate localNow = LocalDate.now();
            Period period = Period.between(localDate, localNow);
            return period.getYears();
        }catch(Exception e){
            return 0;
        }
    }

    public boolean isStrongPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{12,16}$";
        if(!Pattern.matches(regex, password))
        {
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

