/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacion;

import datos.Juego;
import javax.swing.JFrame;

/**
 *
 * @author nicol
 */
public class Ventana extends JFrame{
    
    private Juego juego;
    
    public Ventana(Juego juego) {
        this.juego = juego;
        this.juego.setVentana(this);
        PanelMenuNiveles tablero = new PanelMenuNiveles(this);
        add(tablero);
        setSize(806, 529);
        setTitle("Adivina El Futbolista");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public Juego getJuego() {
        return juego;
    }
    
}
