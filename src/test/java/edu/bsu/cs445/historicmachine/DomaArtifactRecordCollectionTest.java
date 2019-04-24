package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.DomaArtifactRecord;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecordCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DomaArtifactRecordCollectionTest {

    private DomaArtifactRecord testRecordJpg = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("Foo")
            .withFileName("Bar.jpg")
            .withArtist("Fool")
            .withSubject_LCSH("Foo ; Bar")
            .withDate_Made("1969")
            .withCulture("American")
            .withCentury("21st")
            .withPeriodStyle("Cubism")
            .buildRecord();

    private DomaArtifactRecord testRecordCpd = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("Foo")
            .withFileName("Bar.cpd")
            .withArtist("Fool")
            .withSubject_LCSH("Foo ; Bar")
            .withDate_Made("1969")
            .withCulture("American")
            .withCentury("21st")
            .withPeriodStyle("Cubism")
            .buildRecord();

    private DomaArtifactRecord testRecordNoTitle = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("")
            .withFileName("Bar.jpg")
            .withArtist("Fool")
            .withSubject_LCSH("Foo ; Bar")
            .withDate_Made("1969")
            .withCulture("American")
            .withCentury("21st")
            .withPeriodStyle("Cubism")
            .buildRecord();

    /*
    private List<String> testParamaters_Jpg = Arrays.asList("Foo","Bar.jpg","Fool","Foo ; Bar","1969","American","21st","Cubism");
    private List<String> testParamaters_Cpd = Arrays.asList("Foo","Bar.cpd","Fool","Foo ; Bar","1969","American","21st","Cubism");
    private List<String> testParamaters_NoTitle = Arrays.asList("","Bar.jpg","Fool","Foo ; Bar","1969","American","21st","Cubism");
    */

    @Test
    void testCountRecords_emptyCollection(){
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    void testCountRecords_collection_two(){
        DomaArtifactRecordCollection collection = DomaArtifactRecordCollection.of(testRecordJpg, testRecordJpg);
        Assertions.assertEquals(2, collection.size());
    }

    /*
    @Test
    void testConvertJaxbToDoma_noCpd(){
        JaxbArtifactRecordCollection jaxbCollection = JaxbArtifactRecordCollection.of(testRecordJpg, testRecordJpg);
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        DomaArtifactRecordCollection convertedCollection = collection.convertCollectionToDoma(jaxbCollection);
        Assertions.assertEquals(2, convertedCollection.size());
    }*/

    /*
    @Test
    void testConvertJaxbToDoma_Cpd(){
        JaxbArtifactRecord recordJpg = buildTestRecord(testParamaters_Jpg);
        JaxbArtifactRecord recordCpd = buildTestRecord(testParamaters_Cpd);
        JaxbArtifactRecord recordNoTitle = buildTestRecord(testParamaters_NoTitle);
        JaxbArtifactRecordCollection jaxbCollection = JaxbArtifactRecordCollection.of(recordJpg, recordNoTitle, recordCpd);
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        DomaArtifactRecordCollection convertedCollection = collection.convertCollectionToDoma(jaxbCollection);
        Assertions.assertEquals(2, convertedCollection.size());
    }
    */
}
