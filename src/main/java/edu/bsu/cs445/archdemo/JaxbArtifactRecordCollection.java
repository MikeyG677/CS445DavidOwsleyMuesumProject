package edu.bsu.cs445.archdemo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name="metadata")
@XmlAccessorType(XmlAccessType.FIELD)
class JaxbArtifactRecordCollection {

    static JaxbArtifactRecordCollection of(ArtifactRecord... records) {
        Preconditions.checkNotNull(records, "Parameter may not be null");
        JaxbArtifactRecordCollection collection = new JaxbArtifactRecordCollection();
        collection.items.addAll(Arrays.asList(records));
        System.out.println(collection);
        return collection;
    }

    static JaxbArtifactRecordCollection createEmpty() {
        return new JaxbArtifactRecordCollection();
    }

    // This item is used by the JAXB parsing but not used in custom code.
    @SuppressWarnings({"unused","MismatchedQueryAndUpdateOfCollection"})
    @XmlElement(name="record")
    List<ArtifactRecord> items = Lists.newArrayList();

    int size() {
        return items.size();
    }
}
