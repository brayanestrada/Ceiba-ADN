package com.ventas.ventadepasajes.domain.exceptions;


import sun.security.provider.PolicyParser;

public class ExceptionParsing extends PolicyParser.ParsingException {

    private static final long serialVersionUID = 1L;

    public ExceptionParsing(String message){ super(message); }
}
