/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author nicol
 */
public class Letra {
    private char letra;
    private boolean escogida;

    public Letra(boolean escogida,char letra) {
        this.letra = letra;
        this.escogida = escogida;
    }

    public char getLetra() {
        return letra;
    }

    public boolean isEscogida() {
        return escogida;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setEscogida(boolean escogida) {
        this.escogida = escogida;
    }
    
}
