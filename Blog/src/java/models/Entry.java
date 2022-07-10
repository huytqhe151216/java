
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package models;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Entry {
    private  int entryId;
    Category category;
    private String title;
    private String entryContent;
    Date dateCreated;
    Date dateModified;

    public Entry() {
    }

    public Entry(int entryId, Category category, String title, String entryContent, Date dateCreated, Date dateModified) {
        this.entryId = entryId;
        this.category = category;
        this.title = title;
        this.entryContent = entryContent;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent) {
        this.entryContent = entryContent;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
    
}
