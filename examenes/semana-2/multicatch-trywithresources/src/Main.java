import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        int resultado;

        try {
            a = Integer.parseInt(JOptionPane.showInputDialog("Digite el primer numero"));
            b = Integer.parseInt(JOptionPane.showInputDialog("Digite el segundo numero: "));
            resultado = a / b;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
        } catch (ArithmeticException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage()
                    + "\nNo se puede realizar la operación");
        }finally {
            JOptionPane.showMessageDialog(null, "El programa ha finalizado");
        }

        //try with resources
        try(FileInputStream fis = new FileInputStream("archivo.txt")){
            System.out.println("El archivo se ha abierto correctamente");
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se ha podido abrir el archivo");
        }


    }
}