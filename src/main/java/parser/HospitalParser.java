package parser;

import domain.Hospital;

public class HospitalParser implements Parser<Hospital>{

    @Override
    public Hospital parse(String str) {
        str =str.replaceAll("\"","");
        String[] splitted = str.split(",");
//      address;
//      district;
//      category;
//      Integer emergencyRoom;
//      name;
//      subdivision;
        // subdivision은 파싱을 해서 넣는 것이 좋을 것 같다.
        return new Hospital(splitted[0],splitted[1],splitted[2],Integer.parseInt(splitted[6]),splitted[10],splitted[10]);
    }
}
