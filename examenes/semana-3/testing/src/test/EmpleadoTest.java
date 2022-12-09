import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void testNombreCuenta() {
        Empleado empleado = new Empleado("Juan", 20, 1000);
        String nombreEsperado = "Juan";
        assertTrue(empleado.getNombre().equals(nombreEsperado));
    }

    @Test
    void testEdadCuenta() {
        Empleado empleado = new Empleado("Juan", 20, 1000);
        int edadEsperada = 20;
        assertEquals(edadEsperada, empleado.getEdad());
    }

    @Test
    void testSalarioCuenta() {
        Empleado empleado = new Empleado("Juan", 20, 1000);
        double salarioEsperado = 1000;
        assertEquals(salarioEsperado, empleado.getSalario());
    }

    @Test
    void testSalarioNoNegativo(){
        Empleado empleado = new Empleado("Juan", 20, 1000);
        assertFalse(empleado.getSalario() < 0);
    }

    @Test
    void testNombreNoVacio(){
        Empleado empleado = new Empleado("Juan", 20, 1000);
        String nombreEsperado = empleado.getNombre();
        assertFalse(nombreEsperado.isEmpty());
    }

    @Test
    void testNoEsMismoObjeto(){
        Empleado empleado = new Empleado("Juan", 20, 1000);
        Empleado empleado2 = new Empleado("Juanito", 20, 1000);
        assertNotEquals(empleado, empleado2);
    }
}