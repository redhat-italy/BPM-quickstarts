package it.redhat.quickstartlab.util;

public class Key {

    public static String generate(int size){
        byte[] key = new byte[size];
        for(int x=0;x<size;x++){
            key[x] = (byte) (65 + 25 * Math.random());
        }
        return new String(key);
    }

}
