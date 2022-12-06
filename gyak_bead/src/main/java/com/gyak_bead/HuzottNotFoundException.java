package com.gyak_bead;

public class HuzottNotFoundException extends RuntimeException{
    HuzottNotFoundException(int id) {

        super("A huzott nem található: " + id);
    }
}
