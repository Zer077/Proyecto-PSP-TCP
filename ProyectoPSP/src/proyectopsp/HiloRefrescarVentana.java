/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopsp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose_
 */
public class HiloRefrescarVentana extends Thread {

    private Cliente jugador;

    public HiloRefrescarVentana(Cliente jugador) {

        this.jugador = jugador;

    }

    @Override
    public void run() {
        while (true) {

            try {
                refrescarVentana();
                Thread.sleep(300);
            } catch (IOException | ClassNotFoundException | InterruptedException ex) {
                Logger.getLogger(HiloRefrescarVentana.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    
    //este metodo refesca la ventana
    public void refrescarVentana() throws IOException, ClassNotFoundException {

        //Si he recibido el panel significa que me han hecho daño, es decir, me toca recibir daño
        jugador.ObtenerPanelDelServidor();
        jugador.ResfrescarPanel();

    }
}
