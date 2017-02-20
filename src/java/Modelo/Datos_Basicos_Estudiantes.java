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
public class Datos_Basicos_Estudiantes {

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
        return  "name=" + a + ", lastname=" + b + ", telefono=" + telefono + ", Id=" + Id + "\n";
    }
    
    private char[] name;
    private char[] lastname;
    private int telefono;
    private int Id;

    public Datos_Basicos_Estudiantes() {
        this.name = new char[20];
        this.lastname = new char[20];
        this.telefono = telefono;
        this.Id = Id;
    }

    public Datos_Basicos_Estudiantes(String name, String lastname, String telefono, String Id) {
        
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
        this.telefono = Integer.valueOf(telefono);
        this.Id=Integer.valueOf(Id);
        
        
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }




    

   
  
    
    
}

