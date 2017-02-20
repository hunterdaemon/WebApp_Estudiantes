/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
/**
 *
 * @author DavidM
 */
public class Datos_Basicos_Profesor {
    
     @Override
    public String toString() {
        String a="";
        for (int i = 0; i < nombre.length; i++) {
            a=a+nombre[i];
        }
        String b="";
        for (int i = 0; i < apellido.length; i++) {
            b=b+apellido[i];
        }
        return "Base_Datos_Profesor{" + "id=" + id + ", nombre=" + a + ", apellido=" + b + ", ext=" + ext + '}';
    }
    
    
    
    private int id;
    private char[] nombre;
    private char[] apellido;
    private int ext;

    public Datos_Basicos_Profesor() {
        this.id = id;
        this.nombre = new char[20];
        this.apellido = new char[20];
        this.ext = ext;
  }

    public Datos_Basicos_Profesor(String id, String nombre, String apellido, String ext) {
     
        char[] a=new char[20];
        char[] b= nombre.toCharArray();
        
        for (int i = 0; i < 20; i++) {
            if (i<b.length) {
                a[i]=b[i];
            }else{
                a[i]='\u0000';
            }
        }
        
        char[] c=new char[20];
        char[] d=apellido.toCharArray();
        
        for (int i = 0; i < 20; i++) {
            if (i<d.length) {
                c[i]=d[i];
            }else{
                c[i]='\u0000';
                
            }
        }
        
        this.id=Integer.valueOf(id);
        this.nombre=a;
        this.apellido=c;
        this.ext=Integer.valueOf(ext);
        
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public char[] getApellido() {
        return apellido;
    }

    public void setApellido(char[] apellido) {
        this.apellido = apellido;
    }

    public int getExt() {
        return ext;
    }

    public void setExt(int ext) {
        this.ext = ext;
    }
    
    
    
}
