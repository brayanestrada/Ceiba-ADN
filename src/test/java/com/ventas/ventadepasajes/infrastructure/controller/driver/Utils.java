package com.ventas.ventadepasajes.infrastructure.controller.driver;

class Utils {

    private static final int NAME_MIN_LENGTH = 2;
    private static final int NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MIN_LENGTH = 2;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final int IDENTIFICATION_MIN_LENGTH = 8;
    private static final int IDENTIFICATION_MAX_LENGTH = 11;
    private static final String MUST_HAVE_MIN = "must have min characters";
    private static final String MUST_HAVE_MAX = "must have max";
    static final String ERROR_NAME_IS_MANDATORY = "Name is mandatory";
    static final String ERROR_LAST_NAME_IS_MANDATORY = "Last name is mandatory";
    static final String ERROR_IDENTIFICATION_IS_MANDATORY = "Identification is mandatory";
    static final String ERROR_NAME_MIN_LENGTH = "Name "+ MUST_HAVE_MIN + NAME_MIN_LENGTH;
    static final String ERROR_NAME_MAX_LENGTH = "Name "+ MUST_HAVE_MAX + NAME_MAX_LENGTH;
    static final String ERROR_LAST_NAME_MIN_LENGTH = "Last name "+ MUST_HAVE_MIN + LAST_NAME_MIN_LENGTH;
    static final String ERROR_LAST_NAME_MAX_LENGTH = "Last name" + MUST_HAVE_MAX + LAST_NAME_MAX_LENGTH;
    static final String ERROR_IDENTIFICATION_MIN_LENGTH = "Identification "+ MUST_HAVE_MIN + IDENTIFICATION_MIN_LENGTH;
    static final String ERROR_IDENTIFICATION_MAX_LENGTH = "Identification must have max " + IDENTIFICATION_MAX_LENGTH;

}
