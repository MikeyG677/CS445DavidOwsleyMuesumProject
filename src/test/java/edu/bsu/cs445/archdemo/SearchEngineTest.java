package edu.bsu.cs445.archdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchEngineTest {

    private DomaArtifactRecordCollection testCollection_empty = new DomaArtifactRecordCollection();

    @Test
    void testSearchTitle_WholeWord_zeroResults(){
        SearchEngine testEngine = new SearchEngine(testCollection_empty);
        Assertions.assertEquals(0, testEngine.searchTitle_WholeWord("query").size());
    }

    @Test
    void testSearchTitle_Contains_zeroResults(){
        SearchEngine testEngine = new SearchEngine(testCollection_empty);
        Assertions.assertEquals(0, testEngine.searchTitle_Contains("query").size());
    }
}
