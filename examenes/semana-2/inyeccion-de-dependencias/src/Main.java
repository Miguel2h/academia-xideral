import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Declaración de variables;
        int opcion;
        Piloto piloto;
        List<Piloto> pilotos = new ArrayList<>();

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:" +
                    "\n1. Añadir piloto" +
                    "\n2. Mostrar pilotos" +
                    "\n3. Interactuar con el auto" +
                    "\n4. Salir"));

            switch (opcion){
                case 1: piloto = new Piloto(ingresarNombre(), ingresarEdad());
                        ingresarAuto();
                        switch (ingresarAuto()){
                            case NASCAR:
                                Inyector.inyectarAuto(piloto, TipoAuto.NASCAR);
                                break;
                            case INDY:
                                Inyector.inyectarAuto(piloto, TipoAuto.INDY);
                                break;
                            case FORMULA:
                                Inyector.inyectarAuto(piloto, TipoAuto.FORMULA);
                                break;
                            default:
                                Inyector.inyectarAuto(piloto, TipoAuto.DEFAULT);
                                break;
                        }
                        pilotos.add(piloto);
                        break;
                case 2: for(Piloto p: pilotos){
                            System.out.println(p);
                        }
                        break;
                case 3:
                        int opcionAuto;
                        int pilotoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog("Seleccione un piloto:"));
                        do {
                            opcionAuto = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:" +
                                    "\n1. Encender auto" +
                                    "\n2. Acelerar auto" +
                                    "\n3. Frenar auto" +
                                    "\n4. Regresar"));

                            switch (opcionAuto){
                                case 1: pilotos.get(pilotoSeleccionado).getAuto().encender();
                                        break;
                                case 2: pilotos.get(pilotoSeleccionado).getAuto().acelerar();
                                        break;
                                case 3: pilotos.get(pilotoSeleccionado).getAuto().frenar();
                                        break;
                            }
                        } while (opcionAuto != 4);
                        break;
            }
        } while (opcion != 4);
    }

    static String ingresarNombre(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del piloto");
        return nombre;
    }

    static int ingresarEdad(){
        boolean comprobar = false;
        int edad = 0;
        do {
            try {
                edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del piloto"));
                comprobar = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número");
            }
        } while (!comprobar);
        return edad;
    }

    static TipoAuto ingresarAuto(){
        boolean comprobar = false;
        TipoAuto tipoAuto = null;
        String auto = JOptionPane.showInputDialog("Ingrese el tipo de auto").toUpperCase();
        do {
            try {
                tipoAuto = TipoAuto.valueOf(TipoAuto.class, auto);
                comprobar = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un tipo de auto válido");
                auto = JOptionPane.showInputDialog("Ingrese el tipo de auto");
            }
        } while (!comprobar);
        return tipoAuto;
    }
}