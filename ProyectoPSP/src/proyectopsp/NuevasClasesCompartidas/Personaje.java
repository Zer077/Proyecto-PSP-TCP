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
public class Personaje implements Serializable {

    private int fuerza;
    private boolean esquivando=false;
    private int vida;
    private String imagen;
    private String imagencontraria;

    public Personaje(int fuerza, int vida, String ruta) {
        this.fuerza = fuerza;
        this.vida = vida;
        imagen = ruta;
        imagencontraria = ruta + "-rival";

    }

    /**
     * @return the fuerza
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * @param fuerza the fuerza to set
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * @return the esquivando
     */
    public boolean isEsquivando() {
        return esquivando;
    }

    /**
     * @param esquivando the esquivando to set
     */
    public void setEsquivando(boolean esquivando) {
        this.esquivando = esquivando;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void quitarVida(int daño) {
        if (!esquivando) {
            setVida(getVida() - daño);
            System.out.println(getVida());
        }
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen+".gif";
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the imagencontraria
     */
    public String getImagencontraria() {
        return imagencontraria+".gif";
    }

    /**
     * @param imagencontraria the imagencontraria to set
     */
    public void setImagencontraria(String imagencontraria) {
        this.imagencontraria = imagencontraria;
    }

}
