package edu.bsu.cs445.archdemo.model;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {

    private List<ArtifactRecord> artifacts;
    private List<ArtifactRecord> results;

    public SearchEngine(DomaArtifactRecordCollection collection) {
        this.artifacts = collection.records;
    }

    public List<ArtifactRecord> searchTitle_WholeWord(String query) {
        results = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                        .matches(".*\\b" + query.toLowerCase() + "\\b.*")).collect(Collectors.toList());
        return ImmutableList.copyOf(results);
    }

    public List<ArtifactRecord> searchTitle_Contains(String query) {
        results = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                        .contains(query.toLowerCase())).collect(Collectors.toList());
        return ImmutableList.copyOf(results);
    }
}
