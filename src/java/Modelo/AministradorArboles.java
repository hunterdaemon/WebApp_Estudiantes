
package Modelo;

public class AministradorArboles {
    
    
    public void imprimirArboles(NodoArbolitos a){
   if(a!=null){
        System.out.println(a.informacion+" "+a.pos+" "+a.pos1);
       
        imprimirArboles(a.derecha);
         imprimirArboles(a.izquierda);
        }
      
    }
    
public void Preorden(NodoArbolitos a){
    if(a!=null){
        System.out.println(a.informacion);
        Preorden(a.izquierda);
        Preorden(a.derecha);
        
    }
    
    
}

public void inorden(NodoArbolitos a){
    if(a!=null){
        inorden(a.izquierda);
        System.out.println(a.informacion);
        inorden(a.derecha);
        
    }
    
}
public void posorden(NodoArbolitos a){
    if(a!=null){
        posorden(a.izquierda);
        posorden(a.derecha);
        System.out.println(a.informacion);
    }
    
    
}
public NodoArbolitos insetrNodo(NodoArbolitos a,int valor,int pos,int pos1){
    NodoArbolitos p = a;
    
    if (p == null) {
     
        p = new NodoArbolitos();
        p.informacion = valor;
        p.pos=pos;
        p.pos1=pos1;
        
    }
    if (p.informacion <valor) {

        if (p.derecha == null) {
            p.derecha = new NodoArbolitos();
            p.derecha.informacion = valor;
            p.derecha.pos=pos;
            p.derecha.pos1=pos1;
            insetrNodo(p, valor,pos,pos1);
        } 
            else {

            
            insetrNodo(p.derecha, valor,pos,pos1);
        }
    }
    if (p.informacion > valor) {

        if (p.izquierda == null) {
            p.izquierda = new NodoArbolitos();
            p.izquierda.informacion = valor;
            p.izquierda.pos=pos;
            p.izquierda.pos1=pos1;
            insetrNodo(p, valor,pos,pos1);
        } 
        else {

            
            insetrNodo(p.izquierda, valor,pos,pos1);
        }

    
    }
    
    
   

 return p;
}
public NodoArbolitos BuscarNodoaEliminar(NodoArbolitos a,int valor){

    if (a==null) {
        return null;
    }else{
        if (a.informacion==valor) {
            return a;
        }
        else if (a.informacion>valor) {
            return BuscarNodoaEliminar(a.izquierda, valor);
        }else{
    return BuscarNodoaEliminar(a.derecha, valor);
    }
    }
    

}
public NodoArbolitos BuscarNodo(NodoArbolitos a,int valor){

    if (a==null) {
        return null;
    }else{
        if (a.informacion==valor) {
            return a;
        }
        else if (a.informacion>valor) {
            return BuscarNodoaEliminar(a.izquierda, valor);
        }else{
    return BuscarNodoaEliminar(a.derecha, valor);
    }
    }
    

}
public boolean EvaluarSesHoja(NodoArbolitos a){
    if ((a.derecha==null)&&(a.izquierda==null)) {
        return true;
    }else{
    return false;
    }
}


public NodoArbolitos BuscarMasPequeño(NodoArbolitos a){
   
    a=a.derecha;
    while(a.izquierda!=null){
     a=a.izquierda;
    }
    return a;
}


public NodoArbolitos BuscarMasGrande(NodoArbolitos a){
   
    a=a.izquierda;
    while(a.derecha!=null){
     a=a.derecha;
    }
    return a;
}


}
    

