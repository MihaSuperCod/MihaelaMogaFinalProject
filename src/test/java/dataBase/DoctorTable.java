package dataBase;

import models.DoctorModel;

import java.sql.PreparedStatement;

public class DoctorTable {
    private final DataBaseConnection dataBaseConnection;

    public DoctorTable() {
        dataBaseConnection = new DataBaseConnection();
    }

    public void insertDoctorIntoTable(DoctorModel doctorData) {
        String sql = "INSERT INTO Doctor (name, surname, address, city, email, phone) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = dataBaseConnection.getConnection().prepareStatement(sql);

            stmt.setString(1, doctorData.getNameInputValue());
            stmt.setString(2, doctorData.getSurnameInputValue());
            stmt.setString(3, doctorData.getAddressInputValue());
            stmt.setString(4, doctorData.getCityInputValue());
            stmt.setString(5, doctorData.getEmailInputValue());
            stmt.setString(6, doctorData.getPhoneInputValue());

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




