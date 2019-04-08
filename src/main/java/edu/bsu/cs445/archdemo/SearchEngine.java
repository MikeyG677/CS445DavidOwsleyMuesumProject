package edu.bsu.cs445.archdemo;

import com.google.common.collect.ImmutableList;
import java.util.LinkedHashSet;
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

    List<ArtifactRecord> searchSubject_WholeWord(String query) {
        results = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getSubject_LCSH().toLowerCase()
                        .matches(".*\\b" + query.toLowerCase() + "\\b.*")).collect(Collectors.toList());
        return ImmutableList.copyOf(results);
    }

    List<ArtifactRecord> searchSubject_Contains(String query) {
        results = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getSubject_LCSH().toLowerCase()
                        .contains(query.toLowerCase())).collect(Collectors.toList());
        return ImmutableList.copyOf(results);
    }

    List<ArtifactRecord> searchRelatedWorks(ArtifactRecord record){
        LinkedHashSet<ArtifactRecord> resultsList = new LinkedHashSet<>();

        String[] culturesSeparated = record.getCulture().split(" ; ", -1);
        for (String cultureSingular : culturesSeparated){
            results = artifacts.stream()
                    .filter(artifactRecord -> artifactRecord.getCulture().toLowerCase()
                            .contains(".*\\b" + cultureSingular.toLowerCase() + "\\b.*")).collect(Collectors.toList());
            resultsList.addAll(results);
        }

        String[] centuriesSeparated = record.getCentury().split(" ; ", -1);
        for (String centurySingular : centuriesSeparated){
            results = artifacts.stream()
                    .filter(artifactRecord -> artifactRecord.getCentury().toLowerCase()
                            .contains(".*\\b" + centurySingular.toLowerCase() + "\\b.*")).collect(Collectors.toList());
            resultsList.addAll(results);
        }

        String[] periodStylesSeparated = record.getPeriodStyle().split(" ; ", -1);
        for (String periodStyleSingular : periodStylesSeparated){
            results = artifacts.stream()
                    .filter(artifactRecord -> artifactRecord.getPeriodStyle().toLowerCase()
                            .contains(".*\\b" + periodStyleSingular.toLowerCase() + "\\b.*")).collect(Collectors.toList());
            resultsList.addAll(results);
        }

        return ImmutableList.copyOf(resultsList);
    }
}
