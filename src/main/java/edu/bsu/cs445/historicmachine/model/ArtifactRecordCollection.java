package edu.bsu.cs445.historicmachine.model;

public interface ArtifactRecordCollection {

    JaxbArtifactRecord getItem(int i);

    int size();
}
