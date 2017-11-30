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
import java.io.PrintStream;
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
                   dosJugadores.setJuego(juego);
                   juego.setLogica(this);
                   this.setJuego(juego);
                }
               flujoEntrada.close();
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
                   System.out.println(nombre);
                   String camiseta = flujoEntrada.next().trim();
                   this.juego.getEquipos().add(new Equipo(nombre,camiseta));
                }
               flujoEntrada.close();
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
               String n = prox;
               System.out.println(n);
               while(flujoEntrada.hasNext()){
                   System.out.println(prox.equals("N"));
                   while(prox.equals("N")) {
                               int numero = flujoEntrada.nextInt();
                               int adivinados = flujoEntrada.nextInt();
                               int rpd = flujoEntrada.nextInt();
                               Nivel nivel = new Nivel(numero, adivinados, rpd);
                               prox = flujoEntrada.next().trim();
                               for(int i = 0; i<30;i++){
                                   System.out.println(i);
                                    if(prox.equals("J")){}else{
                                        System.out.println("error lectura jugadores");
                                    }
                                   String nombre = flujoEntrada.next().trim();
                                   System.out.println(nombre);
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
                                       System.out.println(equipo);
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
               flujoEntrada.close();
           } catch (FileNotFoundException ex) {
               System.out.println("Archivo de datos no Encontrado");
           }
          
       }
    }
    public void guardarDatos(String archivo1,String archivo2){
        File escritura1 = new File(archivo1);
        File escritura2 = new File(archivo2);
        PrintStream flujo1 = null;
        PrintStream flujo2 = null;
        if(escritura1.exists()){
           try {
               flujo1 = new PrintStream(escritura1);
               flujo1.print(this.juego.getNombre()+",");
               flujo1.print(this.juego.getMonedas()+",");
               flujo1.print(this.juego.getUnJugador().getTotalAdivinados()+",");
               flujo1.close();
            }catch(FileNotFoundException e){}
       }
        if(escritura2.exists()){
           try {
               flujo2 = new PrintStream(escritura2);
               for(Nivel nivel : this.juego.getUnJugador().getNiveles()){
                   flujo2.print("N,");
                   flujo2.print(nivel.getNumero()+",");
                   flujo2.print(nivel.getJugadoresAdivinados()+",");
                   flujo2.print(nivel.getRestantesParaDesbloquear()+",");
                   for(Jugador jugador : nivel.getJugadores()){
                       flujo2.print("J,");
                       flujo2.print(jugador.getNombre()+",");
                       if(jugador.isAdivinado()){
                           flujo2.print("1,");
                       }else{
                           flujo2.print("0,");
                       }
                       flujo2.print(jugador.getIntentos()+",");
                       flujo2.print(jugador.getPais()+",");
                       flujo2.print(jugador.getPosicion()+",");
                       for(Equipo equipo : jugador.getEquipos()){
                           flujo2.print(equipo.getNombre()+",");
                       }
                   }
               }
            }catch(FileNotFoundException e){}
       }
    }
}
