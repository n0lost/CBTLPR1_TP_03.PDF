//Gabriel Afonso dos Santos - CB3026167

import org.junit.Test;
import static org.junit.Assert.*;

public class HoraTest {

    @Test
    public void testeConstrutorComValoresValidos() {
        Hora h = new Hora(10, 30, 45);
        assertEquals(10, h.getHor());
        assertEquals(30, h.getMin());
        assertEquals(45, h.getSeg());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeConstrutorComHoraInvalida() {
        new Hora(24, 0, 0); // Deve lançar uma exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeConstrutorComMinutoInvalido() {
        new Hora(12, 60, 0); // Deve lançar uma exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeConstrutorComSegundoInvalido() {
        new Hora(12, 0, 60); // Deve lançar uma exceção
    }

    @Test
    public void testeSettersComValoresValidos() {
        Hora h = new Hora(0, 0, 0);
        h.setHor(23);
        h.setMin(59);
        h.setSeg(59);
        assertEquals(23, h.getHor());
        assertEquals(59, h.getMin());
        assertEquals(59, h.getSeg());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeSettersComHoraInvalida() {
        Hora h = new Hora(0, 0, 0);
        h.setHor(24); // Deve lançar uma exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeSettersComMinutoInvalido() {
        Hora h = new Hora(0, 0, 0);
        h.setMin(60); // Deve lançar uma exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeSettersComSegundoInvalido() {
        Hora h = new Hora(0, 0, 0);
        h.setSeg(60); // Deve lançar uma exceção
    }

    @Test
    public void testeFormato24Horas() {
        Hora h = new Hora(14, 30, 45);
        assertEquals("14:30:45", h.getHora1());
    }

    @Test
    public void testeFormatoAMPM() {
        Hora h = new Hora(14, 30, 45);
        assertEquals("02:30:45 PM", h.getHora2());
    }

    @Test
    public void testeTotalSegundos() {
        Hora h = new Hora(1, 1, 1);
        assertEquals(3661, h.getSegundos());
    }
}
