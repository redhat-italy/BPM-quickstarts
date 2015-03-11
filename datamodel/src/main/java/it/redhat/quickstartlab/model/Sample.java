package it.redhat.quickstartlab.model;

public class Sample {
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    int size;
    long id;

    public Sample(){
        this.size = (int)(100 * Math.random());
        this.id = this.size + System.currentTimeMillis();
    }

    public Sample(long id, int size){
        this.id = id;
        this.size = size;
    }
}
