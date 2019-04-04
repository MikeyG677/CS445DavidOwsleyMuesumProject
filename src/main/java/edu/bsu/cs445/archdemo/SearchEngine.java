package edu.bsu.cs445.archdemo;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;

class SearchEngine {

    private List<ArtifactRecord> artifacts;
    private List<ArtifactRecord> result;

    SearchEngine(JaxbArtifactRecordCollection collection) {
        this.artifacts = collection.items;
    }

    List<ArtifactRecord> searchTitles_WholeWord(String query) {
        result = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                .matches(".*\\b" + query.toLowerCase() + "\\b.*")).collect(Collectors.toList());
        return ImmutableList.copyOf(result);
    }

    List<ArtifactRecord> searchTitles_Contains(String query) {
        result = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                .contains(query.toLowerCase())).collect(Collectors.toList());
        return ImmutableList.copyOf(result);
    }

}
