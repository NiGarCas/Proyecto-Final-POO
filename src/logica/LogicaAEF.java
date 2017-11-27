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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author nicol
 */
public class LogicaAEF {
    
    private Juego juego;

    public LogicaAEF() {
    }

    public Juego getJuego() {
        return juego;
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
                   int monedas = flujoEntrada.nextInt();
                   int adivinados = flujoEntrada.nextInt();
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
                   while(prox.equals("N")) {
                               int numero = flujoEntrada.nextInt();
                               int adivinados = flujoEntrada.nextInt();
                               int rpd = flujoEntrada.nextInt();
                               Nivel nivel = new Nivel(numero, adivinados, rpd);
                               prox = flujoEntrada.next().trim();
                               for(int i = 0; i<30;i++){
                                    if(prox.equals("J")){}else{
                                        System.out.println("error lectura jugadores");
                                    }
                                   String nombre = flujoEntrada.next().trim();
                                   boolean p = false;
                                   int ad = flujoEntrada.nextInt();
                                   if(ad == 1){
                                       p = true;
                                   }
                                   int intentos = flujoEntrada.nextInt();
                                   String pais = flujoEntrada.next().trim();
                                   String posicion = flujoEntrada.next().trim();
                                   Jugador jugador = new Jugador(p,nombre,intentos,pais,posicion);
                                   nivel.agregarJugador(jugador);
                                   
                                   prox = flujoEntrada.next().trim();
                                   while ((!(prox.equals("N")))&&(!(prox.equals("J")))){
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
                               this.juego.getUnJugador().agregarNivel(nivel);
                               break;
                           }
                   
               }
           } catch (FileNotFoundException ex) {
               System.out.println("Archivo de datos no Encontrado");
           }
          
       }
    }
}
