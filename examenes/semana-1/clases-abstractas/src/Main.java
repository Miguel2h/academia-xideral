import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Jefe("Juan", 2733, 10000, "Jefe de ventas", 5));
        empleados.add(new Supervisor("Francisco", 3304, 8000, "Supervisor", 10));
        empleados.add(new Vendedor("Carlos", 4545, 7000, "Vendedor", 25));

        for(Empleado i : empleados){
            i.imprimirDatos();
            System.out.println("El salario del empleado es: " + i.calcularSalario());
            System.out.println();
        }
    }
}