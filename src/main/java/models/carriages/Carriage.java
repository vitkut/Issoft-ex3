package models.carriages;

import services.IdGenerator;

public abstract class Carriage {

    private String id;
    private Carriage next;

    public Carriage() {
        id = IdGenerator.generateId(5);
        next = null;
    }

    public String getId() {
        return id;
    }

    public Carriage getNext(){
        return next;
    }

    public void setNext(Carriage next){
        this.next = next;
    }
}
