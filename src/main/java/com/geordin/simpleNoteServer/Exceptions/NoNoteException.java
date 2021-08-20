package com.geordin.simpleNoteServer.Exceptions;

public class NoNoteException extends RuntimeException{
    public NoNoteException(){
        super("The data you are are looking for does not exist in this database");

    }
}
