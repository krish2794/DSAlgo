package org.example.threadTest;

public class Main {
    public static void main(String[] args){
        Message message = new Message();
        Thread t1 = new Thread(new Producer(message), "Producer");
        Thread t2 = new Thread(new Consumer(message), "Consumer");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Completed");
    }
}
