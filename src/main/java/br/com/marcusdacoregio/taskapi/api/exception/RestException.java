package br.com.marcusdacoregio.taskapi.api.exception;

public class RestException extends RuntimeException {

    private String message;

    private Object[] args;

    public RestException(String message, Object... args) {
        this.message = message;
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public Object[] getArgs() {
        return args;
    }
}
