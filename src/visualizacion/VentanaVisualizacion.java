/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import javax.swing.JFrame;

/**
 *
 * @author nicol
 */
public class VentanaVisualizacion extends JFrame{
    public VentanaVisualizacion() {
        initUI();
    }

    private void initUI() {
        Tablero tablero = new Tablero();
        tablero.setFrame(this);
        add(tablero);
        setSize(816, 539);
        setTitle("ADIVINA EL FUTBOLISTA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        VentanaVisualizacion ex = new VentanaVisualizacion();
        ex.setVisible(true);
       
    }
}
