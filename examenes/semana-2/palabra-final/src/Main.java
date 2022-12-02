public class Main {
    public static void main(String[] args) {
        System.out.println("------final en primitivos------");
        System.out.println("El valor de la variable no puede ser modificado");
        Primitivo.finalPrimitivo();

        System.out.println("\n------final en instancias------");
        System.out.println("El valor de sus atributos si se puede modificar," +
                " pero no se puede cambiar la dirección a la que apunta la variable");
        final Instancia instancia = new Instancia("Instancia con el valor de su atributo inicial");
        System.out.println(instancia.nombre);
        instancia.nombre = "Instancia con su aatributo modificado";
        System.out.println(instancia.nombre);
        //La varialbe de referencia no puede cambiar la dirección a la que apunta
        //instancia = new Instancia("Instancia al quere cambiar la dirección a la que apunta la variable");
        System.out.println("La variable de referencia no puede cambiar la dirección a la que apunta");

        System.out.println("\n------final en clases------");
        System.out.println("Cuando se aplica la palabra final a una clase, esta no puede ser heredada");
        Clases clases = new Clases("Clase Clases");
        clases.mostrarDescripcion();
        System.out.println("Al colocar la palabra final a la clase Instancia, esta no puede ser heredada");

        System.out.println("\n------final en métodos------");
        System.out.println("Cuando se aplica la palabra final a un método, este no puede ser sobreescrito");
        Instancia instancia2 = new Instancia("Instancia");
        Clases clases2 = new Clases("Clase Clases");
        instancia2.mostrarDescripcion();
        clases2.mostrarDescripcion();
        System.out.println("Al colocar la palabra final al método mostrarDescripcion de la clase Instancia," +
                " este no puede ser sobreescrito");
        //clases2.mostrarDescripcion();
    }
}