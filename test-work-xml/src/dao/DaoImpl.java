package dao;

import xml.CreateXmlFIle;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl extends ConnectionDb implements Dao {

    private static Integer FIELD;

    @Override
    public boolean saveFile()  throws SQLException {

        try (Connection c = getConnection()) {
            PreparedStatement statement = c.prepareStatement("LOAD DATA  INFILE 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test.csv'  INTO TABLE test ");

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("updated successfully!");
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }


        return false;


    }


    @Override
    public boolean selectN() throws SQLException, TransformerException, ParserConfigurationException, FileNotFoundException {

        CreateXmlFIle xml = new CreateXmlFIle();

        try (Connection c = getConnection()) {
            String sql = "select * from test";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            List<Integer> list = new ArrayList<>();

            while (rs.next()) {

                FIELD = rs.getInt("FIELD");


                list.add(FIELD);

            }


            System.out.println(list.size());


            xml.createXml(list);


        }

        return false;
    }




    @Override
    public boolean updateDelete()throws SQLException {
        System.out.println("Удаление из Tests ");
        try (Connection c = getConnection()) {
            PreparedStatement statement = c.prepareStatement("DELETE FROM test ;");


            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("updated successfully!");
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }


        return false;

    }


    @Override
    public Connection getConnection()throws SQLException {


        try {
            return DriverManager.getConnection(getUrl(), getUser(), getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

}
