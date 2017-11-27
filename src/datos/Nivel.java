/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import datos.Jugador;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class Nivel {
    private UnJugador unjugador;
    private int numero;
    private int jugadoresAdivinados;
    private int restantesParaDesbloquear;
    private ArrayList<Jugador> jugadores;

    public Nivel(int numero, int jugadoresAdivinados, int restantesParaDesbloquear) {
        this.numero = numero;
        this.jugadores = new ArrayList();
        this.jugadoresAdivinados = jugadoresAdivinados;
        this.restantesParaDesbloquear = restantesParaDesbloquear;
    }

    public UnJugador getUnjugador() {
        return unjugador;
    }

    public int getNumero() {
        return numero;
    }

    public int getJugadoresAdivinados() {
        return jugadoresAdivinados;
    }
    
    public int getRestantesParaDesbloquear() {
        return restantesParaDesbloquear;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadoresAdivinados(int jugadoresAdivinados) {
        this.jugadoresAdivinados = jugadoresAdivinados;
    }

    public void setRestantesParaDesbloquear(int restantesParaDesbloquear) {
        this.restantesParaDesbloquear = restantesParaDesbloquear;
    }
    
    public boolean isDesbloqueado(){
        if(this.restantesParaDesbloquear <= 0){
            return true;
        }else{
            return false;
        }
    }
    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }
    
    public int determinarJugador(String textoBoton) {
        char[] a = textoBoton.toCharArray();
        switch (a[0]){
            case 49:
                return 1;
            case 50:
                return 2;
            case 51:
                return 3;
            case 52:
                return 4;
            case 53:
                return 5;
            case 54:
                return 6;
            case 55:
                return 7;
            case 56:
                return 8;
            case 57:
                return 9;
            default:
                return 0;
        }
    }

    public int getNumeroJugador(Jugador jugador) {
        int a = 0;
        for(int i = 0;i < this.getJugadores().size(); i++){
            if(this.getJugadores().get(i).equals(jugador)){
            a = i+1;
            break;
            }
        }
        return a;
    }
}

