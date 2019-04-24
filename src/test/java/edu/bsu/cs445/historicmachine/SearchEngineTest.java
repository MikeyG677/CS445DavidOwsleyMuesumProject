package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.DomaArtifactRecord;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.historicmachine.model.SearchEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchEngineTest {

    private DomaArtifactRecordCollection testCollectionEmpty = new DomaArtifactRecordCollection();
    private DomaArtifactRecordCollection testCollectionContainingOne = new DomaArtifactRecordCollection();
    private DomaArtifactRecord testRecord1 = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("Foo")
            .withFileName("Bar")
            .withArtist("Fool")
            .withSubject_LCSH("Foo ; Bar")
            .withDate_Made("1969")
            .withCulture("American")
            .withCentury("21st")
            .withPeriodStyle("Cubism")
            .buildRecord();

    @Test
    void testSearchTitle_WholeWord_zeroResults_emptyCollection(){
        SearchEngine testEngine = new SearchEngine(testCollectionEmpty);
        Assertions.assertEquals(0, testEngine.searchTitle_WholeWord("Foo").size());
    }

    @Test
    void testSearchTitle_Contains_zeroResults_emptyCollection(){
        SearchEngine testEngine = new SearchEngine(testCollectionEmpty);
        Assertions.assertEquals(0, testEngine.searchTitle_Contains("F").size());
    }

    @Test
    void testSearchTitle_WholeWord_oneResult_oneCollection(){
        testCollectionContainingOne.records.add(testRecord1);
        SearchEngine testEngine = new SearchEngine(testCollectionContainingOne);
        Assertions.assertEquals(1, testEngine.searchTitle_WholeWord("Foo").size());
    }

    @Test
    void testSearchTitle_Contains_oneResult_oneCollection(){
        testCollectionContainingOne.records.add(testRecord1);
        SearchEngine testEngine = new SearchEngine(testCollectionContainingOne);
        Assertions.assertEquals(1, testEngine.searchTitle_Contains("F").size());
    }
}
