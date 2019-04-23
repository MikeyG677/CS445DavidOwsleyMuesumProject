package edu.bsu.cs445.historicmachine.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name="metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class DomaArtifactRecordCollection {

    public DomaArtifactRecordCollection convertCollectionToDoma(ArtifactRecordCollection artifactCollection) {
        Preconditions.checkNotNull(artifactCollection, "Collection may not be null");
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        for(int i=0; i<artifactCollection.size(); i++){
            ArtifactRecord record = artifactCollection.getItem(i);
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

    public static DomaArtifactRecordCollection of(ArtifactRecord... record){
        Preconditions.checkNotNull(record, "Parameter may not be null");
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        collection.records.addAll(Arrays.asList(record));
        System.out.println(collection);
        return collection;
    }

    @SuppressWarnings({"unused","MismatchedQueryAndUpdateOfCollection"})
    @XmlElement(name="DomaRecords")
    public List<ArtifactRecord> records = Lists.newArrayList();

    public int size() { return records.size(); }
}
