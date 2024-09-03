package br.org.iredeam.data.dtos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FieldErrorDto extends ErrorDto {
    private Map<String, String> fieldErrors = new HashMap<>();

    public FieldErrorDto(Date timeStamp, String message, Map<String, String> fieldErrors) {
        super(timeStamp, message);
        this.fieldErrors = fieldErrors;
    }

    public FieldErrorDto() {
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}