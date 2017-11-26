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
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author nicol
 */
public abstract class Panel extends JPanel implements ActionListener{
    
    private Ventana Ventana;
    private Font font;
    private Color verdeClaro;
    private Color verdeMedio;
    private Color verdeOscuro;
    private Color dorado;

    public Panel(Ventana Ventana) {
        this.Ventana = Ventana;
        this.setSize(800, 500);
        this.setFocusable(true);
        this.font =  new Font("Poetsen One", 0, 16);
        this.verdeOscuro = new Color (17,94,44);
        this.verdeMedio = new Color (35,162,80);
        this.verdeClaro = new Color (124,234,162);
        this.dorado = new Color (249,225,143);
    }

    @Override
    public Font getFont() {
        return font;
    }

    public Color getVerdeClaro() {
        return verdeClaro;
    }

    public Color getVerdeMedio() {
        return verdeMedio;
    }

    public Color getVerdeOscuro() {
        return verdeOscuro;
    }

    public Color getDorado() {
        return dorado;
    }

    public Ventana getVentana() {
        return Ventana;
    }
    
    public Image loadImage (String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    @Override
    public abstract void actionPerformed(ActionEvent evento);
    
    public abstract void agregarComponentes(Graphics g);
}
