public class Primitivo {

    static void finalPrimitivo(){
        //Final en Primitivos
        int numero = 10;
        //Se imprime el valor de la variable antes de ser modificada
        System.out.println("El valor inicial de la variable es: " + numero);
        //Se modifica el valor de la variable
        numero = 20;
        //Se imprime el valor de la variable despues de ser modificada
        System.out.println("El valor de la variable depués de que se modificó su valor es: " + numero);

        //Declaración de una variable final
        final int numeroFinal = 10;
        //Se imprime el valor de la variable antes de ser modificada
        System.out.println("El valor inicial de la variable es: " + numeroFinal);
        //Se modifica el valor de la variable
        //anumeroFinal = 20;
        System.out.println("El valor de la variable no puede ser modificado depués de que se le añadió la palabra final");
    }
}
