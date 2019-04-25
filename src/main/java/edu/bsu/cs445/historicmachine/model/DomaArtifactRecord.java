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
    private String subject;
    private String date_made;
    private String culture;
    private String century;
    private String periodStyle;

    public String getTitle() {return title;}
    public String getFileName() {return fileName;}
    public String getArtist(){return artist;}
    public String getSubject(){return subject;}
    public String getCulture(){return culture;}
    public String getCentury(){return century;}
    public String getPeriodStyle(){return periodStyle;}
    public String getDate_made(){return date_made;}

    public static class DomaArtifactRecordBuilder {

        private String title;
        private String fileName;
        private String artist;
        private String subject;
        private String culture;
        private String century;
        private String periodStyle;
        private String date_made;

        public DomaArtifactRecordBuilder withTitle(String title){
            this.title = title;
            return this;
        }

        public DomaArtifactRecordBuilder withFileName(String fileName){
            this.fileName = fileName;
            return this;
        }

        public DomaArtifactRecordBuilder withArtist(String artist){
            this.artist = artist;
            return this;
        }

        public DomaArtifactRecordBuilder withSubject(String subject){
            this.subject = subject;
            return this;
        }

        public DomaArtifactRecordBuilder withCulture(String culture){
            this.culture = culture;
            return this;
        }

        public DomaArtifactRecordBuilder withCentury(String century){
            this.century = century;
            return this;
        }

        public DomaArtifactRecordBuilder withPeriodStyle(String periodStyle){
            this.periodStyle = periodStyle;
            return this;
        }

        public DomaArtifactRecordBuilder withDate(String date){
            this.date_made = date;
            return this;
        }

        public DomaArtifactRecord buildRecord(){
            DomaArtifactRecord record = new DomaArtifactRecord();
            record.title = this.title;
            record.fileName = this.fileName;
            record.artist = this.artist;
            record.subject = this.subject;
            record.culture = this.culture;
            record.century = this.century;
            record.periodStyle = this.periodStyle;
            record.date_made = this.date_made;
            return record;
        }

    }

}

