
package DAO;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
/**
 *
 * @author Lyse
 */
public class CustomerDAO {

  
    private String dbUrl = "jdbc:postgresql://localhost:5432/Art_Gallery_Management_System_db";
    private String username = "postgres";
    private String passwd = "sql";
    
    public CustomerDAO() {
        
    }
//REGISTER /SIGNUP   
    public String registerCustomer(Customer customerObj) {
        String hashedPassword = BCrypt.hashpw(customerObj.getPassword(), BCrypt.gensalt());
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("INSERT INTO customers (name, email, phone, address, password, role_id) VALUES (?, ?, ?, ?, ?, ?)")) { 
            pst.setString(1, customerObj.getName());
            pst.setString(2, customerObj.getEmail());
            pst.setString(3, customerObj.getPhone());
            pst.setString(4, customerObj.getAddress());
            pst.setString(5, hashedPassword);
            pst.setInt(6, 5);  
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Customer Account Created Successfully";
            } 
        } catch (SQLException e) {
         return "Error Creating Customer Account";
        }
        return "No customer account was Created";
    }

//REGISTER USERS ON ADMINPAGE WHEN REGISTERING DIFFERENT USERS    
     public String registerUsers(Customer customerObj) {
        String hashedPassword = BCrypt.hashpw(customerObj.getPassword(), BCrypt.gensalt());
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("INSERT INTO customers (name, email, phone, address, password, role_id) VALUES (?, ?, ?, ?, ?, ?)")) { 
            pst.setString(1, customerObj.getName());
            pst.setString(2, customerObj.getEmail());
            pst.setString(3, customerObj.getPhone());
            pst.setString(4, customerObj.getAddress());
            pst.setString(5, hashedPassword);
            pst.setInt(6, customerObj.getRole_Id());  
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "User Registered Successfully";
            } 
        } catch (SQLException e) {
         return "Error Registered User";
        }
        return "No User was Registered";
    }
    
//UPDATE    
    public String updateCustomer(Customer customerObj) {
        String hashedPassword = BCrypt.hashpw(customerObj.getPassword(), BCrypt.gensalt());
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("UPDATE customers SET name = ?, email = ?, phone = ?, address = ? , password = ? WHERE customer_id = ?")) {
            pst.setString(1, customerObj.getName());
            pst.setString(2, customerObj.getEmail());
            pst.setString(3, customerObj.getPhone());
            pst.setString(4, customerObj.getAddress());
            pst.setString(5, hashedPassword);
            pst.setInt(6, customerObj.getCustomerId());
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Customer Updated Successfully";
            } 
        } catch (SQLException e) {
            return "Error Updating Customer";
        }
        return "No Customer was updated";
    }
    //UPDATE USERS ON ADMINPAGE WHEN UPDATING DIFFERENT USERS  
    public String updateUser(Customer customerObj) {
        String hashedPassword = BCrypt.hashpw(customerObj.getPassword(), BCrypt.gensalt());
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("UPDATE customers SET name = ?, email = ?, phone = ?, address = ? , password = ?, role_id= ? WHERE customer_id = ?")) {
            pst.setString(1, customerObj.getName());
            pst.setString(2, customerObj.getEmail());
            pst.setString(3, customerObj.getPhone());
            pst.setString(4, customerObj.getAddress());
            pst.setString(5, hashedPassword);
            pst.setInt(6, customerObj.getRole_Id());  
            pst.setInt(7, customerObj.getCustomerId());
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "User Updated Successfully";
            } 
        } catch (SQLException e) {
            return "Error Updating User";
        }
        return "No User was updated";
    }
//DELETE    
    public String deleteCustomer(int customerId) {
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement("DELETE FROM customers WHERE customer_id = ?")) {
            pst.setInt(1, customerId);
            int rowAffected = pst.executeUpdate();
            if (rowAffected >= 1) {
                return "Customer Deleted Successfully";
            } 
        } catch (SQLException e) {
          return " Error deleting Customer";
        }
        return "No Customer was Deleted";
    }
    
//RETRIEVE ALL
    public List<Customer> getAllCustomers() {
    List<Customer> customers = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM customers")) {
        while (rs.next()) {
            Customer customer;
            customer = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("password"),
                    rs.getInt("role_id")
            );
            customers.add(customer);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return customers;
}

// LOGIN
    public Customer authenticateUser(String email, String password) {
        Customer customer = null;
        String query = "SELECT * FROM customers WHERE email = ?";
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if (BCrypt.checkpw(password, rs.getString("password"))) {
                    customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("password"),
                        rs.getInt("role_id")
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
    public String getRoleName(int roleId) {
        String roleName = null;
        String query = "SELECT role_name FROM role WHERE role_id = ?";
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, roleId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                roleName = rs.getString("role_name");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roleName;
    }

//SEARCH
public List<Customer> searchCustomersByName(String name) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE LOWER(name) LIKE LOWER(?)";
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement(sql)) {            
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("password"),
                    rs.getInt("role_id")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

//GETTING CUSTOMER BY ID
    public Customer getCustomerById(int customerId) {
    Customer customer = null;
    String sql = "SELECT * FROM customers WHERE customer_id = ?";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            customer = new Customer(
                rs.getInt("customer_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getString("password")  
               
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return customer;
}  
    
//GETTING CUSTOMER BY NAME    
  public String getCustomerName(int customerId) {
    String customerName = "";
    String sql = "SELECT name FROM customers WHERE customer_id = ?";
    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setInt(1, customerId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            customerName = rs.getString("name");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return customerName;
}

//GETTING ALL CUSTOMER BY THEIR IDS 
  public List<Integer> getAllCustomerIds() {
        List<Integer> customerIds = new ArrayList<>();
        String sql = "SELECT customer_id FROM customers"; 
        try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
             PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                customerIds.add(rs.getInt("customer_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerIds;
    }

}
