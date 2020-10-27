package dao;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public interface Dao {
    public Connection getConnection() throws SQLException;
    public  boolean updateDelete() throws SQLException;
    public  boolean saveFile() throws SQLException;
    public boolean selectN() throws SQLException, TransformerException, ParserConfigurationException, FileNotFoundException;

}
