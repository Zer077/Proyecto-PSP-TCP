/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopsp.NuevasClasesCompartidas;

import java.io.Serializable;

/**
 *
 * @author jose_
 */
public class ObjetoCompartido implements Serializable {

    private Personaje Personaje1;
    private Personaje Personaje2;

    private String ImagenPersonaje1;
    private String ImagenPersonaje2;

    private int specialJ1 = 1;
    private int specialJ2 = 1;

   

    private int fuerzaAtaqueJ1 = 0;
    private int fuerzaAtaqueJ2 = 0;

    public ObjetoCompartido() {

    }

    /**
     * @return the Jugador1
     */
    public synchronized Personaje getJugador1() {
        return Personaje1;
    }

    /**
     * @param Jugador1 the Jugador1 to set
     */
    public synchronized void setJugador1(Personaje Jugador1) {
        this.Personaje1 = Jugador1;
    }

    /**
     * @return the Jugador2
     */
    public synchronized Personaje getJugador2() {
        return Personaje2;
    }

    /**
     * @param Jugador2 the Jugador2 to set
     */
    public synchronized void setJugador2(Personaje Jugador2) {
        this.Personaje2 = Jugador2;
    }

    /**
     * @return the Personaje1
     */
    /**
     * @return the fuerzaAtaqueJ1
     */
    public synchronized int getFuerzaAtaqueJ1() {
        return fuerzaAtaqueJ1;
    }

    /**
     * @param fuerzaAtaqueJ1 the fuerzaAtaqueJ1 to set
     */
    public synchronized void setFuerzaAtaqueJ1(int fuerzaAtaqueJ1) {
        this.fuerzaAtaqueJ1 = fuerzaAtaqueJ1;
    }

    /**
     * @return the fuerzaAtaqueJ2
     */
    public synchronized int getFuerzaAtaqueJ2() {
        return fuerzaAtaqueJ2;
    }

    /**
     * @param fuerzaAtaqueJ2 the fuerzaAtaqueJ2 to set
     */
    public synchronized void setFuerzaAtaqueJ2(int fuerzaAtaqueJ2) {
        this.fuerzaAtaqueJ2 = fuerzaAtaqueJ2;
    }

    /**
     * @return the Personaje1
     */
    public String getPersonaje1() {
        return ImagenPersonaje1;
    }

    /**
     * @param Personaje1 the Personaje1 to set
     */
    public void setPersonaje1(String Personaje1) {
        this.ImagenPersonaje1 = Personaje1;
    }

    /**
     * @return the Personaje2
     */
    public String getPersonaje2() {
        return ImagenPersonaje2;
    }

    /**
     * @param Personaje2 the Personaje2 to set
     */
    public void setPersonaje2(String Personaje2) {
        this.ImagenPersonaje2 = Personaje2;
    }

    /**
     * @return the specialJ1
     */
    public int getSpecialJ1() {
        return specialJ1;
    }

    /**
     * @param specialJ1 the specialJ1 to set
     */
    public void setSpecialJ1(int specialJ1) {
        this.specialJ1 = specialJ1;
    }

    /**
     * @return the specialJ2
     */
    public int getSpecialJ2() {
        return specialJ2;
    }

    /**
     * @param specialJ2 the specialJ2 to set
     */
    public void setSpecialJ2(int specialJ2) {
        this.specialJ2 = specialJ2;
    }

    
}
