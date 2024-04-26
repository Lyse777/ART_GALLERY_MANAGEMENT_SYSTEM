
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Sale;
/**
 *
 * @author Lyse
 */
public class SaleDAO {
    private String dbUrl = "jdbc:postgresql://localhost:5432/Art_Gallery_Management_System_db";
    private String username = "postgres";
    private String passwd = "sql";
   
    public SaleDAO() {
       
    }
//REGISTER    
    public String registerSale(Sale saleObj) {
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("INSERT INTO sales (artwork_id, customer_id, sale_date, sale_price) VALUES (?, ?, ?, ?)")) {
            pst.setInt(1, saleObj.getArtworkId());
            pst.setInt(2, saleObj.getCustomerId());
            pst.setDate(3, (Date) saleObj.getSaleDate()); 
            pst.setDouble(4, saleObj.getPrice()); 
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Sale Registered Successfully";
            } 
        } catch (SQLException e) {
          return "Error Registering Sale";
        }
        return "No Sale was Registered";
    }
//UPDATE    
    public String updateSale(Sale saleObj) {
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("UPDATE sales SET artwork_id = ?, customer_id = ?, sale_date = ?, sale_price = ? WHERE sale_id = ?")) {
            pst.setInt(1, saleObj.getArtworkId());
            pst.setInt(2, saleObj.getCustomerId());
            pst.setDate(3, (Date) saleObj.getSaleDate()); 
            pst.setDouble(4, saleObj.getPrice()); 
            pst.setInt(5, saleObj.getSaleId());
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Sale Updated Successfully";
            } 
        } catch (SQLException e) {
             return "Error Updating Sale";
        }
        return "No Sale was Updated";
    }
//DELETE    
    public String deleteSale(int saleId) {
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("DELETE FROM sales WHERE sale_id = ?")) {
            pst.setInt(1, saleId);
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Sale Deleted Successfully";
            } 
        } catch (SQLException e) {
             return "Error Deleting Sale";
        }
         return "No Sale was Deleted";
    }
//RETRIEVE ALL    
public List<Sale> getAllSales() {
    List<Sale> sales = new ArrayList<>();
    String sql = "SELECT * FROM sales";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Sale sale = new Sale(
                    rs.getInt("sale_id"),
                    rs.getInt("artwork_id"),
                    rs.getInt("customer_id"),
                    rs.getDate("sale_date"),
                    rs.getDouble("sale_price")  
            );
            sales.add(sale);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sales;
}

//SEARCH
public List<Sale> searchSaleById(String searchText) {
    List<Sale> sales = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement("SELECT * FROM sales WHERE sale_id = ?")) {
        int saleId = Integer.parseInt(searchText);
        pst.setInt(1, saleId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Sale sale = new Sale(
                rs.getInt("sale_id"),
                rs.getInt("artwork_id"),
                rs.getInt("customer_id"),
                rs.getDate("sale_date"),
                rs.getDouble("sale_price")
            );
            sales.add(sale);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        System.out.println("Invalid sale ID format.");
    }
    return sales;
}

//GETTING ALL SALE DETAILS
public Sale getSaleDetails(int saleId) {
    Sale sale = null;
    String sql = "SELECT * FROM sales WHERE sale_id = ?";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setInt(1, saleId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            sale = new Sale(
                rs.getInt("sale_id"),
                rs.getInt("artwork_id"),
                rs.getInt("customer_id"),
                rs.getDate("sale_date"),
                rs.getDouble("sale_price")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sale;
}

//INSERTING SALES ON CUSTOMER PAGE BY SELECTING AN ARTWORK 
  public int insertSale(int artworkId, int customerId, double price) {
    int saleId = -1;
    String sql = "INSERT INTO sales (artwork_id, customer_id, sale_date, sale_price) VALUES (?, ?, CURRENT_DATE, ?)";
    String generatedColumns[] = { "sale_id" }; 
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql, generatedColumns)) {
        pst.setInt(1, artworkId);
        pst.setInt(2, customerId);
        pst.setDouble(3, price);
        pst.executeUpdate();
        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                saleId = generatedKeys.getInt(1);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return saleId;
}

//GETTING SALES BY CUSTOMERID  
  public List<Sale> getSalesByCustomerId(int customerId) {
    List<Sale> sales = new ArrayList<>();
    String sql = "SELECT * FROM sales WHERE customer_id = ?";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Sale sale = new Sale(
                rs.getInt("sale_id"),
                rs.getInt("artwork_id"),
                rs.getInt("customer_id"),
                rs.getDate("sale_date"),
                rs.getDouble("sale_price")
            );
            sales.add(sale);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return sales;
}


}


