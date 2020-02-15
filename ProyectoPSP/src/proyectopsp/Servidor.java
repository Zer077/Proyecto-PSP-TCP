/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopsp;

import proyectopsp.NuevasClasesCompartidas.ObjetoCompartido;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose_
 */
public class Servidor {

    public Servidor() {
    }

    public void conectarCliente() throws IOException {

        try {

            ServerSocket servidor = new ServerSocket(6001);

            ObjetoCompartido panel = new ObjetoCompartido();
            int n = 1;
            while (n <= 2) {
                System.out.println("ESPERANDO CLIENTES");
                Socket cliente = new Socket();
                cliente = servidor.accept(); //esperando cliente
                n++;

                HiloServidorControl hilo = new HiloServidorControl(cliente, panel, n);

                hilo.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
