package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArtifactRecordTest {

    @Test
    void testGetFileName() {

        new ArtifactRecord();
        ArtifactRecord record = ArtifactRecord.withFileName();
        ArtifactRecord.withFileName();
        Assertions.assertEquals("foo", record.getFileName());

    }

    @Test
    void testGetArtist() {

        new ArtifactRecord();
        ArtifactRecord record = ArtifactRecord.withArtistName();
        ArtifactRecord.withArtistName();
        Assertions.assertEquals("foo", record.getArtist());

    }

    @Test
    void testGetDate() {

        new ArtifactRecord();
        ArtifactRecord record = ArtifactRecord.withDate();
        ArtifactRecord.withDate();
        Assertions.assertEquals("foo", record.getDate_Made());

    }

}
