public class Piloto {
    //Atributos
    private String nombre;
    private int edad;
    private Auto auto;

    //Constructor
    public Piloto(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Metodos
    void encenderAuto() {
        auto.encender();
    }

    void acelerarAuto(){
        auto.acelerar();
    }

    void frenarAuto(){
        auto.frenar();
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", auto=" + auto +
                '}';
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
