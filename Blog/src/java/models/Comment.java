
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
public class Comment {
    private  int commentId;
    Entry entry;
    private String commentContent;
    private int authorId;
    Date dateCreated;
    Date dateModified;

    public Comment() {
    }

    public Comment(int commentId, Entry entry, String commentContent, int authorId, Date dateCreated, Date dateModified) {
        this.commentId = commentId;
        this.entry = entry;
        this.commentContent = commentContent;
        this.authorId = authorId;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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
