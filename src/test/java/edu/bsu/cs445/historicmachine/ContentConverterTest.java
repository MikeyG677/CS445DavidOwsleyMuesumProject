package edu.bsu.cs445.historicmachine;

import edu.bsu.cs445.historicmachine.model.ContentConverter;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecord;
import edu.bsu.cs445.historicmachine.model.DomaArtifactRecordCollection;
import edu.bsu.cs445.historicmachine.model.JaxbArtifactRecordCollection;
import org.junit.jupiter.params.ParameterizedTest;

public class ContentConverterTest {

    private DomaArtifactRecord testRecordIncandescents = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("Incandescents")
            .withFileName("3420.cpd")
            .withCulture("American ; North American")
            .withCentury("20th century")
            .withPeriodStyle("Modern ; Contemporary")
            .buildRecord();
    private DomaArtifactRecord testRecordCpd = new DomaArtifactRecord.ArtifactRecordBuilder()
            .withTitle("")
            .withFileName("3419.jpg")
            .buildRecord();
    private JaxbArtifactRecordCollection testCollection = new JaxbArtifactRecordCollection();

    void testCreateDomaRecord(){
        ContentConverter converter = new ContentConverter(testCollection);
    }
}
