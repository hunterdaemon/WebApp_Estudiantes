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
     public void LeerArbol() {
        try {
            RandomAccessFile raf = new RandomAccessFile("ProfesoresArbol.txt", "rw");
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

            RandomAccessFile raf = new RandomAccessFile("ProfesoresArbol.txt", "rw");
            RandomAccessFile raf1 = new RandomAccessFile("Profesores.txt", "rw");

            long tamaño = raf1.length();

            System.out.println(tamaño);
            File archivo = new File("Estudiantes.txt");
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

    public void BuscarArbol(int id) {
        int rest = 1;
        try {
            int res = -1;
            RandomAccessFile raf = new RandomAccessFile("ProfesoresArbol.txt", "rw");

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
                RandomAccessFile raf1 = new RandomAccessFile("Profesores.txt", "rw");
                Datos_Basicos_Profesor D = new Datos_Basicos_Profesor();
                raf1.seek(res);
                D.setId(raf1.readInt());
                char[] nombre = new char[20];
                for (int j = 0; j < 20; j++) {
                    nombre[j] = raf1.readChar();
                }
                D.setNombre(nombre);

                char[] apellido = new char[20];
                for (int j = 0; j < 20; j++) {
                    apellido[j] = raf1.readChar();
                }
                D.setApellido(apellido);

                D.setExt(raf1.readInt());

                System.out.println(D.getNombre());
                System.out.println(D.getApellido());
                System.out.println(D.getId());
                System.out.println(D.getExt());
            }

        } catch (Exception e) {
        }

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
