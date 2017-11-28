/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author nicol
 */
public class Cliente{
    private Socket socket;
    private String nombre;
    private DataInputStream entrada;
    private DataOutputStream salida;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
