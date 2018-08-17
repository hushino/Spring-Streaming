package libro.random;

import javax.swing.*;
import java.util.Scanner;

public class prueba {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);

        int arreglo[],nElementos,aux;

        nElementos = Integer.parseInt(JOptionPane.showInputDialog("algo:"));

        arreglo = new int[nElementos];

        for (int i=0;i<nElementos;i++){
            System.out.println((i+1)+". Digite un numero: ");
            arreglo[i] = entrada.nextInt();
        }

    }
}
