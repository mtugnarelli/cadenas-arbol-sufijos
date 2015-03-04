package ar.uba.fi.cadenas;

public class ArbolSufijos {

    private Nodo raiz;

    private String texto;
    
    public ArbolSufijos(String texto) {
        
        this.texto = texto;
        this.raiz = Nodo.raiz();
    }
    
    public String texto() {
    
        return this.texto;
    }

    public Nodo raiz() {

        return this.raiz;
    }
    
}
