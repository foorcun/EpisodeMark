package com.example.episodemark.entity;

public class Series {
    private int id;
    private String documentName;
    private String diziName;




    public Series(int id, String documentName, String diziName) {
        this.id = id;
        this.documentName = documentName;
        this.diziName = diziName;
    }

    public Series(){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDiziName() {
        return diziName;
    }

    public void setDiziName(String diziName) {
        this.diziName = diziName;
    }

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", documentName='" + documentName + '\'' +
                ", diziName='" + diziName + '\'' +
                '}';
    }
}
