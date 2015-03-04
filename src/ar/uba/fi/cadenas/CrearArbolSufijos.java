package ar.uba.fi.cadenas;

import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

public class CrearArbolSufijos {
    
    private String texto;

    public CrearArbolSufijos(String texto) {

        this.texto = texto;
    }

    public ArbolSufijos ejecutar() {
        
        ArbolSufijos arbol = new ArbolSufijos(texto);

        if (!texto.isEmpty()) {
            
            AtomicInteger fin = new AtomicInteger(0);
            Nodo hojaji = Nodo.hoja(arbol.raiz(), 0, 0, fin);
            
            for (int i = 0; i < texto.length() - 1; i++) { /* fase i + 1 */
                
                /* extensión j */
                fin.incrementAndGet();
                for (int j = hojaji.numero() + 1; j <= (i + 1); j++) {
                    
                    Nodo anterior = hojaji.padre();
                    
                    if (anterior.esRaiz()) {

                        ListIterator<Nodo> itHijos = anterior.hijos().listIterator();
                        
                        Nodo hijo = null;
                        boolean encontrado = false;

                        while (itHijos.hasNext() && !encontrado) {
                        
                            hijo = itHijos.next();
                            encontrado = texto.charAt(j) == texto.charAt(hijo.inicio());
                        }
                        
                        if (! encontrado) {
                            
                            /* agrega el nuevo sufijo */
                            hojaji = Nodo.hoja(anterior, j, j, fin);
                        
                        } else {

                            int finInterior = hijo.inicio(); // al menos un caracter es igual
                            for (int k = 1; coinciden(i + 1, j, j + k, hijo.inicio() + k); k++) {
                                finInterior++;
                            }
                            
                            Nodo interior = Nodo.interior(anterior, itHijos, hijo.inicio(), finInterior);
                        }
                    }
                }
            }
            
        }
        
        return arbol;
    }

    private boolean coinciden(int fase, int extension, int posicion1, int posicion2) {
        
        return (posicion1 <= fase) && (posicion2 <= fase) &&
               (texto.charAt(posicion1) ==  texto.charAt(posicion2)); 
    }
    
    public String texto() {

        return this.texto;
    }

}
