package edu.bsu.cs445.historicmachine.model;

import com.google.common.collect.ImmutableList;

import java.util.LinkedHashSet;
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

    public List<ArtifactRecord> searchRelatedWorks(ArtifactRecord record){
        LinkedHashSet<ArtifactRecord> resultsList = new LinkedHashSet<>();

        String[] culturesSeparated = record.getCulture().split(" ; ", -1);
        for (String cultureSingular : culturesSeparated){
            results = artifacts.stream()
                    .filter(artifactRecord -> artifactRecord.getCentury().toLowerCase()
                            .contains(cultureSingular.toLowerCase())).collect(Collectors.toList());
            resultsList.addAll(results);
        }

        String[] periodStylesSeparated = record.getPeriodStyle().split(" ; ", -1);
        for (String periodStyleSingular : periodStylesSeparated){
            results = artifacts.stream()
                    .filter(artifactRecord -> artifactRecord.getPeriodStyle().toLowerCase()
                            .contains(periodStyleSingular.toLowerCase())).collect(Collectors.toList());
            resultsList.addAll(results);
        }

        return ImmutableList.copyOf(resultsList);
    }
}
