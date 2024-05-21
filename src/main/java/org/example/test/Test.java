package org.example.test;

public class Test implements Cloneable{

    int id;
    String name;

    Test(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Test clone(){
        return new Test(id, name);
    }
}
