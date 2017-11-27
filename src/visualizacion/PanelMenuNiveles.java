/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import datos.Nivel;
import datos.UnJugador;
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
    
    private UnJugador unjugador;
    public PanelMenuNiveles(Ventana Ventana) {
        super(Ventana);
        this.unjugador = this.getVentana().getJuego().getUnJugador();
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
                this.getVentana().actualizarPanel(0);
                break;
            default:
                int nivel = this.unjugador.determinarNivel(textoBoton);
                if(nivel != 0){
                    this.getVentana().getJuego().getUnJugador().setNivelActual(this.getVentana().getJuego().getUnJugador().getNiveles().get(nivel-1));
                    if(this.getVentana().getJuego().getUnJugador().getNivelActual().isDesbloqueado()){
                    
                    this.getVentana().actualizarPanel(2);
                    }
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
        for (int i = 0; i<3;i++){
            Nivel nivel = this.getVentana().getJuego().getUnJugador().getNiveles().get(i);
            JButton bNivel;
            if(nivel.isDesbloqueado()){
                bNivel = new JButton(nivel.getNumero() + " - " + nivel.getJugadoresAdivinados() + "/30");
                bNivel.setBackground(this.getVerdeMedio());
                bNivel.setForeground(Color.WHITE);
                bNivel.setFont(this.getFont().deriveFont(0, 30));
            }else{
                bNivel = new JButton(nivel.getNumero() + " - " + nivel.getRestantesParaDesbloquear() + " JUG. +");
                bNivel.setBackground(this.getVerdeOscuro());
                bNivel.setForeground(this.getVerdeMedio());
                bNivel.setFont(this.getFont().deriveFont(0, 20));
            }
            bNivel.setBounds(50+(i*250), 170, 200, 80);
            bNivel.setLocation(50+(i*250), 170);
            bNivel.addActionListener(this);
            this.add(bNivel);
        }
        for (int i = 3; i<6;i++){
            Nivel nivel = this.getVentana().getJuego().getUnJugador().getNiveles().get(i);
            JButton bNivel;
            if(nivel.isDesbloqueado()){
                bNivel = new JButton(nivel.getNumero() + " - " + nivel.getJugadoresAdivinados() + "/30");
                bNivel.setBackground(this.getVerdeMedio());
                bNivel.setForeground(Color.WHITE);
                bNivel.setFont(this.getFont().deriveFont(0, 30));
            }else{
                bNivel = new JButton(nivel.getNumero() + " - " + nivel.getRestantesParaDesbloquear() + " JUG. +");
                bNivel.setBackground(this.getVerdeOscuro());
                bNivel.setForeground(this.getVerdeMedio());
                bNivel.setFont(this.getFont().deriveFont(0, 20));
            }
            bNivel.setBounds(50+((i-3)*250), 274, 200, 80);
            bNivel.setLocation(50+((i-3)*250), 274);
            bNivel.addActionListener(this);
            this.add(bNivel);
        }
        for (int i = 6; i<9;i++){
            Nivel nivel = this.getVentana().getJuego().getUnJugador().getNiveles().get(i);
            JButton bNivel;
            if(nivel.isDesbloqueado()){
                bNivel = new JButton(nivel.getNumero() + " - " + nivel.getJugadoresAdivinados() + "/30");
                bNivel.setBackground(this.getVerdeMedio());
                bNivel.setForeground(Color.WHITE);
                bNivel.setFont(this.getFont().deriveFont(0, 30));
            }else{
                bNivel = new JButton(nivel.getNumero() + " - " + nivel.getRestantesParaDesbloquear() + " JUG. +");
                bNivel.setBackground(this.getVerdeOscuro());
                bNivel.setForeground(this.getVerdeMedio());
                bNivel.setFont(this.getFont().deriveFont(0, 20));
            }
            bNivel.setBounds(50+((i-6)*250), 378, 200, 80);
            bNivel.setLocation(50+((i-6)*250), 378);
            bNivel.addActionListener(this);
            this.add(bNivel);
        }
    }
}
