/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.DosJugadores;
import datos.Juego;
import datos.UnJugador;
import java.awt.BorderLayout;
import visualizacion.Ventana;

/**
 *
 * @author nicol
 */
public class LogicaAEF {
    public static void main(String[] args) {
        UnJugador unJugador = new UnJugador(0);
        DosJugadores dosJugadores = new DosJugadores();
        Juego juego = new Juego(0,unJugador,dosJugadores);
        Ventana ventana = new Ventana(juego);
//        ventana.add(ventana.getPanel_actual());
        ventana.setVisible(true);
    }
}
