/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import datos.Jugador;

/**
 *
 * @author nicol
 */
public class Nivel {
    private int numero;
    private int jugAdivinados;
    private int restantesParaDesbloquear;
    private Jugador[] jugadores;

    public Nivel(int numero, int jugAdivinados, int restantesParaDesbloquear, Jugador[] jugadores) {
        this.numero = numero;
        this.jugAdivinados = jugAdivinados;
        this.restantesParaDesbloquear = restantesParaDesbloquear;
        this.jugadores = jugadores;
    }
    
}

