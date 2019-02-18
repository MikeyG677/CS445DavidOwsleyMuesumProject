package edu.bsu.cs445.archdemo;
import com.google.common.base.Preconditions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
class ArtifactRecord {

    static ArtifactRecord withTitle(String title) {
        ArtifactRecord record = new ArtifactRecord();
        record.title = Preconditions.checkNotNull(title);
        return record;
    }

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Title")
    private String title;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="CONTENTdm_File_Name")
    private String fileName;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Artist")
    private String artist;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Subject_LCSH")
    private String subject_LCSH;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Date_Made")
    private String date_Made;

    String getTitle() {
        return title;
    }

    String getFileName() { return fileName; }

    String getArtist(){return artist;}

    String getSubject_LCSH(){return subject_LCSH;}

    String getDate_Made(){return date_Made;}

}
