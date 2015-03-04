package ar.uba.fi.cadenas;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestCrearArbolSufijos {

    @Test
    public void construir() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("");

        assertThat(crear.texto(), is( equalTo( "" )));
    }
    
    @Test
    public void ejecutar() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol, is( notNullValue( )));
        assertThat(arbol.texto(), is( equalTo( "" )));
    }
    
    @Test
    public void ejecutarConCadenaDeLongitud1() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("a");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol, is( notNullValue( )));
        assertThat(arbol.raiz(), is( notNullValue( )));
        assertThat(arbol.raiz().hijos(), is( notNullValue( )));
        assertThat(arbol.raiz().hijos().size(), is( equalTo( 1 )));
        
        Nodo hijo = arbol.raiz().hijos().get(0);
        assertThat(hijo.inicio(), is( equalTo( 0 )));
        assertThat(hijo.fin(), is( equalTo( 0 )));
    }
    
    @Test
    public void ejecutarConCadenaDeLongitud2() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("ab");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol, is( notNullValue( )));
        assertThat(arbol.raiz(), is( notNullValue( )));
        assertThat(arbol.raiz().hijos(), is( notNullValue( )));
        assertThat(arbol.raiz().hijos().size(), is( equalTo( 2 )));
        
        assertNodo(arbol.raiz().hijos().get(0), 0, 1, 0);
        assertNodo(arbol.raiz().hijos().get(1), 1, 1, 1);
    }
    
    @Test
    public void ejecutarConCadenaDeLongitud3Diferentes() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("abc");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol.raiz().hijos().size(), is( equalTo( 3 )));
        
        assertNodo(arbol.raiz().hijos().get(0), 0, 2, 0);
        assertNodo(arbol.raiz().hijos().get(1), 1, 2, 1);
        assertNodo(arbol.raiz().hijos().get(2), 2, 2, 2);
    }
    
    @Test
    public void ejecutarConCadenaDeLongitud4Diferentes() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("abce");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol.raiz().hijos().size(), is( equalTo( 4 )));
        
        assertNodo(arbol.raiz().hijos().get(0), 0, 3, 0);
        assertNodo(arbol.raiz().hijos().get(1), 1, 3, 1);
        assertNodo(arbol.raiz().hijos().get(2), 2, 3, 2);
        assertNodo(arbol.raiz().hijos().get(3), 3, 3, 3);
    }
    
    @Test
    public void ejecutarConCadenaDeLongitud2PeroIguales() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("aa");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol.raiz().hijos().size(), is( equalTo( 1 )));
        assertNodo(arbol.raiz().hijos().get(0), 0, 0, null);
        
        assertThat(arbol.raiz().hijos().get(0).hijos().size(), is( equalTo( 1 )));
        assertNodo(arbol.raiz().hijos().get(0).hijos().get(0), 1, 1, 0);
    }

    @Test
    public void ejecutarConCadenaDeLongitud3ConDosIgualesAdelanteYAtras() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("aba");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol.raiz().hijos().size(), is( equalTo( 2 )));
        assertNodo(arbol.raiz().hijos().get(0), 0, 0, null);
        assertNodo(arbol.raiz().hijos().get(1), 1, 2, 1);
        
        assertThat(arbol.raiz().hijos().get(0).hijos().size(), is( equalTo( 1 )));
        assertNodo(arbol.raiz().hijos().get(0).hijos().get(0), 1, 2, 0);
    }

    @Test
    public void ejecutarConCadenaDeLongitud4ConDosIgualesAdelanteYAtras() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("abca");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol.raiz().hijos().size(), is( equalTo( 3 )));
        assertNodo(arbol.raiz().hijos().get(0), 0, 0, null);
        assertNodo(arbol.raiz().hijos().get(1), 1, 3, 1);
        assertNodo(arbol.raiz().hijos().get(2), 2, 3, 2);
        
        assertThat(arbol.raiz().hijos().get(0).hijos().size(), is( equalTo( 1 )));
        assertNodo(arbol.raiz().hijos().get(0).hijos().get(0), 1, 3, 0);
    }
    
    protected void assertNodo(Nodo nodo, int inicio, int fin, Integer numero) {
        
        assertThat("numero", nodo.numero(), is( equalTo( numero )));
        assertThat("inicio", nodo.inicio(), is( equalTo( inicio )));
        assertThat("fin", nodo.fin(), is( equalTo( fin )));
    }
}
