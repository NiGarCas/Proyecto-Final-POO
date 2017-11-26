/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import datos.Juego;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nicol
 */
public class Ventana extends JFrame{
    
    private Juego juego;
    private Panel[] paneles;
    private JPanel panel_actual;
    
    public Ventana(Juego juego) {
        this.juego = juego;
        this.juego.setVentana(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(806, 529);
        setTitle("Adivina El Futbolista");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        setResizable(false);
        this.paneles = new Panel[6];
        this.paneles[0] = new PanelMenuPrincipal(this);
        this.paneles[1] = new PanelMenuNiveles(this);
        this.paneles[2] = new PanelNivel(this);
        this.paneles[3] = new PanelJugador(this);
        this.paneles[4] = new PanelPistas(this);
        this.paneles[5] = new PanelPista(this);
        this.panel_actual = new JPanel();
        this.add(this.paneles[3]);
//        this.actualizarPanel(0);
        
    }

    public Juego getJuego() {
        return juego;
    }

    public Panel[] getPaneles() {
        return paneles;
    }

    public JPanel getPanel_actual() {
        return panel_actual;
    }

    public void setPanel_actual(JPanel panel_actual) {
        this.panel_actual = panel_actual;
    }
    
    public void actualizarPanel(int k){
        this.dispose();
        this.removeAll();
        this.add(this.paneles[4]);
        this.setVisible(true);
//        this.panel_actual.removeAll();
//        this.panel_actual.add(this.getPaneles()[k]);
//        this.panel_actual.updateUI();
//        System.out.println(this.panel_actual.toString());
//        this.panel_actual.repaint();
    }
}
