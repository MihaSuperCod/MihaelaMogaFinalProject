package models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ClientModel {
    private String emailFieldValue;
    private String passwordFieldValue;
    private String invalidPasswordFieldValue;

    public ClientModel(String filePath){
        loadFromJson(filePath);
    }

    public void loadFromJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readerForUpdating(this)
                    .readValue(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailFieldValue() {
        return emailFieldValue;
    }

    public void setEmailFieldValue(String emailFieldValue) {
        this.emailFieldValue = emailFieldValue;
    }

    public String getPasswordFieldValue() {
        return passwordFieldValue;
    }

    public void setPasswordFieldValue(String passwordFieldValue) {
        this.passwordFieldValue = passwordFieldValue;
    }

    public String getInvalidPasswordFieldValue() {
        return invalidPasswordFieldValue;
    }

    public void setInvalidPasswordFieldValue(String invalidPasswordFieldValue) {
        this.invalidPasswordFieldValue = invalidPasswordFieldValue;
    }
}
