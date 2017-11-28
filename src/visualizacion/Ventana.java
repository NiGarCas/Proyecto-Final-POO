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
        this.paneles = new Panel[9];
        this.paneles[0] = new PanelMenuPrincipal(this);
        this.paneles[1] = new PanelMenuNiveles(this);
        this.paneles[2] = new PanelNivel(this);
        this.paneles[3] = new PanelJugador(this);
        this.paneles[4] = new PanelPistas(this);
        this.paneles[5] = new PanelPista(this);
        this.paneles[6] = new PanelBusquedaAdversario(this);
        this.paneles[7] = new PanelRival(this);
        this.paneles[8] = new PanelJugadorRonda(this);
        this.panel_actual = new JPanel();
        panel_actual.setLayout(null);
        this.actualizarPanel(0);
        this.add(this.panel_actual);
        this.setVisible(true);
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
        this.getPanel_actual().removeAll();
        this.getPanel_actual().add(this.paneles[k]);
        this.getPanel_actual().updateUI();
        this.getPanel_actual().repaint();
    }
}
