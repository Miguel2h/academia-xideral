import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        //Declaración de lista de pilotos
        List<Pilotos> listaPilotos = new ArrayList<>();

        //Añadimos pilotos a la lista
        listaPilotos.add(new Pilotos("Lewis Hamilton", 35, "20.000.000", "Mercedes"));
        listaPilotos.add(new Pilotos("Valtteri Bottas", 31, "15.000.000", "Mercedes"));
        listaPilotos.add(new Pilotos("Max Verstappen", 23, "10.000.000", "Red Bull"));
        listaPilotos.add(new Pilotos("Sergio Perez", 30, "10.000.000", "Red Bull"));

        //Imprimimos la lista de pilotos
        System.out.println("\nPilotos de Mercedes:");
        mostrarPiloto(listaPilotos, p -> p.getEscuderia().equals("Mercedes"));

        System.out.println("\nPilotos de Red Bull:");
        mostrarPiloto(listaPilotos, p -> p.getEscuderia().equals("Red Bull"));

        System.out.println("\nPilotos de Red Bull mayores de 25 años:");
        mostrarPiloto(listaPilotos, p -> p.getEscuderia().equals("Red Bull") && p.getEdad() > 25);

    }

    //Método para imprimir la lista de pilotos
    static void mostrarPiloto(List<Pilotos> listaPilotos, Predicate<Pilotos> pilotos) {
        for (Pilotos p : listaPilotos) {
            if (pilotos.test(p)) {
                System.out.println(p);
            }
        }
    }
}