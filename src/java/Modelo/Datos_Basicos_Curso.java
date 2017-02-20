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
public class Datos_Basicos_Curso {

    @Override
    public String toString() {
        
        String a="";
        for (int i = 0; i < nombre.length; i++) {
            a=a+nombre[i];
        }
        return "Datos_Basicos_Curso{" + "codigo=" + codigo + ", nombre=" + a + ", duracion=" + duracion + ", IdProfesor=" + IdProfesor + '}';
    }



    
    private int codigo;
    private char[] nombre;
    private int duracion;
    private int IdProfesor;

    public Datos_Basicos_Curso() {
        this.codigo = codigo;
        this.nombre = new char[20];
        this.duracion = duracion;
        this.IdProfesor = IdProfesor;
    }

    public Datos_Basicos_Curso(String codigo, String nombre, String duracion, String IdProfesor) {
       
        this.codigo=Integer.valueOf(codigo);
        
        char[] a=new char[20];
        char[] b= nombre.toCharArray();
        
        for (int i = 0; i < 20; i++) {
            if (i<b.length) {
                a[i]=b[i];
            }else{
                a[i]='\u0000';
            }
        }
        this.nombre=a;
        
        this.duracion=Integer.valueOf(duracion);
        
        this.IdProfesor=Integer.valueOf(IdProfesor);
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(int IdProfesor) {
        this.IdProfesor = IdProfesor;
    }
    
    
    
    
    
    
}
