package ar.uba.fi.cadenas;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class TestNodo {

    @Test
    public void construirRaiz() {

        Nodo nodo = Nodo.raiz();
        
        assertThat(nodo.hijos(), is( notNullValue( List.class )));
        assertThat(nodo.padre(), is( nullValue( Nodo.class )));
        assertThat(nodo.esRaiz(), is( equalTo( true )));
    }
    
    @Test
    public void construirInterior() {
        
        final Nodo padre = Nodo.raiz();
        Nodo nodo = Nodo.interior(padre, 2, 10);
        
        assertThat(nodo.padre(), is( sameInstance( padre )));
        assertThat(nodo.indice(), is( equalTo( 2 )));
        assertThat(nodo.longitud(), is( equalTo( 10 )));
        assertThat(nodo.numero(), is( nullValue( )));
        assertThat(nodo.esRaiz(), is( equalTo( false )));
    }

    @Test
    public void construirInteriorEnlazaNodos() {
        
        final Nodo padre = Nodo.raiz();
        Nodo nodo = Nodo.interior(padre, 2, 10);

        assertThat(padre.hijos().size(), is( equalTo( 1 )));
        assertThat(padre.hijos(), hasItem( nodo ));
    }
    

    @Test
    public void construirHoja() {
        
        final Nodo padre = Nodo.raiz();
        final int numero = 3;
        final int indice = 2;
        final AtomicInteger longitud = new AtomicInteger(23);
        Nodo hoja = Nodo.hoja(padre, numero, indice, longitud);
        
        assertThat(hoja.padre(), is( sameInstance( padre )));
        assertThat(hoja.numero(), is( equalTo( numero )));
        assertThat(hoja.indice(), is( equalTo( indice )));
        assertThat(hoja.longitud(), is( equalTo( 23 )));
        assertThat(hoja.esRaiz(), is( equalTo( false )));
    }
}
