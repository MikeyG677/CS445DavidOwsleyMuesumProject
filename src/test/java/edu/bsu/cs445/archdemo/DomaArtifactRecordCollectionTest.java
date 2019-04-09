package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class DomaArtifactRecordCollectionTest {

    @Test
    void testCountRecords_emptyCollection(){
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    void testCountRecords_collection_three(){
        final HashMap<String, String> testInfo = new HashMap<>();
        final String testTitle = "Foo";
        testInfo.put("title", testTitle);
        testInfo.put("fileName", "Foo.jpg");
        testInfo.put("artist", "Bar");
        testInfo.put("subject_LCSH", "Fool");
        testInfo.put("date_Made", "Barl");

        ArtifactRecord record1 = ArtifactRecord.withSpecificInfo(testInfo);
        ArtifactRecord record2 = ArtifactRecord.withSpecificInfo(testInfo);
        DomaArtifactRecordCollection collection = DomaArtifactRecordCollection.of(record1, record2);
        Assertions.assertEquals(2, collection.size());
    }

    @Test
    void testConvertJaxbToDoma_noCpd(){
        final HashMap<String, String> testInfo = new HashMap<>();
        final String testTitle = "Foo";
        testInfo.put("title", testTitle);
        testInfo.put("fileName", "Foo.jpg");
        testInfo.put("artist", "Bar");
        testInfo.put("subject_LCSH", "Fool");
        testInfo.put("date_Made", "Barl");

        ArtifactRecord record1 = ArtifactRecord.withSpecificInfo(testInfo);
        ArtifactRecord record2 = ArtifactRecord.withSpecificInfo(testInfo);
        JaxbArtifactRecordCollection jaxbCollection = JaxbArtifactRecordCollection.of(record1, record2);
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        DomaArtifactRecordCollection convertedCollection = collection.convertJaxbToDoma(jaxbCollection);
        Assertions.assertEquals(2, convertedCollection.size());
    }

    @Test
    void testConvertJaxbToDoma_cpd(){
        final HashMap<String, String> testInfoJpg = new HashMap<>();
        final String testTitleJpg = "Foo";
        testInfoJpg.put("title", testTitleJpg);
        testInfoJpg.put("fileName", "Foo.jpg");
        testInfoJpg.put("artist", "Bar");
        testInfoJpg.put("subject_LCSH", "Fool");
        testInfoJpg.put("date_Made", "Barl");

        final HashMap<String, String> testInfoCpd = new HashMap<>();
        final String testTitleCpd = "Fool";
        testInfoCpd.put("title", testTitleCpd);
        testInfoCpd.put("fileName", "Fool.cpd");
        testInfoCpd.put("artist", "Bar");
        testInfoCpd.put("subject_LCSH", "Fool");
        testInfoCpd.put("date_Made", "Barl");

        final HashMap<String, String> testInfo = new HashMap<>();
        final String testTitle = "";
        testInfo.put("title", testTitle);
        testInfo.put("fileName", "Fool.jpg");
        testInfo.put("artist", "Bar");
        testInfo.put("subject_LCSH", "Fool");
        testInfo.put("date_Made", "Barl");

        ArtifactRecord recordJpg = ArtifactRecord.withSpecificInfo(testInfoJpg);
        ArtifactRecord recordCpd = ArtifactRecord.withSpecificInfo(testInfoCpd);
        ArtifactRecord record = ArtifactRecord.withSpecificInfo(testInfo);
        JaxbArtifactRecordCollection jaxbCollection = JaxbArtifactRecordCollection.of(recordJpg, record, recordCpd);
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        DomaArtifactRecordCollection convertedCollection = collection.convertJaxbToDoma(jaxbCollection);
        Assertions.assertEquals(2, convertedCollection.size());
    }
}
