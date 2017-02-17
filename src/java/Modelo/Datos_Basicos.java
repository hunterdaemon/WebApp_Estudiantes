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
public class Datos_Basicos {

    @Override
    public String toString() {
        String a = "";
        for (int i = 0; i < name.length; i++) {
            a=a+name[i];
        }
                String b = "";
        for (int i = 0; i < lastname.length; i++) {
            b=b+lastname[i];
        }
        return  "name=" + a + ", lastname=" + b + ", promedio=" + promedio + ", genero=" + genero + "\n";
    }
    
    private char[] name;
    private char[] lastname;
    private double promedio;
    private int genero;

    public Datos_Basicos() {
        this.name = new char[20];
        this.lastname = new char[20];
        this.promedio = promedio;
        this.genero = genero;
    }

    public Datos_Basicos(String name, String lastname, String promedio, String genero) {
        
       char[] a=new char[20];
       char[] b= name.toCharArray();
        for (int i = 0; i < 20; i++) {
            if (i<b.length) {
              a[i]=b[i];  
            }else{
                a[i]='\u0000';
            }
        }
        
        char[] c=new char[20];
       char[] d= lastname.toCharArray();
        for (int i = 0; i < 20; i++) {
             if (i<d.length) {
              c[i]=d[i];  
            }else{
                c[i]='\u0000';
            }
        }
        
//        char[] e=new char[5];
//       char[] f= promedio.toCharArray();
//        for (int i = 0; i < 5; i++) {
//             if (i<f.length) {
//              e[i]=f[i];  
//            }else{
//                e[i]='\u0000';
//            }
//        }
        
        this.name = a;
        this.lastname = c;
        this.promedio = Double.valueOf(promedio);
        
        if (genero.equals("Masculino")) {
           this.genero=1;  
        }else{
            this.genero=0;
        }
    }

    public char[] getName() {
        return name;
    }

    public void setName(char[] name) {
        this.name = name;
    }

    public char[] getLastname() {
        return lastname;
    }

    public void setLastname(char[] lastname) {
        this.lastname = lastname;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }


    

   
  
    
    
}

