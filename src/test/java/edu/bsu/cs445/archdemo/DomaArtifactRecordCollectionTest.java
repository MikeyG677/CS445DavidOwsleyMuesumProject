package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DomaArtifactRecordCollectionTest {

    private ArtifactRecord buildTestRecordJpg(){
        ArtifactRecord testRecord = new ArtifactRecord();

        testRecord.title = "Foo";
        testRecord.fileName = "Bar.jpg";
        testRecord.artist = "Fool";
        testRecord.subject_LCSH = "Foo ; Bar";
        testRecord.date_Made = "1969";
        testRecord.culture = "American";
        testRecord.century = "21st";
        testRecord.periodStyle = "Cubism";

        return testRecord;
    }

    private ArtifactRecord buildTestRecordCpd(){
        ArtifactRecord testRecord = new ArtifactRecord();

        testRecord.title = "Foo";
        testRecord.fileName = "Bar.cpd";
        testRecord.artist = "Fool";
        testRecord.subject_LCSH = "Foo ; Bar";
        testRecord.date_Made = "1969";
        testRecord.culture = "American";
        testRecord.century = "21st";
        testRecord.periodStyle = "Cubism";

        return testRecord;
    }

    private ArtifactRecord buildTestRecordNoTitle(){
        ArtifactRecord testRecord = new ArtifactRecord();

        testRecord.title = "";
        testRecord.fileName = "Bar.jpg";
        testRecord.artist = "Fool";
        testRecord.subject_LCSH = "Foo ; Bar";
        testRecord.date_Made = "1969";
        testRecord.culture = "American";
        testRecord.century = "21st";
        testRecord.periodStyle = "Cubism";

        return testRecord;
    }

    @Test
    void testCountRecords_emptyCollection(){
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    void testCountRecords_collection_three(){
        ArtifactRecord record1 = buildTestRecordJpg();
        ArtifactRecord record2 = buildTestRecordJpg();
        DomaArtifactRecordCollection collection = DomaArtifactRecordCollection.of(record1, record2);
        Assertions.assertEquals(2, collection.size());
    }

    @Test
    void testConvertJaxbToDoma_noCpd(){
        ArtifactRecord record1 = buildTestRecordJpg();
        ArtifactRecord record2 = buildTestRecordJpg();
        JaxbArtifactRecordCollection jaxbCollection = JaxbArtifactRecordCollection.of(record1, record2);
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        DomaArtifactRecordCollection convertedCollection = collection.convertJaxbToDoma(jaxbCollection);
        Assertions.assertEquals(2, convertedCollection.size());
    }

    @Test
    void testConvertJaxbToDoma_cpd(){
        ArtifactRecord recordJpg = buildTestRecordJpg();
        ArtifactRecord recordCpd = buildTestRecordCpd();
        ArtifactRecord record = buildTestRecordNoTitle();
        JaxbArtifactRecordCollection jaxbCollection = JaxbArtifactRecordCollection.of(recordJpg, record, recordCpd);
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        DomaArtifactRecordCollection convertedCollection = collection.convertJaxbToDoma(jaxbCollection);
        Assertions.assertEquals(2, convertedCollection.size());
    }
}
