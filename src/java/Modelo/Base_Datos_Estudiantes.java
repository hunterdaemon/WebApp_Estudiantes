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
import Modelo.Datos_Basicos_Estudiantes;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author David
 */
public class Base_Datos_Estudiantes {
    
    

    private ArrayList<Object> estudiantes;
    ArrayList colita = new ArrayList<>();
    
    public Base_Datos_Estudiantes() {
        this.estudiantes = new ArrayList<>();
    }
        public void LeerArbol() {
        try {
            RandomAccessFile raf = new RandomAccessFile("EstudiantesArbol.txt", "rw");
            long tamaño = raf.length();
            raf.seek(0);
            for (int j = 0; j < 8; j++) {

                for (int i = 0; i < 4; i++) {

                    System.out.print(raf.readInt() + " ");
                }
                System.out.println("");
            }

        } catch (Exception e) {
        }

    }

    public void Arbol() {
        AministradorArboles aministradorArboles = new AministradorArboles();
        NodoArbolitos arb = new NodoArbolitos();
        arb = null;
        try {

            RandomAccessFile raf = new RandomAccessFile("EstudiantesArbol.txt", "rw");
            RandomAccessFile raf1 = new RandomAccessFile("Estudiantes.txt", "rw");

            long tamaño = raf1.length();

            System.out.println(tamaño);
            File archivo = new File("EstudiantesArbol.txt");
            archivo.delete();
            System.out.println(archivo.getAbsolutePath());
            for (int i = 0; i < tamaño; i = i + 88) {
                raf1.seek(i);

                arb = aministradorArboles.insetrNodo(arb, raf1.readInt(), i, (int) raf.getFilePointer());
                raf1.seek(i);

                raf.writeInt(raf1.readInt());

                raf.seek(raf.getFilePointer() + 8);
                raf.writeInt(i);

            }

            long tamaño1 = raf.length();
            NodoArbolitos arbp = arb;
            for (int i = 0; i < tamaño1; i = i + 16) {
                raf.seek(i);

                arb = aministradorArboles.BuscarNodo(arbp, raf.readInt());
                if (aministradorArboles.EvaluarSesHoja(arb) == false) {

                    try {
                        if (arb.izquierda != null) {
                            raf.seek(i + 4);

                            raf.writeInt(arb.izquierda.pos1);
                        }
                    } catch (Exception e) {
                        System.out.println("nada izquierda");
                    }

                    try {
                        if (arb.derecha != null) {
                            raf.seek(i + 8);
                            raf.writeInt(arb.derecha.pos1);
                        }
                    } catch (Exception e) {
                        System.out.println("nada derecha");
                    }
                } else {

                }
//                System.out.println(arb.informacion+"info");

            }
//            aministradorArboles.imprimirArboles(arb);

            // set the file pointer at 0 position  
        } catch (Exception error) {
            System.out.println("acaestoy");
        }

    }

    public Datos_Basicos_Estudiantes BuscarArbol(int id) {
        int rest = 1;
        try {
            int res = -1;
            RandomAccessFile raf = new RandomAccessFile("EstudiantesArbol.txt", "rw");

            raf.seek(0);

            while (res == -1) {
                int num = raf.readInt();
                if (id == num) {
                    raf.seek(raf.getFilePointer() + 8);
                    res = raf.readInt();

                } else if (id > num) {

                    raf.seek(raf.getFilePointer() + 4);
                    if (raf.readInt() == 0) {
                        rest = 0;
                        break;
                    } else {
                        raf.seek(raf.getFilePointer() - 4);
                    }
                    raf.seek(raf.readInt());

                } else {
                    if (raf.readInt() == 0) {
                        rest = 0;
                        break;
                    } else {
                        raf.seek(raf.getFilePointer() - 4);
                    }
                    raf.seek(raf.getFilePointer() + 0);
                    raf.seek(raf.readInt());

                }

            }
            if (rest == 0) {
                return null;
            } else {
                RandomAccessFile raf1 = new RandomAccessFile("Estudiantes.txt", "rw");
                Datos_Basicos_Estudiantes D = new Datos_Basicos_Estudiantes();
                raf1.seek(res);
                D.setId(raf1.readInt());
                char[] nombre = new char[20];
                for (int j = 0; j < 20; j++) {
                    nombre[j] = raf1.readChar();
                }
                D.setName(nombre);

                char[] apellido = new char[20];
                for (int j = 0; j < 20; j++) {
                    apellido[j] = raf1.readChar();
                }
                D.setLastname(apellido);

                D.setTelefono(raf1.readInt());

                System.out.println(D.getName());
                System.out.println(D.getLastname());
                System.out.println(D.getId());
                System.out.println(D.getTelefono());
                return D;
            }

        } catch (Exception e) {
        }
return null;
    }

    public void agregar (Datos_Basicos_Estudiantes e){
    this.estudiantes.add(e);
    archivo(e);
    }
    
    public void archivo(Datos_Basicos_Estudiantes e){
        try {
         RandomAccessFile raf = new RandomAccessFile("Estudiantes.txt", "rw");
         long tamaño=raf.length();
          File archivo = new File("Estudiantes.txt");
            System.out.println(archivo.getAbsolutePath());
            raf.seek(tamaño);
         
             raf.writeInt(e.getId());
             
              for (int j = 0; j < 20; j++) {
                 raf.writeChar((int)e.getName()[j]); 
              }
              for (int j = 0; j < 20; j++) {
                 raf.writeChar((int)e.getLastname()[j]); 
              }
//              for (int j = 0; j < 5; j++) {
//                 raf.writeChar((int)e.getPromedio()[j]); 
//              }
                raf.writeInt(e.getTelefono());
               
            
          // set the file pointer at 0 position  
        } catch (Exception error) {
        }
       
    }
    
    public ArrayList cargar(){
        try {
            RandomAccessFile raf = new RandomAccessFile("Estudiantes.txt", "rw");
            long a=raf.length();
        for (int i = 0; i <a ; i=i+88) {
//            System.out.println(i);

            
            Datos_Basicos_Estudiantes D = new Datos_Basicos_Estudiantes();
            raf.seek(i);
           D.setId(raf.readInt());
           
            char[] nombre=new char[20];
            for (int j = 0; j < 20; j++) {
                nombre[j]=raf.readChar();
            }
//            for (int j = 0; j < nombre.length; j++) {
//                System.out.println(nombre[j]);
//            }
            D.setName(nombre);
         
            char[] apellido=new char[20];
            for (int j = 0; j < 20; j++) {
                apellido[j]=raf.readChar();
            }
            D.setLastname(apellido);
            
            D.setTelefono(raf.readInt());
            
            
            colita.add(D);
//            System.out.println(D.getName());
//            System.out.println(D.getLastname());
//            System.out.println(D.getPromedio());
//            System.out.println(D.getGenero());
            
        }
            
      } catch (IOException ex) {
         ex.printStackTrace();
      }
        
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
