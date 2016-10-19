package com.dosideas.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalcTest {

    @Test
    public void sumar_dosNumeros_sumaEsperada() {
        Calculadora calc = new Calculadora();
        assertEquals(4, calc.sumar(3, 1));
    }

    @Test
    public void restar_dosNumeros_restaEsperada() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.restar(3, 1));
    }
    
    @Test
    public void dividir_dosNumeros_divisionEsperada() {
        Calculadora calc = new Calculadora();
        assertEquals(0.5, calc.dividir(2, 4), 0.0002);
    }

    @Test(expected=IllegalArgumentException.class)
    public void dividir_unNumeroPorCero_exception() {
        Calculadora calc = new Calculadora();
        calc.dividir(2, 0);
    }
    
}
