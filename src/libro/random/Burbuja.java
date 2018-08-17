package libro.random;

import javax.swing.*;
import java.util.Scanner;

public class Burbuja {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int arreglo[],nElementos,aux;

        nElementos = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de elementos"));

        arreglo = new int[nElementos]; // le asignamos el numero de lementos al arreglo

        for (int i=0;i<nElementos;i++){
            System.out.println((i+1)+". Digite un numero: ");
            arreglo[i] = entrada.nextInt();
        }

        // Metodo burbuja, el -1 es por que no es necesario ej: 5 vueltas solo 4 para ser ordenado.
        for (int i=0;i<(nElementos-1);i++);{
            for (int j=0;j<(nElementos-1);j++){
                if (arreglo[j] > arreglo[j+1]) { // si numeroActual > numeroSiguiente
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
                }
            }
        }
        // Mostrando el arreglo ordenado en forma creciente
        System.out.print("\nArreglo ordenado en forma creciente: ");
        for (int i=0;i<nElementos;i++){
            System.out.print(arreglo[i]+" - ");
        }
        System.out.print("");
    }
}
