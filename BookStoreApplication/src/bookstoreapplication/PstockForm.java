/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapplication;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import MySqlConnection.DatabaseConnection;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class PstockForm extends javax.swing.JFrame {

    private final DatabaseConnection connection;
    boolean vib;
    /**
     * Creates new form PstockForm
     */
    public PstockForm() {
        initComponents();
        connection = new DatabaseConnection();
        Update_table();
        fillOutcome();
        fillIncome();
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
    }


    private void Update_table() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        try {
            ResultSet rs = connection.select(" a.name_book as 'Название', a.author as 'Автор', a.year as 'Год', a.amount as 'Количество' ", "books as a", null);
//            DefaultTableModel model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            Object[] columnNames = {"Название", "Автор", "Год", "Количество"};
            model.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                String d = rs.getString("Название");
                String b = rs.getString("Автор");
                Object e = rs.getString("Год");
                Object a = rs.getObject("Количество");
                model.addRow(new Object[]{d, b, e, a});
            }
            jTableProd.setModel(model);

        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProd = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCBmonth = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        yearField = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        itogField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Склад");

        jPanel3.setBackground(java.awt.SystemColor.inactiveCaption);

        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel22.setText("СКЛАД");
        jLabel22.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel4.setText("Поиск");

        searchField.setToolTipText("Поиск чувствителен к регистру");
        searchField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/file.png"))); // NOI18N

        jPanel4.setBackground(java.awt.SystemColor.inactiveCaption);
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 4));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 688, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(61, 61, 61))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addComponent(jLabel1))
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Comic Sans MS", 3, 16)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTableProd.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProd);

        jTabbedPane1.addTab("На складе", jScrollPane1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jTabbedPane1.addTab("Приход", jScrollPane2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jTabbedPane1.addTab("Расход", jScrollPane3);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Месяц");

        jCBmonth.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jCBmonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" }));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Год");

        try {
            yearField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        yearField.setText("2016");
        yearField.setFont(new java.awt.Font("Comic Sans MS", 3, 16)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Применить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Отменить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(486, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBmonth, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBmonth)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        itogField.setBackground(new java.awt.Color(228, 228, 245));
        itogField.setFont(new java.awt.Font("Comic Sans MS", 3, 16)); // NOI18N
        itogField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        itogField.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("сом");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sum-sign (3).png"))); // NOI18N
        jLabel5.setText("Итого за месяц");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itogField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(itogField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        JScrollPane scrollRef = (JScrollPane) jTabbedPane1.getSelectedComponent();
        JTable tableRef = (JTable) scrollRef.getViewport().getComponents()[0];
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableRef.getModel());
        tableRef.setRowSorter(sorter);
        String text = searchField.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException e) {
                System.err.println("Bad regex pattern");
            }
        }
        TableRowSorter<TableModel> sorter2 = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(sorter2);
        if (text.length() == 0) {
            sorter2.setRowFilter(null);
        } else {
            sorter2.setRowFilter(RowFilter.regexFilter(text));
            itog();
        }

        TableRowSorter<TableModel> sorter3 = new TableRowSorter<>(jTable2.getModel());
        jTable2.setRowSorter(sorter3);
        if (text.length() == 0) {
            sorter3.setRowFilter(null);
        } else {
            sorter3.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
         DefaultTableModel dtm2 = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        try {
            Integer month = jCBmonth.getSelectedIndex() + 1;
            String year = yearField.getText();
            ResultSet rs = connection.customSelect("select date_stock as 'Date', books.name_book as 'Name', books.author as 'Author', books.year as 'Year', provider.name_provider as 'Provider', stock.count_stock as 'Count', stock.number_invoice as 'bill', stock.summ_stock as 'Summ'  from books INNER JOIN stock ON books.id_book = stock.id_book INNER JOIN provider ON stock.id_provider = provider.id_provider where month(date_stock) = '" + month + "' and year(date_stock)= '" + year + "'");
             Object[] columnNames = {"Дата", "№ накладной", "Поставщик", "Книга", "Количество", "Сумма"};
            dtm.setColumnIdentifiers(columnNames);
            while (rs.next()) {
              String a = rs.getString("Date");
                int b = rs.getInt("bill");
                String w = rs.getString("Provider");
                String e = rs.getString("Name");
                 String r= rs.getString("Author");
                 String t = rs.getString("Year");
                String g = e + " " + r + " " + t; 
                Object f = rs.getObject("Count");
                Object h = rs.getObject("Summ");
                dtm.addRow(new Object[]{a, b, w, g, f, h});
            }
            jTable2.setModel(dtm);
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable2.getModel());
            jTable2.setRowSorter(sorter);
        } catch (SQLException e) {
        }
         try {
            Integer month = jCBmonth.getSelectedIndex() + 1;
            String year = yearField.getText();
            ResultSet rs = connection.customSelect("select order_store.date_order as 'Date' ,order_store.number_invoce as 'bill', books.name_book as 'Name', books.author as 'Author', books.year as 'Year', order_store.count_books as 'Amount' , order_store.summ_order as 'Summ'  from books INNER JOIN order_store ON books.id_book = order_store.id_book where month(order_store.date_order) = '" + month + "' and year(order_store.date_order)= '" + year + "'");
           Object[] columnNames = {"Дата", "№ накладной", "Книга", "Количество", "Сумма"};
            dtm2.setColumnIdentifiers(columnNames);
            while (rs.next()) {
              String a = rs.getString("Date");
                int b = rs.getInt("bill");
                String e = rs.getString("Name");
                 String r= rs.getString("Author");
                 String t = rs.getString("Year");
                String g = e + " " + r + " " + t; 
                Object f = rs.getObject("Amount");
                Object h = rs.getObject("Summ");
                dtm2.addRow(new Object[]{a, b, g, f, h});
            }
            jTable1.setModel(dtm2);
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
            jTable1.setRowSorter(sorter);
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        int index = jTabbedPane1.getSelectedIndex();
        switch (index) {
            case 1:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                vib = true;
                 itog();
                break;
            case 2:
                jPanel1.setVisible(true);
                jPanel2.setVisible(true);
                vib = false;
                 itog();
                break;
            default:
                jPanel1.setVisible(false);
                jPanel2.setVisible(false);
                break;
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index = jTabbedPane1.getSelectedIndex();
        if (index == 1) {
            fillIncome();
        } else if (index == 2) {
            fillOutcome();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void fillIncome() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        try (ResultSet rs = connection.customSelect(" select order_store.date_order as 'Date' ,order_store.number_invoce as 'bill', books.name_book as 'Name', books.author as 'Author', books.year as 'Year', order_store.count_books as 'Amount' , order_store.summ_order as 'Summ'  from books INNER JOIN order_store ON books.id_book = order_store.id_book")) 
        {
            Object[] columnNames = {"Дата", "№ накладной", "Книга", "Количество", "Сумма"};
            dtm.setColumnIdentifiers(columnNames);
            while (rs.next()) {
              String a = rs.getString("Date");
                int b = rs.getInt("bill");
                String e = rs.getString("Name");
                 String r= rs.getString("Author");
                 String t = rs.getString("Year");
                String g = e + " " + r + " " + t; 
                Object f = rs.getObject("Amount");
                Object h = rs.getObject("Summ");
                dtm.addRow(new Object[]{a, b, g, f, h});
            }
            jTable1.setModel(dtm);
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
            jTable1.setRowSorter(sorter);
        } catch (Exception e) {
        }
    }

    private void fillOutcome() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        try (ResultSet rs = connection.customSelect("select date_stock as 'Date', books.name_book as 'Name', books.author as 'Author', books.year as 'Year', provider.name_provider as 'Provider', stock.count_stock as 'Count', stock.number_invoice as 'bill', stock.summ_stock as 'Summ'  from books INNER JOIN stock ON books.id_book = stock.id_book INNER JOIN provider ON stock.id_provider = provider.id_provider")) {
            Object[] columnNames = {"Дата", "№ накладной", "Поставщик", "Книга", "Количество", "Сумма"};
            dtm.setColumnIdentifiers(columnNames);
            while (rs.next()) {
              String a = rs.getString("Date");
                int b = rs.getInt("bill");
                String w = rs.getString("Provider");
                String e = rs.getString("Name");
                 String r= rs.getString("Author");
                 String t = rs.getString("Year");
                String g = e + " " + r + " " + t; 
                Object f = rs.getObject("Count");
                Object h = rs.getObject("Summ");
                dtm.addRow(new Object[]{a, b, w, g, f, h});
            }
            jTable2.setModel(dtm);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(40);
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            jTable2.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
            jTable2.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable2.getModel());
            jTable2.setRowSorter(sorter);
        } catch (Exception e) {
        }

    }

    private void itog() {
        if(vib == false)
        {
        Double sum_itog = 0.0;
        int n = jTable2.getRowCount();
        for (int i = 0; i < n; i++) {
            Double itog = Double.parseDouble(jTable2.getValueAt(i, 5).toString());
            sum_itog += itog;
        }
        itogField.setText(String.valueOf(sum_itog));
        }
        else if(vib == true)
        {
         Double sum_itog = 0.0;
        int n = jTable1.getRowCount();
        for (int i = 0; i < n; i++) {
            Double itog = Double.parseDouble(jTable1.getValueAt(i, 4).toString());
            sum_itog += itog;
        }
        itogField.setText(String.valueOf(sum_itog));
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PstockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PstockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PstockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PstockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PstockForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField itogField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBmonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableProd;
    private javax.swing.JTextField searchField;
    private javax.swing.JFormattedTextField yearField;
    // End of variables declaration//GEN-END:variables
}
