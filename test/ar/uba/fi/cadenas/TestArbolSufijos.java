package ar.uba.fi.cadenas;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Test;

public class TestArbolSufijos {

    @Test
    public void construir() {
        
        ArbolSufijos arbol = new ArbolSufijos("aaaasd");
        
        assertThat(arbol.texto(), is( equalTo( "aaaasd" )));
        assertThat(arbol.raiz(), is( notNullValue( Nodo.class )));
        assertThat(arbol.raiz().hijos(), is( notNullValue( List.class )));
    }
}
