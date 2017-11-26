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
    private boolean escogida;
    private char letra;

    public Letra(boolean escogida, char letra) {
        this.escogida = escogida;
        this.letra = letra;
    }

    public boolean isEscogida() {
        return escogida;
    }

    public char getLetra() {
        return letra;
    }

    public void setEscogida(boolean escogida) {
        this.escogida = escogida;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
    
}
