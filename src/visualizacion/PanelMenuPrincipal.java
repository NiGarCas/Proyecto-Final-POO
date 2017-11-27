/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
            case "SALIR":
                this.getVentana().getJuego().getLogica().guardarDatos("datosBasicos.txt", "escritura.txt");
                JOptionPane.showMessageDialog(this.getVentana(), "Datos guardados exitosamente");
                this.getVentana().dispose();
                break;
            case "UN JUGADOR":
                this.getVentana().actualizarPanel(1);
                break;
            case "DOS JUGADORES":
                this.getVentana().actualizarPanel(2);
                break;
            case "COMPRAR MONEDAS":
                this.getVentana().getJuego().setMonedas(this.getVentana().getJuego().getMonedas() + 1);
                this.repaint();
                break;
        }
    }

    @Override
    public void agregarComponentes(Graphics g) {
       this.removeAll();
       JButton salir = new JButton("SALIR");
       salir.setFont(this.getFont());
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
