/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author vice1
 */
public class Excel {
    
    private String Ubicacion;

    public Excel(String ubicacion){
        this.Ubicacion = Ubicacion;
    }
    
    public void Leer() throws CsvValidationException{
        File file = new File(this.Ubicacion);
        try {
            FileReader inputfile = new FileReader("src/test/java/ArchivoDePrueba.csv");
            CSVReader reader = new CSVReader(inputFile);
        
            String[] nextRecord;
            
            int i=0;
            while ((nextRecord = reader.readNext()) != null) {
                
                if(i>0)LUsuarios.add(new Usuario(nextRecord[0],nextRecord[1],nextRecord[2],Boolean.valueOf(nextRecord[3]),nextRecord[4]));
                  
                
                for (String cell : nextRecord) {
                    
                    System.out.print(cell + "\t");
                }
                i++;
                System.out.println();
            }
            
        
        }catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
    }
    
    
}
