package org.example.threadTest;

public class Consumer implements Runnable{

    private Message message;

    public Consumer(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        for(int i=0;i<6;i++){
            String msg = message.read();
            System.out.println("Consumer: "+msg);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
