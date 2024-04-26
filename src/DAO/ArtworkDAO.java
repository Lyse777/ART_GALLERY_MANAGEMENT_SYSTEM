
package DAO;

import java.sql.*;
import model.Artwork;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lyse
 */
public class ArtworkDAO {
    
    private String dbUrl = "jdbc:postgresql://localhost:5432/Art_Gallery_Management_System_db";
    private String username = "postgres";
    private String passwd = "sql";
    
    public ArtworkDAO() {
        
    }
//REGISTER    
    public String registerArtwork(Artwork artworkObj) {
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            PreparedStatement pst = con.prepareStatement("INSERT INTO artworks (title, artist_id, medium, year, price, status) VALUES (?, ?, ?, ?, ?, ?)")) {
            pst.setString(1, artworkObj.getTitle());
            pst.setInt(2, artworkObj.getArtistId());
            pst.setString(3, artworkObj.getMedium());
            pst.setInt(4, artworkObj.getYear());
            pst.setDouble(5, artworkObj.getPrice());
            pst.setString(6, artworkObj.getStatus());
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Artwork Registered Successfully";
            } 
        } catch (SQLException e) {
            return "Error Registering artwork: " + e.getMessage();
        }
        return "No artwork was registered.";
    }
//UPDATE    
    public String updateArtwork(Artwork artworkObj) {
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("UPDATE artworks SET title = ?, artist_id = ?, medium = ?, year = ?, price = ?, status = ? WHERE artwork_id = ?")) {
            pst.setString(1, artworkObj.getTitle());
            pst.setInt(2, artworkObj.getArtistId());
            pst.setString(3, artworkObj.getMedium());
            pst.setInt(4, artworkObj.getYear());
            pst.setDouble(5, artworkObj.getPrice());
            pst.setString(6, artworkObj.getStatus());
            pst.setInt(7, artworkObj.getArtworkId());
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Artwork Updated Successfully";
            } 
        } catch (SQLException e) {
            return "Error Updating artwork: " + e.getMessage();
        }
        return "No artwork was updated.";
    }
//DELETE    
    public String deleteArtwork(int artworkId) {
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("DELETE FROM artworks WHERE artwork_id = ?")) {
            pst.setInt(1, artworkId);
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Artwork Deleted Successfully";
            } 
        } catch (SQLException e) {
          return "Error Deleting artwork: " + e.getMessage();
        }
        return "No artwork was deleted.";
    }
//RETRIEVE ALL    
     public List<Artwork> getAllArtworks() {
        List<Artwork> artworks = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM artworks")) {
            while (rs.next()) {
                Artwork artwork = new Artwork(
                    rs.getInt("artwork_id"),
                    rs.getString("title"),
                    rs.getInt("artist_id"),
                    rs.getString("medium"),
                    rs.getInt("year"),
                    rs.getDouble("price"),
                    rs.getString("status")
                );
                artworks.add(artwork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }

    //SEARCH
    public List<Artwork> searchArtworksByTitle(String title) {
        List<Artwork> artworks = new ArrayList<>();
        String sql = "SELECT * FROM artworks WHERE LOWER(title) LIKE LOWER(?)";
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement(sql)) {            
            pst.setString(1, "%" + title + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Artwork artwork = new Artwork(
                    rs.getInt("artwork_id"),
                    rs.getString("title"),
                    rs.getInt("artist_id"),
                    rs.getString("medium"),
                    rs.getInt("year"),
                    rs.getDouble("price"),
                    rs.getString("status")
                );
                artworks.add(artwork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }
//RETRIEVING ONLY THOSE ARTWORKS WITH THE STATUS AVAILABLE    
    public List<Artwork> getAllAvailableArtworks() {
    List<Artwork> artworkss = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM artworks WHERE status = 'available'")) {
        while (rs.next()) {
            Artwork artwork = new Artwork(
                rs.getInt("artwork_id"),
                rs.getString("title"),
                rs.getInt("artist_id"),
                rs.getString("medium"),
                rs.getInt("year"),
                rs.getDouble("price"),
                rs.getString("status")
            );
            artworkss.add(artwork);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return artworkss;
}

//SEARCH ALL ARTWORKS WITH STATUS AVAILABLE
public List<Artwork> searchAvailableArtworksByTitle(String title) {
    List<Artwork> artworks = new ArrayList<>();
    String sql = "SELECT * FROM artworks WHERE LOWER(title) LIKE LOWER(?) AND status = 'available'";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {            
        pst.setString(1, "%" + title + "%");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Artwork artwork = new Artwork(
                rs.getInt("artwork_id"),
                rs.getString("title"),
                rs.getInt("artist_id"),
                rs.getString("medium"),
                rs.getInt("year"),
                rs.getDouble("price"),
                rs.getString("status")
            );
            artworks.add(artwork);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return artworks;
}
     
//GETTING THE PRICE AND THE TITLE FROM THE SELECTED ARTWORK 
     public double getSelectedArtworkPrice(int artworkId) {
        double price = 0.0;
        String sql = "SELECT price FROM artworks WHERE artwork_id = ?";
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement(sql)) {     
            pst.setInt(1, artworkId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }
     public String getArtworkName(int artworkId) {
    String artworkName = "";
    String sql = "SELECT title FROM artworks WHERE artwork_id = ?";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setInt(1, artworkId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            artworkName = rs.getString("title");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return artworkName;
}

//GETTING ALL ARTWORK BY THEIR IDS    
public List<Integer> getAllArtworkIds() {
    List<Integer> artworkIds = new ArrayList<>();
    String sql = "SELECT artwork_id FROM artworks"; 
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            artworkIds.add(rs.getInt("artwork_id"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return artworkIds;
}

//GETTING THE ARTWORK PRICE BASED ON THE ARTWORK ID SELECTED IN THE COMBOBOX OF SALE
public double getArtworkPrice(int artworkId) {
        String sql = "SELECT price FROM artworks WHERE artwork_id = ?";
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, artworkId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getDouble("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0; 
    }


}
