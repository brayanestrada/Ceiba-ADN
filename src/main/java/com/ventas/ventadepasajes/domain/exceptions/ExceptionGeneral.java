package com.ventas.ventadepasajes.domain.exceptions;

import javax.persistence.GeneratedValue;

public class GeneralException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public GeneralException(String message){ super(message); }
}
