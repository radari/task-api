package br.com.marcusdacoregio.taskapi.api.i18n;

public enum Message {
    EXCEPTION_UNEXPECTED("Exception.unexpected"),
    EXCEPTION_NOT_FOUND("Exception.not_found"),
    VALIDATION_ACCESS_DENIED("Validation.access_denied"),
    VALIDATION_WRONG_CREDENTIALS("Validation.wrong_credentials"),
    VALIDATION_USER_INEXISTENT("Validation.user_inexistent"),
    VALIDATION_USER_ALREADY_TAKEN("Validation.user_already_taken");

    private String key;

    Message(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
