package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.DomaArtifactRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArtifactRecordTest {

    private DomaArtifactRecord testRecord1 = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("Foo")
            .withFileName("Bar")
            .withArtist("Fool")
            .withSubject_LCSH("Foo ; Bar")
            .withDate_Made("1969")
            .withCulture("American")
            .withCentury("21st")
            .withPeriodStyle("Cubism")
            .buildRecord();

    private DomaArtifactRecord testRecord2 = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("The Monolith")
            .withFileName("hal_marktwo_the_monolith")
            .withArtist("Hal Marktwo")
            .withSubject_LCSH("Industrial ; Modernism ; Futuristic ; Sci-fi")
            .withDate_Made("2001")
            .withCulture("Alien")
            .withCentury("20th")
            .withPeriodStyle("Impressionism")
            .buildRecord();

    @Test
    void testSpecificTitle_1(){
        Assertions.assertEquals("Foo", testRecord1.getTitle());
    }
    @Test
    void testSpecificTitle_2(){
        Assertions.assertEquals("The Monolith", testRecord2.getTitle());
    }

    @Test
    void testSpecificFileName_1(){
        Assertions.assertEquals("Bar", testRecord1.getFileName());
    }
    @Test
    void testSpecificFileName_2(){
        Assertions.assertEquals("hal_marktwo_the_monolith", testRecord2.getFileName());
    }

    @Test
    void testSpecificArtist_1(){
        Assertions.assertEquals("Fool", testRecord1.getArtist());
    }
    @Test
    void testSpecificArtist_2(){
        Assertions.assertEquals("Hal Marktwo", testRecord2.getArtist());
    }

    @Test
    void testSpecificSubject_1(){
        Assertions.assertEquals("Foo ; Bar", testRecord1.getSubject_LCSH());
    }
    @Test
    void testSpecificSubject_2() { Assertions.assertEquals("Industrial ; Modernism ; Futuristic ; Sci-fi", testRecord2.getSubject_LCSH()); }

    @Test
    void testSpecificDate_1(){
        Assertions.assertEquals("1969", testRecord1.getDate_Made());
    }
    @Test
    void testSpecificDate_2(){
        Assertions.assertEquals("2001", testRecord2.getDate_Made());
    }

    @Test
    void testSpecificCulture_1(){
        Assertions.assertEquals("American", testRecord1.getCulture());
    }
    @Test
    void testSpecificCulture_2(){
        Assertions.assertEquals("Alien", testRecord2.getCulture());
    }

    @Test
    void testSpecificCentury_1(){
        Assertions.assertEquals("21st", testRecord1.getCentury());
    }
    @Test
    void testSpecificCentury_2(){
        Assertions.assertEquals("20th", testRecord2.getCentury());
    }

    @Test
    void testSpecificPeriodStyle_1(){
        Assertions.assertEquals("Cubism", testRecord1.getPeriodStyle());
    }
    @Test
    void testSpecificPeriodStyle_2(){
        Assertions.assertEquals("Impressionism", testRecord2.getPeriodStyle());
    }

}
