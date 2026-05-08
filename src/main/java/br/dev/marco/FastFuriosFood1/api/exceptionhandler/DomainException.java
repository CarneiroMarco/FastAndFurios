package br.dev.marco.FastFuriosFood1.api.exceptionhandler;


public class DomainException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    public DomainException(String message){
        super (message);
    }}
