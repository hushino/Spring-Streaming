package libro.cap01;

import java.util.Scanner;

public class DemoConstantes {
    // definimos las constantes
    private static final int LUNES = 1;
    private static final int MARTES = 2;
    private static final int MIERCOLES = 3;
    private static final int JUEVES = 4;
    private static final int VIERNES = 5;
    private static final int SABADO = 6;
    private static final int DOMINGO = 7;
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un dia de la semana (numero) : ");
        int v = scanner.nextInt();

        String dia;

        switch (v) {
            case LUNES:
                dia = "Lunes";
                break;
            case MARTES:
                dia = "Martes";
                break;
            case MIERCOLES:
                dia = "Miercoles";
                break;
            case JUEVES:
                dia = "Jueves";
                break;
            case VIERNES:
                dia = "Viernes";
                break;
            case SABADO:
                dia = "Sabado";
                break;
            case DOMINGO:
                dia = "Domingo";
                break;
            default:
                dia = "Dia incorrecto... Ingrese un valor entre 1 y 7.";
        }
        System.out.println(dia);
    }
}
