
package DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Artist;

/**
 *
 * @author Lyse
 */
public class ArtistDAO {
    private String dbUrl = "jdbc:postgresql://localhost:5432/Art_Gallery_Management_System_db";
    private String username = "postgres";
    private String passwd = "sql";
    
    public ArtistDAO() {
        
    }
//REGISTER    
   public String registerArtist(Artist artistObj) {
    try {
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        String sql = "INSERT INTO artists (name, biography, birth_year, death_year, nationality) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, artistObj.getName());
        pst.setString(2, artistObj.getBiography());
        pst.setObject(3, artistObj.getBirthYear()); 
        pst.setObject(4, artistObj.getDeathYear()); 
        pst.setString(5, artistObj.getNationality());
        int rowAffected = pst.executeUpdate();
        if (rowAffected >= 1) {
            return "Artist Registered Successfully";
        }
    } catch (SQLException e) {
            return "Error Registering artist: " + e.getMessage();
    }
   return "No artist was registered.";
}
//UPDATE   
   public String updateArtist(Artist artistObj) {
    try {
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        String sql = "UPDATE artists SET name = ?, biography = ?, birth_year = ?, death_year = ?, nationality = ? WHERE artist_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, artistObj.getName());
        pst.setString(2, artistObj.getBiography());
        pst.setObject(3, artistObj.getBirthYear());
        pst.setObject(4, artistObj.getDeathYear());
        pst.setString(5, artistObj.getNationality());
        pst.setInt(6, artistObj.getArtistId());
        int rowAffected = pst.executeUpdate();
        if (rowAffected > 0) {
            return "Artist updated successfully.";
        }
    } catch (SQLException e) {
        return "Error updating artist: " + e.getMessage();
    }
    return "No artist was updated.";
}
//DELETE
   public String deleteArtist(int artistId) {
    try {
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        String sql = "DELETE FROM artists WHERE artist_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, artistId);
        int rowAffected = pst.executeUpdate();
        if (rowAffected >= 1) {
            return "Artist Deleted Successfully.";
        } 
    } catch (SQLException e) {
        return "Error deleting artist: " + e.getMessage();
    }
    return "No artist was deleted.";
}
//RETRIEVE ALL   
   public List<Artist> getAllArtists() {
    List<Artist> artists = new ArrayList<>();
    try {
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        String sql = "SELECT * FROM artists";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Artist artist = new Artist(
                rs.getInt("artist_id"),
                rs.getString("name"),
                rs.getString("biography"),
                rs.getObject("birth_year", Integer.class),
                rs.getObject("death_year", Integer.class),
                rs.getString("nationality")
            );
            artists.add(artist);
        }
        rs.close();
        st.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return artists;
}

   //SEARCH
    public List<Artist> searchArtistsByName(String name) {
    List<Artist> artists = new ArrayList<>();
    String sql = "SELECT * FROM artists WHERE LOWER(name) LIKE LOWER(?)";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, "%" + name + "%");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Artist artist = new Artist(
                    rs.getInt("artist_id"),
                    rs.getString("name"),
                    rs.getString("biography"),
                    rs.getInt("birth_year"),
                    rs.getObject("death_year") != null ? rs.getInt("death_year") : null,
                    rs.getString("nationality")
            );
            artists.add(artist);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return artists;
}

//GETTING ALL ARTIST BY THEIR IDS    
public List<Integer> getAllArtistIds() {
    List<Integer> artistIds = new ArrayList<>();
    String sql = "SELECT artist_id FROM artists";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            artistIds.add(rs.getInt("artist_id"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return artistIds;
}


    
}
