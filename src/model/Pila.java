package model;

import java.util.Stack;

public class Pila {
    private Stack<Publicacion> pila;
    
    public Pila(){
        pila=new Stack<Publicacion>();
    }

    public boolean estaVacia() {
        return pila.isEmpty();
    }

    public void apilar(Publicacion publicacion) {
        pila.push(publicacion);
    }

    public Publicacion desapilar() throws IllegalStateException {
        if(estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return pila.pop();
    }

    public Publicacion verTope() throws IllegalStateException {
        if(estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return pila.peek();
    }
    
    public int tamano() {
        return pila.size();
    }
    
    public void limpiar() {
        pila.clear();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=pila.size()-1; i>=0; i--){
            sb.append(pila.get(i).toString());
        }
        return "Pila\n"+sb.toString();
    }
}