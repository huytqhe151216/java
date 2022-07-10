
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

/**
 *
 * @author ADMIN
 */
public class Shipper {
    private int shipId;
    private String companyName;

    public Shipper() {
    }

    public Shipper(int shipId, String companyName) {
        this.shipId = shipId;
        this.companyName = companyName;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}
