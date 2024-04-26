
package model;

import java.sql.Date;


/**
 *
 * @author Lyse
 */
public class Sale {
    private Integer saleId;
    private int artworkId;
    private int customerId;
    private Date saleDate;
    private double Price;

    public Sale(Integer saleId, int artworkId, int customerId, Date saleDate, double Price) {
        this.saleId = saleId;
        this.artworkId = artworkId;
        this.customerId = customerId;
        this.saleDate = saleDate;
        this.Price = Price;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }
    
    public int getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(int artworkId) {
        this.artworkId = artworkId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

  
}
