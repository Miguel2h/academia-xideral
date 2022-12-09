public class Formula implements Auto {

    // Atributos
    private String escuderia;

    // Constructor
    public Formula(String escuderia) {
        this.escuderia = escuderia;
    }

    // Metodos
    @Override
    public void encender() {
        System.out.println("Encendiendo auto " + escuderia);
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando auto " + escuderia);
    }

    @Override
    public void frenar() {
        System.out.println("Frenando auto " + escuderia);
    }

    @Override
    public String toString() {
        return "Nascar{" +
                "escuderia='" + escuderia + '\'' +
                '}';
    }

    // Getters y Setters
    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }
}

