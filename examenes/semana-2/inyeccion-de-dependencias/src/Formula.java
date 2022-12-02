public class Formula implements Auto {

    private String escuderia;

    public Formula(String escuderia) {
        this.escuderia = escuderia;
    }

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

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }
}

