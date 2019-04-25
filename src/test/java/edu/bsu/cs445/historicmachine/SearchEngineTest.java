package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.DomaArtifactRecord;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.historicmachine.model.SearchEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchEngineTest {

    private DomaArtifactRecord testRecordFishingBoats = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("Fishing Boats (Fischerboote)")
            .withCulture("German ; European")
            .withCentury("20th century")
            .withPeriodStyle("Expressionist")
            .buildRecord();
    private DomaArtifactRecord testRecordHeadOfGirl = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("Head of a Girl (Frauenbild)")
            .withCulture("German ; European")
            .withCentury("20th century")
            .withPeriodStyle("Expressionist ; Modern")
            .buildRecord();
    private DomaArtifactRecord testRecordIncandescents = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("Incandescents")
            .withCulture("American ; North American")
            .withCentury("20th century")
            .withPeriodStyle("Modern ; Contemporary")
            .buildRecord();
    private DomaArtifactRecordCollection testCollection = DomaArtifactRecordCollection.of(
            testRecordFishingBoats, testRecordHeadOfGirl, testRecordIncandescents);

    @Test
    void testSearchTitle_wholeWord_zeroResults_collection(){
        SearchEngine testEngine = new SearchEngine(testCollection);
        Assertions.assertEquals(0, testEngine.searchTitle_wholeWord("Foo").size());
    }

    @Test
    void testSearchTitle_contains_zeroResults_collection(){
        SearchEngine testEngine = new SearchEngine(testCollection);
        Assertions.assertEquals(0, testEngine.searchTitle_contains("Z").size());
    }

    @Test
    void testSearchTitle_wholeWord_oneResult_collection(){
        SearchEngine testEngine = new SearchEngine(testCollection);
        Assertions.assertEquals(1, testEngine.searchTitle_wholeWord("Fishing").size());
    }

    @Test
    void testSearchTitle_contains_twoResults_collection(){
        SearchEngine testEngine = new SearchEngine(testCollection);
        Assertions.assertEquals(2, testEngine.searchTitle_contains("F").size());
    }

    @Test
    void testSearchRelatedWorks_threeResults(){
        SearchEngine testEngine = new SearchEngine(testCollection);
        Assertions.assertEquals(3, testEngine.searchRelatedWorks(testRecordFishingBoats).size());
    }

    @Test
    void testSearchRelatedWorksByCulture_twoResults(){
        SearchEngine testEngine = new SearchEngine(testCollection);
        Assertions.assertEquals(2, testEngine.searchRelatedWorksByCulture(testRecordFishingBoats).size());
    }

    @Test
    void testSearchRelatedWorksByPeriodStyle_twoResults(){
        SearchEngine testEngine = new SearchEngine(testCollection);
        Assertions.assertEquals(2, testEngine.searchRelatedWorksByPeriodStyle(testRecordFishingBoats).size());
    }

    @Test
    void testSearchRelatedWorksByCentury_threeResults(){
        SearchEngine testEngine = new SearchEngine(testCollection);
        Assertions.assertEquals(3, testEngine.searchRelatedWorksByCentury(testRecordFishingBoats).size());
    }
}
