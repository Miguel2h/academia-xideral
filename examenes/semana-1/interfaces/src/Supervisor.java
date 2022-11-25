public class Supervisor implements Empleado{
    private String nombre;
    private int numEmpelado;
    private int sueldoBase;
    private String puesto;
    private int horasExtras;

    public Supervisor(String nombre, int numEmpelado, int sueldoBase, String puesto, int horasExtras) {
        this.nombre = nombre;
        this.numEmpelado = numEmpelado;
        this.sueldoBase = sueldoBase;
        this.puesto = puesto;
        this.horasExtras = horasExtras;
    }

    @Override
    public void imprimirDatos(){
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Número de empleado: " + numEmpelado);
        System.out.println("Sueldo base: " + sueldoBase);
        System.out.println("Puesto: " + puesto);
        System.out.println("Horas extras laboradas: " + horasExtras);
    }

    @Override
    public double calcularSalario() {
        return sueldoBase + ((sueldoBase / 30) * horasExtras);
    }
}
