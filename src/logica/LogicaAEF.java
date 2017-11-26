/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.DosJugadores;
import datos.Equipo;
import datos.Juego;
import datos.Jugador;
import datos.Nivel;
import datos.UnJugador;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import visualizacion.Ventana;

/**
 *
 * @author nicol
 */
public class LogicaAEF {
    
    private Juego juego;
    public static void main(String[] args) {
        UnJugador unJugador = new UnJugador(0);
        DosJugadores dosJugadores = new DosJugadores();
        Juego juego = new Juego("ok",0,unJugador,dosJugadores);
        Ventana ventana = new Ventana(juego);
//        ventana.add(ventana.getPanel_actual());
        ventana.setVisible(true);
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
    public void cargarInfoBasica(String archivo){
    File lectura = new File(archivo);
       Scanner flujoEntrada = null;
       if(lectura.exists()){
           try {
               flujoEntrada = new Scanner(lectura);
               flujoEntrada.useDelimiter(",");
               while(flujoEntrada.hasNext()){
                   String nombre = flujoEntrada.next().trim();
                   int monedas = Integer.parseInt(flujoEntrada.next().trim());
                   int adivinados = Integer.parseInt(flujoEntrada.next().trim());
                   UnJugador unJugador = new UnJugador(adivinados);
                   DosJugadores dosJugadores = new DosJugadores();
                   Juego juego = new Juego(nombre,monedas,unJugador,dosJugadores);
                   this.setJuego(juego);
                }
            }catch(FileNotFoundException e){}
       }
    }
    public void cargarEquipos(String archivo){
    File lectura = new File(archivo);
       Scanner flujoEntrada = null;
       if(lectura.exists()){
           try {
               flujoEntrada = new Scanner(lectura);
               flujoEntrada.useDelimiter(",");
               while(flujoEntrada.hasNext()){
                   String nombre = flujoEntrada.next().trim();
                   String camiseta = flujoEntrada.next().trim();
                   this.juego.getEquipos().add(new Equipo(nombre,camiseta));
                }
            }catch(FileNotFoundException e){}
       }
    }
    public void cargarNiveles(String archivo){
        File lectura = new File(archivo);
       Scanner flujoEntrada = null;
       if(lectura.exists()){
           try {
               flujoEntrada = new Scanner(lectura);
               flujoEntrada.useDelimiter(",");
               String prox  = flujoEntrada.next().trim();
               while(flujoEntrada.hasNext()){
                   switch (prox) {
                       case "N":
                           {
                               prox = flujoEntrada.next().trim();
                               if(prox.equals("J")){}else{
                                   System.out.println("error lectura jugadores");
                               }
                               int numero = Integer.parseInt(flujoEntrada.next().trim());
                               int adivinados = Integer.parseInt(flujoEntrada.next().trim());
                               int rpd = Integer.parseInt(flujoEntrada.next().trim());
                               Nivel nivel = new Nivel(numero,adivinados,rpd);
                               for(int i = 0; i<30;i++){
                                   String nombre = flujoEntrada.next().trim();
                                   boolean p = false;
                                   int ad= Integer.parseInt(flujoEntrada.next().trim());
                                   if(ad == 1){
                                       p = true;
                                   }
                                   int intentos = Integer.parseInt(flujoEntrada.next().trim());
                                   String pais = flujoEntrada.next().trim();
                                   String posicion = flujoEntrada.next().trim();
                                   Jugador jugador = new Jugador(p,nombre,intentos,pais,posicion);
                                   prox = flujoEntrada.next().trim();
                                   while (!(prox.equals("N"))){
                                       String equipo = prox;
                                       Equipo eq = this.juego.determinarEquipo(equipo);
                                       jugador.agregarEquipo(eq);
                                       if(flujoEntrada.hasNext()){
                                           prox = flujoEntrada.next().trim();
                                       }else{
                                           break;
                                       }
                                   }
                               }
                           }
                   }
               }
           } catch (FileNotFoundException ex) {
               System.out.println("Archivo de datos no Encontrado");
           }
          
       }
    }
}
