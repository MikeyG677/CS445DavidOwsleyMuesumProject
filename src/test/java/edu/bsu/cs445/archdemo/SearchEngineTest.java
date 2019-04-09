package edu.bsu.cs445.archdemo;

import edu.bsu.cs445.archdemo.model.ArtifactRecord;
import edu.bsu.cs445.archdemo.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.archdemo.model.SearchEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SearchEngineTest {

    private DomaArtifactRecordCollection testCollection_empty = new DomaArtifactRecordCollection();
    private DomaArtifactRecordCollection testCollection_oneRecord = new DomaArtifactRecordCollection();
    private ArtifactRecord testRecord = new ArtifactRecord();

    ArtifactRecord buildTestRecord(List<String> paramaters){
        ArtifactRecord testRecord = new ArtifactRecord();

        testRecord.setTitle(paramaters.get(0));
        testRecord.setFileName(paramaters.get(1));
        testRecord.setArtist(paramaters.get(2));
        testRecord.setSubject_LCSH(paramaters.get(3));
        testRecord.setDate_Made(paramaters.get(4));
        testRecord.setCulture(paramaters.get(5));
        testRecord.setCentury(paramaters.get(6));
        testRecord.setPeriodStyle(paramaters.get(7));

        return testRecord;
    }

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
