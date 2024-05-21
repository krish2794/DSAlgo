package org.example.threadTest;

public class Producer implements Runnable{

    private Message message;

    public Producer(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        String[] messages = {"Hello", "Hi", "Yes","This","is", "producer"};
        for(String msg : messages){
            message.write(msg);
            System.out.println("Producer: "+msg);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
