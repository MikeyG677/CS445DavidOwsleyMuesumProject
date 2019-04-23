package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.ArtifactRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class ArtifactRecordTest {
    ArtifactRecord buildTestRecord(List<String> paramaters){
        ArtifactRecord testRecord = new ArtifactRecord();

        testRecord.setTitle(paramaters.get(0));
        testRecord.setFileName(paramaters.get(1));
        testRecord.setArtist(paramaters.get(2));
        testRecord.setSubject_LCSH(paramaters.get(3));
        testRecord.setDate_Made(paramaters.get(4));
        testRecord.setCulture(paramaters.get(5));
        testRecord.setCentury(paramaters.get(6));
        testRecord.setPeriodStyle(paramaters.get(7));

        return testRecord;
    }

    private List<String> testParameters_1 = Arrays.asList("Foo","Bar","Fool","Foo ; Bar","1969","American","21st","Cubism");
    private List<String> testParameters_2 = Arrays.asList("The Monolith","hal_marktwo_the_monolith","Hal Marktwo","Industrial ; Modernism ; Futuristic ; Sci-fi","2001","Alien","20th","Impressionism");
    private ArtifactRecord testRecord_1 = buildTestRecord(testParameters_1);
    private ArtifactRecord testRecord_2 = buildTestRecord(testParameters_2);

    @Test
    void testSpecificTitle_1(){
        Assertions.assertEquals("Foo", testRecord_1.getTitle());
    }
    @Test
    void testSpecificTitle_2(){
        Assertions.assertEquals("The Monolith", testRecord_2.getTitle());
    }

    @Test
    void testSpecificFileName_1(){
        Assertions.assertEquals("Bar", testRecord_1.getFileName());
    }
    @Test
    void testSpecificFileName_2(){
        Assertions.assertEquals("hal_marktwo_the_monolith", testRecord_2.getFileName());
    }

    @Test
    void testSpecificArtist_1(){
        Assertions.assertEquals("Fool", testRecord_1.getArtist());
    }
    @Test
    void testSpecificArtist_2(){
        Assertions.assertEquals("Hal Marktwo", testRecord_2.getArtist());
    }

    @Test
    void testSpecificSubject_1(){
        Assertions.assertEquals("Foo ; Bar", testRecord_1.getSubject_LCSH());
    }
    @Test
    void testSpecificSubject_2() { Assertions.assertEquals("Industrial ; Modernism ; Futuristic ; Sci-fi", testRecord_2.getSubject_LCSH()); }

    @Test
    void testSpecificDate_1(){
        Assertions.assertEquals("1969", testRecord_1.getDate_Made());
    }
    @Test
    void testSpecificDate_2(){
        Assertions.assertEquals("2001", testRecord_2.getDate_Made());
    }

    @Test
    void testSpecificCulture_1(){
        Assertions.assertEquals("American", testRecord_1.getCulture());
    }
    @Test
    void testSpecificCulture_2(){
        Assertions.assertEquals("Alien", testRecord_2.getCulture());
    }

    @Test
    void testSpecificCentury_1(){
        Assertions.assertEquals("21st", testRecord_1.getCentury());
    }
    @Test
    void testSpecificCentury_2(){
        Assertions.assertEquals("20th", testRecord_2.getCentury());
    }

    @Test
    void testSpecificPeriodStyle_1(){
        Assertions.assertEquals("Cubism", testRecord_1.getPeriodStyle());
    }
    @Test
    void testSpecificPeriodStyle_2(){
        Assertions.assertEquals("Impressionism", testRecord_2.getPeriodStyle());
    }

}
