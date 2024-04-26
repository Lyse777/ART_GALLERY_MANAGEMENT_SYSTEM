
package model;

/**
 *
 * @author Lyse
 */
public class Customer {
    private Integer customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private int role_Id; 

    public Customer(String name, String email, String phone, String address, String password, int role_Id) {
        
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.role_Id = role_Id;
    }

    public Customer(Integer customerId, String name, String email, String phone, String address, String password, int role_Id) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.role_Id = role_Id;
    }
      public Customer(Integer customerId, String name, String email, String phone, String address, String password) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
       
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(int role_Id) {
        this.role_Id = role_Id;
    }

   

   
    
}
