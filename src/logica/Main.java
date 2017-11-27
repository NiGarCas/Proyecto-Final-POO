/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.DosJugadores;
import datos.Equipo;
import datos.Juego;
import datos.UnJugador;
import visualizacion.Ventana;

/**
 *
 * @author nicol
 */
public class Main {
    public static void main(String[] args) {
        LogicaAEF logica = new LogicaAEF();
        logica.cargarInfoBasica("datosBasicos.txt");
        logica.cargarEquipos("equipos.txt");
        logica.cargarNiveles("pruebaJug.txt");
        UnJugador unJugador = new UnJugador(0);
        Ventana ventana = new Ventana(logica.getJuego());
        ventana.setVisible(true);
    }
}
