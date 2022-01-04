package com.happyness.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Document
public class Family {

    @Id
    private UUID id;
    private String responsibleName;

    private ArrayList<Child> children;

    public Family(UUID id, String responsibleName) {
        this.id = UUID.randomUUID();
        this.responsibleName = responsibleName;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }
}
