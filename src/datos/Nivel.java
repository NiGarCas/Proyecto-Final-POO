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
    private int necesariosParaDesbloquear;
    private int restantesParaDesbloquear;
    private ArrayList<Jugador> jugadores;

    public Nivel(int numero, int jugadoresAdivinados, int necesariosParaDesbloquear) {
        this.numero = numero;
        this.jugadoresAdivinados = jugadoresAdivinados;
        this.necesariosParaDesbloquear = necesariosParaDesbloquear;
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

    public int getNecesariosParaDesbloquear() {
        return necesariosParaDesbloquear;
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
    public void agregarJugador(boolean adivinado, String nombre, int intentos, String pais, String posicion){
        this.jugadores.add(new Jugador(adivinado,nombre,intentos,pais,posicion));
    }
    public boolean isDesbloqueado(){
        if(this.restantesParaDesbloquear < 0){
            return true;
        }else{
            return false;
        }
    }

    public int determinarJugador(String textoBoton) {
        int a = 0;
        for(int i = 0; i < this.getJugadores().size(); i++){
            if(textoBoton.equals(this.getJugadores().get(i))){
                 a = i+1;
                 break;
            }
        }
        return a;
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

