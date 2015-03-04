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
            
            AtomicInteger longitud = new AtomicInteger(1);
            Nodo hojaj_1i = Nodo.hoja(arbol.raiz(), 0, 0, longitud);
            
            for (int i = 0; i < this.texto.length() - 1; i++) { /* fase i + 1 */
                
                /* extensión 1 */
                longitud.incrementAndGet();
                
                for (int j = 2; j <= (i + 1); j++) { /* extensión j > 1 */
                    
                    Nodo anterior = hojaj_1i.padre();
                    
                    if (anterior.esRaiz()) {

                        Iterator<Nodo> itHijos = anterior.hijos().listIterator();
                        
                        Nodo hijo;

                        boolean encontrado = false;
                        do {
                        
                            hijo = itHijos.next();
                            
                            for (int h = 0; ; h++) {
                                
                                
                            }
                            
                        } while (itHijos.hasNext() && !encontrado);
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
