package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchEngineTest {

    private DomaArtifactRecordCollection testCollection_empty = new DomaArtifactRecordCollection();
    private DomaArtifactRecordCollection testCollection_oneRecord = new DomaArtifactRecordCollection();
    private ArtifactRecord testRecord = new ArtifactRecord();

    @Test
    void testSearchTitle_WholeWord_zeroResults_emptyCollection(){
        SearchEngine testEngine = new SearchEngine(testCollection_empty);
        Assertions.assertEquals(0, testEngine.searchTitle_WholeWord("query").size());
    }

    @Test
    void testSearchTitle_Contains_zeroResults_emptyCollection(){
        SearchEngine testEngine = new SearchEngine(testCollection_empty);
        Assertions.assertEquals(0, testEngine.searchTitle_Contains("query").size());
    }

    @Test
    void testSearchTitle_WholeWord_oneResult_oneCollection(){
        testRecord.setTitle("Foo");
        testCollection_oneRecord.records.add(testRecord);
        SearchEngine testEngine = new SearchEngine(testCollection_oneRecord);
        Assertions.assertEquals(1, testEngine.searchTitle_WholeWord("Foo").size());
    }

    @Test
    void testSearchTitle_Contains_oneResult_oneCollection(){
        testRecord.setTitle("Foo");
        testCollection_oneRecord.records.add(testRecord);
        SearchEngine testEngine = new SearchEngine(testCollection_oneRecord);
        Assertions.assertEquals(1, testEngine.searchTitle_Contains("F").size());
    }
}
