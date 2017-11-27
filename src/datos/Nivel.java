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
        char b = a[0];
        char c = a[1];
        int d;
        int e;
        switch (b){
            case 49:
                d = 1;
                break;
            case 50:
                d = 2;
                break;
            case 51:
                d = 3;
                break;
            case 52:
                d = 4;
                break;
            case 53:
                d = 5;
                break;
            case 54:
                d = 6;
                break;
            case 55:
                d = 7;
                break;
            case 56:
                d = 8;
                break;
            case 57:
                d = 9;
                break;
            default:
                d = 0;
                break;
        }
        switch (c){
            case 49:
                e = 1;
                break;
            case 50:
                e = 2;
                break;
            case 51:
                e = 3;
                break;
            case 52:
                e = 4;
                break;
            case 53:
                e = 5;
                break;
            case 54:
                e = 6;
                break;
            case 55:
                e = 7;
                break;
            case 56:
                e = 8;
                break;
            case 57:
                e = 9;
                break;
            default:
                e = 0;
                break;
        }
        return (e + (d*10));
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

