
package model;

/**
 *
 * @author Lyse
 */
public class Artwork {
    private Integer artworkId;
    private String title;
    private int artistId; 
    private String medium;
    private int year;
    private double price;
    private String status;

    public Artwork(Integer artworkId, String title, int artistId, String medium, int year, double price, String status) {
        this.artworkId = artworkId;
        this.title = title;
        this.artistId = artistId;
        this.medium = medium;
        this.year = year;
        this.price = price;
        this.status = status;
    }

    public Integer getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Integer artworkId) {
        this.artworkId = artworkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
