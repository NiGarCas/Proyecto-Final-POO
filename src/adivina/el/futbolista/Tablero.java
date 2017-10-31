/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina.el.futbolista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;;

/**
 *
 * @author nicol
 */
public class Tablero extends JPanel implements ActionListener, MouseListener{
    private Timer timer ;
    private JFrame frame;

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public Tablero(){
        //Lanza un evento de tipo ActionListener cada 100 Milisegundos
        //Se hace referencia a this porque la misma clase (Tablero) procesa el evento
        this.timer = new Timer(100, this);
        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
        addMouseListener (this);
        this.timer.start(); //Inicio con el escenario
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        Rectangle c1 = new Rectangle (50, 30, 200, 50);
        Rectangle c2 = new Rectangle (50, 380, 200, 50);
        Rectangle c3 = new Rectangle (308, 380, 200, 50);
        Rectangle c4 = new Rectangle (564, 380, 200, 50);
        if (c1.contains(mp)){
            System.out.println("SALIENDO");
        }
        if (c2.contains(mp)){
            System.out.println("MODO 1 JUGADOR");
        }
        if (c3.contains(mp)){
            System.out.println("MODO MULTIJUGADOR");
        }
        if (c4.contains(mp)){
            System.out.println("COMPRA MONEDAS");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
        
    //Inner class Que captura los eventos del teclado
     private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
//           int key = e.getKeyCode();
//           if (key == KeyEvent.VK_SPACE) {
//            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
//           }
        }
        //Cuando se presiona una tecla
        @Override
            public void keyPressed(KeyEvent e) {
               int key = e.getKeyCode();

               if (key == KeyEvent.VK_LEFT){
                   
               }
               if (key == KeyEvent.VK_DOWN){
                   
               }
               if (key == KeyEvent.VK_RIGHT){
                   
               }
               if (key == KeyEvent.VK_UP){
                   
               }
            }
        }
    
    //Metodo donde se pintan los objetos 
     @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       Image fondo = loadImage("Fondo.png");
       g.drawImage(fondo, 0, 0, this);
       Image tituloPrincipal = loadImage("AdivinaElFutbolista.png");
       g.drawImage(tituloPrincipal, 50, 120, this);
       Image botonPrueba = loadImage("BotonBase.png");
       g.drawImage(botonPrueba, 50, 30, this);
       g.drawImage(botonPrueba, 50, 380, this);
       g.drawImage(botonPrueba, 308, 380, this);
       g.drawImage(botonPrueba, 564, 380, this);
       g.setColor(Color.white);
       g.drawString("SALIR", 130, 60);
       g.drawString("1 JUGADOR", 115, 410);
       g.drawString("MULTIJUGADOR", 360, 410);
       g.drawString("COMPRAR MONEDAS", 605, 410);
       g.setColor(Color.yellow);
       g.drawString("XX MONEDAS", 678, 45);
    }

    //Metodo que se ejecuta cada vez que se lanza un ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public Image loadImage (String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
