import domain.Hospital;
import parser.HospitalParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        boolean a=true;
        FileController<Hospital> hospitalFileController = new FileController<>(new HospitalParser(),a);
        String filename =   "C:\\Users\\daehwan\\Desktop\\서울시 병의원 위치정보.csv";
        List<Hospital> hospitals = hospitalFileController.readLines(filename);

        System.out.println(hospitals.size());
        List<String> lines = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            lines.add(hospital.getSqlInsertQuery());
        }
        String sqlFilename = "hospital_insert.sql";
        hospitalFileController.createANewFile(sqlFilename);
        hospitalFileController.writeLines(lines, sqlFilename);
    }
}
