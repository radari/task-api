package br.com.marcusdacoregio.taskapi.core.enums;

public enum TaskStatus {
    NOVA("N"),
    EM_EXECUCAO("E"),
    CONCLUIDA("C");

    private String code;

    TaskStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static TaskStatus fromCode(String code) {
        for (TaskStatus taskStatus : values()) {
            if (taskStatus.getCode().equals(code)) {
                return taskStatus;
            }
        }

        return null;
    }
}
