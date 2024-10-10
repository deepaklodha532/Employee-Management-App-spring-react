package com.codingvisit.ems.exception;

public class ResourceNotFooundException extends RuntimeException {
     public ResourceNotFooundException(){
         super("Resource not found given id") ;
     }

     public ResourceNotFooundException(String message){
         super(message) ;
     }
}
