import dao.Dao;
import dao.DaoImpl;
import initializeN.CreateFIleCsv;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.SQLException;


public class Main  {


    public static void main(String[] args) throws SQLException, IOException, TransformerException, ParserConfigurationException {

        DaoImpl dao = new DaoImpl();
        CreateFIleCsv createFIleCsv = new CreateFIleCsv();
        long time = System.currentTimeMillis();

        dao.setPassword("530433");
        dao.setUser("root");
        dao.setUrl("jdbc:mysql://localhost:3306/xml");
        dao.updateDelete();
        createFIleCsv.setN(5);
        createFIleCsv.addN();
      //  dao.saveFile();
        dao.save(5);
        dao.selectN();



        System.out.println(System.currentTimeMillis() - time);

    }



}
