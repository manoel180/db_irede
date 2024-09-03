package br.org.iredeam.data.dtos;

import java.util.Date;

public class ErrorDto {
    private Date timeStamp;
    private String message;

    public ErrorDto(Date timeStamp, String message) {
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public ErrorDto() {
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
}