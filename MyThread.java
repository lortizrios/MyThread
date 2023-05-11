///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// */
//
package com.lowebservices.mythread;

import java.time.Duration;
import java.time.Instant;

//
///**
// *
// * @author leroyortizrios
// */

public class MyThread extends Thread {

    private String nombre;
    public static int cantidad = 0;

    public MyThread(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        synchronized (MyThread.class) {
            cantidad++;
        }
        
        System.out.println(nombre + " cantidad: " + cantidad);
    }


    public static void main(String[] args) {
        //Time stamps
        Instant start = Instant.now();
        MyThread[] threads = new MyThread[10];        
        
        while (cantidad < 10) {
            try {
                if (cantidad < 10) {
                    for (int i = 0; i < threads.length; i++) {
                        threads[i] = new MyThread("T" + (i+1));
                    }
                    for (MyThread thread : threads) {
                        thread.start();
                    }
                    
                }
                
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
        Instant end = Instant.now();
        System.out.println("Thread Execution Time: " + Duration.between(start, end));
    }
}

