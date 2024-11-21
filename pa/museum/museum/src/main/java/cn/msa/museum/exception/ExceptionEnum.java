package cn.msa.museum.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    MISSING_PARAMETERS(1001, "Missing Parameters"),

    USER_EXISTS(2001, "User already exists"),
    USER_DOES_NOT_EXIST(2002, "User does not exist"),
    WRONG_PASSWORD(2003, "Wrong password");

    private final int code;
    private final String message;
}
