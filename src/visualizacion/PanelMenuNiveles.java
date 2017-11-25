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
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author nicol
 */
public class PanelMenuNiveles extends Panel{

    public PanelMenuNiveles(Ventana Ventana) {
        super(Ventana);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        this.setLayout(null);
       super.paintComponent(g);
       Image fondo = loadImage("Fondo.png");
       g.drawImage(fondo, 0, 0, this);
       this.agregarComponentes();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
    }

    @Override
    public void agregarComponentes() {
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
       JButton salir = new JButton("ATRÁS");
       salir.setFont(this.getFont());
       salir.setBounds(614, 80, 150, 35);
       salir.setLocation(614, 80);
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
       dosJugadores.setBounds(308, 380, 200, 50);
       dosJugadores.setLocation(308, 380);
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
    }
    
}
