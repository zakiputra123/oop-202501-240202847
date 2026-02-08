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
    public JButton btnAdd = new JButton("Tambah Produk");
    public JList<String> listView = new JList<>(new DefaultListModel<>());

    public ProductFormView() {
        setTitle("Agri-POS - Kelola Produk (Week 12)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Form Input Produk"));

        formPanel.add(new JLabel("Kode:"));
        formPanel.add(txtCode);
        formPanel.add(new JLabel("Nama:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Harga:"));
        formPanel.add(txtPrice);
        formPanel.add(new JLabel("Stok:"));
        formPanel.add(txtStock);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);

        JScrollPane listScroll = new JScrollPane(listView);
        listScroll.setBorder(BorderFactory.createTitledBorder("Daftar Produk"));

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(listScroll, BorderLayout.SOUTH);

        setSize(400, 500);
        setLocationRelativeTo(null);
    }
}