package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecord;
import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecordCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JaxbArtifactRecordCollectionTest {
    private JaxbArtifactRecord buildTestRecord() {
        return new JaxbArtifactRecord();
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