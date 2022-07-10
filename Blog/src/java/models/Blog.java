
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
public class Blog {
    private int  blogId;
    private  String blogName;
    private String decription;
    private Date date;

    public Blog() {
    }

    public Blog(int blogId, String blogName, String decription, Date date) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.decription = decription;
        this.date = date;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
