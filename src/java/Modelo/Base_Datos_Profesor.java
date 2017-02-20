/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author DavidM
 */
public class Base_Datos_Profesor {

   
    private ArrayList<Object> profesores;
    ArrayList colita= new ArrayList();

    public Base_Datos_Profesor() {
    this.profesores=new ArrayList<>();
    }
    
    public void agregar(Datos_Basicos_Profesor e){
        this.profesores.add(e);
        archivo(e);
    }
    
    public void archivo(Datos_Basicos_Profesor e){
        try {
            
            RandomAccessFile raf= new RandomAccessFile("Profesores.txt", "rw");
            long tamaño=raf.length();
            File archivo=new File("Profesores.txt");
            raf.seek(tamaño);
            raf.writeInt(e.getId());
            System.out.println(archivo.getAbsolutePath());
            
            for (int i = 0; i < 20; i++) {
                raf.writeChar((int)e.getNombre()[i]);
            }
            for (int i = 0; i < 20; i++) {
                raf.writeChar((int)e.getApellido()[i]);
            }
            
            
            raf.writeInt(e.getExt());
            
            
            
        } catch (Exception error) {
        }
    
    }
    
    public ArrayList cargar(){
        try {
            RandomAccessFile raf= new RandomAccessFile("Profesores.txt", "rw");
            long a=raf.length();
            
            for (int i = 0; i < a; i=i+88) {
                Datos_Basicos_Profesor D=new Datos_Basicos_Profesor();
                raf.seek(i);
                
                D.setId(raf.readInt());
                
                char[] nombre=new char[20];
                for (int j = 0; j < 20; j++) {
                    nombre[j]=raf.readChar();
                }
                
                D.setNombre(nombre);
                
                char[] apellido=new char[20];
                for (int j = 0; j < 20; j++) {
                    apellido[j]=raf.readChar();
                }
                
                D.setApellido(apellido);
                
                D.setExt(raf.readInt());
                colita.add(D);
                
            }
        } catch (Exception e) {
        }
        return colita;
    }
    
    public ArrayList listar(){
        return profesores;
    }

    @Override
    public String toString() {
        return "Base_Datos_Profesor{" + "profesores=" + profesores + '}';
    }
    
    
    
}
