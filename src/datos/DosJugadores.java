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
import java.net.Socket;

/**
 *
 * @author nicol
 */
public class DosJugadores {
    private Juego juego;
    private int modo;
    private Ronda ronda_actual;
    private Ronda[] rondas;
    private Servidor servidor;
    private Cliente cliente;
    private int puntuacion;
    private boolean hayRival;
    private String nombreRival;
    private BufferedReader lectura;
    private PrintWriter escritura;

    public DosJugadores() {
        this.modo  = 0;
        this.ronda_actual = null;
        this.puntuacion = 0;
        this.hayRival = false;
        this.cliente = null;
        this.servidor = null;
        this.rondas = new Ronda[5];
        this.rondas[0] = new Ronda(1,this);
        this.rondas[1] = new Ronda(2,this);
        this.rondas[2] = new Ronda(3,this);
        this.rondas[3] = new Ronda(4,this);
        this.rondas[4] = new Ronda(5,this);
        this.ronda_actual = this.rondas[0];
    }

    public Juego getJuego() {
        return juego;
    }
    
    public int getModo() {
        return modo;
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

    public String getNombreRival() {
        return nombreRival;
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

    public void setNombreRival(String nombreRival) {
        this.nombreRival = nombreRival;
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
                this.rondas[0].setJugador(0, 6);
                this.rondas[1].setJugador(4, 3);
                this.rondas[2].setJugador(3, 21);
                this.rondas[3].setJugador(2, 1);
                this.rondas[4].setJugador(1, 17);
            } catch (IOException ex) {System.out.println("error");}
        } else {
            try {
                Socket socket = this.getServidor().getServer().accept();
                InputStream entrada = socket.getInputStream();
                OutputStream salida = socket.getOutputStream();
                this.hayRival = true;
                this.lectura = new BufferedReader(new InputStreamReader(entrada));
                this.escritura = new PrintWriter(salida,true);
                this.rondas[0].setJugador(0, 6);
                this.rondas[1].setJugador(4, 3);
                this.rondas[2].setJugador(3, 21);
                this.rondas[3].setJugador(2, 1);
                this.rondas[4].setJugador(1, 17);
                escritura.println(this.servidor.getNombre());
            } catch (IOException ex) {System.out.println("error");}
            
        }
    }
}
