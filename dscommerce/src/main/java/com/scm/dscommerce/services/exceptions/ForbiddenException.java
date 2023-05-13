package com.scm.dscommerce.services.exceptions;

public class ForbiddenException extends RuntimeException{ // RuntimeException -> não exige o bloco try cath
    public ForbiddenException(String msg){ // Classe de exção customizada que exige uma mensagem
        super(msg);

    }
}
