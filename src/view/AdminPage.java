
package view;

import DAO.*;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author Lyse
 */
public class AdminPage extends javax.swing.JFrame {

     DefaultTableModel tableModel = new DefaultTableModel();
     DefaultTableModel artworkTableModel = new DefaultTableModel();
     DefaultTableModel UserTableModel = new DefaultTableModel();
     DefaultTableModel saleTableModel = new DefaultTableModel();
    /**
     * Creates new form AdminForm
     */
    public AdminPage() {
        initComponents();
        populateArtistIdComboBox();
        populateArtworkIdComboBox();
//Searching by Artist Name
        searchartistTextField.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void changedUpdate(DocumentEvent e) {
        search();
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        search();
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        search();
    }
    public void search() {
         searchAndUpdateTable();
    }
});
 //Searching by Artwork Title/name
        searchartworkTextField.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void changedUpdate(DocumentEvent e) {
        search();
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        search();
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        search();
    }
    public void search() {
         searchAndUpdateTableArtwork();
    }
});
//Searching by the user name
        searchuserTextField.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void changedUpdate(DocumentEvent e) {
        search();
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        search();
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        search();
    }
    public void search() {
         searchAndUpdateTableUser();
    }
});
//Searching by Sale id
        searchsaleTextField1.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void changedUpdate(DocumentEvent e) {
        search();
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        search();
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        search();
    }
    public void search() {
         searchAndUpdateTableSale();
    }
});
      

        
        
        artistIdTextField.setEditable(false);
       addArtistTableColumns();
       addArtistTableRowData();
          artworkidfield.setEditable(false);
       addArtworkTableColumns();
       addArtworkTableRowData(); 
        customerIdTextField.setEditable(false);
       addUserTableColumns();
       addUserTableRowData(); 
       saleIdTextField.setEditable(false);
       addSaleTableColumns();
       addSaleTableRowData(); 
    }
    private void addArtistTableColumns() {
    tableModel.addColumn("Artist ID");
    tableModel.addColumn("Name");
    tableModel.addColumn("Biography");
    tableModel.addColumn("Birth Year");
    tableModel.addColumn("Death Year");
    tableModel.addColumn("Nationality");
    artistTable.setModel(tableModel);
}
  private void addArtistTableRowData() {
    tableModel.setRowCount(0); 
    ArtistDAO artistDAO = new ArtistDAO();
    List<Artist> artists = artistDAO.getAllArtists();
    for (Artist artist : artists) {
        tableModel.addRow(new Object[]{
            artist.getArtistId(),
            artist.getName(),
            artist.getBiography(),
            artist.getBirthYear(),
            artist.getDeathYear(),
            artist.getNationality()
        });
    }
}
  
  private void addArtworkTableColumns() {
    artworkTableModel.addColumn("Artwork ID");
    artworkTableModel.addColumn("Title");
    artworkTableModel.addColumn("Artist ID");
    artworkTableModel.addColumn("Medium");
    artworkTableModel.addColumn("Year");
    artworkTableModel.addColumn("Price");
    artworkTableModel.addColumn("Status");
    artworkTable.setModel(artworkTableModel);
}
private void addArtworkTableRowData() {
    artworkTableModel.setRowCount(0); 
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    ArtworkDAO artworkDAO = new ArtworkDAO();
    List<Artwork> artworks = artworkDAO.getAllArtworks();
    for (Artwork artwork : artworks) {
        artworkTableModel.addRow(new Object[]{
            artwork.getArtworkId(),
            artwork.getTitle(),
            artwork.getArtistId(),
            artwork.getMedium(),
            artwork.getYear(),
            formatter.format(artwork.getPrice()),
            artwork.getStatus()
        });
    }
}

private void addUserTableColumns() {
    UserTableModel.addColumn("User ID");
    UserTableModel.addColumn("FullNames");
    UserTableModel.addColumn("Email");
    UserTableModel.addColumn("PhoneNumber");
    UserTableModel.addColumn("Address");
    UserTableModel.addColumn("Password");
    UserTableModel.addColumn("RoleId");
    userTable.setModel(UserTableModel);
}
private void addUserTableRowData() {
    UserTableModel.setRowCount(0); 
    CustomerDAO customerDAO = new CustomerDAO();
    List<Customer> customers = customerDAO.getAllCustomers();
    for (Customer customer : customers) {
        UserTableModel.addRow(new Object[]{
            customer.getCustomerId(),
            customer.getName(),
            customer.getEmail(),
            customer.getPhone(),
            customer.getAddress(),
            customer.getPassword(),
            customer.getRole_Id()
        });
    }
}

