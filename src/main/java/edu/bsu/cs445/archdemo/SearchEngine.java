package edu.bsu.cs445.archdemo;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;

class SearchEngine {

    private List<ArtifactRecord> artifacts;
    private List<ArtifactRecord> results;

    SearchEngine(JaxbArtifactRecordCollection collection) {
        this.artifacts = collection.items;
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

    /* Old search function: KEEP FOR NOW, WILL REUSE/REDESIGN
    List<ArtifactRecord> searchThroughSubjects(HashSet<String> queryList, Boolean isExactWord) {
        List<ArtifactRecord> resultList = new ArrayList<>();
        for(String query : queryList){
            if(isExactWord){
                List<ArtifactRecord> result = items.stream()
                        .filter(artifactRecord -> artifactRecord.getSubject_LCSH().toLowerCase()
                                .matches(".*\\b" + query.toLowerCase() + "\\b.*")).collect(Collectors.toList());
                resultList.addAll(result);
            }
            else {
                List<ArtifactRecord> result = items.stream()
                        .filter(artifactRecord -> artifactRecord.getSubject_LCSH().toLowerCase()
                                .contains(query.toLowerCase())).collect(Collectors.toList());
                resultList.addAll(result);
            }
        }

        LinkedHashSet<ArtifactRecord> resultListDuplicatesRemoved = new LinkedHashSet<>(resultList);
        return ImmutableList.copyOf(resultListDuplicatesRemoved);
    }
    */

}
