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

    int countRecordsByTitleQuery(String query) {
        List<ArtifactRecord> result = searchTitles(query);
        return result.size();
    }

    List<ArtifactRecord> searchTitles(String query) {
        List<ArtifactRecord> result = items.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().toLowerCase()
                .contains(query.toLowerCase())).collect(Collectors.toList());
        return ImmutableList.copyOf(result);
    }

    List<ArtifactRecord> searchSubject(HashSet<String> queryList) {
        List<ArtifactRecord> resultList = new ArrayList<>();
        for(String query : queryList){
            List<ArtifactRecord> result = items.stream()
                    .filter(artifactRecord -> artifactRecord.getSubject_LCSH().toLowerCase()
                    .contains(query.toLowerCase())).collect(Collectors.toList());
            resultList.addAll(result);
        }
        LinkedHashSet<ArtifactRecord> resultListCleaned = new LinkedHashSet<>(resultList); // Strips resultList of duplicate artifact records.
        return ImmutableList.copyOf(resultListCleaned);
    }
}
