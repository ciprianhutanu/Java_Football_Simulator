package tests;

import config.DBConnection;
import java.sql.*;


public class TestDB {
    public static void main(String[] args) {
        DBConnection connection = DBConnection.getInstance();

        String query = "SELECT * " +
                       "FROM jucator " +
                       "WHERE idJucator IN (SELECT idJucator FROM portar)";

        try{
            PreparedStatement myStm = connection.getContext().prepareStatement(query);

            ResultSet res = myStm.executeQuery();
            while(res.next()){
                System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
