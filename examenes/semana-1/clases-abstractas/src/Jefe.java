public class Jefe extends Empleado{
    private int antiguedad;

    public Jefe(String nombre, int numEmpelado, int sueldoBase, String puesto, int antiguedad) {
        super(nombre, numEmpelado, sueldoBase, puesto);
        this.antiguedad = antiguedad;
    }

    @Override
    void imprimirDatos(){
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Número de empleado: " + numEmpelado);
        System.out.println("Sueldo base: " + sueldoBase);
        System.out.println("Puesto: " + puesto);
        System.out.println("Años de antigüedad: " + antiguedad);
    }

    @Override
    double calcularSalario() {
        return sueldoBase * (((double)antiguedad / 20) + 1);
    }
}
