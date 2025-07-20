package bf.yiristech.domain.enums;

import lombok.Getter;

@Getter
public enum Role {

    USER("user"),
    ADMIN("admin"),
    SUPERVISOR("supervisor"),
    AUDITOR("auditor"),
    OPERATOR("operator"),
    MANAGER("manager");

    private final String value;

    Role(String value) {
        this.value = value;
    }
}
