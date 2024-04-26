
package view;

import DAO.*;
import java.awt.CardLayout;
import java.text.DecimalFormat;
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
public class CustomerPage extends javax.swing.JFrame {
     private int customerId;
     DefaultTableModel tableModel = new DefaultTableModel();
     DefaultTableModel artworkTableModel = new DefaultTableModel();
     DefaultTableModel customerTableModel = new DefaultTableModel();
     DefaultTableModel saleTableModel = new DefaultTableModel();
    /**
     * Creates new form AdminForm
     */
    public CustomerPage(int customerId) {
        initComponents();
        this.customerId = customerId;
        displayLoggedInCustomerDetails();
        loadCustomerSales();
    
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
 //Searching by Artwork Which are Available by status
        searchavailableartworkTextField.getDocument().addDocumentListener(new DocumentListener() {
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
         searchAndUpdateTableArtworkAvailable();
    }
});


             
       addArtistTableColumns();
       addArtistTableRowData();
       addArtworkTableColumns();
       addArtworkTableRowData(); 
       customerIdTextField.setEditable(false);
       addCustomerTableColumns();
       displayLoggedInCustomerDetails();
       addSaleTableColumns();
       addSaleTableRowData(); 
    }

    private CustomerPage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

private void addCustomerTableColumns() {
    customerTableModel.addColumn("Customer ID");
    customerTableModel.addColumn("FullNames");
    customerTableModel.addColumn("Email");
    customerTableModel.addColumn("PhoneNumber");
    customerTableModel.addColumn("Address");
    customerTableModel.addColumn("Password");
    customerTable.setModel(customerTableModel);
}
private void displayLoggedInCustomerDetails() {
    customerTableModel.setRowCount(0);
    CustomerDAO customerDAO = new CustomerDAO();
    Customer customer = customerDAO.getCustomerById(customerId);
    DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
    if (customer != null) {
       customerTableModel.addRow(new Object[]{
            customer.getCustomerId(),
            customer.getName(),
            customer.getEmail(),
            customer.getPhone(),
            customer.getAddress(),    
            customer.getPassword()
        });
    }

}

