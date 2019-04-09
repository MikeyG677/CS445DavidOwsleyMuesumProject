package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class JaxbArtifactRecordCollectionTest {
    @Test
    void testResultCount_zero(){
        //WIP and getting done as you read this!
    }



/*///////////////////////////////////////////////////////////////////////////////
    @Test
    void testCountRecordsByTitleQuery_emptyString_zero() {
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.createEmpty();
        int countExactFalse = collection.countRecordsByTitleQuery("", false);
        Assertions.assertEquals(0, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("", true);
        Assertions.assertEquals(0, countExactTrue);
    }

    @Test
    void testCountRecordsByTitleQuery_oneItemMatch_one() {
        final HashMap<String, String> testInfo = new HashMap<>();
        final String testTitle = "Foo";
        testInfo.put("title", testTitle);
        testInfo.put("fileName", "Foo");
        testInfo.put("artist", "Bar");
        testInfo.put("subject_LCSH", "Fool");
        testInfo.put("date_Made", "Barl");

        ArtifactRecord record = ArtifactRecord.withSpecificInfo(testInfo);
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.of(record);
        int countExactFalse = collection.countRecordsByTitleQuery("Foo", false);
        Assertions.assertEquals(1, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("Foo", true);
        Assertions.assertEquals(1, countExactTrue);
    }

    @Test
    void testCountRecordsByTitleQuery_noItemsMatchInNonemptyCollection_zero() {
        final HashMap<String, String> testInfo = new HashMap<>();
        final String testTitle = "Foo";
        testInfo.put("title", testTitle);
        testInfo.put("fileName", "Foo");
        testInfo.put("artist", "Bar");
        testInfo.put("subject_LCSH", "Fool");
        testInfo.put("date_Made", "Barl");

        ArtifactRecord record = ArtifactRecord.withSpecificInfo(testInfo);
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.of(record);
        int countExactFalse = collection.countRecordsByTitleQuery("Bar", false);
        Assertions.assertEquals(0, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("Bar", true);
        Assertions.assertEquals(0, countExactTrue);
    }

    @Test
    void testCountRecordsByTitleQuery_twoItemsMatch_two() {
        final HashMap<String, String> testInfo1 = new HashMap<>();
        final String testTitle1 = "Foo";
        testInfo1.put("title", testTitle1);
        testInfo1.put("fileName", "Foo");
        testInfo1.put("artist", "Bar");
        testInfo1.put("subject_LCSH", "Fool");
        testInfo1.put("date_Made", "Barl");

        final HashMap<String, String> testInfo2 = new HashMap<>();
        final String testTitle2 = "Fool";
        testInfo2.put("title", testTitle2);
        testInfo2.put("fileName", "Foo");
        testInfo2.put("artist", "Bar");
        testInfo2.put("subject_LCSH", "Fool");
        testInfo2.put("date_Made", "Barl");

        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.of(
                ArtifactRecord.withSpecificInfo(testInfo1),
                ArtifactRecord.withSpecificInfo(testInfo2));
        int countExactFalse = collection.countRecordsByTitleQuery("Foo", false);
        Assertions.assertEquals(2, countExactFalse);
    }

    @Test
    void testSearchTitles() {
        final HashMap<String, String> testInfo = new HashMap<>();
        final String testTitle = "Foo";
        testInfo.put("title", testTitle);
        testInfo.put("fileName", "Foo");
        testInfo.put("artist", "Bar");
        testInfo.put("subject_LCSH", "Fool");
        testInfo.put("date_Made", "Barl");

        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.of(
                ArtifactRecord.withSpecificInfo(testInfo)
        );
        List<ArtifactRecord> resultExactFalse = collection.searchThroughTitles(testTitle, false);
        Assertions.assertEquals(testTitle, resultExactFalse.get(0).getTitle());
        List<ArtifactRecord>resultExactTrue = collection.searchThroughTitles(testTitle, true);
        Assertions.assertEquals(testTitle, resultExactTrue.get(0).getTitle());
    }

    @Test
    void testCountRecordsBySubjectQuery_emptyString_zero() {
        final HashSet<String> query = new HashSet<>();
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.createEmpty();
        int countExactFalse = collection.countRecordsBySubjectQuery(query, false);
        Assertions.assertEquals(0, countExactFalse);
        int countExactTrue = collection.countRecordsBySubjectQuery(query, true);
        Assertions.assertEquals(0, countExactTrue);
    }

    @Test
    void testCountRecordsBySubjectQuery_oneItemMatch_one() {
        final HashMap<String, String> testInfo = new HashMap<>();
        final String testSubject = "Foo";
        final HashSet<String> testQuery = new HashSet<>();
        testQuery.add(testSubject);
        testInfo.put("title", "Foo");
        testInfo.put("fileName", "Bar");
        testInfo.put("artist", "Fool");
        testInfo.put("subject_LCSH", testSubject);
        testInfo.put("date_Made", "Barl");

        ArtifactRecord record = ArtifactRecord.withSpecificInfo(testInfo);
        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.of(record);
        int countExactFalse = collection.countRecordsBySubjectQuery(testQuery, false);
        Assertions.assertEquals(1, countExactFalse);
        int countExactTrue = collection.countRecordsBySubjectQuery(testQuery, true);
        Assertions.assertEquals(1, countExactTrue);
    }

    @Test
    void testSearchSubjectEXPERIMENTAL(){
        final HashSet<String> testSubjectList = new HashSet<>();
        testSubjectList.add("Foo");
        testSubjectList.add("Bar");
        final HashMap<String, String> testInfo = new HashMap<>();
        String testSubjects = "Foo ; Bar";
        testInfo.put("title", "Foo");
        testInfo.put("fileName", "Bar");
        testInfo.put("artist", "Fool");
        testInfo.put("subject_LCSH", testSubjects);
        testInfo.put("date_Made", "Barl");

        JaxbArtifactRecordCollection collection = JaxbArtifactRecordCollection.of(
                ArtifactRecord.withSpecificInfo(testInfo)
        );
        List<ArtifactRecord> resultExactFalse = collection.searchThroughSubjects(testSubjectList, false);
        Assertions.assertEquals(testSubjects, resultExactFalse.get(0).getSubject_LCSH());
        List<ArtifactRecord>resultExactTrue = collection.searchThroughSubjects(testSubjectList, true);
        Assertions.assertEquals(testSubjects, resultExactTrue.get(0).getSubject_LCSH());

    }
}
*/
}