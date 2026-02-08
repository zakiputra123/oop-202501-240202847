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
import javax.swing.JTextField;

public class ProductFormView extends JFrame {
    public JTextField txtCode = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtStock = new JTextField(20);
    public JTextField txtSearch = new JTextField(20);
    public JButton btnAdd = new JButton("Tambah Produk");
    public JButton btnUpdate = new JButton("Update Produk");
    public JButton btnDelete = new JButton("Hapus Produk");
    public JButton btnSearch = new JButton("Cari");
    public JList<String> listView = new JList<>(new DefaultListModel<>());

    public ProductFormView() {
        setTitle("Agri-POS - Kelola Produk (Week 13) - Zaki Saputra - 240202847");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);

        JScrollPane listScroll = new JScrollPane(listView);
        listScroll.setBorder(BorderFactory.createTitledBorder("Daftar Produk"));

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(listScroll, BorderLayout.SOUTH);

        setSize(400, 500);
        setLocationRelativeTo(null);
    }
}