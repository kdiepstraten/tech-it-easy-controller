
package com.example.TechItEasy.Exeptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message){
        super(message);
    }
}