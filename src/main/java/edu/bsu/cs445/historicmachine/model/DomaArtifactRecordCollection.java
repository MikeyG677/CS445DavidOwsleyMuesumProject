package edu.bsu.cs445.historicmachine.model;

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
public class DomaArtifactRecordCollection {

    public static DomaArtifactRecordCollection of(DomaArtifactRecord... record){
        Preconditions.checkNotNull(record, "Parameter may not be null");
        DomaArtifactRecordCollection collection = new DomaArtifactRecordCollection();
        collection.records.addAll(Arrays.asList(record));
        System.out.println(collection);
        return collection;
    }

    @SuppressWarnings({"unused","MismatchedQueryAndUpdateOfCollection"})
    @XmlElement(name="DomaRecords")
    List<DomaArtifactRecord> records = Lists.newArrayList();
}
