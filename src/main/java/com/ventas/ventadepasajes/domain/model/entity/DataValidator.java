package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;

public class DataValidator {

    public DataValidator(){}

    public static void validateMandatory(Object value, String message){
        if(value == null){
            throw new ExceptionGeneral(message);
        }
    }

    public static void validateMaximumValue(String value, int length, String message){
        if (value.length() > length){
            throw new ExceptionGeneral(message);
        }
    }

    public static void validateMinimumValue(String value, int length, String message){
        if (value.length() < length){
            throw new ExceptionGeneral(message);
        }
    }

    public static void validateMinimumValue(double value, int minValue, String message){
        if (value < minValue){
            throw new ExceptionGeneral(message);
        }
    }

    public static void validateMinimumValue(int value, int minValue, String message){
        if (value < minValue){
            throw new ExceptionGeneral(message);
        }
    }
}
