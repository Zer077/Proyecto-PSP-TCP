/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopsp;

import java.awt.Dialog;
import proyectopsp.NuevasClasesCompartidas.Personaje;
import proyectopsp.NuevasClasesCompartidas.ObjetoCompartido;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jose_
 */
class HiloServidorControl extends Thread {

    ObjectInputStream fentrada;
    ObjectOutputStream fsalida;

    Socket socket = null;

    ObjetoCompartido panel;
    int identificador;

    public HiloServidorControl(Socket cliente, ObjetoCompartido panel, int n) throws IOException {
        this.socket = cliente;
        this.panel = panel;
        this.identificador = n;
        try {
            fsalida = new ObjectOutputStream(socket.getOutputStream());
            fentrada = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR DE E/S en HiloServidor");
        }

        //Se recibe un objeto
        try {
            if (panel.getJugador1() == null) {

                panel.setJugador1((Personaje) fentrada.readObject());
                panel.setSpecialJ1(0);
                panel.setPersonaje1(panel.getJugador1().getImagencontraria());
                System.out.println("Jugador 1");

            } else {
                System.out.println("Jugador 2");
                panel.setJugador2((Personaje) fentrada.readObject());
                panel.setSpecialJ2(0);
                panel.setPersonaje2(panel.getJugador2().getImagen());

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloServidorControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        super.run();
        while (panel.getJugador1() == null || panel.getJugador2() == null) {

            System.out.print(".");

        }

        try {

            fsalida.writeObject(panel); //enviando objeto
            System.out.println("HE ENVIADO EL PANEL");

        } catch (IOException ex) {
            Logger.getLogger(HiloServidorControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (panel.getJugador1().getVida() > 0 && panel.getJugador2().getVida() > 0) {
            //Flujo de entrada para objetos
            try {
                fentrada = new ObjectInputStream(socket.getInputStream());

                //Se recibe un objeto
                panel = (ObjetoCompartido) fentrada.readObject();//recibo objeto
                System.out.println("HE RECIBIDO UN MENSAJE");
                fsalida = new ObjectOutputStream(socket.getOutputStream());
                // Se prepara un objeto y se envía 

                fsalida.writeObject(panel); //enviando objeto
                System.out.println("SERVIDOR: vida del j1 " + panel.getJugador1().getVida() + " vida del j2 " + panel.getJugador2().getVida());
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(HiloServidorControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (panel.getJugador1().getVida() <= 0) {
            System.out.println("GANA EL J2");
            JOptionPane.showMessageDialog(null, "Gana el Jugador 2 ");

        } else {
            System.out.println("GANA EL J1");
            JOptionPane.showMessageDialog(null, "Gana el Jugador 1");
        }

    }

}
