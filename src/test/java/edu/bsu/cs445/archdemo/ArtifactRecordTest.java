package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArtifactRecordTest {
    ArtifactRecord buildTestRecord(){
        ArtifactRecord testRecord = new ArtifactRecord();

        testRecord.title = "Foo";
        testRecord.fileName = "Bar";
        testRecord.artist = "Fool";
        testRecord.subject_LCSH = "Foo ; Bar";
        testRecord.date_Made = "1969";
        testRecord.culture = "American";
        testRecord.century = "21st";
        testRecord.periodStyle = "Cubism";

        return testRecord;
    }

    private ArtifactRecord testRecord = buildTestRecord();

    @Test
    void testSpecificTitle(){
        Assertions.assertEquals("Foo", testRecord.getTitle());
    }

    @Test
    void testSpecificFileName(){
        Assertions.assertEquals("Bar", testRecord.getFileName());
    }

    @Test
    void testSpecificArtist(){
        Assertions.assertEquals("Fool", testRecord.getArtist());
    }

    @Test
    void testSpecificSubject(){
        Assertions.assertEquals("Foo ; Bar", testRecord.getSubject_LCSH());
    }

    @Test
    void testSpecificDate(){
        Assertions.assertEquals("1969", testRecord.getDate_Made());
    }

    @Test
    void testSpecificCulture(){
        Assertions.assertEquals("American", testRecord.getCulture());
    }

    @Test
    void testSpecificCentury(){
        Assertions.assertEquals("21st", testRecord.getCentury());
    }

    @Test
    void testSpecificPeriodStyle(){
        Assertions.assertEquals("Cubism", testRecord.getPeriodStyle());
    }

    @Test
    void testSettingFileName(){
        testRecord.setFileName("Foobar");
        Assertions.assertEquals("Foobar", testRecord.getFileName());
    }

}
