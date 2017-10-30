/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina.el.futbolista;

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
import javax.swing.JPanel;
import javax.swing.Timer;;

/**
 *
 * @author nicol
 */
public class Tablero extends JPanel implements ActionListener, MouseListener{
    private Timer timer ;
    
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
        Rectangle cuadrado = new Rectangle (40, 40, 55, 44);
        if (cuadrado.contains(mp)){
            
            System.out.println("SALIENDO");
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
       g.setColor(Color.black);
       g.fillRect(40, 40, 55, 44);
       g.setColor(Color.white);
       g.drawString("SALIR", 50, 50);
       g.drawString("1 JUGADOR", 50, 400);
       g.drawString("MULTIJUGADOR", 330, 400);
       g.drawString("COMPRAR MONEDAS", 630, 400);
       g.setColor(Color.yellow);
       g.drawString("XX MONEDAS", 670, 50);
      

    }

    //Metodo que se ejecuta cada vez que se lanza un ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Repaint");
        repaint();
    }
    
    public Image loadImage (String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
