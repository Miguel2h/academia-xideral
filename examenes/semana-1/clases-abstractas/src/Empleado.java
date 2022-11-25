public abstract class Empleado {
    String nombre;
    int numEmpelado;
    int sueldoBase;
    String puesto;

    public Empleado(String nombre, int numEmpelado, int sueldoBase, String puesto) {
        this.nombre = nombre;
        this.numEmpelado = numEmpelado;
        this.sueldoBase = sueldoBase;
        this.puesto = puesto;
    }

    void imprimirDatos(){
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Número de empleado: " + numEmpelado);
        System.out.println("Sueldo base: " + sueldoBase);
        System.out.println("Puesto: " + puesto);
    }

    abstract double calcularSalario();

}
