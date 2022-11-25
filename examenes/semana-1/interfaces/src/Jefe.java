public class Jefe implements Empleado{
    private String nombre;
    private int numEmpelado;
    private int sueldoBase;
    private String puesto;
    private int antiguedad;

    public Jefe(String nombre, int numEmpelado, int sueldoBase, String puesto, int antiguedad) {
        this.nombre = nombre;
        this.numEmpelado = numEmpelado;
        this.sueldoBase = sueldoBase;
        this.puesto = puesto;
        this.antiguedad = antiguedad;
    }

    @Override
    public void imprimirDatos(){
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Número de empleado: " + numEmpelado);
        System.out.println("Sueldo base: " + sueldoBase);
        System.out.println("Puesto: " + puesto);
        System.out.println("Años de antigüedad: " + antiguedad);
    }

    @Override
    public double calcularSalario() {
        return sueldoBase * (((double)antiguedad / 20) + 1);
    }
}
