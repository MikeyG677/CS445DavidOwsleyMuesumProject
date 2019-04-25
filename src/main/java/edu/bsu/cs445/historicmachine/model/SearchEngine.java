package edu.bsu.cs445.historicmachine.model;

import com.google.common.collect.ImmutableList;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {

    private List<DomaArtifactRecord> artifacts;
    private List<DomaArtifactRecord> results;

    public SearchEngine(DomaArtifactRecordCollection collection) {
        this.artifacts = collection.records;
    }

    public List<DomaArtifactRecord> searchTitle_WholeWord(String query) {
        results = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                        .matches(".*\\b" + query.toLowerCase() + "\\b.*")).collect(Collectors.toList());
        return ImmutableList.copyOf(results);
    }

    public List<DomaArtifactRecord> searchTitle_Contains(String query) {
        results = artifacts.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                        .contains(query.toLowerCase())).collect(Collectors.toList());
        return ImmutableList.copyOf(results);
    }

    public List<DomaArtifactRecord> searchRelatedWorks(DomaArtifactRecord record){
        LinkedHashSet<DomaArtifactRecord> resultsList = new LinkedHashSet<>();

        resultsList.addAll(searchRelatedWorksByCulture(record));
        resultsList.addAll(searchRelatedWorksByPeriodStyle(record));
        resultsList.addAll(searchRelatedWorksByCentury(record));

        System.out.println(searchRelatedWorksByCulture(record));
        System.out.println(searchRelatedWorksByPeriodStyle(record));
        System.out.println(searchRelatedWorksByCentury(record));

        return ImmutableList.copyOf(resultsList);
    }

    public List<DomaArtifactRecord> searchRelatedWorksByCulture(DomaArtifactRecord record){
        LinkedHashSet<DomaArtifactRecord> resultsList = new LinkedHashSet<>();

        String[] culturesSeparated = record.getCulture().split(" ; ", -1);
        for (String cultureSingular : culturesSeparated){
            results = artifacts.stream()
                    .filter(artifactRecord -> artifactRecord.getCulture().toLowerCase()
                            .contains(cultureSingular.toLowerCase())).collect(Collectors.toList());
            resultsList.addAll(results);
        }
        return ImmutableList.copyOf(resultsList);
    }

    public List<DomaArtifactRecord> searchRelatedWorksByPeriodStyle(DomaArtifactRecord record){
        LinkedHashSet<DomaArtifactRecord> resultsList = new LinkedHashSet<>();

        String[] periodStylesSeparated = record.getPeriodStyle().split(" ; ", -1);
        for (String periodStyleSingular : periodStylesSeparated){
            results = artifacts.stream()
                    .filter(artifactRecord -> artifactRecord.getPeriodStyle().toLowerCase()
                            .contains(periodStyleSingular.toLowerCase())).collect(Collectors.toList());
            resultsList.addAll(results);
        }
        return ImmutableList.copyOf(resultsList);
    }

    public List<DomaArtifactRecord> searchRelatedWorksByCentury(DomaArtifactRecord record){
        LinkedHashSet<DomaArtifactRecord> resultsList = new LinkedHashSet<>();

        String[] centurySeparated = record.getCentury().split(" ; ", -1);
        for (String centurySingular : centurySeparated){
            results = artifacts.stream()
                    .filter(artifactRecord -> artifactRecord.getCentury().toLowerCase()
                            .contains(centurySingular.toLowerCase())).collect(Collectors.toList());
            resultsList.addAll(results);
        }
        return ImmutableList.copyOf(resultsList);
    }
}
