package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArtifactViewTest {

    @Test
    void testTitleSet() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.createEmpty();
        int count = collection.countRecordsByTitleQuery("", false);
        Assertions.assertEquals(0, count);
    }

}
