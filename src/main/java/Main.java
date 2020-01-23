import com.sun.tools.jdeprscan.CSV;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {

        try (Reader reader = new FileReader("C:\\Development\\reviews\\resources\\user-reviews.csv")) {
            //Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("id", "username", "rating", "review_title", "review_body").parse(reader);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);

//            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);
            for (CSVRecord record : records) {
//                String lastName = record.get("Last Name");
//                String firstName = record.get("First Name");
                System.out.println("Id: " + record.get(ReviewHeaders.id));
                System.out.println("Username: " + record.get(ReviewHeaders.username));
                System.out.println("Rating: " + record.get(ReviewHeaders.rating));
                System.out.println("Title: " + record.get(ReviewHeaders.review_title));
                System.out.println("Body: " + record.get(ReviewHeaders.review_body));
                System.out.println("*********************************************************");
            }
        } catch (Exception e) {

        }
    }
}
