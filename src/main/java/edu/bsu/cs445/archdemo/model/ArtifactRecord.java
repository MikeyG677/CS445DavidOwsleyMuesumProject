package edu.bsu.cs445.archdemo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArtifactRecord {

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

    public String getTitle() { return title; }

    public String getFileName() { return fileName; }

    public String getArtist(){return artist;}

    public String getSubject_LCSH(){return subject_LCSH;}

    public String getCulture(){return culture;}

    public String getCentury(){return century;}

    public String getPeriodStyle(){return periodStyle;}

    public String getDate_Made(){return date_Made;}

    public void setTitle(String title){ this.title = title;}

    public void setFileName(String file){ this.fileName = file; }

    public void setArtist(String artist){ this.artist = artist; }

    public void setSubject_LCSH(String subject_LCSH){ this.subject_LCSH = subject_LCSH; }

    public void setCulture(String culture){ this.culture = culture; }

    public void setCentury(String century){ this.century = century; }

    public void setPeriodStyle(String periodStyle){ this.periodStyle = periodStyle; }

    public void setDate_Made(String date_Made){ this.date_Made = date_Made; }

}
