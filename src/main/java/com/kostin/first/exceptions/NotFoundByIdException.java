package com.kostin.first.exceptions;

import jakarta.persistence.EntityNotFoundException;
import java.util.Objects;

public class NotFoundByIdException extends EntityNotFoundException {
    public <T> NotFoundByIdException(Class<T> clazz, Integer id){
        super(clazz.getSimpleName() + " by id=" + id + " not found");
    }
}
