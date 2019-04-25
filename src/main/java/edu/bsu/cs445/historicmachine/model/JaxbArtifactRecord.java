package edu.bsu.cs445.historicmachine.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
public class JaxbArtifactRecord implements ArtifactRecord{

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name = "Title")
    private String title;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name = "CONTENTdm_File_Name")
    private String fileName;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name = "Artist")
    private String artist;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name = "Subject_LCSH")
    private String subject;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name = "Date_Made")
    private String date_made;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name = "Culture")
    private String culture;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name = "Century")
    private String century;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name = "Period_Style")
    private String periodStyle;

    public String getTitle() {return title;}
    public String getFileName() {return fileName;}
    public String getArtist(){return artist;}
    public String getSubject(){return subject;}
    public String getCulture(){return culture;}
    public String getCentury(){return century;}
    public String getPeriodStyle(){return periodStyle;}
    public String getDate_made(){return date_made;}

    public static class JaxbArtifactRecordBuilder {

        private String title;
        private String fileName;
        private String culture;
        private String century;
        private String periodStyle;

        public JaxbArtifactRecord.JaxbArtifactRecordBuilder withTitle(String title){
            this.title = title;
            return this;
        }

        public JaxbArtifactRecord.JaxbArtifactRecordBuilder withFileName(String fileName){
            this.fileName = fileName;
            return this;
        }

        public JaxbArtifactRecord.JaxbArtifactRecordBuilder withCulture(String culture){
            this.culture = culture;
            return this;
        }

        public JaxbArtifactRecord.JaxbArtifactRecordBuilder withCentury(String century){
            this.century = century;
            return this;
        }

        public JaxbArtifactRecord.JaxbArtifactRecordBuilder withPeriodStyle(String periodStyle){
            this.periodStyle = periodStyle;
            return this;
        }

        public JaxbArtifactRecord buildRecord(){
            JaxbArtifactRecord record = new JaxbArtifactRecord();
            record.title = this.title;
            record.fileName = this.fileName;
            record.culture = this.culture;
            record.century = this.century;
            record.periodStyle = this.periodStyle;
            return record;
        }

    }
}