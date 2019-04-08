package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

class DomaArtifactRecordCollection {

    static DomaArtifactRecordCollection convertJaxbToDoma(JaxbArtifactRecordCollection jaxbCollection) {
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
                    //Grab image and add it to .cpds images. Do NOT add the record.

                    j += 1;
                }
                System.out.println("This is a .cpd!");
            }
            else if(!record.getTitle().isEmpty()){
                System.out.println("Record.");
                collection.records.add(record);
            }
            else{
                System.out.println("This is an image for a .cpd.");
            }
        }
        return collection;
    }

    @SuppressWarnings({"unused","MismatchedQueryAndUpdateOfCollection"})
    @XmlElement(name="DOMA records")
    private List<ArtifactRecord> records = Lists.newArrayList();

    int size() { return records.size(); }
}
