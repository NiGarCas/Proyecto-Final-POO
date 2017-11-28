/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nicol
 */
public class DosJugadores {
    private Juego juego;
    private int modo;
    private Jugador jugador_actual;
    private Ronda ronda_actual;
    private Ronda[] rondas;
    private Servidor servidor;
    private Cliente cliente;
    private int puntuacion;
    private boolean hayRival;
    private BufferedReader lectura;
    private PrintWriter escritura;

    public DosJugadores() {
        this.modo  = 0;
        this.ronda_actual = null;
        this.puntuacion = 0;
        this.jugador_actual = null;
        this.hayRival = false;
        this.cliente = null;
        this.servidor = null;
    }

    public Juego getJuego() {
        return juego;
    }
    
    public int getModo() {
        return modo;
    }

    public Jugador getJugador_actual() {
        return jugador_actual;
    }

    public Ronda getRonda_actual() {
        return ronda_actual;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public boolean isHayRival() {
        return hayRival;
    }

    public Ronda[] getRondas() {
        return rondas;
    }

    public BufferedReader getLectura() {
        return lectura;
    }

    public PrintWriter getEscritura() {
        return escritura;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public void setJugador_actual(Jugador jugador_actual) {
        this.jugador_actual = jugador_actual;
    }

    public void setRonda_actual(Ronda ronda) {
        this.ronda_actual = ronda;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setHayRival(boolean hayRival) {
        this.hayRival = hayRival;
    }
    public void empezarPartida() {
        if(this.getModo() == 2){
            try {
                Socket socket = new Socket("localhost",8000);
                this.getCliente().setSocket(socket);
                this.hayRival = true;
                InputStream entrada = socket.getInputStream();
                OutputStream salida = socket.getOutputStream();
                this.lectura = new BufferedReader(new InputStreamReader(entrada));
                this.escritura = new PrintWriter(salida,true);
                escritura.println(this.cliente.getNombre());
            } catch (IOException ex) {System.out.println("error");}
        } else {
            try {
                Ronda ronda = new Ronda(1,this);
                this.setRonda_actual(ronda);
                Socket socket = this.getServidor().getServer().accept();
                InputStream entrada = socket.getInputStream();
                OutputStream salida = socket.getOutputStream();
                this.hayRival = true;
                this.lectura = new BufferedReader(new InputStreamReader(entrada));
                this.escritura = new PrintWriter(salida,true);
                escritura.println(this.servidor.getNombre());
            } catch (IOException ex) {System.out.println("error");}
            
        }
    }
}
