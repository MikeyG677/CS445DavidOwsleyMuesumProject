package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;

class ArtifactRecordCollectionTest {

    @Test
    void testCountRecordsByTitleQuery_emptyString_zero() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.createEmpty();
        int countExactFalse = collection.countRecordsByTitleQuery("", false);
        Assertions.assertEquals(0, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("", true);
        Assertions.assertEquals(0, countExactTrue);
    }

    @Test
    void testCountRecordsByTitleQuery_oneItemMatch_one() {
        ArtifactRecord record = ArtifactRecord.withTitle("Foo");
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(record);
        int countExactFalse = collection.countRecordsByTitleQuery("Foo", false);
        Assertions.assertEquals(1, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("Foo", true);
        Assertions.assertEquals(1, countExactTrue);
    }

    @Test
    void testCountRecordsByTitleQuery_noItemsMatchInNonemptyCollection_zero() {
        ArtifactRecord record = ArtifactRecord.withTitle("Foo");
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(record);
        int countExactFalse = collection.countRecordsByTitleQuery("Bar", false);
        Assertions.assertEquals(0, countExactFalse);
        int countExactTrue = collection.countRecordsByTitleQuery("Bar", true);
        Assertions.assertEquals(0, countExactTrue);
    }

    @Test
    void testCountRecordsByTitleQuery_twoItemsMatch_two() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(
                ArtifactRecord.withTitle("Foo"),
                ArtifactRecord.withTitle("Fool"));
        int countExactFalse = collection.countRecordsByTitleQuery("Foo", false);
        Assertions.assertEquals(2, countExactFalse);
    }

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

    @Test
    void testSearchSubject(){
        final String testSubject1 = "Foo";
        final String testSubject2 = "Bar";
        final HashSet<String> testSubjectList = new HashSet<>();
        testSubjectList.add(testSubject1);
        testSubjectList.add(testSubject2);
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(
                ArtifactRecord.withSubject(testSubject1 + " ; " + testSubject2)
        );
        List<ArtifactRecord> resultExactFalse = collection.searchSubject(testSubjectList, false);
        Assertions.assertEquals(testSubject1 + " ; " + testSubject2, resultExactFalse.get(0).getSubject_LCSH());

        List<ArtifactRecord>resultExactTrue = collection.searchSubject(testSubjectList, true);
        Assertions.assertEquals(testSubject1 + " ; " + testSubject2, resultExactTrue.get(0).getSubject_LCSH());

    }
}
