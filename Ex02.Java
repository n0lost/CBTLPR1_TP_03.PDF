import org.junit.Test;
import org.junit.Assert;

public class HoraTest {

    @Test
    public void testHoraInicializacao() {
        Hora hora = new Hora(10, 20, 30);
        Assert.assertEquals(10, hora.getHor());
        Assert.assertEquals(20, hora.getMin());
        Assert.assertEquals(30, hora.getSeg());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHoraInicializacaoInvalida() {
        new Hora(25, 60, 60); 
    }

    @Test
    public void testSetters() {
        Hora hora = new Hora(1, 1, 1);
        
        hora.setHor(10);
        hora.setMin(20);
        hora.setSeg(30);

        Assert.assertEquals(10, hora.getHor());
        Assert.assertEquals(20, hora.getMin());
        Assert.assertEquals(30, hora.getSeg());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSettersInvalidos() {
        Hora hora = new Hora(1, 1, 1);

        hora.setHor(24); 
    }

    @Test
    public void testGetHora1() {
        Hora hora = new Hora(10, 20, 30);
        Assert.assertEquals("10:20:30", hora.getHora1());
    }

    @Test
    public void testGetHora2() {
        Hora hora = new Hora(10, 20, 30);
        Assert.assertEquals("10:20:30 AM", hora.getHora2());
        
        Hora horaPM = new Hora(13, 20, 30);
        Assert.assertEquals("01:20:30 PM", horaPM.getHora2());
    }

    @Test
    public void testGetSegundos() {
        Hora hora = new Hora(1, 1, 1);
        Assert.assertEquals(3661, hora.getSegundos());
    }
}
