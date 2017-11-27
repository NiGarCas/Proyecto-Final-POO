/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import datos.Jugador;
import datos.Letra;
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
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        this.jugador = this.getVentana().getJuego().getUnJugador().getJugador_Actual();
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
            case "PISTAS":
                this.getVentana().actualizarPanel(4);
                break;
            case "ATRÁS":
                this.getVentana().getJuego().getUnJugador().setJugador_Actual(null);
                this.getVentana().actualizarPanel(2);
                break;
            case "ANTERIOR  JUGADOR":
                this.getVentana().getJuego().getUnJugador().anteriorJugador();
                this.repaint();
                System.out.println(this.jugador.getNombre());
                break;
            case "SIGUIENTE  JUGADOR":
                this.getVentana().getJuego().getUnJugador().siguienteJugador();
                this.repaint();
                break;
            case "<":
                this.getVentana().getJuego().getUnJugador().siguienteJugador();
                this.repaint();
                break;
            default:
                if(source.getBackground().equals(this.getVerdeMedio())){
                    this.jugador.getLetrasRespuesta().add(new Letra(false,textoBoton.toCharArray()[0]));
                    this.repaint();
                source.setBackground(this.getVerdeClaro());
                }
                break;
        }
    }

    @Override
    public void agregarComponentes(Graphics g) {
        this.removeAll();
        JButton pistas = new JButton("PISTAS");
        pistas.setFont(this.getFont());
        pistas.setBounds(50, 30, 200, 35);
        pistas.setLocation(50, 30);
        pistas.setBackground(this.getVerdeOscuro());
        pistas.setForeground(this.getVerdeClaro());
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
        atras.setForeground(this.getVerdeClaro());
        atras.addActionListener(this);
        this.add(atras);
        JButton anterior = new JButton("ANTERIOR  JUGADOR");
        anterior.setFont(this.getFont());
        anterior.setBounds(50, 435, 200, 35);
        anterior.setLocation(50, 435);
        anterior.setBackground(this.getVerdeOscuro());
        anterior.setForeground(this.getVerdeClaro());
        anterior.addActionListener(this);
        this.add(anterior);
        JButton siguiente = new JButton("SIGUIENTE  JUGADOR");
        siguiente.setFont(this.getFont());
        siguiente.setBounds(564, 435, 200, 35);
        siguiente.setLocation(564, 435);
        siguiente.setBackground(this.getVerdeOscuro());
        siguiente.setForeground(this.getVerdeClaro());
        siguiente.addActionListener(this);
        this.add(siguiente);
        this.agregarCamisetas(g);
        JLabel intentos = new JLabel("INTENTOS: " + this.jugador.getIntentos());
        intentos.setFont(this.getFont());
        intentos.setBounds(356, 295, 200, 50);
        intentos.setLocation(356, 295);
        intentos.setForeground(Color.WHITE);
        this.add(intentos);
        this.agregarCampoRta();
        this.agregarDisponibles();
    }

    private void agregarCampoRta() {
        int size = this.jugador.getNombre().toCharArray().length;
        int inicio = 0;
        switch(size){
            case 1:
                inicio = 378;
                break;
            case 2:
                inicio = 356;
                break;
            case 3:
                inicio = 333;
                break;
            case 4:
                inicio = 311;
                break;
            case 5:
                inicio = 288;
                break;
            case 6:
                inicio = 266;
                break;
            case 7:
                inicio = 243;
                break;
            case 8:
                inicio = 221;
                break;
            case 9:
                inicio = 198;
                break;
            case 10:
                inicio = 176;
                break;
            case 11:
                inicio = 153;
                break;
            case 12:
                inicio = 131;
                break;
            case 13:
                inicio = 108;
                break;
            case 14:
                inicio = 86;
                break;
            case 15:
                inicio = 63;
                break;
        }
        for(int i = 0;i<size;i++){
                if(i < this.jugador.getLetrasRespuesta().size()){
                    JButton tecla = new JButton(this.jugador.getLetrasRespuesta().get(i).getLetra()+"");
                }else{
                    JButton tecla = new JButton(" ");
                }
                JButton tecla = new JButton(" ");
                tecla.setFont(this.getFont());
                tecla.setBounds(inicio +(i*45), 337, 43, 25);
                tecla.setLocation(inicio +(i*45), 337);
                tecla.setBackground(Color.WHITE);
                tecla.setForeground(this.getVerdeOscuro());
                tecla.addActionListener(this);
                this.add(tecla);
                }
    }

    private void agregarCamisetas(Graphics g) {
        this.jugador = this.getVentana().getJuego().getUnJugador().getJugador_Actual();
        int cantidad = this.jugador.getEquipos().size();
        switch(cantidad){
            case 1:
                g.drawImage(this.loadImage(jugador.getEquipos().get(0).getCamiseta()), 350, 163, 450, 275, 0, 0, 238, 150, this);
                break;
            case 2:
                for(int i=0; i<2; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 300+(i*100), 163, 400+(i*100), 238, 0, 0, 200, 150, this);
                }
                break;
            case 3:
                for(int i=0; i<3; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 250+(i*100), 163, 350+(i*100), 238, 0, 0, 200, 150, this);
                }
                break;
            case 4:
                for(int i=0; i<4; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 200+(i*100), 163, 300+(i*100), 238, 0, 0, 200, 150, this);
                }
                break;
            case 5:
                for(int i=0; i<5; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 150+(i*100), 163, 250+(i*100), 238, 0, 0, 200, 150, this);
                }
                break;
            case 6:
                for(int i=0; i<3; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 250+(i*100), 125, 350+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=3; i<6; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 250+((i-3)*100), 200, 350+((i-3)*100), 275, 0, 0, 200, 150, this);
                }
                break;
            case 7:
                for(int i=0; i<4; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 200+(i*100), 125, 300+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=4; i<7; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 250+((i-4)*100), 200, 350+((i-4)*100), 275, 0, 0, 200, 150, this);
                }
                break;
            case 8:
                for(int i=0; i<4; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 200+(i*100), 125, 300+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=4; i<8; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 200+((i-4)*100), 200, 300+((i-4)*100), 275, 0, 0, 200, 150, this);
                }
                break;
            case 9:
                for(int i=0; i<5; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 150+(i*100), 125, 250+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=5; i<9; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 200+((i-5)*100), 200, 300+((i-5)*100), 275, 0, 0, 200, 150, this);
                }
                break;
            case 10:
                for(int i=0; i<5; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 150+(i*100), 125, 250+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=5; i<10; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 150+((i-5)*100), 200, 250+((i-5)*100), 275, 0, 0, 200, 150, this);
                }
                break;
            case 11:
                for(int i=0; i<6; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 100+(i*100), 125, 200+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=6; i<11; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 150+((i-6)*100), 200, 250+((i-6)*100), 275, 0, 0, 200, 150, this);
                }
                break;
            case 12:
                for(int i=0; i<6; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 100+(i*100), 125, 200+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=6; i<12; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 100+((i-6)*100), 200, 200+((i-6)*100), 275, 0, 0, 200, 150, this);
                }
                break;
            case 13:
                for(int i=0; i<7; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 50+(i*100), 125, 150+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=7; i<13; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 100+((i-7)*100), 200, 200+((i-7)*100), 275, 0, 0, 200, 150, this);
                }
                break;
            case 14:
                for(int i=0; i<7; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 50+(i*100), 125, 150+(i*100), 200, 0, 0, 200, 150, this);
                }
                for(int i=7; i<14; i++){
                    g.drawImage(this.loadImage(jugador.getEquipos().get(i).getCamiseta()), 50+((i-7)*100), 200, 150+((i-7)*100), 275, 0, 0, 200, 150, this);
                }
                break;
        }
    }

    private void agregarDisponibles() {
        for(int i = 0; i< 8; i++){
            JButton tecla = new JButton(this.jugador.getLetrasDisponibles()[i].getLetra() + "");
            tecla.setFont(this.getFont().deriveFont(0, 10));
            tecla.setBounds(221 + (i*45), 375, 43, 25);
            tecla.setLocation(221 + (i*45), 375);
            tecla.setBackground(this.getVerdeMedio());
            tecla.setForeground(this.getVerdeOscuro());
            tecla.addActionListener(this);
            this.add(tecla);
        }
        for(int i = 8; i< 15; i++){
            JButton tecla = new JButton(this.jugador.getLetrasDisponibles()[i].getLetra() + "");
            tecla.setFont(this.getFont().deriveFont(0, 10));
            tecla.setBounds(221 + ((i-8)*45), 402, 43, 25);
            tecla.setLocation(221 + ((i-8)*45), 402);
            tecla.setBackground(this.getVerdeMedio());
            tecla.setForeground(this.getVerdeOscuro());
            tecla.addActionListener(this);
            this.add(tecla);
        }
        JButton tecla = new JButton("<");
        tecla.setFont(this.getFont());
        tecla.setBounds(536, 402, 43, 25);
        tecla.setLocation(536, 402);
        tecla.setBackground(this.getVerdeOscuro());
        tecla.setForeground(this.getVerdeClaro());
        tecla.addActionListener(this);
        this.add(tecla);
    }
    
}
