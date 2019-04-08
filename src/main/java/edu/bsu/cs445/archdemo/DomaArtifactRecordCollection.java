package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="metadata")
@XmlAccessorType(XmlAccessType.FIELD)
class DomaArtifactRecordCollection {

    DomaArtifactRecordCollection convertJaxbToDoma(JaxbArtifactRecordCollection jaxbCollection) {
        Preconditions.checkNotNull(jaxbCollection, "Collection may not be null");
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        for(int i=0; i<jaxbCollection.size(); i++){
            ArtifactRecord record = jaxbCollection.items.get(i);
            if(record.getFileName().contains(".cpd")) {
                int j = 1;
                collection.records.add(record);
                while(true){
                    ArtifactRecord recordAbove = jaxbCollection.items.get(i-j);
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

    static DomaArtifactRecordCollection createEmpty(){ return new DomaArtifactRecordCollection(); }

    @SuppressWarnings({"unused","MismatchedQueryAndUpdateOfCollection"})
    @XmlElement(name="record")
    List<ArtifactRecord> records = Lists.newArrayList();

    int size() { return records.size(); }
}
