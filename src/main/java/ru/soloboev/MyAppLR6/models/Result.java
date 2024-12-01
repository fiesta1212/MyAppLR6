package ru.soloboev.MyAppLR6.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    public static final String SUCCESS_MESSAGE = "success";
    public static final String ERROR_MESSAGE = "error";
    private String message;
    private T result;
}
