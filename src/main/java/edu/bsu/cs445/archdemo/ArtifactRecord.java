package edu.bsu.cs445.archdemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
class ArtifactRecord {

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

    String getTitle() { return title; }

    String getFileName() { return fileName; }

    String getArtist(){return artist;}

    String getSubject_LCSH(){return subject_LCSH;}

    String getCulture(){return culture;}

    String getCentury(){return century;}

    String getPeriodStyle(){return periodStyle;}

    String getDate_Made(){return date_Made;}

    void setTitle(String title){ this.title = title;}

    void setFileName(String file){ this.fileName = file; }

    void setArtist(String artist){ this.artist = artist; }

    void setSubject_LCSH(String subject_LCSH){ this.subject_LCSH = subject_LCSH; }

    void setCulture(String culture){ this.culture = culture; }

    void setCentury(String century){ this.century = century; }

    void setPeriodStyle(String periodStyle){ this.periodStyle = periodStyle; }

    void setDate_Made(String date_Made){ this.date_Made = date_Made; }

}

