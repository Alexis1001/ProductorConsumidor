/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidorvfinal;
import java.lang.Math;

public class Buffer { 
    private int[] buffer;
    private int elementos;
    private final int VACIO = -1;

    public Buffer (int elementos) {
        this.elementos = elementos;
        buffer = new int[elementos];
        for (int i=0;i<elementos;i++)
            buffer[i] = -1;
    }
    
    public void setElemento (int elemento){//productor
        int indice = 0;
        while (buffer[indice]!= VACIO)
            indice++;
        buffer[indice] = elemento;
    }

    public void getElemento(){//consumidor
        int indice = 0;
        while (buffer[indice]== VACIO)
            indice++;
        buffer[indice] = -1;   
    }

    public void imprimir(){
        for (int x=0;x<elementos;x++)
            System.out.print (buffer[x] + ":");
    }
}


