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
public class PanelPistas extends Panel{
    
    public Nivel nivel;
    public Jugador jugador;
    public PanelPistas(Ventana Ventana) {
        super(Ventana);
        this.nivel = this.getVentana().getJuego().getUnJugador().getNivelActual();
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
            case "ATRÁS":
                this.getVentana().actualizarPanel(3);
                break;
            case "PAÍS DE NACIMIENTO                                                                                     -15 MONEDAS":
                this.jugador.setPista(1);
                boolean a = this.getVentana().getJuego().restarMonedas(15);
                this.getVentana().getJuego().setPudoRestar(a);
                this.getVentana().actualizarPanel(5);
                break;
            case "POSICIÓN                                                                                                                -8 MONEDAS":
                this.jugador.setPista(2);
                boolean b = this.getVentana().getJuego().restarMonedas(8);
                this.getVentana().getJuego().setPudoRestar(b);
                this.getVentana().actualizarPanel(5);
                break;
            case "PRIMERA LETRA                                                                                                    -5 MONEDAS":
                this.jugador.setPista(3);
                boolean c = this.getVentana().getJuego().restarMonedas(5);
                this.getVentana().getJuego().setPudoRestar(c);
                this.getVentana().actualizarPanel(5);
                break;
            case "ÚLTIMO EQUIPO                                                                                                  -15 MONEDAS":
                this.jugador.setPista(4);
                boolean d = this.getVentana().getJuego().restarMonedas(15);
                this.getVentana().getJuego().setPudoRestar(d);
                this.getVentana().actualizarPanel(5);
                break;
            case "RESPUESTA                                                                                                             -25 MONEDAS":
                this.jugador.setPista(5);
                boolean e = this.getVentana().getJuego().restarMonedas(25);
                this.getVentana().getJuego().setPudoRestar(e);
                this.getVentana().actualizarPanel(5);
                break;
        }
    }

    @Override
    public void agregarComponentes() {
        this.removeAll();
        JLabel niveles = new JLabel("PISTAS");
        niveles.setFont(this.getFont().deriveFont(0, 110));
        niveles.setBounds(40, 15, 500, 110);
        niveles.setLocation(40, 15);
        niveles.setForeground(Color.WHITE);
        this.add(niveles);
//        JLabel niv_jug = new JLabel("NIVEL " + nivel.getNumero() + " - JUGADOR #" + nivel.getNumeroJugador(jugador));
        JLabel niv_jug = new JLabel("NIVEL 2 - JUGADOR #30");
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
        JButton pais = new JButton("PAÍS DE NACIMIENTO                                                                                     -15 MONEDAS");
        pais.setFont(this.getFont().deriveFont(0,20));
        pais.setBounds(50, 200, 700, 35);
        pais.setLocation(50, 200);
        pais.setBackground(this.getVerdeOscuro());
        pais.setForeground(this.getVerdeClaro());
        pais.addActionListener(this);
        this.add(pais);
        JButton posicion = new JButton("POSICIÓN                                                                                                                -8 MONEDAS");
        posicion.setFont(this.getFont().deriveFont(0,20));
        posicion.setBounds(50, 252, 700, 35);
        posicion.setLocation(50, 252);
        posicion.setBackground(this.getVerdeOscuro());
        posicion.setForeground(this.getVerdeClaro());
        posicion.addActionListener(this);
        this.add(posicion);
        JButton letra = new JButton("PRIMERA LETRA                                                                                                    -5 MONEDAS");
        letra.setFont(this.getFont().deriveFont(0,20));
        letra.setBounds(50, 304, 700, 35);
        letra.setLocation(50, 304);
        letra.setBackground(this.getVerdeOscuro());
        letra.setForeground(this.getVerdeClaro());
        letra.addActionListener(this);
        this.add(letra);
        JButton uEquipo = new JButton("ÚLTIMO EQUIPO                                                                                                  -15 MONEDAS");
        uEquipo.setFont(this.getFont().deriveFont(0,20));
        uEquipo.setBounds(50, 356, 700, 35);
        uEquipo.setLocation(50, 356);
        uEquipo.setBackground(this.getVerdeOscuro());
        uEquipo.setForeground(this.getVerdeClaro());
        uEquipo.addActionListener(this);
        this.add(uEquipo);
        JButton rta = new JButton("RESPUESTA                                                                                                             -25 MONEDAS");
        rta.setFont(this.getFont().deriveFont(0,20));
        rta.setBounds(50, 408, 700, 35);
        rta.setLocation(50, 408);
        rta.setBackground(this.getVerdeOscuro());
        rta.setForeground(this.getVerdeClaro());
        rta.addActionListener(this);
        this.add(rta);
        JLabel aviso = new JLabel("Si desea comprar monedas regrese al menú principal");
        aviso.setFont(this.getFont().deriveFont(0,20));
        aviso.setBounds(150, 440, 7000, 50);
        aviso.setLocation(150, 440);
        aviso.setForeground(Color.WHITE);
        this.add(aviso);
    }
    
}
