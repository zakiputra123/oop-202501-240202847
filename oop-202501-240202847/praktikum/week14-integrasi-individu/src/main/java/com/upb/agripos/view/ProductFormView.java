package com.upb.agripos.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProductFormView extends JFrame {
    public JTextField txtCode = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtStock = new JTextField(20);
    public JTextField txtSearch = new JTextField(20);
    public JTextField txtQuantity = new JTextField("1", 5);
    public JButton btnAdd = new JButton("Tambah Produk");
    public JButton btnUpdate = new JButton("Update Produk");
    public JButton btnDelete = new JButton("Hapus Produk");
    public JButton btnSearch = new JButton("Cari");
    public JButton btnAddToCart = new JButton("Tambah ke Keranjang");
    public JButton btnViewCart = new JButton("Lihat Keranjang");
    public JButton btnCheckout = new JButton("Checkout");
    public JTable listView;
    public JList<String> cartList;
    public JLabel lblStatus = new JLabel("Status: Ready");

    public ProductFormView() {
        setTitle("Agri-POS - Kelola Produk (Week 14) - Zaki Saputra - 240202847");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Kode", "Nama", "Harga", "Stok"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        listView = new JTable(model);

        cartList = new JList<>();
        cartList.setModel(new DefaultListModel<>());

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Form Input Produk"));

        formPanel.add(new JLabel("Kode:"));
        formPanel.add(txtCode);
        formPanel.add(new JLabel("Nama:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Harga:"));
        formPanel.add(txtPrice);
        formPanel.add(new JLabel("Stok:"));
        formPanel.add(txtStock);
        formPanel.add(new JLabel("Cari (Kode/Nama):"));
        formPanel.add(txtSearch);
        formPanel.add(new JLabel("Qty:"));
        formPanel.add(txtQuantity);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnAddToCart);
        buttonPanel.add(btnViewCart);
        buttonPanel.add(btnCheckout);
        // Empty cell for alignment
        buttonPanel.add(new JPanel());

        JScrollPane listScroll = new JScrollPane(listView);
        listScroll.setBorder(BorderFactory.createTitledBorder("Daftar Produk"));

        JScrollPane cartScroll = new JScrollPane(cartList);
        cartScroll.setBorder(BorderFactory.createTitledBorder("Keranjang Belanja"));

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(listScroll, BorderLayout.WEST);
        southPanel.add(cartScroll, BorderLayout.EAST);
        southPanel.add(lblStatus, BorderLayout.SOUTH);

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        setSize(600, 600);
        setLocationRelativeTo(null);
    }
}