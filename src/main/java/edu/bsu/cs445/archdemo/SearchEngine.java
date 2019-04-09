package edu.bsu.cs445.archdemo;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;

class SearchEngine {

    private List<ArtifactRecord> artifacts;
    private List<ArtifactRecord> results;

    SearchEngine(DomaArtifactRecordCollection collection) {
        this.artifacts = collection.records;
    }

    List<ArtifactRecord> searchTitle_WholeWord(String query) {
        results = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                        .matches(".*\\b" + query.toLowerCase() + "\\b.*")).collect(Collectors.toList());
        return ImmutableList.copyOf(results);
    }

    List<ArtifactRecord> searchTitle_Contains(String query) {
        results = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                        .contains(query.toLowerCase())).collect(Collectors.toList());
        return ImmutableList.copyOf(results);
    }
}
