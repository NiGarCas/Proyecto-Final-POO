/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author nicol
 */
public class Servidor{
    private ServerSocket server;
    private String nombre;

    public Servidor(String nombre) throws IOException {
        this.nombre = nombre;
        this.server = new ServerSocket(8000);
    }

    public ServerSocket getServer() {
        return server;
    }

    public String getNombre() {
        return nombre;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }
    
}
