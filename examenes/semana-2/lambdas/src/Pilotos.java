public class Pilotos {
    private String nombre;
    private int edad;
    private String sueldo;
    private String escuderia;

    public Pilotos(String nombre, int edad, String sueldo, String escuderia) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.escuderia = escuderia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    @Override
    public String toString() {
        return "Pilotos{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sueldo='" + sueldo + '\'' +
                ", escuderia='" + escuderia + '\'' +
                '}';
    }
}
