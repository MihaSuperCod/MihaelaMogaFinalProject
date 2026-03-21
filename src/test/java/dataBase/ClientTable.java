package dataBase;

import models.UserModel;

import java.sql.PreparedStatement;

public class ClientTable {
        private final DataBaseConnection dataBaseConnection;

        public ClientTable() {
            dataBaseConnection = new DataBaseConnection();
        }

        public void insertClientIntoTable(UserModel userData) {
            String sql = "insert into client(email, password) values(?, ?);";

            try {
                PreparedStatement stmt = dataBaseConnection.getConnection().prepareStatement(sql);

                stmt.setString(1, userData.getEmailFieldValue());
                stmt.setString(2, userData.getPasswordFieldValue());

                int rowsInserted = stmt.executeUpdate();
                System.out.println("Rows inserted: " + rowsInserted);

            } catch (Exception e) {
                e.printStackTrace();
            }}
        }


