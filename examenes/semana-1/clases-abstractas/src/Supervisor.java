public class Supervisor extends Empleado{
    private int horasExtras;

    public Supervisor(String nombre, int numEmpelado, int sueldoBase, String puesto, int horasExtras) {
        super(nombre, numEmpelado, sueldoBase, puesto);
        this.horasExtras = horasExtras;
    }

    @Override
    void imprimirDatos(){
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Número de empleado: " + numEmpelado);
        System.out.println("Sueldo base: " + sueldoBase);
        System.out.println("Puesto: " + puesto);
        System.out.println("Horas extras laboradas: " + horasExtras);
    }

    @Override
    double calcularSalario() {
        return sueldoBase + ((sueldoBase / 30) * horasExtras);
    }
}
