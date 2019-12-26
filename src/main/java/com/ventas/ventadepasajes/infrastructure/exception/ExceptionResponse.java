package com.ventas.ventadepasajes.infrastructure.exception;

import java.util.Date;

public class ExceptionResponse {

    private Date timeStamp;
    private String message;
    private String description;

    public ExceptionResponse(Date timeStamp, String message, String detail) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.description = detail;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String detail) {
        this.description = detail;
    }



}
