
package model;

/**
 *
 * @author Lyse
 */
public class Artist {
    private Integer artistId;
    private String name;
    private String biography;
    private Integer birthYear; 
    private Integer deathYear;
    private String nationality;

    public Artist(Integer artistId, String name, String biography, Integer birthYear, Integer deathYear, String nationality) {
        this.artistId = artistId;
        this.name = name;
        this.biography = biography;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.nationality = nationality;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
}

