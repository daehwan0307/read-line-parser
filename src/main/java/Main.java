import domain.Hospital;
import parser.HospitalParser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileController<Hospital> hospitalFileController = new FileController<>(new HospitalParser());
        String filename =   "C:\\Users\\daehwan\\Desktop\\서울시 병의원 위치 정보.csv";
        List<Hospital> hospitals = hospitalFileController.readLines(filename);

        System.out.println(hospitals.size());
        for (Hospital hospital : hospitals) {
            System.out.printf("%s,%s,%s,%s,%d,%s,%s\n",hospital.getId(),hospital.getAddress(),
                    hospital.getDistrict(),hospital.getCategory(),
                    hospital.getEmergencyRoom(),hospital.getName(),
                    hospital.getSubdivision());
        }
    }
}
