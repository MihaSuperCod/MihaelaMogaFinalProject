package dataBase;

import models.CaseModel;

import java.sql.PreparedStatement;

public class CasesTable {
    private DataBaseConnection dataBaseConnection;

    public CasesTable() {
        dataBaseConnection = new DataBaseConnection();
    }

    public void insertCasesIntoTable(CaseModel caseData) {
        String sql = "INSERT INTO Cases (doctorName, patientName, color, element) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement stmt = dataBaseConnection.getConnection().prepareStatement(sql);

            stmt.setString(1, caseData.getDoctorInputField());
            stmt.setString(2, caseData.getPatientNameInput());
            stmt.setString(3, caseData.getColorDropdownInput()); // 3, nu 4
            stmt.setString(4, caseData.getElementInputField());  // 4, nu 5

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


