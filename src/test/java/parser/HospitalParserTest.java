package parser;

import domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalParserTest {
    @Test
    @DisplayName("id를 잘 파싱 하늕 ㅣ테스트")
    void parseId() {
        HospitalParser hp = new HospitalParser();
        Hospital hospital =  hp.parse("Eee");
        Assertions.assertEquals("Eee",hospital.getId());
    }
}