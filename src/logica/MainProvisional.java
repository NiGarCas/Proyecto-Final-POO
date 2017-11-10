package logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import datos.Nivel;
import datos.Jugador;
import datos.Equipo;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class MainProvisional {
    public static void main (String[] args){
        ArrayList<Equipo> equipos = new ArrayList();
        Equipo e1 = new Equipo ("e1", null);
        Equipo e2 = new Equipo ("e2", null);
        Equipo e3 = new Equipo ("e3", null);
        equipos.add(e1);
        equipos.add(e2);
        equipos.add(e3);
        char[] letrasDisponibles = new char[23];
        for(int i = 66 ; i<88 ; i++){
            letrasDisponibles[i-66] = (char) i;
            System.out.println(letrasDisponibles[i-66]);
        }
        Jugador j1 = new Jugador(false,"nombre1", equipos, letrasDisponibles, 0, "col", "arquero",(char)78);
        Jugador j2 = new Jugador(false,"nombre2", equipos, letrasDisponibles, 0, "bra", "delantero",(char)78);
        Jugador[] jugadores = new Jugador[30];
        jugadores[0] = j1;
        jugadores[1] = j2;
        Nivel n1 = new Nivel(1,0,0,jugadores);
    }
}
