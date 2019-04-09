package edu.bsu.cs445.archdemo;

import com.google.common.base.Preconditions;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
class ArtifactRecord {

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Title")
    String title;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="CONTENTdm_File_Name")
    String fileName;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Artist")
    String artist;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Subject_LCSH")
    String subject_LCSH;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Date_Made")
    String date_Made;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Culture")
    String culture;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Century")
    String century;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Period_Style")
    String periodStyle;

    String getTitle() { return title; }

    String getFileName() { return fileName; }

    String getArtist(){return artist;}

    String getSubject_LCSH(){return subject_LCSH;}

    String getCulture(){return culture;}

    String getCentury(){return century;}

    String getPeriodStyle(){return periodStyle;}

    String getDate_Made(){return date_Made;}

    void setFileName(String file){this.fileName = file;}

}

