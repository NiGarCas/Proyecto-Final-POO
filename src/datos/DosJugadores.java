/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author nicol
 */
public class DosJugadores {
    private int modo;
    private Jugador jugador_actual;
    private int ronda;
    private Servidor servidor;
    private Cliente cliente;
    private int puntuacion;

    public DosJugadores() {
        this.ronda = 0;
        this.puntuacion = 0;
    }
}
