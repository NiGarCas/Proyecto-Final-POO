/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import datos.Jugador;
import datos.Nivel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author nicol
 */
public class PanelNivel extends Panel{
    
    private Nivel nivel;
    public PanelNivel(Ventana Ventana) {
        super(Ventana);
        this.nivel = this.getVentana().getJuego().getUnJugador().getNivelActual();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        this.setLayout(null);
        super.paintComponent(g);
        Image fondo = loadImage("Fondo.png");
        g.drawImage(fondo, 0, 0, this);
        this.agregarComponentes(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        JButton source = (JButton)evento.getSource();
        String textoBoton = source.getText();
        switch(textoBoton){
            case "ATRÁS":
                this.getVentana().getJuego().getUnJugador().setNivelActual(null);
                this.getVentana().actualizarPanel(1);
                break;
            default:
                int jugador = this.nivel.determinarJugador(textoBoton);
                System.out.println(jugador);
                if(jugador != 0){
                this.getVentana().getJuego().getUnJugador().setJugador_Actual(this.getVentana().getJuego().getUnJugador().getNivelActual().getJugadores().get(jugador-1));
                this.getVentana().actualizarPanel(3);
                }
                break;
        }
    }

    @Override
    public void agregarComponentes(Graphics g) {
        this.removeAll();
        JLabel niveles = new JLabel("NIVELES");
        niveles.setFont(this.getFont().deriveFont(0, 110));
        niveles.setBounds(40, 15, 500, 110);
        niveles.setLocation(40, 15);
        niveles.setForeground(Color.WHITE);
        this.add(niveles);
        JLabel monedas = new JLabel("MONEDAS: " + this.getVentana().getJuego().getMonedas());
        monedas.setFont(this.getFont().deriveFont(0,25));
        monedas.setBounds(615, 15, 200, 50);
        monedas.setLocation(615, 15);
        monedas.setForeground(this.getDorado());
        this.add(monedas);
        JButton atras = new JButton("ATRÁS");
        atras.setFont(this.getFont());
        atras.setBounds(614, 80, 150, 35);
        atras.setLocation(614, 80);
        atras.setBackground(this.getVerdeOscuro());
        atras.setForeground(Color.WHITE);
        atras.addActionListener(this);
        this.add(atras);
        this.nivel = this.getVentana().getJuego().getUnJugador().getNivelActual();
        for (int i = 0; i<5;i++){
            Jugador jugador = this.nivel.getJugadores().get(i);
            JButton bJugador;
            if(jugador.isAdivinado()){
                bJugador = new JButton((i+1) + " - " + jugador.getNombre());
                bJugador.setBackground(this.getVerdeMedio());
                bJugador.setForeground(Color.WHITE);
            }else{
                bJugador = new JButton((i+1) + " - " + "?");
                bJugador.setBackground(this.getVerdeOscuro());
                bJugador.setForeground(this.getVerdeClaro());
            }
            bJugador.setFont(this.getFont());
            bJugador.setBounds(50+(i*147), 170, 120, 35);
            bJugador.setLocation(50+(i*147), 170);
            bJugador.addActionListener(this);
            this.add(bJugador);
        }
        for (int i = 5; i<10;i++){
            Jugador jugador = this.nivel.getJugadores().get(i);
            JButton bJugador;
            if(jugador.isAdivinado()){
                bJugador = new JButton((i+1) + " - " + jugador.getNombre());
                bJugador.setBackground(this.getVerdeMedio());
                bJugador.setForeground(Color.WHITE);
            }else{
                bJugador = new JButton((i+1) + " - " + "?");
                bJugador.setBackground(this.getVerdeOscuro());
                bJugador.setForeground(this.getVerdeClaro());
            }
            bJugador.setFont(this.getFont());
            bJugador.setBounds(50+((i-5)*147), 224, 120, 35);
            bJugador.setLocation(50+((i-5)*147), 224);
            bJugador.addActionListener(this);
            this.add(bJugador);
        }
        for (int i = 10; i<15;i++){
            Jugador jugador = this.nivel.getJugadores().get(i);
            JButton bJugador;
            if(jugador.isAdivinado()){
                bJugador = new JButton((i+1) + " - " + jugador.getNombre());
                bJugador.setBackground(this.getVerdeMedio());
                bJugador.setForeground(Color.WHITE);
            }else{
                bJugador = new JButton((i+1) + " - " + "?");
                bJugador.setBackground(this.getVerdeOscuro());
                bJugador.setForeground(this.getVerdeClaro());
            }
            bJugador.setFont(this.getFont());
            bJugador.setBounds(50+((i-10)*147), 278, 120, 35);
            bJugador.setLocation(50+((i-10)*147), 278);
            bJugador.addActionListener(this);
            this.add(bJugador);
        }
        for (int i = 15; i<20;i++){
            Jugador jugador = this.nivel.getJugadores().get(i);
            JButton bJugador;
            if(jugador.isAdivinado()){
                bJugador = new JButton((i+1) + " - " + jugador.getNombre());
                bJugador.setBackground(this.getVerdeMedio());
                bJugador.setForeground(Color.WHITE);
            }else{
                bJugador = new JButton((i+1) + " - " + "?");
                bJugador.setBackground(this.getVerdeOscuro());
                bJugador.setForeground(this.getVerdeClaro());
            }
            bJugador.setFont(this.getFont());
            bJugador.setBounds(50+((i-15)*147), 332, 120, 35);
            bJugador.setLocation(50+((i-15)*147), 332);
            bJugador.addActionListener(this);
            this.add(bJugador);
        }
        for (int i = 20; i<25;i++){
            Jugador jugador = this.nivel.getJugadores().get(i);
            JButton bJugador;
            if(jugador.isAdivinado()){
                bJugador = new JButton((i+1) + " - " + jugador.getNombre());
                bJugador.setBackground(this.getVerdeMedio());
                bJugador.setForeground(Color.WHITE);
            }else{
                bJugador = new JButton((i+1) + " - " + "?");
                bJugador.setBackground(this.getVerdeOscuro());
                bJugador.setForeground(this.getVerdeClaro());
            }
            bJugador.setFont(this.getFont());
            bJugador.setBounds(50+((i-20)*147), 386, 120, 35);
            bJugador.setLocation(50+((i-20)*147), 386);
            bJugador.addActionListener(this);
            this.add(bJugador);
        }
        for (int i = 25; i<30;i++){
            Jugador jugador = this.nivel.getJugadores().get(i);
            JButton bJugador;
            if(jugador.isAdivinado()){
                bJugador = new JButton((i+1) + " - " + jugador.getNombre());
                bJugador.setBackground(this.getVerdeMedio());
                bJugador.setForeground(Color.WHITE);
            }else{
                bJugador = new JButton((i+1) + " - " + "?");
                bJugador.setBackground(this.getVerdeOscuro());
                bJugador.setForeground(this.getVerdeClaro());
            }
            bJugador.setFont(this.getFont());
            bJugador.setBounds(50+((i-25)*147), 440, 120, 35);
            bJugador.setLocation(50+((i-25)*147), 440);
            bJugador.addActionListener(this);
            this.add(bJugador);
        }
    }
}
