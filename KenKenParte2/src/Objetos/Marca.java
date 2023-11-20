/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Marca implements Serializable{
    String jugador;
    int horas;
    int minutos;
    int segundos;
    int tamannoKenKen;
    int dificultad;

    public Marca(String jugador, int horas, int minutos, int segundos, int tamannoKenKen, int dificultad) {
        this.jugador = jugador;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.tamannoKenKen = tamannoKenKen;
        this.dificultad = dificultad;
    }

    
    
    
    
    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getTamannoKenKen() {
        return tamannoKenKen;
    }

    public void setTamannoKenKen(int tamannoKenKen) {
        this.tamannoKenKen = tamannoKenKen;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    
    @Override
    public String toString(){
        return jugador+" - "+horas+":"+minutos+":"+segundos;
    }
    
}
