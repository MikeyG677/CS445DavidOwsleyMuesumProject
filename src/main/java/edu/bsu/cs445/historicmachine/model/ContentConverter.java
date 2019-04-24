package edu.bsu.cs445.historicmachine.model;

import com.google.common.base.Preconditions;

public class ContentConverter {

    private ArtifactRecordCollection collection;

    public ContentConverter(ArtifactRecordCollection artifactCollection) {
        this.collection = artifactCollection;
    }

    public DomaArtifactRecordCollection createDomaCollection(){
        ArtifactRecordCollection artifactCollection = this.collection;
        Preconditions.checkNotNull(artifactCollection, "Collection may not be null");
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        for(int i=0; i<artifactCollection.size(); i++){
            ArtifactRecord jaxbRecord = artifactCollection.getItem(i);
            DomaArtifactRecord record = createDomaRecord(jaxbRecord);
            if(!record.getTitle().isEmpty()){
                collection.records.add(record);
            }
        }
        return collection;
    }

    private DomaArtifactRecord createDomaRecord(ArtifactRecord record){
        String file = record.getFileName();
        if(record.getFileName().contains(".cpd")){
            int endIndex = record.getFileName().indexOf(".");
            file = record.getFileName().substring(0, endIndex);
            int fileNumber = Integer.parseInt(file);
            file = Integer.toString(fileNumber-1) + ".jpg";
        }
        return new DomaArtifactRecord.ArtifactRecordBuilder()
                .withTitle(record.getTitle())
                .withFileName(file)
                .withArtist(record.getArtist())
                .withSubject_LCSH(record.getSubject_LCSH())
                .withDate_Made(record.getDate_Made())
                .withCulture(record.getCulture())
                .withCentury(record.getCentury())
                .withPeriodStyle(record.getPeriodStyle())
                .buildRecord();
    }
}
