package com.kostin.first.exceptions;

import jakarta.persistence.EntityExistsException;

public class FoundException extends EntityExistsException {
    public <T> FoundException(Class<T> clazz, String param){
        super(clazz.getSimpleName() + " by nameParameter = " + param + " already exist");
    }

}
