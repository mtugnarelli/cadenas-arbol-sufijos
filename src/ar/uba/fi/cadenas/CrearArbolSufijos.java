package ar.uba.fi.cadenas;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

public class CrearArbolSufijos {
    
    private String texto;

    public CrearArbolSufijos(String texto) {

        this.texto = texto;
    }

    public ArbolSufijos ejecutar() {
        
        ArbolSufijos arbol = new ArbolSufijos(this.texto);

        if (!this.texto.isEmpty()) {
            
            AtomicInteger fin = new AtomicInteger(0);
            Nodo hojaj_1i = Nodo.hoja(arbol.raiz(), 0, 0, fin);
            
            for (int i = 0; i < this.texto.length() - 1; i++) { /* fase i + 1 */
                
                /* extensión j */
                
                fin.incrementAndGet();
                for (int j = 1; j <= (i + 1); j++) {
                    
                    Nodo anterior = hojaj_1i.padre();
                    
                    if (anterior.esRaiz()) {

                        Iterator<Nodo> itHijos = anterior.hijos().listIterator();
                        
                        Nodo hijo;

                        boolean encontrado = false;
                        while (itHijos.hasNext() && !encontrado) {
                        
                            hijo = itHijos.next();
                            encontrado = this.texto.charAt(j) == this.texto.charAt(hijo.inicio());
                        }
                        
                        if (! encontrado) {
                            
                            /* agrega el nuevo sufijo */
                            Nodo.hoja(anterior, j, j, fin);
                        
                        } else {
                        
                            
                        }
                    }
                }
            }
            
        }
        
        return arbol;
    }

    public String texto() {

        return this.texto;
    }

}
