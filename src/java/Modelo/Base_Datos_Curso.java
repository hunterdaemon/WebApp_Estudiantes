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
public class Base_Datos_Curso {
    
   private  ArrayList<Object> cursos;
    ArrayList colita = new ArrayList(); 
  
    public Base_Datos_Curso() {
        this.cursos = new ArrayList<>();
    }
   
         public void LeerArbol() {
        try {
            RandomAccessFile raf = new RandomAccessFile("CursosArbol.txt", "rw");
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

            RandomAccessFile raf = new RandomAccessFile("CursosArbol.txt", "rw");
            RandomAccessFile raf1 = new RandomAccessFile("Cursos.txt", "rw");

            long tamaño = raf1.length();

            System.out.println(tamaño);
            File archivo = new File("Estudiantes.txt");
            System.out.println(archivo.getAbsolutePath());
            for (int i = 0; i < tamaño; i = i + 52) {
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

    public void BuscarArbol(int id) {
        int rest = 1;
        try {
            int res = -1;
            RandomAccessFile raf = new RandomAccessFile("CursosArbol.txt", "rw");

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
                System.out.println("el dato buscado no se encuentra registrado");
            } else {
                RandomAccessFile raf1 = new RandomAccessFile("Cursos.txt", "rw");
                Datos_Basicos_Curso D = new Datos_Basicos_Curso();
                raf1.seek(res);
                D.setCodigo(raf1.readInt());
                char[] nombre = new char[20];
                for (int j = 0; j < 20; j++) {
                    nombre[j] = raf1.readChar();
                }
                D.setNombre(nombre);

                
                D.setDuracion(raf1.readInt());

                D.setIdProfesor(raf1.readInt());

                System.out.println(D.getNombre());
                System.out.println(D.getDuracion());
                System.out.println(D.getCodigo());
                System.out.println(D.getIdProfesor());
            }

        } catch (Exception e) {
        }

    }

    public void Agregar(Datos_Basicos_Curso e){
        this.cursos.add(e);
        archivos(e);
    }
    
    public void archivos(Datos_Basicos_Curso e){
        try {
            RandomAccessFile raf=new RandomAccessFile("Cursos.txt", "rw");
            long tamaño= raf.length();
            File archivo=new File("Cursos.txt");
            System.out.println(archivo.getAbsolutePath());
            
            raf.seek(tamaño);
            
            raf.writeInt(e.getCodigo());
            
            for (int i = 0; i < 20; i++) {
                raf.writeChar((int)e.getNombre()[i]);
            }
            
            raf.writeInt(e.getDuracion());
            raf.writeInt(e.getIdProfesor());
            
            
        } catch (Exception error) {
        }
    }
    
    public ArrayList cargar(){
        try {
            
            RandomAccessFile raf=new RandomAccessFile("Cursos.txt", "rw");
            long a= raf.length();
            
            for (int i = 0; i < a; i=i+52) {
                
                Datos_Basicos_Curso db=new Datos_Basicos_Curso();
                raf.seek(i);
                
                db.setCodigo(raf.readInt());
                
                char[] nombre=new char[20];
                for (int j = 0; j < 20; j++) {
                    nombre[j]=raf.readChar();
                }
                
                db.setNombre(nombre);
                db.setDuracion(raf.readInt());
                db.setIdProfesor(raf.readInt());
                
                colita.add(db);
                
            }
            
            
        } catch (Exception error) {
        }
        return colita;
    }
    
    public ArrayList listar(){
        return cursos;
    }

    @Override
    public String toString() {
        return "Base_Datos_Curso{" + "cursos=" + cursos + '}';
    }
    
    
}
