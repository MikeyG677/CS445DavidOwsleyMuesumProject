package edu.bsu.cs445.historicmachine.model;

import com.google.common.collect.Lists;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class JaxbArtifactRecordCollection implements ArtifactRecordCollection {

    // This item is used by the JAXB parsing but not used in custom code.
    @SuppressWarnings({"unused","MismatchedQueryAndUpdateOfCollection"})
    @XmlElement(name="record")
    private List<JaxbArtifactRecord> items = Lists.newArrayList();

    public int size() {
        return items.size();
    }

    @Override
    public JaxbArtifactRecord getItem(int i){
        return items.get(i);
    }
}
