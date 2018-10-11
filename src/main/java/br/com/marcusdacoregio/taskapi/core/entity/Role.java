package br.com.marcusdacoregio.taskapi.core.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    // Não mudar a ordem dos enums pois o spring usa o ordinal() pra cadastrar no banco
    ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
