package hu.nive.ujratervezes.jurassic;

import java.sql.*;

public class JurassicPark {

    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public JurassicPark(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public String checkOverpopulation() {
        String dinoPopulation = "";
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            String sql = "";
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            dinoPopulation += resultSet.getString(1);
            if (dinoPopulation.equals("")) return "";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dinoPopulation;
    }


}
