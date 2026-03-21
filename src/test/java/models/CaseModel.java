package models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CaseModel {
        private String doctorInputField;
        private String patientNameInput;
        private String colorDropdownInput;
        private String elementInputField;

        public CaseModel(String filePath) {
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

        public String getDoctorInputField() {
            return doctorInputField;
        }

        public void setDoctorInputField(String doctorInputField) {
            this.doctorInputField = doctorInputField;
        }

        public String getPatientNameInput() {
            return patientNameInput;
        }

        public void setPatientNameInput(String patientNameInput) {
            this.patientNameInput = patientNameInput;
        }

        public String getColorDropdownInput() {
            return colorDropdownInput;
        }

        public void setColorDropdownInput(String colorDropdownInput) {
            this.colorDropdownInput = colorDropdownInput;
        }

        public String getElementInputField() {
            return elementInputField;
        }

        public void setElementInputField(String elementInputField) {
            this.elementInputField = elementInputField;
        }
    }