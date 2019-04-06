package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;

class DomaArtifactRecordCollection {

    static DomaArtifactRecordCollection convertJaxbToDoma(JaxbArtifactRecordCollection jaxbCollection) {
        Preconditions.checkNotNull(jaxbCollection, "Collection may not be null");
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        for(int i=0; i<jaxbCollection.size(); i++){
            ArtifactRecord record = jaxbCollection.items.get(i);
            if(record.getFileName().contains(".cpd")) { //record.getFilename().contains(".cpd")
                int j = 1;
                while(true){
                    ArtifactRecord recordAbove = jaxbCollection.items.get(i-j);
                    //Grab image, delete record.
                    if(recordAbove.getTitle().isEmpty()){
                        break;
                    }
                    j += 1;
                }
                System.out.println("This is a .cpd!");
            }
            else if(record.getTitle().isEmpty()){
                System.out.println("This is an image for a .cpd");
            }
            else{
                System.out.println("No.");
            }
        }
        return collection;
    }
}
