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
import javax.swing.JOptionPane;
import visualizacion.Ventana;

/**
 *
 * @author nicol
 */
public class Main {
    public static void main(String[] args) {
        LogicaAEF logica = new LogicaAEF();
        logica.cargarInfoBasica("datosBasicos.txt");
        logica.cargarEquipos("teams.txt");
        System.out.println("---EQUIPOS CARGADOS---");
        logica.cargarNiveles("jugadoresinfo.txt");
        System.out.println("---JUGADORES CARGADOS---");
        Ventana ventana = new Ventana(logica.getJuego());
        ventana.setVisible(true);
    }
}
