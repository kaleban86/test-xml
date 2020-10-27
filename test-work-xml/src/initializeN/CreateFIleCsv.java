package initializeN;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateFIleCsv extends InitializeN {

    private static final String CSV_FILE = "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test.csv";

    public void addN() throws IOException {


        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE));


                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        ) {
            for (int i = 0; i < getN(); i++) {



                    csvPrinter.printRecord(1);
                    csvPrinter.flush();



            }

        }

    }



}


