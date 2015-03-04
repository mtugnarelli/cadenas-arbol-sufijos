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
        assertThat(hijo.indice(), is( equalTo( 0 )));
        assertThat(hijo.longitud(), is( equalTo( 1 )));
    }
    
    @Test
    public void ejecutarConCadenaDeLongitud2() {
        
        CrearArbolSufijos crear = new CrearArbolSufijos("ab");

        ArbolSufijos arbol = crear.ejecutar();
        
        assertThat(arbol, is( notNullValue( )));
        assertThat(arbol.raiz(), is( notNullValue( )));
        assertThat(arbol.raiz().hijos(), is( notNullValue( )));
        assertThat(arbol.raiz().hijos().size(), is( equalTo( 2 )));
        
        Nodo hijo1 = arbol.raiz().hijos().get(0);
        assertThat(hijo1.indice(), is( equalTo( 0 )));
        assertThat(hijo1.longitud(), is( equalTo( 2 )));
        
        Nodo hijo2 = arbol.raiz().hijos().get(1);
        assertThat(hijo2.indice(), is( equalTo( 0 )));
        assertThat(hijo2.longitud(), is( equalTo( 1 )));
    }
}
