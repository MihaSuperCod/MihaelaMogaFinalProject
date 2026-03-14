package models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DoctorModel {
    private String nameInputValue;
    private String surnameInputValue;
    private String addressInputValue;
    private String cityInputValue;
    private String emailInputValue;
    private String phoneInputValue;

    public DoctorModel(String filePath){
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

    public String getNameInputValue() {
        return nameInputValue;
    }

    public void setNameInputValue(String nameInputValue) {
        this.nameInputValue = nameInputValue;
    }

    public String getSurnameInputValue() {
        return surnameInputValue;
    }

    public void setSurnameInputValue(String surnameInputValue) {
        this.surnameInputValue = surnameInputValue;
    }

    public String getAddressInputValue() {
        return addressInputValue;
    }

    public void setAddressInputValue(String addressInputValue) {
        this.addressInputValue = addressInputValue;
    }

    public String getCityInputValue() {
        return cityInputValue;
    }

    public void setCityInputValue(String cityInputValue) {
        this.cityInputValue = cityInputValue;
    }

    public String getEmailInputValue() {
        return emailInputValue;
    }

    public void setEmailInputValue(String emailInputValue) {
        this.emailInputValue = emailInputValue;
    }

    public String getPhoneInputValue() {
        return phoneInputValue;
    }

    public void setPhoneInputValue(String phoneInputValue) {
        this.phoneInputValue = phoneInputValue;
    }
}


