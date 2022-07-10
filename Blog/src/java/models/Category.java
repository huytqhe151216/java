
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
public class Category {
    private int categoryId;
    Blog blog;
    private String categoryName;
    Date dateCreated;
    Date dateModified;

    public Category() {
    }

    public Category(int categoryId, Blog blog, String categoryName, Date dateCreated, Date dateModified) {
        this.categoryId = categoryId;
        this.blog = blog;
        this.categoryName = categoryName;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
