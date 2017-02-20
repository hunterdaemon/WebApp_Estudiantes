/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David
 */
public class Datos_Basicos_Inscripcion {
    
    private int idEstudiante;
    private int idCurso;
    private char[] fechaInscripcion;
    private char[] fechaFin;
    private double nota;
    private int Duracion;

    public Datos_Basicos_Inscripcion() {
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.fechaInscripcion = new char[10];
        this.fechaFin = new char[10];
        this.nota = nota;
        this.Duracion=Duracion;
    }

    public Datos_Basicos_Inscripcion(String idEstudiante, String idCurso, String fechaInscripcion, String fechaFin, String nota) {
        this.idEstudiante = Integer.valueOf(idEstudiante);
        this.idCurso = Integer.valueOf(idCurso);
        
         String[] añ=fechaInscripcion.split("");
        String añ1="";
        for (int i = 6; i < 10; i++) {
            añ1=añ1+""+añ[i];
            
        }
        
        int año1=Integer.valueOf(añ1);
        
        String[] añf=fechaFin.split("");
        String añ1f="";
        for (int i = 6; i < 10; i++) {
            añ1f=añ1f+añf[i];
        }
        int año2=Integer.valueOf(añ1f);
        int año= año2-año1;
        
      String[] fe=fechaInscripcion.split("");
        String fe1=fe[3];
        fe1=fe1+fe[4];
        int fi=Integer.valueOf(fe1);
        String[] fef=fechaFin.split("");
        String fef1=fef[3];
        fef1=fef1+fef[4];
        int fi2=Integer.valueOf(fef1);
        int mes=fi2-fi;
        
        String[] di=fechaInscripcion.split("");
        String di1=di[0];
        di1=di1+di[1];
        int de=Integer.valueOf(di1);
        String[] dif=fechaFin.split("");
        String dif1=dif[0];
        dif1=dif1+dif[1];
        int de2=Integer.valueOf(dif1);
        int dia=de2-de;
        
        int dura= 365*año+30*mes+dia;
        this.Duracion=dura;
       char[] a=new char[10];
       char[] b= fechaInscripcion.toCharArray();
        for (int i = 0; i < 10; i++) {
            if (i<b.length) {
              a[i]=b[i];  
            }else{
                a[i]='\u0000';
            }
        }
        
        char[] c=new char[10];
       char[] d= fechaFin.toCharArray();
        for (int i = 0; i < 10; i++) {
             if (i<d.length) {
              c[i]=d[i];  
            }else{
                c[i]='\u0000';
            }
        }
        this.fechaInscripcion = a;
        this.fechaFin = c;
        
        
        this.nota = Double.valueOf(nota);
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public char[] getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(char[] fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public char[] getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(char[] fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
}
