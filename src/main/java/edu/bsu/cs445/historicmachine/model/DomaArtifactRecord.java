package edu.bsu.cs445.historicmachine.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
public class DomaArtifactRecord implements ArtifactRecord{

    private String title;
    private String fileName;
    private String artist;
    private String subject_LCSH;
    private String date_Made;
    private String culture;
    private String century;
    private String periodStyle;

    public String getTitle() {return title;}
    public String getFileName() {return fileName;}
    public String getArtist(){return artist;}
    public String getSubject_LCSH(){return subject_LCSH;}
    public String getCulture(){return culture;}
    public String getCentury(){return century;}
    public String getPeriodStyle(){return periodStyle;}
    public String getDate_Made(){return date_Made;}

    public static class ArtifactRecordBuilder{

        private String title;
        private String fileName;
        private String artist;
        private String subject_LCSH;
        private String culture;
        private String century;
        private String periodStyle;
        private String date_Made;

        public ArtifactRecordBuilder withTitle(String title){
            this.title = title;
            return this;
        }

        public ArtifactRecordBuilder withFileName(String fileName){
            this.fileName = fileName;
            return this;
        }

        public ArtifactRecordBuilder withArtist(String artist){
            this.artist = artist;
            return this;
        }

        public ArtifactRecordBuilder withSubject_LCSH(String subject_LCSH){
            this.subject_LCSH = subject_LCSH;
            return this;
        }

        public ArtifactRecordBuilder withCulture(String culture){
            this.culture = culture;
            return this;
        }

        public ArtifactRecordBuilder withCentury(String century){
            this.century = century;
            return this;
        }

        public ArtifactRecordBuilder withPeriodStyle(String periodStyle){
            this.periodStyle = periodStyle;
            return this;
        }

        public ArtifactRecordBuilder withDate_Made(String date_Made){
            this.date_Made = date_Made;
            return this;
        }

        public DomaArtifactRecord buildRecord(){
            DomaArtifactRecord record = new DomaArtifactRecord();
            record.title = this.title;
            record.fileName = this.fileName;
            record.artist = this.artist;
            record.subject_LCSH = this.subject_LCSH;
            record.culture = this.culture;
            record.century = this.century;
            record.periodStyle = this.periodStyle;
            record.date_Made = this.date_Made;

            return record;
        }

    }

}

