package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class ArtifactRecordTest {

    @Test
    void testGetSpecificInfo(){
        final HashMap<String, String> testInfo = new HashMap<>();
        testInfo.put("title", "Foo");
        testInfo.put("fileName", "Bar");
        testInfo.put("artist", "Fool");
        testInfo.put("subject_LCSH", "Barl");
        testInfo.put("date_Made", "Boo");

        new ArtifactRecord();
        ArtifactRecord record = ArtifactRecord.withSpecificInfo(testInfo);
        Assertions.assertEquals("Foo", record.getTitle());
        Assertions.assertEquals("Bar", record.getFileName());
        Assertions.assertEquals("Fool", record.getArtist());
        Assertions.assertEquals("Barl", record.getSubject_LCSH());
        Assertions.assertEquals("Boo", record.getDate_Made());
    }

}
