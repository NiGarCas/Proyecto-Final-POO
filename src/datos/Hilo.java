/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicol
 */
public class Hilo implements Runnable{
    private DosJugadores dosj;

    public Hilo(DosJugadores dosj) {
        this.dosj = dosj;
    }
    
    @Override
    public void run() {
        String a =(this.dosj.getNombreRival());
        while(true){
            
            try {
                
                String recibi = this.dosj.getLectura().readLine();
                if(recibi.equals(a)){
                    if(this.dosj.getRonda_actual().equals(this.dosj.getRondas()[4])){
                    this.dosj.getJuego().getVentana().actualizarPanel(9);
                    }else{
                        this.dosj.getJuego().getVentana().actualizarPanel(9);
                    }
                }
            } catch (IOException ex) {
            }

        }
    }
    
}
