package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
class ArtifactRecord {

    static ArtifactRecord withSpecificInfo(HashMap<String, String> specificInfo) {
        ArtifactRecord record = new ArtifactRecord();
        record.title = Preconditions.checkNotNull(specificInfo.get("title"));
        record.fileName = Preconditions.checkNotNull(specificInfo.get("fileName"));
        record.artist = Preconditions.checkNotNull(specificInfo.get("artist"));
        record.subject_LCSH = Preconditions.checkNotNull(specificInfo.get("subject_LCSH"));
        record.date_Made = Preconditions.checkNotNull(specificInfo.get("date_Made"));
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

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Culture")
    private String culture;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Century")
    private String century;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Period_Style")
    private String periodStyle;

    String getTitle() {
        return title;
    }

    String getFileName() { return fileName; }

    String getArtist(){return artist;}

    String getSubject_LCSH(){return subject_LCSH;}

    String getCulture(){return culture;}

    String getCentury(){return century;}

    String getPeriodStyle(){return periodStyle;}

    String getDate_Made(){return date_Made;}

    void setFileName(String file){this.fileName = file;}

}
