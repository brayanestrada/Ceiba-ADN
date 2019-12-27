package com.ventas.ventadepasajes.infrastructure.controller.user;

public class Utils {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 30;
    private static final int LAST_NAME_MIN_LENGTH = 3;
    private static final int LAST_NAME_MAX_LENGTH = 30;
    private static final int PHONE_MIN_LENGTH = 7;
    private static final int PHONE_MAX_LENGTH = 14;
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final int PASSWORD_MAX_LENGTH = 30;
    private static final String MUST_HAVE_MIN = "must have min ";
    private static final String MUST_HAVE_MAX = "must have max ";
    private static final String CHARACTERS = " characters ";
    public static final String NAME_IS_MANDATORY = "Name is mandatory";
    public static final String LAST_NAME_IS_MANDATORY = "Last name is mandatory";
    public static final String EMAIL_IS_MANDATORY = "Email is mandatory";
    public static final String PHONE_IS_MANDATORY = "Phone is mandatory";
    public static final String ROLE_ID_IS_MANDATORY = "Role is mandatory";
    public static final String PASS_IS_MANDATORY = "Password is mandatory";
    private static final String NUMBERS = " numbers";
    public static final String ERROR_NAME_MIN_LENGTH = "Name "+ MUST_HAVE_MIN + NAME_MIN_LENGTH + NUMBERS;
    public static final String ERROR_PHONE_MIN_LENGTH = "Phone "+ MUST_HAVE_MIN + PHONE_MIN_LENGTH + NUMBERS;
    public static final String ERROR_PHONE_MAX_LENGTH = "Phone "+ MUST_HAVE_MAX + PHONE_MAX_LENGTH + NUMBERS;
    public static final String ERROR_NAME_MAX_LENGTH = "Name "+ MUST_HAVE_MAX + NAME_MAX_LENGTH + CHARACTERS;
    public static final String ERROR_LAST_NAME_MIN_LENGTH = "Last name "+ MUST_HAVE_MIN + LAST_NAME_MIN_LENGTH + CHARACTERS;
    public static final String ERROR_LAST_NAME_MAX_LENGTH = "Last name" + MUST_HAVE_MAX + LAST_NAME_MAX_LENGTH + CHARACTERS;
    public static final String ERROR_PASS_MIN_LENGTH = "Password "+ MUST_HAVE_MIN + PASSWORD_MIN_LENGTH + CHARACTERS;
    public static final String ERROR_PASS_MAX_LENGTH = "Password " + MUST_HAVE_MAX + PASSWORD_MAX_LENGTH + CHARACTERS;

}
