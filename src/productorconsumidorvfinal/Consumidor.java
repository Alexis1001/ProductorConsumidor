/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package productorconsumidorvfinal;
import java.util.concurrent.Semaphore;
/**
 *
 * @author PC
 */
public class Consumidor extends Thread{
    Buffer buffer;
    Semaphore Vacios;
    Semaphore Mutex;
    Semaphore Llenos;

    public Consumidor (Buffer b, Semaphore Vacios, Semaphore Llenos, Semaphore Mutex) {
        buffer = b;
        this.Vacios = Vacios;
        this.Mutex = Mutex;
        this.Llenos = Llenos;
    }

    public void run () {

            try {
                Llenos.acquire();
                Mutex.acquire();
            } catch (InterruptedException exc) { 
                System.out.println(exc); 
            }
            buffer.getElemento();
            System.out.print ("CON:");
            buffer.imprimir();
            System.out.println();
            Mutex.release();
            Vacios.release();
        
    }  
    
    
}