private void addSaleTableColumns() {
    saleTableModel.addColumn("Sale Id");
    saleTableModel.addColumn("Artwork Id");
    saleTableModel.addColumn("Customer Id");
    saleTableModel.addColumn("Sale Date");
    saleTableModel.addColumn("Price");
    saleTable.setModel(saleTableModel);
}
private void addSaleTableRowData() {
    saleTableModel.setRowCount(0); 
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    SaleDAO saleDAO = new SaleDAO();
    List<Sale> sales = saleDAO.getAllSales();
    for (Sale sale : sales) {
        saleTableModel.addRow(new Object[]{
            sale.getSaleId(),
            sale.getArtworkId(),
            sale.getCustomerId(),
           sale.getSaleDate(),
             formatter.format(sale.getPrice())
        });
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ArtistBtnAll = new javax.swing.JButton();
        ArtworksArtBtn = new javax.swing.JButton();
        UsersartBtn = new javax.swing.JButton();
        SalesartBtn = new javax.swing.JButton();
        logoutb = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        AdminPanel = new javax.swing.JPanel();
        ArtistsCard = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        artistIdTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        birthYearTextField = new javax.swing.JTextField();
        deathYearTextField = new javax.swing.JTextField();
        nationalityTextField = new javax.swing.JTextField();
        registerartistBtn = new javax.swing.JButton();
        updateartistBtn = new javax.swing.JButton();
        deleteartistBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        artistTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchartistTextField = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        bioTextField = new javax.swing.JTextArea();
        ArtworksCard = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        artworkidfield = new javax.swing.JTextField();
        titleTextField = new javax.swing.JTextField();
        mediumTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        registerartworkBtn = new javax.swing.JButton();
        updateartworkBtn = new javax.swing.JButton();
        deleteartworkBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        artworkTable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        searchartworkTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        StatusComboBox = new javax.swing.JComboBox<>();
        artistIdComboBox = new javax.swing.JComboBox<>();
        UsersCard = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        customerIdTextField = new javax.swing.JTextField();
        nameTextField1 = new javax.swing.JTextField();
        emailTextField1 = new javax.swing.JTextField();
        addressTextField1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        searchuserTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        registeruserBtn = new javax.swing.JButton();
        updateuserBtn = new javax.swing.JButton();
        deleteuserBtn = new javax.swing.JButton();
        phoneTextField1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        rolecombobox = new javax.swing.JComboBox<>();
        passwordField1 = new javax.swing.JPasswordField();
        SalesCard = new javax.swing.JPanel();
        saleIdTextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        pricesTextField = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        saleTable = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        searchsaleTextField1 = new javax.swing.JTextField();
        registersaleBtn = new javax.swing.JButton();
        updatesaleBtn = new javax.swing.JButton();
        deletesaleBtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        SaleDateChooser = new com.toedter.calendar.JDateChooser();
        artworkIdComboBox = new javax.swing.JComboBox<>();
        customerIdComboBox = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Page");
        setBackground(new java.awt.Color(102, 0, 204));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ArtistBtnAll.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        ArtistBtnAll.setText("Artists");
        ArtistBtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtistBtnAllActionPerformed(evt);
            }
        });
        jPanel1.add(ArtistBtnAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 47));

        ArtworksArtBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        ArtworksArtBtn.setText("Artworks");
        ArtworksArtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtworksArtBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ArtworksArtBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 50));

        UsersartBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        UsersartBtn.setText("Users");
        UsersartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersartBtnActionPerformed(evt);
            }
        });
        jPanel1.add(UsersartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 50));

        SalesartBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        SalesartBtn.setText("Sales");
        SalesartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesartBtnActionPerformed(evt);
            }
        });
        jPanel1.add(SalesartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 200, 50));

        logoutb.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        logoutb.setForeground(new java.awt.Color(255, 255, 255));
        logoutb.setText("Logout");
        logoutb.setBorder(null);
        logoutb.setContentAreaFilled(false);
        logoutb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbActionPerformed(evt);
            }
        });
        jPanel1.add(logoutb, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 470, -1, -1));

        jLabel37.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel37.setIcon(new javax.swing.ImageIcon("C:\\Users\\Adelain\\Desktop\\LYSE\\JAVA PROGRAMMING\\pic\\13.jpg")); // NOI18N
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 510));

        AdminPanel.setBackground(new java.awt.Color(204, 255, 255));
        AdminPanel.setLayout(new java.awt.CardLayout());

        ArtistsCard.setBackground(new java.awt.Color(204, 204, 255));
        ArtistsCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));
        ArtistsCard.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Artist Id");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Names");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Biography");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("Birth Year");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Death Year");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Nationality");

        registerartistBtn.setBackground(new java.awt.Color(102, 102, 255));
        registerartistBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registerartistBtn.setText("ADD");
        registerartistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerartistBtnActionPerformed(evt);
            }
        });

        updateartistBtn.setBackground(new java.awt.Color(0, 153, 204));
        updateartistBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updateartistBtn.setText("UPDATE");
        updateartistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateartistBtnActionPerformed(evt);
            }
        });

        deleteartistBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteartistBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        deleteartistBtn.setText("DELETE");
        deleteartistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteartistBtnActionPerformed(evt);
            }
        });

        artistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(artistTable);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("Search");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("<html><u>Artists</u></html>");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(402, 402, 402))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        bioTextField.setColumns(20);
        bioTextField.setRows(5);
        jScrollPane5.setViewportView(bioTextField);

        javax.swing.GroupLayout ArtistsCardLayout = new javax.swing.GroupLayout(ArtistsCard);
        ArtistsCard.setLayout(ArtistsCardLayout);
        ArtistsCardLayout.setHorizontalGroup(
            ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtistsCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(ArtistsCardLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ArtistsCardLayout.createSequentialGroup()
                            .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ArtistsCardLayout.createSequentialGroup()
                                    .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addGap(31, 31, 31))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtistsCardLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)))
                            .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(artistIdTextField)
                                .addComponent(nameTextField)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ArtistsCardLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(birthYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtistsCardLayout.createSequentialGroup()
                                .addComponent(registerartistBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateartistBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteartistBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ArtistsCardLayout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deathYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ArtistsCardLayout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(nationalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtistsCardLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(searchartistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        ArtistsCardLayout.setVerticalGroup(
            ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtistsCardLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(searchartistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(artistIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ArtistsCardLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ArtistsCardLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ArtistsCardLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(ArtistsCardLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtistsCardLayout.createSequentialGroup()
                                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(birthYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtistsCardLayout.createSequentialGroup()
                                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(deathYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)))
                        .addGap(14, 14, 14)
                        .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nationalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(27, 27, 27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateartistBtn)
                    .addComponent(deleteartistBtn)
                    .addComponent(registerartistBtn))
                .addGap(52, 52, 52))
        );

        AdminPanel.add(ArtistsCard, "Artists");

        ArtworksCard.setBackground(new java.awt.Color(204, 204, 255));
        ArtworksCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setText("Artwork Id");

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setText("Title");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setText("Artist Id");

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel16.setText("Medium");

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel17.setText("Year");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel18.setText("Price");

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel19.setText("Status");

        registerartworkBtn.setBackground(new java.awt.Color(102, 102, 255));
        registerartworkBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registerartworkBtn.setText("ADD");
        registerartworkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerartworkBtnActionPerformed(evt);
            }
        });

        updateartworkBtn.setBackground(new java.awt.Color(0, 153, 204));
        updateartworkBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updateartworkBtn.setText("UPDATE");
        updateartworkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateartworkBtnActionPerformed(evt);
            }
        });

        deleteartworkBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteartworkBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        deleteartworkBtn.setText("DELETE");
        deleteartworkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteartworkBtnActionPerformed(evt);
            }
        });

        artworkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(artworkTable);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel12.setText("<html><u>Artworks</u><</html>");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(433, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setText("Search");

        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "available", "sold", "on exhibition" }));

        artistIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout ArtworksCardLayout = new javax.swing.GroupLayout(ArtworksCard);
        ArtworksCard.setLayout(ArtworksCardLayout);
        ArtworksCardLayout.setHorizontalGroup(
            ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtworksCardLayout.createSequentialGroup()
                .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtworksCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ArtworksCardLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ArtworksCardLayout.createSequentialGroup()
                                .addComponent(registerartworkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateartworkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteartworkBtn))
                            .addGroup(ArtworksCardLayout.createSequentialGroup()
                                .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(titleTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mediumTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StatusComboBox, 0, 221, Short.MAX_VALUE)
                                    .addComponent(artworkidfield)
                                    .addComponent(artistIdComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(42, 42, 42)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ArtworksCardLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(searchartworkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ArtworksCardLayout.setVerticalGroup(
            ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtworksCardLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtworksCardLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(artworkidfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20))
                        .addGap(29, 29, 29)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(artistIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(mediumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerartworkBtn)
                            .addComponent(updateartworkBtn)
                            .addComponent(deleteartworkBtn)))
                    .addGroup(ArtworksCardLayout.createSequentialGroup()
                        .addComponent(searchartworkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        AdminPanel.add(ArtworksCard, "Artworks");

        UsersCard.setBackground(new java.awt.Color(204, 204, 255));
        UsersCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));
        UsersCard.setName(""); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel21.setText("<html><u>Users</u><</html>");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(433, 433, 433))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel22.setText("User Id");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel23.setText("Name");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel24.setText("Email");

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel25.setText("Phone Number");

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel26.setText("Address");

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel27.setText("Search");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(userTable);

        registeruserBtn.setBackground(new java.awt.Color(102, 102, 255));
        registeruserBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registeruserBtn.setText("ADD");
        registeruserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registeruserBtnActionPerformed(evt);
            }
        });

        updateuserBtn.setBackground(new java.awt.Color(0, 153, 204));
        updateuserBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updateuserBtn.setText("UPDATE");
        updateuserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateuserBtnActionPerformed(evt);
            }
        });

        deleteuserBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteuserBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        deleteuserBtn.setText("DELETE");
        deleteuserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteuserBtnActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel28.setText("Password");

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel29.setText("Role Id");

        rolecombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "7" }));

        javax.swing.GroupLayout UsersCardLayout = new javax.swing.GroupLayout(UsersCard);
        UsersCard.setLayout(UsersCardLayout);
        UsersCardLayout.setHorizontalGroup(
            UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(UsersCardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsersCardLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsersCardLayout.createSequentialGroup()
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UsersCardLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UsersCardLayout.createSequentialGroup()
                                .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(registeruserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(UsersCardLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(updateuserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(deleteuserBtn))
                                    .addGroup(UsersCardLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(phoneTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                            .addComponent(emailTextField1)
                                            .addComponent(nameTextField1)
                                            .addComponent(customerIdTextField)
                                            .addComponent(addressTextField1)
                                            .addComponent(rolecombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(passwordField1))))))
                        .addGap(39, 39, 39)))
                .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsersCardLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(searchuserTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        UsersCardLayout.setVerticalGroup(
            UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersCardLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsersCardLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(searchuserTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(UsersCardLayout.createSequentialGroup()
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(phoneTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(rolecombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(UsersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteuserBtn)
                            .addComponent(updateuserBtn)
                            .addComponent(registeruserBtn))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        AdminPanel.add(UsersCard, "Users");

        SalesCard.setBackground(new java.awt.Color(204, 204, 255));
        SalesCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel30.setText("Customer Id");

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel31.setText("Artwork Id");

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel32.setText("Sale Id");

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel33.setText("Sale Date");

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel34.setText("Sale Price");

        saleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(saleTable);

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel35.setText("Search");

        registersaleBtn.setBackground(new java.awt.Color(102, 102, 255));
        registersaleBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registersaleBtn.setText("ADD");
        registersaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registersaleBtnActionPerformed(evt);
            }
        });

        updatesaleBtn.setBackground(new java.awt.Color(0, 153, 204));
        updatesaleBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updatesaleBtn.setText("UPDATE");
        updatesaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatesaleBtnActionPerformed(evt);
            }
        });

        deletesaleBtn.setBackground(new java.awt.Color(255, 0, 0));
        deletesaleBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        deletesaleBtn.setText("DELETE");
        deletesaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletesaleBtnActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        jLabel36.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel36.setText("<html><u>Sales</u><</html>");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        artworkIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        artworkIdComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                artworkIdComboBoxItemStateChanged(evt);
            }
        });

        customerIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout SalesCardLayout = new javax.swing.GroupLayout(SalesCard);
        SalesCard.setLayout(SalesCardLayout);
        SalesCardLayout.setHorizontalGroup(
            SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(SalesCardLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalesCardLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(58, 58, 58)
                        .addComponent(saleIdTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalesCardLayout.createSequentialGroup()
                        .addComponent(registersaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updatesaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletesaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalesCardLayout.createSequentialGroup()
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pricesTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(SaleDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(SalesCardLayout.createSequentialGroup()
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalesCardLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18))
                            .addGroup(SalesCardLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(31, 31, 31)))
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(artworkIdComboBox, 0, 222, Short.MAX_VALUE)
                            .addComponent(customerIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalesCardLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(searchsaleTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalesCardLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        SalesCardLayout.setVerticalGroup(
            SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalesCardLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(searchsaleTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saleIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalesCardLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalesCardLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(artworkIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(customerIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(SaleDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pricesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(64, 64, 64)
                        .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registersaleBtn)
                            .addComponent(updatesaleBtn)
                            .addComponent(deletesaleBtn))))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        AdminPanel.add(SalesCard, "Sales");

        jPanel7.setBackground(new java.awt.Color(204, 255, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true)));

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel5.setFont(new java.awt.Font("Castellar", 1, 20)); // NOI18N
        jLabel5.setText("ART GALLERY MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 0, -1, 92));

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel6.setFont(new java.awt.Font("Castellar", 1, 20)); // NOI18N
        jLabel6.setText("Admin Page");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel7.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 98, -1, -1));

        jLabel38.setIcon(new javax.swing.ImageIcon("C:\\Users\\Adelain\\Desktop\\LYSE\\JAVA PROGRAMMING\\pic\\DALL·E 2023-11-11 00.59.58 - A high-definition image showcasing a collection of vibrant art supplies arranged on a bright green background. The scene includes several paintbrushes.png")); // NOI18N
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -3, 1200, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//LOGOUT TO REDIRECT TO LOGIN   
    private void logoutbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbActionPerformed
        setVisible(false);
        Login loginForm = new Login();
        loginForm.setVisible(true);
    }//GEN-LAST:event_logoutbActionPerformed

// DELETE ARTIST
    private void deleteartistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteartistBtnActionPerformed
        int selectedRow = artistTable.getSelectedRow();
        if(selectedRow >= 0) {
            int artistId = Integer.parseInt(artistTable.getValueAt(selectedRow, 0).toString());
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this artist?", "INFORMATION MESSAGE", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION) {
                ArtistDAO artistDAO = new ArtistDAO();
                String result = artistDAO.deleteArtist(artistId);
                JOptionPane.showMessageDialog(this, result);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an artist to delete.");
        }
        addArtistTableRowData();
    }//GEN-LAST:event_deleteartistBtnActionPerformed

//UPDATE ARTIST
    private void updateartistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateartistBtnActionPerformed
     int selectedRow = artistTable.getSelectedRow();
    if (!readyToUpdate) {
        if (selectedRow >= 0) {
            transferDataToTextFields(selectedRow);
            readyToUpdate = true; 
        } else {
            JOptionPane.showMessageDialog(this, "Please select an artist to update.");
        }
    } else {
        if (isArtistDataChanged(selectedRow)) {
            performArtistUpdate();
        } else {
            JOptionPane.showMessageDialog(this, "No changes detected. Please modify the fields before updating.", "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
        readyToUpdate = false;
    }
        }
 private boolean isArtistDataChanged(int selectedRow) {
    Object originalNameValue = artistTable.getValueAt(selectedRow, 1);
    Object originalBiographyValue = artistTable.getValueAt(selectedRow, 2);
    Object originalBirthYearValue = artistTable.getValueAt(selectedRow, 3);
    Object originalDeathYearValue = artistTable.getValueAt(selectedRow, 4);
    Object originalNationalityValue = artistTable.getValueAt(selectedRow, 5);

    String originalName = originalNameValue != null ? originalNameValue.toString() : "";
    String originalBiography = originalBiographyValue != null ? originalBiographyValue.toString() : "";
    String originalBirthYear = originalBirthYearValue != null ? originalBirthYearValue.toString() : "";
    String originalDeathYear = originalDeathYearValue != null ? originalDeathYearValue.toString() : "";
    String originalNationality = originalNationalityValue != null ? originalNationalityValue.toString() : "";

    String currentName = nameTextField.getText();
    String currentBiography = bioTextField.getText();
    String currentBirthYear = birthYearTextField.getText();
    String currentDeathYear = deathYearTextField.getText();
    String currentNationality = nationalityTextField.getText();

    return !originalName.equals(currentName) || !originalBiography.equals(currentBiography) ||
           !originalBirthYear.equals(currentBirthYear) || !originalDeathYear.equals(currentDeathYear) ||
           !originalNationality.equals(currentNationality);
}

        private void performArtistUpdate() {
            try {
                int artistId = Integer.parseInt(artistIdTextField.getText());
                String name = nameTextField.getText();
                String biography = bioTextField.getText();
                 Integer birthYear = null;
                 Integer deathYear = null;
                String nationality = nationalityTextField.getText();
                if (name.isEmpty() || nationality.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Nationality must not be empty.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
           if (!birthYearTextField.getText().isEmpty()) {
            birthYear = Integer.parseInt(birthYearTextField.getText());
        }
        if (!deathYearTextField.getText().isEmpty()) {
            deathYear = Integer.parseInt(deathYearTextField.getText());
        }
        if (birthYear != null && (birthYear < 1000 || birthYear > 2023)) {
            JOptionPane.showMessageDialog(this, "Invalid birth year, enter birth year between 1000 and 2023.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (deathYear != null && (deathYear < 1000 || deathYear > 2023)) {
            JOptionPane.showMessageDialog(this, "Invalid death year, enter death year between 1000 and 2023.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
                      Artist updatedArtist = new Artist(artistId, name, biography, birthYear, deathYear, nationality);
                ArtistDAO artistDAO = new ArtistDAO();
                String result = artistDAO.updateArtist(updatedArtist);
                JOptionPane.showMessageDialog(this, result, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                addArtistTableRowData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Birth Year, and Death Year.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error updating artist: " + ex.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            } resetArtistTextFields();
        }
        private void transferDataToTextFields(int selectedRow) {
          Object artistIdObj = artistTable.getValueAt(selectedRow, 0);
    Object birthYearObj = artistTable.getValueAt(selectedRow, 3);
    Object deathYearObj = artistTable.getValueAt(selectedRow, 4);
    int artistId = artistIdObj != null ? Integer.parseInt(artistIdObj.toString()) : -1;
    String name = artistTable.getValueAt(selectedRow, 1) != null ? artistTable.getValueAt(selectedRow, 1).toString() : "";
    String biography = artistTable.getValueAt(selectedRow, 2) != null ? artistTable.getValueAt(selectedRow, 2).toString() : "";
    Integer birthYear = birthYearObj != null ? Integer.parseInt(birthYearObj.toString()) : null;
    Integer deathYear = deathYearObj != null ? Integer.parseInt(deathYearObj.toString()) : null;
    String nationality = artistTable.getValueAt(selectedRow, 5) != null ? artistTable.getValueAt(selectedRow, 5).toString() : "";
    artistIdTextField.setText(artistId != -1 ? String.valueOf(artistId) : "");
    artistIdTextField.setEditable(false);
    nameTextField.setText(name);
    bioTextField.setText(biography);
    birthYearTextField.setText(birthYear != null ? String.valueOf(birthYear) : "");
    deathYearTextField.setText(deathYear != null ? String.valueOf(deathYear) : "");
            nationalityTextField.setText(nationality);
    }//GEN-LAST:event_updateartistBtnActionPerformed

//REGISTER ARTIST
    private void registerartistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerartistBtnActionPerformed
      String name = nameTextField.getText();
    String biography = bioTextField.getText();
    Integer birthYear = null;
    Integer deathYear = null;
    String nationality = nationalityTextField.getText();
    if (name.isEmpty() || nationality.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Name and Nationality must not be empty.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (biography.length() > 100) {
        JOptionPane.showMessageDialog(this, "Biography is too long. Please limit it to 100 characters.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    try {
        if (!birthYearTextField.getText().trim().isEmpty()) {
            birthYear = Integer.parseInt(birthYearTextField.getText());
        }
        if (!deathYearTextField.getText().trim().isEmpty()) {
            deathYear = Integer.parseInt(deathYearTextField.getText());
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid numbers for Birth Year and Death Year.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (birthYear != null && (birthYear < 1000 || birthYear > 2023)) {
        JOptionPane.showMessageDialog(this, "Invalid birth year, enter birth year between 1000 and 2023.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (deathYear != null && (deathYear < 1000 || deathYear > 2023)) {
        JOptionPane.showMessageDialog(this, "Invalid death year, enter death year between 1000 and 2023.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    Artist newArtist = new Artist(null, name, biography, birthYear, deathYear, nationality);
    ArtistDAO artistDAO = new ArtistDAO();
    String result = artistDAO.registerArtist(newArtist);     
    JOptionPane.showMessageDialog(this, result, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    addArtistTableRowData();
    resetArtistTextFields();
    }//GEN-LAST:event_registerartistBtnActionPerformed

//RESETTING ARTIST FIELDS AFTER INPUT FROM REGISTER AND UPDATE
    private boolean readyToUpdate = false; private void resetArtistTextFields() {
    artistIdTextField.setText("");
    nameTextField.setText("");
    bioTextField.setText("");
    birthYearTextField.setText("");
    deathYearTextField.setText("");
    nationalityTextField.setText("");
    }               

//REGISTER ARTWORK   
    private void populateArtistIdComboBox() {     
    ArtistDAO artistDAO = new ArtistDAO();
    List<Integer> artistIds = artistDAO.getAllArtistIds();
    artistIdComboBox.removeAllItems();
    for (Integer id : artistIds) {
        artistIdComboBox.addItem(id.toString());
    }
    }
    private void updateArtistIdComboBox() {
    artistIdComboBox.removeAllItems(); 
    ArtistDAO artistDAO = new ArtistDAO();
    List<Integer> artistIds = artistDAO.getAllArtistIds();
    for (Integer id : artistIds) {
        artistIdComboBox.addItem(id.toString());
    }
}
    private void registerartworkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerartworkBtnActionPerformed
    String title = titleTextField.getText();
    String artistIdStr = artistIdComboBox.getSelectedItem().toString();  
    String medium = mediumTextField.getText();
    String yearStr = yearTextField.getText();
    String priceStr = priceTextField.getText();
    String status = StatusComboBox.getSelectedItem().toString();
    if (title.isEmpty() || medium.isEmpty() || yearStr.isEmpty() || priceStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled in.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int artistId = Integer.parseInt(artistIdStr);
    int year;
    double price;
    try {
        year = Integer.parseInt(yearStr);
        price = Double.parseDouble(priceStr);
        if (year < 1000 || year > java.time.LocalDate.now().getYear()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid year between 1000 and the current year.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (price <= 0) {
            JOptionPane.showMessageDialog(this, "Price must be a positive number.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for Year and Price.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    Artwork newArtwork = new Artwork(null, title, artistId, medium, year, price, status); 
    ArtworkDAO artworkDAO = new ArtworkDAO();
    String result = artworkDAO.registerArtwork(newArtwork);
    JOptionPane.showMessageDialog(this, result, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    addArtworkTableRowData();
    resetArtworkTextFields();
    }//GEN-LAST:event_registerartworkBtnActionPerformed

 //UPDATE ARTWORK
    private void updateartworkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateartworkBtnActionPerformed
      int selectedRow = artworkTable.getSelectedRow();
    if (!readyToUpdateArtwork) {
        if (selectedRow >= 0) {
            transferArtworkDataToTextFields(selectedRow);
            readyToUpdateArtwork = true; 
        } else {
            JOptionPane.showMessageDialog(this, "Please select an artwork to update.");
        }
    } else {
        if (isArtworkDataChanged(selectedRow)) {
            performArtworkUpdate();
        } else {
            JOptionPane.showMessageDialog(this, "No changes detected. Please modify the fields before updating.", "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
        readyToUpdateArtwork = false;
    }
    }//GEN-LAST:event_updateartworkBtnActionPerformed
      private boolean isArtworkDataChanged(int selectedRow) {
    String originalTitle = artworkTable.getValueAt(selectedRow, 1).toString();
    int originalArtistId = Integer.parseInt(artworkTable.getValueAt(selectedRow, 2).toString());
    String originalMedium = artworkTable.getValueAt(selectedRow, 3).toString();
    int originalYear = Integer.parseInt(artworkTable.getValueAt(selectedRow, 4).toString());
    double originalPrice = Double.parseDouble(artworkTable.getValueAt(selectedRow, 5).toString().replaceAll("[^\\d.]", ""));
    String originalStatus = artworkTable.getValueAt(selectedRow, 6).toString();

    String currentTitle = titleTextField.getText();
    int currentArtistId = Integer.parseInt((String) artistIdComboBox.getSelectedItem());
    String currentMedium = mediumTextField.getText();
    int currentYear = Integer.parseInt(yearTextField.getText());
    String currentPriceStr = priceTextField.getText().replaceAll("[^\\d.]", "");
    double currentPrice = Double.parseDouble(currentPriceStr);
    String currentStatus = StatusComboBox.getSelectedItem().toString();

    return !originalTitle.equals(currentTitle) ||
           originalArtistId != currentArtistId ||
           !originalMedium.equals(currentMedium) ||
           originalYear != currentYear ||
           originalPrice != currentPrice ||
           !originalStatus.equals(currentStatus);
}
      private void performArtworkUpdate() {
         try {
        int artworkId = Integer.parseInt(artworkidfield.getText());
        String title = titleTextField.getText();
        int artistId = Integer.parseInt((String) artistIdComboBox.getSelectedItem());
        String medium = mediumTextField.getText();
        int year = Integer.parseInt(yearTextField.getText());
        String priceStr = priceTextField.getText().replaceAll("[^\\d.]", "");
        double price = Double.parseDouble(priceStr);
        String status = StatusComboBox.getSelectedItem().toString(); 
        String yearStr = yearTextField.getText();
         if (title.isEmpty() || medium.isEmpty() || yearStr.isEmpty() || priceStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled in.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
        if (year < 1000 || year > java.time.LocalDate.now().getYear()) {
            JOptionPane.showMessageDialog(this, "Year must be between 1000 and the current year.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (price <= 0) {
            JOptionPane.showMessageDialog(this, "Price must be a positive number.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Artwork updatedArtwork = new Artwork(artworkId, title, artistId, medium, year, price, status);
        ArtworkDAO artworkDAO = new ArtworkDAO();
        String result = artworkDAO.updateArtwork(updatedArtwork);
        JOptionPane.showMessageDialog(this, result, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        addArtworkTableRowData();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for Year and Price.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error updating artwork: " + ex.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }
    resetArtworkTextFields(); 
     }
       private void transferArtworkDataToTextFields(int selectedRow) {
        int artworkId = Integer.parseInt(artworkTable.getValueAt(selectedRow, 0).toString());
        String title = artworkTable.getValueAt(selectedRow, 1).toString();
        int artistidart = Integer.parseInt(artworkTable.getValueAt(selectedRow, 2).toString());
        String artistIdartString = String.valueOf(artistidart);
        String medium = artworkTable.getValueAt(selectedRow, 3).toString();
        int year = Integer.parseInt(artworkTable.getValueAt(selectedRow, 4).toString());
          String priceStr = artworkTable.getValueAt(selectedRow, 5).toString().replaceAll("[^\\d.]", "");
          double price = Double.parseDouble(priceStr);
        String status = artworkTable.getValueAt(selectedRow, 6).toString();
        artworkidfield.setText(String.valueOf(artworkId));
        titleTextField.setText(title);
        artistIdComboBox.setSelectedItem(artistIdartString); 
        mediumTextField.setText(medium);
        yearTextField.setText(String.valueOf(year));
        priceTextField.setText(String.format("%.2f", price));
        StatusComboBox.setSelectedItem(status);
     }

//DELETE ARTWORK       
    private void deleteartworkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteartworkBtnActionPerformed
    int selectedRow = artworkTable.getSelectedRow();   
    if (selectedRow >= 0) {
        int artworkId = Integer.parseInt(artworkTable.getValueAt(selectedRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete this artwork?", 
                "INFORMATION MESSAGE", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            ArtworkDAO artworkDAO = new ArtworkDAO();
            String result = artworkDAO.deleteArtwork(artworkId);
            JOptionPane.showMessageDialog(this, result);
            addArtworkTableRowData();
        }
    } else {
        JOptionPane.showMessageDialog(this, 
                "Please select an artwork to delete.", 
                "ERROR MESSAGE", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_deleteartworkBtnActionPerformed

//RESETTING ARTWORK FIELDS AFTER INPUT FROM REGISTER AND UPDATE
     private boolean readyToUpdateArtwork = false; private void resetArtworkTextFields() {
     artworkidfield.setText("");
     titleTextField.setText("");
     artistIdComboBox.setSelectedItem("");
     mediumTextField.setText("");
     yearTextField.setText("");
     priceTextField.setText("");
     StatusComboBox.setSelectedItem("");
}

//REGISTER CUSTOMER OR AN ADMIN DONE BY ADMIN     
    private void registeruserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registeruserBtnActionPerformed
  String name = nameTextField1.getText();
    String email = emailTextField1.getText();
    String phone = phoneTextField1.getText();
    String address = addressTextField1.getText();
    String password = passwordField1.getText();
    int roleid = Integer.parseInt(rolecombobox.getSelectedItem().toString());
    if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields must be filled in.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!phone.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(null, "Phone number must be exactly 10 digits.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
   if (password.length() < 3) {
        JOptionPane.showMessageDialog(null, "Password must be at least 3 characters long.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
    Customer newCustomer = new Customer(null, name, email, phone, address, password, roleid); 
    CustomerDAO customerDAO = new CustomerDAO();
    String resultMessage = customerDAO.registerUsers(newCustomer);
    JOptionPane.showMessageDialog(null, resultMessage, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    addUserTableRowData();
    resetuserTextFields();
    }//GEN-LAST:event_registeruserBtnActionPerformed

//UPDATE CUSTOMER OR ADMIN DONE BY ADMIN     
    private void updateuserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateuserBtnActionPerformed
        int selectedRow = userTable.getSelectedRow();
    if (!readyToUpdateCustomer) {
        if (selectedRow >= 0) {
            transferUserDataToTextFields(selectedRow);
            readyToUpdateCustomer = true; 
        } else {
            JOptionPane.showMessageDialog(this, "Please select a user to update.");
        }
    } else {
        performUserUpdate();
        readyToUpdateCustomer = false;
    }
    }//GEN-LAST:event_updateuserBtnActionPerformed
private boolean isUserDataChanged(int selectedRow) {
    String originalName = userTable.getValueAt(selectedRow, 1).toString();
    String originalEmail = userTable.getValueAt(selectedRow, 2).toString();
    String originalPhone = userTable.getValueAt(selectedRow, 3).toString();
    String originalAddress = userTable.getValueAt(selectedRow, 4).toString();
    String originalPassword = userTable.getValueAt(selectedRow, 5).toString();
    int originalRoleid = Integer.parseInt(userTable.getValueAt(selectedRow, 6).toString());

    String currentName = nameTextField1.getText();
    String currentEmail = emailTextField1.getText();
    String currentPhone = phoneTextField1.getText();
    String currentAddress = addressTextField1.getText();
    String currentPassword = passwordField1.getText();
    int currentRoleid = Integer.parseInt((String) rolecombobox.getSelectedItem());

    return !originalName.equals(currentName) || !originalEmail.equals(currentEmail) ||
           !originalPhone.equals(currentPhone) || !originalAddress.equals(currentAddress) ||
           !originalPassword.equals(currentPassword) || originalRoleid != currentRoleid;
}

    private void transferUserDataToTextFields(int selectedRow) {
    int customerId = Integer.parseInt(userTable.getValueAt(selectedRow, 0).toString());
    String name = userTable.getValueAt(selectedRow, 1).toString();
    String email = userTable.getValueAt(selectedRow, 2).toString();
    String phone = userTable.getValueAt(selectedRow, 3).toString();
    String address = userTable.getValueAt(selectedRow, 4).toString();
    String password = userTable.getValueAt(selectedRow, 5).toString();
    int roleid = Integer.parseInt(userTable.getValueAt(selectedRow, 6).toString());
    customerIdTextField.setText(String.valueOf(customerId));
    nameTextField1.setText(name);
    emailTextField1.setText(email);
    phoneTextField1.setText(phone);
    addressTextField1.setText(address);
    passwordField1.setText(password);
    rolecombobox.setSelectedItem(roleid);
}
private void performUserUpdate() {
    try {
        int customerId = Integer.parseInt(customerIdTextField.getText());
        String name = nameTextField1.getText();
        String email = emailTextField1.getText();
        String phone = phoneTextField1.getText();
        String address = addressTextField1.getText();
        String password = passwordField1.getText();
        int roleid = Integer.parseInt((String) rolecombobox.getSelectedItem());
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled in.", "VALIDATION MEESAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone number must be exactly 10 digits.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
         if (password.length() < 3) {
        JOptionPane.showMessageDialog(null, "Password must be at least 3 characters long.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
        Customer updatedCustomer = new Customer(customerId, name, email, phone, address, password, roleid); 
        CustomerDAO customerDAO = new CustomerDAO();
        String result = customerDAO.updateUser(updatedCustomer);
        JOptionPane.showMessageDialog(this, result, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);   
        addUserTableRowData();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please check that all fields have valid information.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error updating User: " + ex.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }
    resetuserTextFields(); 
}

//DELETE CUSTOMER OR AN ADMIN DONE BY ADMIN    
    private void deleteuserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteuserBtnActionPerformed
        int selectedRow = userTable.getSelectedRow();
         if(selectedRow >= 0) {
        int customerId = Integer.parseInt(userTable.getValueAt(selectedRow, 0).toString()); 
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "INFORMATION MESSAGE", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
        CustomerDAO customerDAO = new CustomerDAO();
        String result = customerDAO.deleteCustomer(customerId);
        JOptionPane.showMessageDialog(this, result);
        }
         } else {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
        }
        addUserTableRowData();
    
    }//GEN-LAST:event_deleteuserBtnActionPerformed

//RESETTING CUSTOMER OR AN ADMIN FIELDS AFTER INPUT FROM REGISTER AND UPDATE    
private boolean readyToUpdateCustomer = false; private void resetuserTextFields() {
    customerIdTextField.setText("");
    nameTextField1.setText("");
    emailTextField1.setText("");
    phoneTextField1.setText("");
    addressTextField1.setText("");
    passwordField1.setText("");
    rolecombobox.setSelectedItem("");
    
}

//SEARCH ARTIST BY NAME
   private void searchAndUpdateTable() {
    String searchText = searchartistTextField.getText().trim();
    ArtistDAO artistDAO = new ArtistDAO();
    List<Artist> searchResults = artistDAO.searchArtistsByName(searchText);
    updateArtistTable(searchResults);
}  
    private void updateArtistTable(List<Artist> artists) {
    DefaultTableModel model = (DefaultTableModel) artistTable.getModel();
    model.setRowCount(0); 
    if (artists.isEmpty()) {
        model.addRow(new Object[]{"No artist found"});
    } else {
        for (Artist artist : artists) {
            model.addRow(new Object[]{
                artist.getArtistId(),
                artist.getName(),
                artist.getBiography(),
                artist.getBirthYear(),
                artist.getDeathYear(),
                artist.getNationality()
            });
        }
    }
}
    
//SEARCH ARTWORK BY NAME
   private void searchAndUpdateTableArtwork() {
    String searchText = searchartworkTextField.getText().trim();
    ArtworkDAO artworkDAO = new ArtworkDAO();
    List<Artwork> searchResults = artworkDAO.searchArtworksByTitle(searchText);
    updateArtworkTable(searchResults);
}  
    private void updateArtworkTable(List<Artwork> artworks) {
    DefaultTableModel model = (DefaultTableModel) artworkTable.getModel();
    model.setRowCount(0); 
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    if (artworks.isEmpty()) {
        model.addRow(new Object[]{"No artwork found"});
    } else {
        for (Artwork artwork : artworks) {
            model.addRow(new Object[]{
            artwork.getArtworkId(),
            artwork.getTitle(),
            artwork.getArtistId(),
            artwork.getMedium(),
            artwork.getYear(),
            formatter.format(artwork.getPrice()),
            artwork.getStatus()
            });
        }
    }
}   

//SEARCH USER BY NAME
   private void searchAndUpdateTableUser() {
    String searchText1 = searchuserTextField.getText().trim();
    CustomerDAO customerDAO = new CustomerDAO();
    List<Customer> searchResults1 = customerDAO.searchCustomersByName(searchText1);
    updateUserTable(searchResults1);
}  
    private void updateUserTable(List<Customer> customers) {
    DefaultTableModel model = (DefaultTableModel) userTable.getModel();
    model.setRowCount(0); 
    if (customers.isEmpty()) {
        model.addRow(new Object[]{"No user found"});
    } else {
        for (Customer customer : customers) {
            model.addRow(new Object[]{
            customer.getCustomerId(),
            customer.getName(),
            customer.getEmail(),
            customer.getPhone(),
            customer.getAddress(),
            customer.getPassword(),
            customer.getRole_Id()
            });
        }
    }
}           

//REGISTER SALE   
    private void populateArtworkIdComboBox() {     
    ArtworkDAO artworkDAO = new ArtworkDAO();
    List<Integer> artworkIds = artworkDAO.getAllArtworkIds(); 
    artworkIdComboBox.removeAllItems();
    for (Integer id : artworkIds) {
        artworkIdComboBox.addItem(id.toString());
    }
}
   private void updateArtworkIdComboBox() {
    artworkIdComboBox.removeAllItems(); 
    ArtworkDAO artworkDAO = new ArtworkDAO();
    List<Integer> artworkIds = artworkDAO.getAllArtworkIds(); 
    for (Integer id : artworkIds) {
        artworkIdComboBox.addItem(id.toString());
    }
} 
private void populateCustomerIdComboBox() {     
    CustomerDAO customerDAO = new CustomerDAO();
    List<Integer> customerIds = customerDAO.getAllCustomerIds();
    customerIdComboBox.removeAllItems();
    for (Integer id : customerIds) {
        customerIdComboBox.addItem(id.toString());
    }
}
private void updateCustomerIdComboBox() {
    customerIdComboBox.removeAllItems(); 
    CustomerDAO customerDAO = new CustomerDAO();
    List<Integer> customerIds = customerDAO.getAllCustomerIds();
    for (Integer id : customerIds) {
        customerIdComboBox.addItem(id.toString());
    }
}

    private void registersaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registersaleBtnActionPerformed
    int artworkId = Integer.parseInt((String) artworkIdComboBox.getSelectedItem());
    int customerId = Integer.parseInt((String) customerIdComboBox.getSelectedItem());
      java.util.Date utilDate = SaleDateChooser.getDate();
    double price = Double.parseDouble(pricesTextField.getText());
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    Sale newSale = new Sale(null, artworkId, customerId, sqlDate, price);
    SaleDAO saleDAO = new SaleDAO();
    String result = saleDAO.registerSale(newSale);
    JOptionPane.showMessageDialog(this, result, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
     addSaleTableRowData();
     resetSaleTextFields();
    }//GEN-LAST:event_registersaleBtnActionPerformed

//UPDATE SALE
    private void updatesaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatesaleBtnActionPerformed
    int selectedRow = saleTable.getSelectedRow();
    if (!readyToUpdateSale) {
        if (selectedRow >= 0) {
            transferSaleDataToTextFields(selectedRow);
            readyToUpdateSale = true; 
        } else {
            JOptionPane.showMessageDialog(this, "Please select a sale to update.");
        }
    } else {
        performSaleUpdate();
        readyToUpdateSale = false;
    }
    }//GEN-LAST:event_updatesaleBtnActionPerformed
    private boolean isSaleDataChanged(int selectedRow) {
    int originalArtworkId = Integer.parseInt(saleTable.getValueAt(selectedRow, 1).toString());
    int originalCustomerId = Integer.parseInt(saleTable.getValueAt(selectedRow, 2).toString());
    Date originalSaleDate = (Date) saleTable.getValueAt(selectedRow, 3);
    String originalPriceString = saleTable.getValueAt(selectedRow, 4).toString().replace(",", "");
    double originalPrice = Double.parseDouble(originalPriceString);

    int currentArtworkId = Integer.parseInt((String) artworkIdComboBox.getSelectedItem());
    int currentCustomerId = Integer.parseInt((String) customerIdComboBox.getSelectedItem());
    java.util.Date currentUtilDate = SaleDateChooser.getDate();
    java.sql.Date currentSqlDate = new java.sql.Date(currentUtilDate.getTime());
    double currentPrice = Double.parseDouble(pricesTextField.getText());

    return originalArtworkId != currentArtworkId || 
           originalCustomerId != currentCustomerId || 
           !originalSaleDate.equals(currentSqlDate) || 
           originalPrice != currentPrice;
}

    private void performSaleUpdate() {
     int selectedRow = saleTable.getSelectedRow();
    if (!isSaleDataChanged(selectedRow)) {
        JOptionPane.showMessageDialog(this, "No changes detected. Please modify the fields before updating.", "INFORMATON MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
        try {
        int saleId = Integer.parseInt(saleIdTextField.getText());
        int artworkId = Integer.parseInt((String) artworkIdComboBox.getSelectedItem());
        int customerId = Integer.parseInt((String) customerIdComboBox.getSelectedItem());
        java.util.Date utilDate = SaleDateChooser.getDate();
        double price = Double.parseDouble(pricesTextField.getText());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Sale updatedSale = new Sale(saleId, artworkId, customerId, sqlDate, price);
        SaleDAO saleDAO = new SaleDAO();
        String result = saleDAO.updateSale(updatedSale);
        JOptionPane.showMessageDialog(this, result, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        addSaleTableRowData();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for Sale ID, Artwork ID, Customer ID, and Price.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    } catch (DateTimeParseException ex) {
        JOptionPane.showMessageDialog(this, "Please enter a valid date in the format YYYY-MM-DD.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error updating sale: " + ex.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    } 
    resetSaleTextFields();
  }
   private void transferSaleDataToTextFields(int selectedRow) {
    int saleId = Integer.parseInt(saleTable.getValueAt(selectedRow, 0).toString());
    int artworkId = Integer.parseInt(saleTable.getValueAt(selectedRow, 1).toString());
    int customerId = Integer.parseInt(saleTable.getValueAt(selectedRow, 2).toString());
    String artworkIdString = String.valueOf(artworkId);
    String customerIdString = String.valueOf(customerId);
    Date saleDate = (Date) saleTable.getValueAt(selectedRow, 3);
    String priceString = saleTable.getValueAt(selectedRow, 4).toString();
   priceString = priceString.replace(",", ""); // Remove commas
   double price = Double.parseDouble(priceString);
    saleIdTextField.setText(String.valueOf(saleId));
    artworkIdComboBox.setSelectedItem(artworkIdString);
    customerIdComboBox.setSelectedItem(customerIdString);
    SaleDateChooser.setDate(saleDate);
    pricesTextField.setText(String.format("%.2f", price)); 
  }

//DELETE SALE
    private void deletesaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletesaleBtnActionPerformed
     int selectedRow = saleTable.getSelectedRow();
    if (selectedRow >= 0) {
        int saleId = Integer.parseInt(saleTable.getValueAt(selectedRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this sale?", "INFORMATION MESSAGE", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            SaleDAO saleDAO = new SaleDAO();
            String result = saleDAO.deleteSale(saleId);
            JOptionPane.showMessageDialog(this, result);
            addSaleTableRowData();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a sale to delete.");
    }
    }//GEN-LAST:event_deletesaleBtnActionPerformed

// ARTIST,ARTWORK,SALES AND USERS CARDLAYOUT
    private void ArtistBtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistBtnAllActionPerformed
        CardLayout cardLayout = (CardLayout) AdminPanel.getLayout();
        cardLayout.show(AdminPanel, "Artists");
    }//GEN-LAST:event_ArtistBtnAllActionPerformed

    private void ArtworksArtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtworksArtBtnActionPerformed
        CardLayout cardLayout = (CardLayout) AdminPanel.getLayout();
        cardLayout.show(AdminPanel, "Artworks");
        updateArtistIdComboBox();
    }//GEN-LAST:event_ArtworksArtBtnActionPerformed

    private void UsersartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersartBtnActionPerformed
        CardLayout cardLayout = (CardLayout) AdminPanel.getLayout();
        cardLayout.show(AdminPanel, "Users");
    }//GEN-LAST:event_UsersartBtnActionPerformed

    private void SalesartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesartBtnActionPerformed
        CardLayout cardLayout = (CardLayout) AdminPanel.getLayout();
        cardLayout.show(AdminPanel, "Sales");
        updateArtworkIdComboBox();
        updateCustomerIdComboBox();
    }//GEN-LAST:event_SalesartBtnActionPerformed

    private void artworkIdComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_artworkIdComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
        Object selectedItem = artworkIdComboBox.getSelectedItem();
        if (selectedItem != null) {
            int selectedArtworkId = Integer.parseInt(selectedItem.toString());
            updateSalePriceField(selectedArtworkId);
        }
    }
    }//GEN-LAST:event_artworkIdComboBoxItemStateChanged
private void updateSalePriceField(int artworkId) {
    ArtworkDAO artworkDAO = new ArtworkDAO();
    double price = artworkDAO.getArtworkPrice(artworkId);
    pricesTextField.setText(String.format("%.2f", price));
    pricesTextField.setEditable(false);
}

//RESETTING Sale FIELDS AFTER INPUT FROM REGISTER AND UPDATE
private boolean readyToUpdateSale = false;private void resetSaleTextFields() {
    saleIdTextField.setText("");
    artworkIdComboBox.setSelectedItem("");
    customerIdComboBox.setSelectedItem("");
    SaleDateChooser.setDate(null); 
    pricesTextField.setText("");
}

// SEARCH SALE BY ID
private void searchAndUpdateTableSale() {
    String searchText = searchsaleTextField1.getText().trim();
    SaleDAO saleDAO = new SaleDAO();
    List<Sale> searchResults = saleDAO.searchSaleById(searchText);
    updateSaleTable(searchResults);
}
private void updateSaleTable(List<Sale> sales) {
    DefaultTableModel model = (DefaultTableModel) saleTable.getModel();
    model.setRowCount(0);
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    if (sales.isEmpty()) {
        model.addRow(new Object[]{"No sale found"});
    } else {
        for (Sale sale : sales) {
            model.addRow(new Object[]{
                sale.getSaleId(),
                sale.getArtworkId(),
                sale.getCustomerId(),
                sale.getSaleDate().toString(),
                formatter.format(sale.getPrice())
            });
        }
    }
}

     
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminPanel;
    private javax.swing.JButton ArtistBtnAll;
    private javax.swing.JPanel ArtistsCard;
    private javax.swing.JButton ArtworksArtBtn;
    private javax.swing.JPanel ArtworksCard;
    private com.toedter.calendar.JDateChooser SaleDateChooser;
    private javax.swing.JPanel SalesCard;
    private javax.swing.JButton SalesartBtn;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JPanel UsersCard;
    private javax.swing.JButton UsersartBtn;
    private javax.swing.JTextField addressTextField1;
    private javax.swing.JComboBox<String> artistIdComboBox;
    private javax.swing.JTextField artistIdTextField;
    private javax.swing.JTable artistTable;
    private javax.swing.JComboBox<String> artworkIdComboBox;
    private javax.swing.JTable artworkTable;
    private javax.swing.JTextField artworkidfield;
    private javax.swing.JTextArea bioTextField;
    private javax.swing.JTextField birthYearTextField;
    private javax.swing.JComboBox<String> customerIdComboBox;
    private javax.swing.JTextField customerIdTextField;
    private javax.swing.JTextField deathYearTextField;
    private javax.swing.JButton deleteartistBtn;
    private javax.swing.JButton deleteartworkBtn;
    private javax.swing.JButton deletesaleBtn;
    private javax.swing.JButton deleteuserBtn;
    private javax.swing.JTextField emailTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton logoutb;
    private javax.swing.JTextField mediumTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField nameTextField1;
    private javax.swing.JTextField nationalityTextField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JTextField phoneTextField1;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTextField pricesTextField;
    private javax.swing.JButton registerartistBtn;
    private javax.swing.JButton registerartworkBtn;
    private javax.swing.JButton registersaleBtn;
    private javax.swing.JButton registeruserBtn;
    private javax.swing.JComboBox<String> rolecombobox;
    private javax.swing.JTextField saleIdTextField;
    private javax.swing.JTable saleTable;
    private javax.swing.JTextField searchartistTextField;
    private javax.swing.JTextField searchartworkTextField;
    private javax.swing.JTextField searchsaleTextField1;
    private javax.swing.JTextField searchuserTextField;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JButton updateartistBtn;
    private javax.swing.JButton updateartworkBtn;
    private javax.swing.JButton updatesaleBtn;
    private javax.swing.JButton updateuserBtn;
    private javax.swing.JTable userTable;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables

 
}
