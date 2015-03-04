package ar.uba.fi.cadenas;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Nodo {

    private List<Nodo> hijos = new LinkedList<Nodo>();
    private Nodo padre;
    private int inicio;
    
    private Nodo() {
        
    }

    private Nodo(Nodo padre, int indice) {
        
        this.padre = padre;
        this.inicio = indice;
        this.padre.hijos.add(this);
    }

    public List<Nodo> hijos() {

        return this.hijos;
    }

    public Nodo padre() {
        
        return this.padre;
    }

    public int inicio() {

        return this.inicio;
    }

    public abstract int fin();
    
    public abstract Integer numero();

    public static Nodo raiz() {
        
        return new Raiz();
    }

    public abstract boolean esRaiz();
    
    public static Nodo hoja(Nodo padre, int numero, int inicio, AtomicInteger fin) {

        return new Hoja(padre, numero, inicio, fin);
    }
    
    public static Nodo interior(Nodo padre, int inicio, int fin) {
        
        return new Interior(padre, inicio, fin);
    }

    private static class Raiz extends Nodo {
        
        public Raiz() {
            super();
        }

        @Override
        public int fin() {
            return 0;
        }

        @Override
        public Integer numero() {
            return null;
        }

        @Override
        public boolean esRaiz() {
            return true;
        }
    }
    
    private static class Hoja extends Nodo {
        
        private AtomicInteger fin;
        private Integer numero;
        
        public Hoja(Nodo padre, int numero, int inicio, AtomicInteger fin) {

            super(padre, inicio);
            this.numero = numero;
            this.fin = fin;
        }

        @Override
        public int fin() {

            return this.fin.get();
        }

        @Override
        public Integer numero() {

            return this.numero;
        }

        @Override
        public boolean esRaiz() {

            return false;
        }
    }
    
    private static class Interior extends Nodo {
        
        private int fin;
        
        public Interior(Nodo padre, int inicio, int fin) {
            
            super(padre, inicio);
            this.fin = fin;
        }

        @Override
        public int fin() {

            return this.fin;
        }

        @Override
        public Integer numero() {

            return null;
        }

        @Override
        public boolean esRaiz() {

            return false;
        }
    }
}
