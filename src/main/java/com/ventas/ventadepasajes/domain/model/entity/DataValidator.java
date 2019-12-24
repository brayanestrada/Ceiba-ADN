package com.ventas.ventadepasajes.domain.model.entity;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataValidator {

    public static void validateMandatory(Object value, String message){
        if(value == null){
            throw new ExceptionGeneral(message);
        }
    }

    public static void validateMaximumValue(String value, int length, String message){
        if (value.length() > length){
            throw new ExceptionGeneral(message);
        }
    }public static void validateMaximumValue(int value, int maxValue, String message){
        if (value > maxValue){
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

    public static void validateDateFormat(String date, String message){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dateType = sdf.parse(date);
            if(!date.equals(sdf.format(dateType))){ throw new ExceptionGeneral(message);}
        } catch (ParseException e) {
            throw new ExceptionGeneral(message);
        }
    }

    public static void validateNumberMandatory(long value, String message){
        if(value == 0){
            throw new ExceptionGeneral(message);
        }
    }
}
