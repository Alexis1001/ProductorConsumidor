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
public class ProductorConsumidorVFinal {

   
    public static void main(String[] args) {
        Semaphore Vacios = new Semaphore(5);
        Semaphore Llenos = new Semaphore(0);
        Semaphore Mutex = new Semaphore(1);
        Buffer buf = new Buffer(5);
        
        for (int x=0;x<100;x++) {
            new Productor(buf,Vacios,Llenos,Mutex).start();
            new Consumidor(buf,Vacios,Llenos,Mutex).start();
        }
        

    }
    
}
