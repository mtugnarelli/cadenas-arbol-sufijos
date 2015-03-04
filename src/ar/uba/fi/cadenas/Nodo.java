package ar.uba.fi.cadenas;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Nodo {

    private List<Nodo> hijos = new LinkedList<Nodo>();
    private Nodo padre;
    private int indice;
    
    private Nodo() {
        
    }

    private Nodo(Nodo padre, int indice) {
        
        this.padre = padre;
        this.indice = indice;
        this.padre.hijos.add(this);
    }

    public List<Nodo> hijos() {

        return this.hijos;
    }

    public Nodo padre() {
        
        return this.padre;
    }

    public int indice() {

        return this.indice;
    }

    public abstract int longitud();
    
    public abstract Integer numero();

    public static Nodo raiz() {
        
        return new Raiz();
    }

    public abstract boolean esRaiz();
    
    public static Nodo hoja(Nodo padre, int numero, int indice, AtomicInteger longitud) {

        return new Hoja(padre, numero, indice, longitud);
    }
    
    public static Nodo interior(Nodo padre, int indice, int longitud) {
        
        return new Interior(padre, indice, longitud);
    }

    private static class Raiz extends Nodo {
        
        public Raiz() {
            super();
        }

        @Override
        public int longitud() {
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
        
        private AtomicInteger longitud;
        private Integer numero;
        
        public Hoja(Nodo padre, int numero, int indice, AtomicInteger longitud) {

            super(padre, indice);
            this.numero = numero;
            this.longitud = longitud;
        }

        @Override
        public int longitud() {
            return this.longitud.get();
        }

        @Override
        public Integer numero() {
            return this.numero;
        }

        @Override
        public boolean esRaiz() {
            return true;
        }
    }
    
    private static class Interior extends Nodo {
        
        private int longitud;
        
        public Interior(Nodo padre, int indice, int longitud) {
            
            super(padre, indice);
            this.longitud = longitud;
        }

        @Override
        public int longitud() {

            return this.longitud;
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
}
