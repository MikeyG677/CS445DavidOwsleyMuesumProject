package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.ContentConverter;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecord;
import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecordCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class ContentConverterTest {

    private JaxbArtifactRecord testRecordIncandescents = new JaxbArtifactRecord.JaxbArtifactRecordBuilder()
            .withTitle("Incandescents")
            .withFileName("3420.cpd")
            .withCulture("American ; North American")
            .withCentury("20th century")
            .withPeriodStyle("Modern ; Contemporary")
            .buildRecord();
    private JaxbArtifactRecord testRecordCpd = new JaxbArtifactRecord.JaxbArtifactRecordBuilder()
            .withTitle("")
            .withFileName("3419.jpg")
            .buildRecord();
    private JaxbArtifactRecordCollection testCollection = JaxbArtifactRecordCollection.of(testRecordCpd, testRecordIncandescents);

    @Test
    void testCreateDomeCollection_cpd(){
        ContentConverter converter = new ContentConverter(testCollection);
        DomaArtifactRecordCollection result = converter.createDomaCollection();
        Assertions.assertEquals(1, result.size());
    }
}
