package com.scm.dscommerce.services.exceptions;

public class DatabaseException extends RuntimeException{ // RuntimeException -> não exige o bloco try cath
    public DatabaseException(String msg){ // Classe de exção customizada que exige uma mensagem
        super(msg);

    }
}
