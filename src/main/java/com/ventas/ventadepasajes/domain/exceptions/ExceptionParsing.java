package com.ventas.ventadepasajes.domain.exceptions;

import sun.security.pkcs.ParsingException;

public class ExceptionParsing extends ParsingException {

    private static final long serialVersionUID = 1L;

    public ExceptionParsing(String message){ super(message); }
}
