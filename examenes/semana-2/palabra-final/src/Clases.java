public class Clases extends Instancia {

    String nombre;

    public Clases(String nombre) {
        super(nombre);
    }

    void mostrarDescripcion(){
        System.out.println("Esta es una clase heredada de la clase Instancia");
    }
}
