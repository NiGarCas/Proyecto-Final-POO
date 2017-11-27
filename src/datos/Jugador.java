/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import datos.Equipo;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class Jugador {
    
    private Nivel nivel;
    private boolean adivinado;
    private String nombre;
    private ArrayList<Equipo> equipos;
    private Letra[] letrasDisponibles;
    private ArrayList<Letra> letrasRespuesta;
    private int intentos;
    
    private int pista;
    private String pais;
    private String posicion;
    private char primeraLetra;
    private String ultimoEquipo;

    public Jugador(boolean adivinado, String nombre, int intentos, String pais, String posicion) {
        this.adivinado = adivinado;
        this.nombre = nombre;
        char[] nombreEnChar = this.nombre.toCharArray();
        this.equipos = new ArrayList();
        this.letrasDisponibles = new Letra[15];
        this.letrasRespuesta = new ArrayList();
        this.crearLetrasDisponibles(this.nombre);
        this.intentos = intentos;
        this.pais = pais;
        this.posicion = posicion;
        this.primeraLetra = nombreEnChar[0];
        this.pista = 0;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public boolean isAdivinado() {
        return adivinado;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public Letra[] getLetrasDisponibles() {
        return letrasDisponibles;
    }

    public ArrayList<Letra> getLetrasRespuesta() {
        return letrasRespuesta;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getPista() {
        return pista;
    }
    
    public String getPais() {
        return pais;
    }

    public String getPosicion() {
        return posicion;
    }

    public char getPrimeraLetra() {
        return primeraLetra;
    }

    public String getUltimoEquipo() {
        return ultimoEquipo;
    }

    public void setAdivinado(boolean adivinado) {
        this.adivinado = adivinado;
    }

    public void setLetrasDisponibles(Letra[] letrasDisponibles) {
        this.letrasDisponibles = letrasDisponibles;
    }

    public void setLetrasRespuesta(ArrayList<Letra> letrasRespuesta) {
        this.letrasRespuesta = letrasRespuesta;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void setPista(int pista) {
        this.pista = pista;
    }
    
    public void agregarEquipo(Equipo equipo){
        this.equipos.add(equipo);
        this.ultimoEquipo = equipo.getNombre();
    }

    private void crearLetrasDisponibles(String nombre) {
        char[] arreglo = nombre.toCharArray();
        Letra[] letras = new Letra[15];
        int numero;
        int i = 0;
        while (i < arreglo.length){
            numero = ((int) (Math.random() * 14));
            if(letras[numero] == null){
                letras[numero] = new Letra(false,arreglo[i]);
                i++;
            }   
        }
        for(int k = 0;k<15;k++){
            if(letras[k] == null){
            numero = ((int) (Math.random() * 25)+65);
            char a = (char) numero;
            letras[k] = new Letra(false,a);
            }
        }
        this.letrasDisponibles = letras;
    }

    public boolean verificar() {
        boolean rta = true;
        char[] name = this.nombre.toCharArray();
        if(name.length == this.letrasRespuesta.size()){
            for(int i = 0; i<name.length; i++){
                rta = rta && (name[i] == (this.letrasRespuesta.get(i).getLetra()));
            }
        }else{
            rta = false;
        }
        return rta;
    }

    public int determinarMonedas(int intentos) {
        switch (intentos){
            case 1:
                return 5;
            case 2:
                return 3;
            default:
                return 1;
        }
    }
}
