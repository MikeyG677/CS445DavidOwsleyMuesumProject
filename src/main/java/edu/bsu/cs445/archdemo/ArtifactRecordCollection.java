package edu.bsu.cs445.archdemo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;
import java.util.stream.Collectors;

@XmlRootElement(name="metadata")
@XmlAccessorType(XmlAccessType.FIELD)
class ArtifactRecordCollection {

    static ArtifactRecordCollection of(ArtifactRecord... records) {
        Preconditions.checkNotNull(records, "Parameter may not be null");
        ArtifactRecordCollection collection = new ArtifactRecordCollection();
        collection.items.addAll(Arrays.asList(records));
        return collection;
    }

    static ArtifactRecordCollection createEmpty() {
        return new ArtifactRecordCollection();
    }

    // This item is used by the JAXB parsing but not used in custom code.
    @SuppressWarnings({"unused","MismatchedQueryAndUpdateOfCollection"})
    @XmlElement(name="record")
    private List<ArtifactRecord> items = Lists.newArrayList();

    int size() {
        return items.size();
    }

    //Methods below utilize 2 parameters to avoid DRY violation.
    int countRecordsByTitleQuery(String query, Boolean isExactWord) {
        List<ArtifactRecord> result = searchThroughTitles(query, isExactWord);
        return result.size();
    }

    int countRecordsBySubjectQuery(HashSet<String> query, Boolean isExactWord) {
        List<ArtifactRecord> result = searchThroughSubjects(query, isExactWord);
        return result.size();
    }

    List<ArtifactRecord> searchThroughTitles(String query, Boolean isExactWord) {
        List<ArtifactRecord> result;

        if(isExactWord) {
            result = items.stream()
                    .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                    .matches(".*\\b" + query.toLowerCase() + "\\b.*")).collect(Collectors.toList());
        }
        else {
            result = items.stream()
                    .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                    .contains(query.toLowerCase())).collect(Collectors.toList());
        }
        return ImmutableList.copyOf(result);
    }

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

    List<ArtifactRecord> searchByCulture(HashSet<String> queryList, Boolean isExactWord) {
        List<ArtifactRecord> resultList = new ArrayList<>();
        for(String query : queryList){
            if(isExactWord){
                List<ArtifactRecord> result = items.stream()
                        .filter(artifactRecord -> artifactRecord.getCulture().toLowerCase()
                                .matches(".*\\b" + query.toLowerCase() + "\\b.*")).collect(Collectors.toList());
                resultList.addAll(result);
            }
            else {
                List<ArtifactRecord> result = items.stream()
                        .filter(artifactRecord -> artifactRecord.getCulture().toLowerCase()
                                .contains(query.toLowerCase())).collect(Collectors.toList());
                resultList.addAll(result);
            }
        }

        LinkedHashSet<ArtifactRecord> resultListDuplicatesRemoved = new LinkedHashSet<>(resultList);
        return ImmutableList.copyOf(resultListDuplicatesRemoved);

    }

}
