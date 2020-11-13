package initializeN;

import dao.DaoImpl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateFIleCsv extends InitializeN {

    private static final String CSV_FILE = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test.csv";

    public void addN() throws IOException, SQLException {


        DaoImpl dao = new DaoImpl();

        for (int i = 0; i <getN() ; i++) {



            dao.save(i);



        }




    }



}
/*
  try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE));


                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        ) {
            for (int i = 0; i < getN(); i++) {



                    csvPrinter.printRecord(1);
                    csvPrinter.flush();



            }

        }
 */

