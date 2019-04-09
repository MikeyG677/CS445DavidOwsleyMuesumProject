package edu.bsu.cs445.archdemo;

import edu.bsu.cs445.archdemo.model.ArtifactRecord;
import edu.bsu.cs445.archdemo.model.JaxbArtifactRecordCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JaxbArtifactRecordCollectionTest {
    ArtifactRecord buildTestRecord() {
        return new ArtifactRecord();
    }

    @Test
    void testSize_zero() {
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.createEmpty();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    void testSize_one() {
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.of(buildTestRecord());
        Assertions.assertEquals(1, collection.size());
    }
}