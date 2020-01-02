package com.ventas.ventadepasajes.domain.exceptions;

import java.text.ParseException;

public class ExceptionParsing extends ParseException {

    private static final long serialVersionUID = 1L;

    public ExceptionParsing(String message){ super(message,1); }
}
