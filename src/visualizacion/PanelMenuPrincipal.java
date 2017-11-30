/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import datos.Cliente;
import datos.Servidor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class PanelMenuPrincipal extends Panel{
    
    public PanelMenuPrincipal(Ventana Ventana) {
        super(Ventana);
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
       this.setLayout(null);
       super.paintComponent(g);
       Image fondo = loadImage("Fondo.png");
       g.drawImage(fondo, 0, 0, this);
       Image tituloPrincipal = loadImage("AdivinaElFutbolista.png");
       g.drawImage(tituloPrincipal, 50, 120, this);
       this.agregarComponentes(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        JButton source = (JButton)evento.getSource();
        String textoBoton = source.getText();
        switch(textoBoton){
            case "GUARDAR Y SALIR":
                this.getVentana().getJuego().getLogica().guardarDatos("datosBasicos.txt", "pruebaJug.txt");
                JOptionPane.showMessageDialog(this.getVentana(), "Datos guardados exitosamente");
                this.getVentana().dispose();
                break;
            case "UN JUGADOR":
                this.getVentana().actualizarPanel(1);
                break;
            case "DOS JUGADORES":
                String name = JOptionPane.showInputDialog(this.getVentana(), "Escriba el nombre que desea tener durante la partida:");
                this.getVentana().getJuego().setNombre(name);
                int b = JOptionPane.showConfirmDialog(this.getVentana(), "¿Desea asumir el rol de servidor?");
                if(b == JOptionPane.YES_OPTION){
            try {
                this.getVentana().getJuego().getDosJugadores().setModo(1);
                this.getVentana().getJuego().getDosJugadores().setServidor(new Servidor(name));
                
            } catch (IOException ex) {}
                }else{
                    this.getVentana().getJuego().getDosJugadores().setModo(2);
                    this.getVentana().getJuego().getDosJugadores().setCliente(new Cliente(name));
                }
                this.getVentana().getJuego().getDosJugadores().empezarPartida();
                this.getVentana().actualizarPanel(6);
                
                break;
            case "COMPRAR MONEDAS":
                
                int m = Integer.parseInt(JOptionPane.showInputDialog(this.getVentana(), "Ingrese numero de monedas que desea comprar. Cada una cuesta 0.04 USD: "));
                JOptionPane.showMessageDialog(this.getVentana(), "*Redireccionando al pago con tarjeta");
                this.getVentana().getJuego().setMonedas(this.getVentana().getJuego().getMonedas() + m);
                this.repaint();
                break;
        }
    }

    @Override
    public void agregarComponentes(Graphics g) {
       this.removeAll();
       JButton salir = new JButton("GUARDAR Y SALIR");
       salir.setFont(this.getFont().deriveFont(0, 12));
       salir.setBounds(50, 30, 150, 35);
       salir.setLocation(50, 30);
       salir.setBackground(this.getVerdeOscuro());
       salir.setForeground(Color.WHITE);
       salir.addActionListener(this);
       this.add(salir);
       JButton unJugador = new JButton("UN JUGADOR");
       unJugador.setFont(this.getFont());
       unJugador.setBounds(50, 380, 200, 50);
       unJugador.setLocation(50, 380);
       unJugador.setBackground(this.getVerdeOscuro());
       unJugador.setForeground(Color.WHITE);
       unJugador.addActionListener(this);
       this.add(unJugador);
       JButton dosJugadores = new JButton("DOS JUGADORES");
       dosJugadores.setFont(this.getFont());
       dosJugadores.setBounds(307, 380, 200, 50);
       dosJugadores.setLocation(307, 380);
       dosJugadores.setBackground(this.getVerdeOscuro());
       dosJugadores.setForeground(Color.WHITE);
       dosJugadores.addActionListener(this);
       this.add(dosJugadores);
       JButton compraMonedas = new JButton("COMPRAR MONEDAS");
       compraMonedas.setFont(this.getFont());
       compraMonedas.setBounds(564, 380, 200, 50);
       compraMonedas.setLocation(564, 380);
       compraMonedas.setBackground(this.getVerdeOscuro());
       compraMonedas.setForeground(Color.WHITE);
       compraMonedas.addActionListener(this);
       this.add(compraMonedas);
       JLabel monedas = new JLabel("MONEDAS: " + this.getVentana().getJuego().getMonedas());
       monedas.setFont(this.getFont().deriveFont(0,25));
       monedas.setBounds(615, 15, 200, 50);
       monedas.setLocation(615, 15);
       monedas.setForeground(this.getDorado());
       this.add(monedas);
    }
    
}
