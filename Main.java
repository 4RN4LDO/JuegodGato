/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoGato;

/**
 *
 * @author 4RN4LDO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Tablero vacío");
        juego.muestra();//llama al metodo muestra vacio antes de empezar el juego
        System.out.println("\nEl juego empieza");
        juego.juego(); //llama al metodo juego para iniciar la partida.
    }
}
