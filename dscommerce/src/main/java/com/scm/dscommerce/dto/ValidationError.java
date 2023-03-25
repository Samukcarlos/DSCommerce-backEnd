package com.scm.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{
    //criando sub classe de CustomError, ou seja; tem tudo oque CustomError tem mais os atributos dela mesma
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }
    // para que aceite a insersão de erros customizados, esses erros devem ser inseridos em ControllerExcepitionHandler
    public List<FieldMessage> getErrors() {
        return errors;
    }
    public void addError (String fieldName, String message)
    {
        errors.add(new FieldMessage(fieldName, message));
    } // adicionando na lista
}



