/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoGato;
import java.util.Scanner;

/**
 *
 * @author 4RN4LDO
 */
public class juego {

    private static Scanner teclado = new Scanner(System.in);
    private static String[][] tablero = new String[3][3];
    private static int n = 0;

    public static void muestra() {//muestro el tablero del juego que esta vacío
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print(" " + " " + " |");
                } else {
                    System.out.print(" " + tablero[i][j] + " |");
                }
            }
            System.out.println();
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print("---+");
            }
            System.out.println();
        }
    }

    public static boolean gana() {//verifica las posiciones para ganar tanto del usuario como la máquina usando el ciclo for
        for (int i = 0; i < 3; i++) {
            if (("O".equals(tablero[i][0])) && ("O".equals(tablero[i][1])) && ("O".equals(tablero[i][2]))
                    || ("X".equals(tablero[i][0])) && ("X".equals(tablero[i][1])) && ("X".equals(tablero[i][2]))) {
                return true;
            }

            for (int j = 0; j < 3; j++) {
                if (("X".equals(tablero[0][j])) && ("X".equals(tablero[1][j])) && ("X".equals(tablero[2][j]))
                        || ("O".equals(tablero[0][j])) && ("O".equals(tablero[1][j])) && ("O".equals(tablero[2][j]))) {
                    return true;
                }
            }
            if (("X".equals(tablero[0][0])) && ("X".equals(tablero[1][1])) && ("X".equals(tablero[2][2]))
                    || ("O".equals(tablero[0][0])) && ("O".equals(tablero[1][1])) && ("O".equals(tablero[2][2]))) {
                return true;
            }
            if (("X".equals(tablero[0][2])) && ("X".equals(tablero[1][1])) && ("X".equals(tablero[2][0]))
                    || ("O".equals(tablero[0][2])) && ("O".equals(tablero[1][1])) && ("O".equals(tablero[2][0]))) {
                return true;
            }
        }
        return false;
    }

    public static void jugador() {//llena los campos con las coordenadas que el jugador da y verifica que no este ocupado
        System.out.printf("\nEn que fila quiere jugar?\n");
        int c = teclado.nextInt();
        System.out.printf("En que columna quiere jugar?\n");
        int f = teclado.nextInt();
        if ("X".equals(tablero[c][f]) || "O".equals(tablero[c][f])) {
            System.out.println("Esa posición ya esta tomada! Favor seleccionar una diferente");
            jugador();
        } else {
            tablero[c][f] = "X";
        }
    }

    public static void compu() {//llena los campos aleatoriamente y verifica que no esten ocupado
        int cComp = (int) (Math.random() * 3);
        int fComp = (int) (Math.random() * 3);
        System.out.println("La maquina jugó la posición: " + cComp + " y la " + fComp);
        if ("X".equals(tablero[cComp][fComp]) || "O".equals(tablero[cComp][fComp])) {
            compu();
        } else {
            tablero[cComp][fComp] = "O";
        }
    }

    public static void juego() {//ciclo se detiene hasta que haya un ganador o un empate, llama a los demas metodos
        while (n < 10) {
            jugador();
            muestra();
            if (gana() == true) {
                System.out.printf("\nUsted Ganó\n");
                break;
            }else if(n==8){
                System.out.printf("\nEmpate!\n");
                break;
            }
            n = n + 1;
            System.out.printf("\nEs el turno de la maquina?\n");
            compu();
            muestra();
            if (gana() == true) {
                System.out.printf("\nGanó la maquina!\n");
                break;
            }
            n = n + 1;
        }
    }
}//final