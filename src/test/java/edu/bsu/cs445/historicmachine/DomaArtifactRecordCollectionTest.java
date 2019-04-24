package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecord;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecordCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class DomaArtifactRecordCollectionTest {

    private JaxbArtifactRecord buildTestRecord(List<String> paramaters){
        JaxbArtifactRecord testRecord = new JaxbArtifactRecord();

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
    private List<String> testParamaters_Jpg = Arrays.asList("Foo","Bar.jpg","Fool","Foo ; Bar","1969","American","21st","Cubism");
    private List<String> testParamaters_Cpd = Arrays.asList("Foo","Bar.cpd","Fool","Foo ; Bar","1969","American","21st","Cubism");
    private List<String> testParamaters_NoTitle = Arrays.asList("","Bar.jpg","Fool","Foo ; Bar","1969","American","21st","Cubism");

    @Test
    void testCountRecords_emptyCollection(){
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        Assertions.assertEquals(0, collection.size());
    }

    @Test
    void testCountRecords_collection_two(){
        JaxbArtifactRecord record1 = buildTestRecord(testParamaters_Jpg);
        JaxbArtifactRecord record2 = buildTestRecord(testParamaters_Jpg);
        DomaArtifactRecordCollection collection = DomaArtifactRecordCollection.of(record1, record2);
        Assertions.assertEquals(2, collection.size());
    }

    @Test
    void testConvertJaxbToDoma_noCpd(){
        JaxbArtifactRecord record1 = buildTestRecord(testParamaters_Jpg);
        JaxbArtifactRecord record2 = buildTestRecord(testParamaters_Jpg);
        JaxbArtifactRecordCollection jaxbCollection = JaxbArtifactRecordCollection.of(record1, record2);
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        DomaArtifactRecordCollection convertedCollection = collection.convertCollectionToDoma(jaxbCollection);
        Assertions.assertEquals(2, convertedCollection.size());
    }

    @Test
    void testConvertJaxbToDoma_Cpd(){
        JaxbArtifactRecord recordJpg = buildTestRecord(testParamaters_Jpg);
        JaxbArtifactRecord recordCpd = buildTestRecord(testParamaters_Cpd);
        JaxbArtifactRecord recordNoTitle = buildTestRecord(testParamaters_NoTitle);
        JaxbArtifactRecordCollection jaxbCollection = JaxbArtifactRecordCollection.of(recordJpg, recordNoTitle, recordCpd);
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        DomaArtifactRecordCollection convertedCollection = collection.convertCollectionToDoma(jaxbCollection);
        Assertions.assertEquals(2, convertedCollection.size());
    }
}
