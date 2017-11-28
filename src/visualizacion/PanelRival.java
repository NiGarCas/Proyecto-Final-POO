/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author nicol
 */
public class PanelRival extends Panel{
    
    public PanelRival(Ventana Ventana) {
        super(Ventana);
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
    }

    @Override
    public void agregarComponentes(Graphics g) {
        JLabel pistas = new JLabel("BÚSQUEDA DE");
        pistas.setFont(this.getFont().deriveFont(0,40));
        pistas.setBounds(270, 30, 500, 60);
        pistas.setLocation(270, 30);
        pistas.setForeground(Color.WHITE);
        this.add(pistas);
        JLabel monedas = new JLabel("ADVERSARIO");
        monedas.setFont(this.getFont().deriveFont(0,40));
        monedas.setBounds(280, 70, 500, 60);
        monedas.setLocation(280,70);
        monedas.setForeground(Color.WHITE);
        this.add(monedas);
        JLabel rival = new JLabel("Tu rival: ");
        rival.setFont(this.getFont().deriveFont(0,60));
        rival.setBounds(80, 180, 500, 200);
        rival.setLocation(80,180);
        rival.setForeground(Color.WHITE);
        this.add(rival);
        if(this.getVentana().getJuego().getDosJugadores().getModo() == 1){
            JLabel name;
            try {
                name = new JLabel(this.getVentana().getJuego().getDosJugadores().getLectura().readLine());
                name.setFont(this.getFont().deriveFont(0,60));
                name.setBounds(330, 180, 500, 200);
                name.setLocation(330,180);
                name.setForeground(this.getVerdeClaro());
            this.add(name);
            } catch (IOException ex) {
                System.out.println("error");
            }
            
        }else{
            JLabel name;
            try {
                name = new JLabel(this.getVentana().getJuego().getDosJugadores().getLectura().readLine());
                name.setFont(this.getFont().deriveFont(0,60));
                name.setBounds(330, 180, 500, 200);
                name.setLocation(330,180);
                name.setForeground(this.getVerdeClaro());
                this.add(name);
            } catch (IOException ex) {
                System.out.println("error");
            }
            
        }
        System.out.println("panel rival");
        try{ 
            Thread.sleep(4000); 
        } catch(InterruptedException e ) {}
        this.getVentana().actualizarPanel(8);
    }
}
