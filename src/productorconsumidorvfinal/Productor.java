/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidorvfinal;
import java.util.concurrent.Semaphore;

public class Productor extends Thread {
    Buffer buffer;
    Semaphore Vacios;
    Semaphore Mutex;
    Semaphore Llenos;

    public Productor (Buffer b, Semaphore Vacios, Semaphore Llenos, Semaphore Mutex) {
        buffer = b;
        this.Vacios = Vacios;
        this.Mutex = Mutex;
        this.Llenos = Llenos;
    }

    public void run () {
        int item;


            item = (int)(Math.random() * 100);

            try {
                Vacios.acquire();
                Mutex.acquire();
            } catch (InterruptedException exc) { 
                System.out.println(exc); 
            }
            buffer.setElemento(item);
            System.out.print ("PRO:");
            buffer.imprimir();
            System.out.println();
            Mutex.release();
            Llenos.release();

    }
}