private void addSaleTableColumns() {
    saleTableModel.addColumn("Artwork ID");
    saleTableModel.addColumn("Title");
    saleTableModel.addColumn("Artist ID");
    saleTableModel.addColumn("Medium");
    saleTableModel.addColumn("Year");
    saleTableModel.addColumn("Price");
    saleTableModel.addColumn("Status");
    artworkavailableTable.setModel(saleTableModel);
}
private void addSaleTableRowData() {
    saleTableModel.setRowCount(0); 
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    ArtworkDAO artworkDAO = new ArtworkDAO();
    List<Artwork> artworkss = artworkDAO.getAllAvailableArtworks();
    for (Artwork artwork : artworkss) {
        saleTableModel.addRow(new Object[]{
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
        CustomersartBtn = new javax.swing.JButton();
        SalesartBtn = new javax.swing.JButton();
        logoutb = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        CustomerPanel = new javax.swing.JPanel();
        ArtistsCard = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        artistTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchartistTextField = new javax.swing.JTextField();
        ArtworksCard = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        artworkTable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        searchartworkTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        CustomersCard = new javax.swing.JPanel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        updatecustomerBtn1 = new javax.swing.JButton();
        phoneTextField1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordField1 = new javax.swing.JPasswordField();
        SalesCard = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        artworkavailableTable = new javax.swing.JTable();
        buyArtworkBtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        searchavailableartworkTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        saleDetailsAreas = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
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

        CustomersartBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        CustomersartBtn.setText("Customer");
        CustomersartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersartBtnActionPerformed(evt);
            }
        });
        jPanel1.add(CustomersartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 50));

        SalesartBtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        SalesartBtn.setText("Buy");
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

        CustomerPanel.setBackground(new java.awt.Color(204, 255, 255));
        CustomerPanel.setLayout(new java.awt.CardLayout());

        ArtistsCard.setBackground(new java.awt.Color(204, 204, 255));
        ArtistsCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));
        ArtistsCard.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

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

        javax.swing.GroupLayout ArtistsCardLayout = new javax.swing.GroupLayout(ArtistsCard);
        ArtistsCard.setLayout(ArtistsCardLayout);
        ArtistsCardLayout.setHorizontalGroup(
            ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtistsCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtistsCardLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(ArtistsCardLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ArtistsCardLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(searchartistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ArtistsCardLayout.setVerticalGroup(
            ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtistsCardLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(ArtistsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(searchartistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        CustomerPanel.add(ArtistsCard, "Artists");

        ArtworksCard.setBackground(new java.awt.Color(204, 204, 255));
        ArtworksCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

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
                .addContainerGap(439, Short.MAX_VALUE)
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

        javax.swing.GroupLayout ArtworksCardLayout = new javax.swing.GroupLayout(ArtworksCard);
        ArtworksCard.setLayout(ArtworksCardLayout);
        ArtworksCardLayout.setHorizontalGroup(
            ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtworksCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ArtworksCardLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ArtworksCardLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchartworkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ArtworksCardLayout.setVerticalGroup(
            ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtworksCardLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(ArtworksCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchartworkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        CustomerPanel.add(ArtworksCard, "Artworks");

        CustomersCard.setBackground(new java.awt.Color(204, 204, 255));
        CustomersCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));
        CustomersCard.setName(""); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel21.setText("<html><u>Customer</u><</html>");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel22.setText("Customer Id");

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel23.setText("Name");

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel24.setText("Email");

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel25.setText("Phone Number");

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel26.setText("Address");

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(customerTable);

        updatecustomerBtn1.setBackground(new java.awt.Color(0, 153, 204));
        updatecustomerBtn1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updatecustomerBtn1.setText("UPDATE");
        updatecustomerBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatecustomerBtn1ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel28.setText("Password");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Customer Details");

        javax.swing.GroupLayout CustomersCardLayout = new javax.swing.GroupLayout(CustomersCard);
        CustomersCard.setLayout(CustomersCardLayout);
        CustomersCardLayout.setHorizontalGroup(
            CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomersCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(CustomersCardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomersCardLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CustomersCardLayout.createSequentialGroup()
                        .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CustomersCardLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CustomersCardLayout.createSequentialGroup()
                                .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(17, 17, 17)
                                .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(emailTextField1)
                                    .addComponent(nameTextField1)
                                    .addComponent(customerIdTextField)
                                    .addComponent(addressTextField1)
                                    .addGroup(CustomersCardLayout.createSequentialGroup()
                                        .addComponent(updatecustomerBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(passwordField1))))
                        .addGap(39, 39, 39)))
                .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CustomersCardLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel2)))
                .addGap(16, 16, 16))
        );
        CustomersCardLayout.setVerticalGroup(
            CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomersCardLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomersCardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(CustomersCardLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)))
                .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(phoneTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(CustomersCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(updatecustomerBtn1)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        CustomerPanel.add(CustomersCard, "Customers");

        SalesCard.setBackground(new java.awt.Color(204, 204, 255));
        SalesCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        artworkavailableTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(artworkavailableTable);

        buyArtworkBtn.setBackground(new java.awt.Color(102, 102, 255));
        buyArtworkBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buyArtworkBtn.setText("BUY");
        buyArtworkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyArtworkBtnActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        jLabel36.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel36.setText("<html><u>Orders</u><</html>");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
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

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel27.setText("Search All Available Artworks");

        saleDetailsAreas.setColumns(20);
        saleDetailsAreas.setRows(5);
        saleDetailsAreas.setName("saleDetailsAreas"); // NOI18N
        jScrollPane6.setViewportView(saleDetailsAreas);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Artworks Placed For Order");

        javax.swing.GroupLayout SalesCardLayout = new javax.swing.GroupLayout(SalesCard);
        SalesCard.setLayout(SalesCardLayout);
        SalesCardLayout.setHorizontalGroup(
            SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(SalesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalesCardLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(searchavailableartworkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28))
            .addGroup(SalesCardLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(buyArtworkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SalesCardLayout.setVerticalGroup(
            SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalesCardLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchavailableartworkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(SalesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buyArtworkBtn)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        CustomerPanel.add(SalesCard, "Sales");

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
        jLabel6.setText("CUSTOMER Page");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel6)
                .addContainerGap(74, Short.MAX_VALUE))
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
                .addComponent(CustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
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
         
//UPDATE CUSTOMER DONE BY CUSTOMER    
    private void updatecustomerBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatecustomerBtn1ActionPerformed
    int selectedRow = customerTable.getSelectedRow();
    if (!readyToUpdateCustomer) {
        if (selectedRow >= 0) {
            transferCustomerDataToTextFields(selectedRow);
            readyToUpdateCustomer = true; 
        } else {
            JOptionPane.showMessageDialog(this, "Please select your details to update.");
        }
    } else {
        if (isDataChanged(selectedRow)) {
            performCustomerUpdate();
        } else {
            JOptionPane.showMessageDialog(this, "No changes detected. Please modify the fields before updating.", "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
        readyToUpdateCustomer = false;
    }
    }//GEN-LAST:event_updatecustomerBtn1ActionPerformed
private boolean isDataChanged(int selectedRow) {
    String originalName = customerTable.getValueAt(selectedRow, 1).toString();
    String originalEmail = customerTable.getValueAt(selectedRow, 2).toString();
    String originalPhone = customerTable.getValueAt(selectedRow, 3).toString();
    String originalAddress = customerTable.getValueAt(selectedRow, 4).toString();
    String originalPassword = customerTable.getValueAt(selectedRow, 5).toString();
    
    String currentName = nameTextField1.getText();
    String currentEmail = emailTextField1.getText();
    String currentPhone = phoneTextField1.getText();
    String currentAddress = addressTextField1.getText();
    String currentPassword = passwordField1.getText();

    return !originalName.equals(currentName) || !originalEmail.equals(currentEmail) ||
           !originalPhone.equals(currentPhone) || !originalAddress.equals(currentAddress) ||
           !originalPassword.equals(currentPassword);
}
    private void transferCustomerDataToTextFields(int selectedRow) {
    int customerId = Integer.parseInt(customerTable.getValueAt(selectedRow, 0).toString());
    String name = customerTable.getValueAt(selectedRow, 1).toString();
    String email = customerTable.getValueAt(selectedRow, 2).toString();
    String phone = customerTable.getValueAt(selectedRow, 3).toString();
    String address = customerTable.getValueAt(selectedRow, 4).toString();
    String password = customerTable.getValueAt(selectedRow, 5).toString();
    customerIdTextField.setText(String.valueOf(customerId));
    nameTextField1.setText(name);
    emailTextField1.setText(email);
    phoneTextField1.setText(phone);
    addressTextField1.setText(address);
    passwordField1.setText(password);
}
private void performCustomerUpdate() {
    try {
        String name = nameTextField1.getText();
        String email = emailTextField1.getText();
        String phone = phoneTextField1.getText();
        String address = addressTextField1.getText();
        String password = passwordField1.getText();
        if(name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone number must contain only 10 digits.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
            return;
        }
          if (password.length() < 3) {
        JOptionPane.showMessageDialog(null, "Password must be at least 3 characters long.", "VALIDATION MESSAGE", JOptionPane.ERROR_MESSAGE);
        return;
    }
        Customer updatedCustomer = new Customer(customerId, name, email, phone, address, password, 5); 
        CustomerDAO customerDAO = new CustomerDAO();
        String result = customerDAO.updateCustomer(updatedCustomer);
        JOptionPane.showMessageDialog(this, result, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);   
        displayLoggedInCustomerDetails();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please check that all fields have valid information.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error updating customer: " + ex.getMessage(), "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }
    resetCustomerTextFields(); 
}

//RESETTING CUSTOMER FIELDS AFTER UPDATE DONE BY CUSTOMER
private boolean readyToUpdateCustomer = false; private void resetCustomerTextFields() {
    customerIdTextField.setText("");
    nameTextField1.setText("");
    emailTextField1.setText("");
    phoneTextField1.setText("");
    addressTextField1.setText("");
    passwordField1.setText("");
    
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
//SEARCH AVAILABLE ARTWORK BY NAME
   private void searchAndUpdateTableArtworkAvailable() {
    String searchText = searchavailableartworkTextField.getText().trim();
    ArtworkDAO artworkDAO = new ArtworkDAO();
    List<Artwork> searchResults = artworkDAO.searchAvailableArtworksByTitle(searchText);
    updateArtworkAvailableTable(searchResults);
}  
    private void updateArtworkAvailableTable(List<Artwork> artworks) {
    DefaultTableModel model = (DefaultTableModel) artworkavailableTable.getModel();
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

// ARTIST,ARTWORK,SALES AND CUSTOMER CARDLAYOUT
    private void ArtistBtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistBtnAllActionPerformed
        CardLayout cardLayout = (CardLayout) CustomerPanel.getLayout();
        cardLayout.show(CustomerPanel, "Artists");
    }//GEN-LAST:event_ArtistBtnAllActionPerformed

    private void ArtworksArtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtworksArtBtnActionPerformed
        CardLayout cardLayout = (CardLayout) CustomerPanel.getLayout();
        cardLayout.show(CustomerPanel, "Artworks");
       
    }//GEN-LAST:event_ArtworksArtBtnActionPerformed

    private void CustomersartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersartBtnActionPerformed
        CardLayout cardLayout = (CardLayout) CustomerPanel.getLayout();
        cardLayout.show(CustomerPanel, "Customers");
    }//GEN-LAST:event_CustomersartBtnActionPerformed

    private void SalesartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesartBtnActionPerformed
        CardLayout cardLayout = (CardLayout) CustomerPanel.getLayout();
        cardLayout.show(CustomerPanel, "Sales");
    }//GEN-LAST:event_SalesartBtnActionPerformed

//BUYING AN ARTWORK
private void confirmArtworkPurchase(int selectedArtworkId) {
    int response = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to buy this artwork?", 
        "INFORMATION MESSAGE", 
        JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
        processArtworkPurchase(selectedArtworkId);
    } else {
        JOptionPane.showMessageDialog(this, "Come back soon!");
    }
}
private void processArtworkPurchase(int artworkId) {
    ArtworkDAO artworkDAO = new ArtworkDAO();
    SaleDAO saleDAO = new SaleDAO();
    double price = artworkDAO.getSelectedArtworkPrice(artworkId);
    int saleId = saleDAO.insertSale(artworkId, this.customerId, price);
    if (saleId != -1) {
        Sale sale = saleDAO.getSaleDetails(saleId);
        CustomerDAO customerDAO = new CustomerDAO();
        String customerName = customerDAO.getCustomerName(this.customerId);
        displaySaleDetails(sale, customerName);
    } else {
        JOptionPane.showMessageDialog(this, "Sale processing failed!", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }
}
private void displaySaleDetails(Sale sale, String customerName) {
    ArtworkDAO artworkDAO = new ArtworkDAO();
    String artworkName = artworkDAO.getArtworkName(sale.getArtworkId());
    StringBuilder saleDetails = new StringBuilder();
    saleDetails.append("Order Details:\n");
    saleDetails.append("Sale ID: ").append(sale.getSaleId()).append("\n");
    saleDetails.append("Customer ID: ").append(sale.getCustomerId()).append("\n");
    saleDetails.append("Customer Name: ").append(customerName).append("\n");
    saleDetails.append("Artwork ID: ").append(sale.getArtworkId()).append("\n");
    saleDetails.append("Artwork Name: ").append(artworkName).append("\n");
    saleDetails.append("Sale Price: ").append(String.format("%.2f", sale.getPrice())).append("\n");
    saleDetails.append("Sale Date: ").append(sale.getSaleDate().toString()).append("\n");
    saleDetails.append("-------------------------------------------------------\n");  
    saleDetailsAreas.append(saleDetails.toString() + "\n\n"); 
}
private void loadCustomerSales() {
    SaleDAO saleDAO = new SaleDAO();
    List<Sale> sales = saleDAO.getSalesByCustomerId(this.customerId);
    ArtworkDAO artworkDAO = new ArtworkDAO();
    CustomerDAO customerDAO = new CustomerDAO();
    for (Sale sale : sales) {
        String artworkName = artworkDAO.getArtworkName(sale.getArtworkId());
        String customerName = customerDAO.getCustomerName(sale.getCustomerId());
        StringBuilder saleDetails = new StringBuilder();
         saleDetails.append("Order Details:\n");
        saleDetails.append("Sale ID: ").append(sale.getSaleId()).append("\n");
         saleDetails.append("Customer ID: ").append(sale.getCustomerId()).append("\n");
         saleDetails.append("Customer Name: ").append(customerName).append("\n");
         saleDetails.append("Artwork ID: ").append(sale.getArtworkId()).append("\n");
        saleDetails.append("Artwork Name: ").append(artworkName).append("\n");
        saleDetails.append("Sale Price: ").append(String.format("%.2f", sale.getPrice())).append("\n");
        saleDetails.append("Sale Date: ").append(sale.getSaleDate().toString()).append("\n\n");
        saleDetails.append("-------------------------------------------------------\n"); 
        saleDetailsAreas.append(saleDetails.toString());
    }
}
   private int getSelectedArtworkId() {
    int selectedRow = artworkavailableTable.getSelectedRow();
    if (selectedRow != -1) {
        return Integer.parseInt(artworkavailableTable.getValueAt(selectedRow, 0).toString());
    } else {
        JOptionPane.showMessageDialog(this, "Please select an artwork first.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        return -1;
    }
}
    private void buyArtworkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyArtworkBtnActionPerformed
        int selectedArtworkId = getSelectedArtworkId(); 
     if (selectedArtworkId != -1) { 
        confirmArtworkPurchase(selectedArtworkId);
    }
    }//GEN-LAST:event_buyArtworkBtnActionPerformed
     



     
    

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
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArtistBtnAll;
    private javax.swing.JPanel ArtistsCard;
    private javax.swing.JButton ArtworksArtBtn;
    private javax.swing.JPanel ArtworksCard;
    private javax.swing.JPanel CustomerPanel;
    private javax.swing.JPanel CustomersCard;
    private javax.swing.JButton CustomersartBtn;
    private javax.swing.JPanel SalesCard;
    private javax.swing.JButton SalesartBtn;
    private javax.swing.JTextField addressTextField1;
    private javax.swing.JTable artistTable;
    private javax.swing.JTable artworkTable;
    private javax.swing.JTable artworkavailableTable;
    private javax.swing.JButton buyArtworkBtn;
    private javax.swing.JTextField customerIdTextField;
    private javax.swing.JTable customerTable;
    private javax.swing.JTextField emailTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton logoutb;
    private javax.swing.JTextField nameTextField1;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JTextField phoneTextField1;
    private javax.swing.JTextArea saleDetailsAreas;
    private javax.swing.JTextField searchartistTextField;
    private javax.swing.JTextField searchartworkTextField;
    private javax.swing.JTextField searchavailableartworkTextField;
    private javax.swing.JButton updatecustomerBtn1;
    // End of variables declaration//GEN-END:variables

    

    

 
}
