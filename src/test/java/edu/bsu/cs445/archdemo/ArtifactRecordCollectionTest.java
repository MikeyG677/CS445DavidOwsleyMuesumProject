package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

class ArtifactRecordCollectionTest {

    @DisplayName("Test that countRecordByTitleQuery returns 0 records if query-term is empty")
    @Test
    void testCountRecordsByTitleQuery_emptyString_zero() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.createEmpty();
        int countExactFalse = collection.countRecordsByTitleQuery("", false);
        Assertions.assertEquals(0, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("", true);
        Assertions.assertEquals(0, countExactTrue);
    }

    @DisplayName("Test that countRecordByTitleQuery returns 1 record if query-term is in collection")
    @Test
    void testCountRecordsByTitleQuery_oneItemMatch_one() {
        ArtifactRecord record = ArtifactRecord.withTitle("Foo");
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(record);
        int countExactFalse = collection.countRecordsByTitleQuery("Foo", false);
        Assertions.assertEquals(1, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("Foo", true);
        Assertions.assertEquals(1, countExactTrue);
    }

    @DisplayName("Test that countRecordByTitleQuery returns 0 records if query-term is not in collection")
    @Test
    void testCountRecordsByTitleQuery_noItemsMatchInNonemptyCollection_zero() {
        ArtifactRecord record = ArtifactRecord.withTitle("Foo");
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(record);
        int countExactFalse = collection.countRecordsByTitleQuery("Bar", false);
        Assertions.assertEquals(0, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("Bar", true);
        Assertions.assertEquals(0, countExactTrue);
    }

    @DisplayName("Test that countRecordByTitleQuery returns 2 records if the query-term is seen in twice in collection")
    @Test
    void testCountRecordsByTitleQuery_twoItemsMatch_two() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(
                ArtifactRecord.withTitle("Foo"),
                ArtifactRecord.withTitle("Fool"));
        int countExactFalse = collection.countRecordsByTitleQuery("Foo", false);
        Assertions.assertEquals(2, countExactFalse);
    }

    @DisplayName("Test that the function searchTitles does not return results for query-term that is not in collection")
    @Test
    void testSearchTitles() {
        final String testTitle = "Foo";
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(
                ArtifactRecord.withTitle(testTitle)
        );
        List<ArtifactRecord> resultExactFalse = collection.searchTitles(testTitle, false);
        Assertions.assertEquals(testTitle, resultExactFalse.get(0).getTitle());
        List<ArtifactRecord>resultExactTrue = collection.searchTitles(testTitle, true);
        Assertions.assertEquals(testTitle, resultExactTrue.get(0).getTitle());
    }

    @DisplayName("Test that the function searchSubject does not return results for query-term that is not in collection")
    @Test
    void testSearchSubject(){
        final String testSubject = "Foo";
        final HashSet<String> testSubjectList = new HashSet<>();
        testSubjectList.add(testSubject);
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(
                ArtifactRecord.withSubject(testSubject)
        );
        List<ArtifactRecord> resultExactFalse = collection.searchSubject(testSubjectList, false);
        Assertions.assertEquals(testSubject, resultExactFalse.get(0).getSubject_LCSH());

        List<ArtifactRecord>resultExactTrue = collection.searchSubject(testSubjectList, true);
        Assertions.assertEquals(testSubject, resultExactTrue.get(0).getSubject_LCSH());

    }
}
