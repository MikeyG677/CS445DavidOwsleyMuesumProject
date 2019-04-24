package edu.bsu.cs445.historicmachine.model;

import com.google.common.base.Preconditions;

public class ContentConverter {

    private JaxbArtifactRecordCollection jaxbCollection;

    public ContentConverter(JaxbArtifactRecordCollection jaxbCollection) {
        this.jaxbCollection = jaxbCollection;
    }

    public DomaArtifactRecordCollection convertCollectionToDoma(){
        JaxbArtifactRecordCollection artifactCollection = this.jaxbCollection;

        Preconditions.checkNotNull(artifactCollection, "Collection may not be null");
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        for(int i=0; i<artifactCollection.size(); i++){
            JaxbArtifactRecord jaxbRecord = artifactCollection.getItem(i);
            DomaArtifactRecord record = convertJaxbRecordToDomaRecord(jaxbRecord);
            if(record.getFileName().contains(".cpd")) {
                int j = 1;
                collection.records.add(record);
                while(true){
                    ArtifactRecord recordAbove = artifactCollection.getItem(i-j);
                    if(!recordAbove.getTitle().isEmpty()){
                        break;
                    }
                    else if(recordAbove.getArtist().contentEquals("FRONT")){
                        record.setFileName(recordAbove.getFileName());
                        break;
                    }
                    else{
                        record.setFileName(recordAbove.getFileName());
                    }
                    j += 1;
                }
            }
            else if(!record.getTitle().isEmpty()){
                collection.records.add(record);
            }
        }
        return collection;
    }

    private DomaArtifactRecord convertJaxbRecordToDomaRecord(JaxbArtifactRecord jaxbRecord){
        return new DomaArtifactRecord.ArtifactRecordBuilder()
                .withTitle(jaxbRecord.getTitle())
                .withFileName(jaxbRecord.getFileName())
                .withArtist(jaxbRecord.getArtist())
                .withSubject_LCSH(jaxbRecord.getSubject_LCSH())
                .withDate_Made(jaxbRecord.getDate_Made())
                .withCulture(jaxbRecord.getCulture())
                .withCentury(jaxbRecord.getCentury())
                .withPeriodStyle(jaxbRecord.getPeriodStyle())
                .buildRecord();
    }
    //convertJaxBtoDoma stuff - putting into a collection... convert the Jaxb Record to a DOMA record
}
