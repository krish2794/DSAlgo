package org.example.threadTest;

public class Message {

    private String message;
    private boolean empty = true;

    public synchronized void write(String message){
        while(!empty){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        empty = false;
        notifyAll();
        this.message = message;
    }

    public synchronized String read(){
        while(empty){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        empty = true;
        notifyAll();
        return message;
    }
}
