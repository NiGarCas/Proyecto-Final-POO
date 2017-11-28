/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import datos.Ronda;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author nicol
 */
public class PanelBusquedaAdversario extends Panel{
    private Timer timer;
    public PanelBusquedaAdversario(Ventana Ventana) {
        super(Ventana);
        this.timer = new Timer (25,this);
        this.timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        this.setLayout(null);
        super.paintComponent(g);
        Image fondo = loadImage("Fondo.png");
        g.drawImage(fondo, 0, 0, this);
        this.agregarComponentes(g);
    }
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().getClass().getCanonicalName().equals("javax.swing.Timer")){
            repaint();
        }else{
            JButton source = (JButton)evento.getSource();
            String textoBoton = source.getText();
            if(textoBoton.equals("ATRÁS")){
                this.getVentana().getJuego().getDosJugadores().setCliente(null);
                this.getVentana().getJuego().getDosJugadores().setServidor(null);
                this.getVentana().actualizarPanel(0);
            }
        }
    }

    @Override
    public void agregarComponentes(Graphics g) {
        JLabel pistas = new JLabel("BÚSQUEDA DE");
        pistas.setFont(this.getFont().deriveFont(0,40));
        pistas.setBounds(50, 30, 500, 60);
        pistas.setLocation(50, 30);
        pistas.setForeground(Color.WHITE);
        this.add(pistas);
        JLabel monedas = new JLabel("ADVERSARIO");
        monedas.setFont(this.getFont().deriveFont(0,40));
        monedas.setBounds(50, 70, 500, 60);
        monedas.setLocation(50,70);
        monedas.setForeground(Color.WHITE);
        this.add(monedas);
        JButton atras = new JButton("ATRÁS");
        atras.setFont(this.getFont());
        atras.setBounds(564, 45, 200, 35);
        atras.setLocation(564, 45);
        atras.setBackground(this.getVerdeOscuro());
        atras.setForeground(this.getVerdeClaro());
        atras.addActionListener(this);
        this.add(atras);
        JLabel puntos = new JLabel(". . .");
        puntos.setFont(this.getFont().deriveFont(0,190));
        puntos.setBounds(280, 120, 500, 200);
        puntos.setLocation(280,120);
        puntos.setForeground(Color.WHITE);
        this.add(puntos);
        if(this.getVentana().getJuego().getDosJugadores().isHayRival()){
            this.timer.stop();
            this.getVentana().actualizarPanel(7);
        }
        
    }
    
}
