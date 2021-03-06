package com.github.ququzone.basicauth.model;

/**
 * user fact model.
 *
 * @author Yang XuePing
 */
public class UserFact extends AbstractModel {
    private String userId;
    private Field name;
    private String value;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Field getName() {
        return name;
    }

    public void setName(Field name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public enum Field {
        DISPLAY_NAME
    }
}
