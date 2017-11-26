/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import datos.Jugador;
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
public class PanelJugador extends Panel{
    
    private Jugador jugador;
    public PanelJugador(Ventana Ventana) {
        super(Ventana);
        this.jugador = this.getVentana().getJuego().getUnJugador().getJugador_Actual();
    }
    
    @Override
    public void paintComponent(Graphics g){
        this.setLayout(null);
        super.paintComponent(g);
        Image fondo = loadImage("Fondo.png");
        g.drawImage(fondo, 0, 0, this);
        this.agregarComponentes();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        JButton source = (JButton)evento.getSource();
        String textoBoton = source.getText();
        switch(textoBoton){
            case "PISTAS":
                this.getVentana().actualizarPanel(4);
                break;
            case "ATRÁS":
                this.getVentana().getJuego().getUnJugador().setJugador_Actual(null);
                this.getVentana().actualizarPanel(2);
                break;
            case "ANTERIOR  JUGADOR":
                this.getVentana().getJuego().getUnJugador().anteriorJugador();
                this.getVentana().actualizarPanel(3);
                break;
            case "SIGUIENTE  JUGADOR":
                this.getVentana().getJuego().getUnJugador().siguienteJugador();
                this.getVentana().actualizarPanel(3);
                break;
            default:
                break;
        }
    }

    @Override
    public void agregarComponentes() {
        this.removeAll();
        JButton pistas = new JButton("PISTAS");
        pistas.setFont(this.getFont());
        pistas.setBounds(50, 30, 200, 35);
        pistas.setLocation(50, 30);
        pistas.setBackground(this.getVerdeOscuro());
        pistas.setForeground(Color.WHITE);
        pistas.addActionListener(this);
        this.add(pistas);
        JLabel monedas = new JLabel("MONEDAS: " + this.getVentana().getJuego().getMonedas());
        monedas.setFont(this.getFont().deriveFont(0,25));
        monedas.setBounds(340, 15, 200, 50);
        monedas.setLocation(340, 15);
        monedas.setForeground(this.getDorado());
        this.add(monedas);
        JButton atras = new JButton("ATRÁS");
        atras.setFont(this.getFont());
        atras.setBounds(564, 30, 200, 35);
        atras.setLocation(564, 30);
        atras.setBackground(this.getVerdeOscuro());
        atras.setForeground(Color.WHITE);
        atras.addActionListener(this);
        this.add(atras);
        JButton anterior = new JButton("ANTERIOR  JUGADOR");
        anterior.setFont(this.getFont());
        anterior.setBounds(50, 435, 200, 35);
        anterior.setLocation(50, 435);
        anterior.setBackground(this.getVerdeOscuro());
        anterior.setForeground(Color.WHITE);
        anterior.addActionListener(this);
        this.add(anterior);
        JButton siguiente = new JButton("SIGUIENTE  JUGADOR");
        siguiente.setFont(this.getFont());
        siguiente.setBounds(564, 435, 200, 35);
        siguiente.setLocation(564, 435);
        siguiente.setBackground(this.getVerdeOscuro());
        siguiente.setForeground(Color.WHITE);
        siguiente.addActionListener(this);
        this.add(siguiente);
    }
    
}
