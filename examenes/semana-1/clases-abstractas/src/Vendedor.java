public class Vendedor extends Empleado{
    private int ventasRealizadas;
    private int pagoPorVenta = 20;

    public Vendedor(String nombre, int numEmpelado, int sueldoBase, String puesto, int ventasRealizadas) {
        super(nombre, numEmpelado, sueldoBase, puesto);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    void imprimirDatos(){
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Número de empleado: " + numEmpelado);
        System.out.println("Sueldo base: " + sueldoBase);
        System.out.println("Puesto: " + puesto);
        System.out.println("Ventas realizadas: " + ventasRealizadas);
    }

    @Override
    double calcularSalario() {
        int comision;
        if(ventasRealizadas <= 20){
            comision = 5;
        }else if(ventasRealizadas > 20 && ventasRealizadas <= 40){
            comision = 10;
        }else{
            comision = 15;
        }
        return sueldoBase + ((ventasRealizadas * pagoPorVenta) * (((double)comision / 100) + 1));
    }


}
