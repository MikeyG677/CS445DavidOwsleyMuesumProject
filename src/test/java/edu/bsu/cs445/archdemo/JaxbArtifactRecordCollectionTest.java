package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JaxbArtifactRecordCollectionTest {
    ArtifactRecord buildTestRecord() {
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

    @Test
    void testSize_zero() {
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.createEmpty();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    void testCollection_one() {
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.of(buildTestRecord());
        Assertions.assertEquals(1, collection.size());
    }
}