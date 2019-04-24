package edu.bsu.cs445.historicmachine.model;

public interface ArtifactRecord {
    String getTitle();
    String getFileName();
    String getArtist();
    String getSubject_LCSH();
    String getCulture();
    String getCentury();
    String getPeriodStyle();
    String getDate_Made();
}
