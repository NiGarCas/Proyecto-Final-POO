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
public class PanelPista extends Panel{
    public Nivel nivel;
    public Jugador jugador;
    public boolean advertencia;
    public PanelPista(Ventana Ventana) {
        super(Ventana);
        this.nivel = this.getVentana().getJuego().getUnJugador().getNivelActual();
        this.jugador = this.getVentana().getJuego().getUnJugador().getJugador_Actual();
        this.advertencia = false;
    }
    
    @Override
    public void paintComponent(Graphics g){
        this.nivel = this.getVentana().getJuego().getUnJugador().getNivelActual();
        this.jugador = this.getVentana().getJuego().getUnJugador().getJugador_Actual();
        this.setLayout(null);
        super.paintComponent(g);
        Image fondo = loadImage("Fondo.png");
        g.drawImage(fondo, 0, 0, this);
        this.agregarComponentes(g);
        if(this.advertencia){
        Image adv = loadImage("Advertencia.png");
        g.drawImage(adv, 107, 280, this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent evento) {
        JButton source = (JButton)evento.getSource();
        String textoBoton = source.getText();
        switch(textoBoton){
            case "ATRÁS":
                this.getVentana().actualizarPanel(4);
                break;
        }
    }

    @Override
    public void agregarComponentes(Graphics g) {
        this.removeAll();
        JLabel niveles = new JLabel("PISTAS");
        niveles.setFont(this.getFont().deriveFont(0, 110));
        niveles.setBounds(40, 15, 500, 110);
        niveles.setLocation(40, 15);
        niveles.setForeground(Color.WHITE);
        this.add(niveles);
        JLabel niv_jug = new JLabel("NIVEL " + nivel.getNumero() + " - JUGADOR #" + nivel.getNumeroJugador(jugador));
        niv_jug.setFont(this.getFont().deriveFont(0, 30));
        niv_jug.setBounds(40, 90, 500, 110);
        niv_jug.setLocation(40, 90);
        niv_jug.setForeground(Color.WHITE);
        this.add(niv_jug);
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
        JButton pista;
        switch(jugador.getPista()){
            case 1:
                pista = new JButton("PAÍS DE NACIMIENTO                                                                                     -15 MONEDAS");
                break;
            case 2:
                pista = new JButton ("POSICIÓN                                                                                                                -8 MONEDAS");
                break;
            case 3:
                pista = new JButton ("PRIMERA LETRA                                                                                                    -5 MONEDAS");
                break;
            case 4:
                pista = new JButton ("ÚLTIMO EQUIPO                                                                                                  -15 MONEDAS");
                break;
            case 5:
                pista = new JButton ("RESPUESTA                                                                                                             -25 MONEDAS");
                break;
            default:
                pista = new JButton("error");
                break;
        }
        pista.setFont(this.getFont().deriveFont(0,20));
        pista.setBounds(50, 200, 700, 35);
        pista.setLocation(50, 200);
        pista.setBackground(this.getVerdeOscuro());
        pista.setForeground(this.getVerdeClaro());
        pista.addActionListener(this);
        this.add(pista);
        JLabel respuesta = null;
        if(this.getVentana().getJuego().isPudoRestar()){
            switch(jugador.getPista()){
            case 1:
                respuesta = new JLabel(jugador.getPais());
                break;
            case 2:
                respuesta = new JLabel (jugador.getPosicion());
                System.out.println(jugador.getPosicion());
                break;
            case 3:
                respuesta = new JLabel (jugador.getPrimeraLetra()+"");
                break;
            case 4:
                respuesta = new JLabel (jugador.getUltimoEquipo());
                break;
            case 5:
                respuesta = new JLabel (jugador.getNombre());
                break;
            default:
                respuesta = new JLabel("error");
                break;
            }
            respuesta.setFont(this.getFont().deriveFont(0,40));
            respuesta.setBounds(50, 250, 700, 100);
            respuesta.setLocation(50, 250);
            respuesta.setForeground(Color.WHITE);
            this.add(respuesta);

            this.advertencia = false;
        }else{
            this.advertencia = true;
        }
    }
}
