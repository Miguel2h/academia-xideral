import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declaración de variables;
        int opcion;
        Piloto piloto;
        List<Piloto> pilotos = new ArrayList<>();

        //Ciclo para repetir el menú
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:" +
                    "\n1. Añadir piloto" +
                    "\n2. Mostrar pilotos" +
                    "\n3. Interactuar con el auto" +
                    "\n4. Salir"));

            //Switch para las opciones del menú
            switch (opcion){
                //Opción para añadir piloto
                case 1: piloto = new Piloto(ingresarNombre(), ingresarEdad());
                        ingresarAuto();
                        //inyección de dependencia
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
                        //Opción para mostrar pilotos
                case 2: for(Piloto p: pilotos){
                            System.out.println(p);
                        }
                        break;
                case 3:
                    //Opción para interactuar con el auto
                        int opcionAuto;
                        int pilotoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog("Seleccione un piloto:"));
                        //Ciclo para repetir el menú
                        do {
                            opcionAuto = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:" +
                                    "\n1. Encender auto" +
                                    "\n2. Acelerar auto" +
                                    "\n3. Frenar auto" +
                                    "\n4. Regresar"));
                            //Switch para las opciones del menú
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

    //Método para ingresar el nombre del piloto
    static String ingresarNombre(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del piloto");
        return nombre;
    }

    //Método para ingresar la edad del piloto
    static int ingresarEdad(){
        boolean comprobar = false;
        int edad = 0;
        //Ciclo para comprobar que la edad sea un número
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

    //Método para ingresar el tipo de auto
    static TipoAuto ingresarAuto(){
        boolean comprobar = false;
        TipoAuto tipoAuto = null;
        String auto = JOptionPane.showInputDialog("Ingrese el tipo de auto").toUpperCase();
        //Ciclo para comprobar que el tipo de auto sea válido
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