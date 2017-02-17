/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import Modelo.Datos_Basicos;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author David
 */
public class Base_Datos {
    
    private ArrayList<Object> estudiantes;
    ArrayList colita = new ArrayList<>();
    
    public Base_Datos() {
        this.estudiantes = new ArrayList<>();
    }
    
    public void agregar (Datos_Basicos e){
    this.estudiantes.add(e);
    archivo(e);
    }
    
    public void archivo(Datos_Basicos e){
        try {
         RandomAccessFile raf = new RandomAccessFile("Estudiantes.txt", "rw");
         long tamaño=raf.length();
          File archivo = new File("Estudiantes.txt");
            System.out.println(archivo.getAbsolutePath()+"hmmmmizii");
            raf.seek(tamaño);
         
         
              for (int j = 0; j < 20; j++) {
                 raf.writeChar((int)e.getName()[j]); 
              }
              for (int j = 0; j < 20; j++) {
                 raf.writeChar((int)e.getLastname()[j]); 
              }
//              for (int j = 0; j < 5; j++) {
//                 raf.writeChar((int)e.getPromedio()[j]); 
//              }
            raf.writeDouble(e.getPromedio());
            raf.writeInt(e.getGenero());
            
          // set the file pointer at 0 position  
        } catch (Exception error) {
        }
       
    }
    
    public ArrayList cargar(){
        try {
            RandomAccessFile raf = new RandomAccessFile("Estudiantes.txt", "rw");
            long a=raf.length();
            System.out.println(a+" asi de larga esta mi verga");
        for (int i = 0; i <a ; i=i+92) {
            System.out.println(i);
            
            Datos_Basicos D = new Datos_Basicos();
            raf.seek(i);
           
            char[] nombre=new char[20];
            for (int j = 0; j < 20; j++) {
                nombre[j]=raf.readChar();
            }
            for (int j = 0; j < nombre.length; j++) {
                System.out.println(nombre[j]);
            }
            D.setName(nombre);
         
            char[] apellido=new char[20];
            for (int j = 0; j < 20; j++) {
                apellido[j]=raf.readChar();
            }
            D.setLastname(apellido);
            
            D.setPromedio(raf.readDouble());
            D.setGenero(raf.readInt());
            
            colita.add(D);
            System.out.println(D.getName());
            System.out.println(D.getLastname());
            System.out.println(D.getPromedio());
            System.out.println(D.getGenero());
            
        }
            
      } catch (IOException ex) {
         ex.printStackTrace();
      }
        Collections.sort(colita, new Comparator() {
	

            
            public int compare(Datos_Basicos p1, Datos_Basicos p2) {
                return new Integer((int)p1.getPromedio()).compareTo(new Integer((int)p2.getPromedio()));
            }

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
       return colita;
    }
    
    public ArrayList listar() {
      return estudiantes;
    }

    @Override
    public String toString() {
        return "Base_Datos{" + "estudiantes=" + estudiantes + '}';
    }
    
    
}
