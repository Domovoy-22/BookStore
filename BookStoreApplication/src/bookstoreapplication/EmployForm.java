package bookstoreapplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.PatternSyntaxException;
import net.proteanit.sql.DbUtils;
import MySqlConnection.DatabaseConnection;
import valid.Validation;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class EmployForm extends javax.swing.JFrame {

    private ResultSet resultSet;
    private final DatabaseConnection databaseConnection;
    private final Validation valid;

    /**
     * Creates new form EmployForm
     */
    public EmployForm() {
        initComponents();
        jTableEmp.setDefaultEditor(Object.class, null);
        jTableEmp.getTableHeader().setReorderingAllowed(false);
        databaseConnection = new DatabaseConnection();
        valid = new Validation();
        Update_table();
        ComboItem();
        getContentPane().setBackground(new Color(235, 235, 235));
        jPanel5.setBackground(new Color(235, 235, 235));
        jPanel2.setBackground(new Color(235, 235, 235));
    }

    private void Update_table() {
        jButtonUpd.setEnabled(false);
        jButtonDel.setEnabled(false);
        jButtonAdd.setEnabled(true);

        try {
            resultSet = databaseConnection.customSelect("select a.id_employee as '№', a.name_employee as 'ФИО', a.date_recruitment as 'Дата зачисления', b.name_position as 'Должность', a.number_phone as 'Телефон', a.adress as 'Адрес' from employee as a, position as b where a.id_position = b.id_position order by a.id_employee asc");
            jTableEmp.setModel(DbUtils.resultSetToTableModel(resultSet));
            jTableEmp.removeColumn(jTableEmp.getColumnModel().getColumn(0));
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTableEmp.getModel());
            jTableEmp.setRowSorter(sorter);
            Calendar cal = Calendar.getInstance();
            jXDatePicker1.setDate(cal.getTime());
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    private void ComboItem() {
        try {
            resultSet = databaseConnection.select("*", "position", null);
            while (resultSet.next()) {
                String name = resultSet.getString("name_position");
                jCBpost.addItem(name);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButtonDel = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmp = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCBpost = new javax.swing.JComboBox<String>();
        phoneField = new javax.swing.JFormattedTextField();
        error = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Сотрудники");

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonDel.setBackground(new java.awt.Color(227, 227, 227));
        jButtonDel.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButtonDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete-button-png-28580.png"))); // NOI18N
        jButtonDel.setText("Удалить");
        jButtonDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(227, 227, 227));
        jButtonAdd.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-icon-png-2466.png"))); // NOI18N
        jButtonAdd.setText("Добавить");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpd.setBackground(new java.awt.Color(227, 227, 227));
        jButtonUpd.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButtonUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pencil-symbol-icon-2487.png"))); // NOI18N
        jButtonUpd.setText("Изменить");
        jButtonUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(227, 227, 227));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/unnamed.png"))); // NOI18N
        jButton1.setText("Очистить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonUpd)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUpd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTableEmp.setFont(new java.awt.Font("Comic Sans MS", 3, 13)); // NOI18N
        jTableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableEmp.setToolTipText("Выберите сотрудника для редактирования");
        jTableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmp);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel20.setText("ФИО");

        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel22.setText("Телефон");

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel23.setText("Дата зачисления");

        jLabel24.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel24.setText("Адрес");

        jLabel25.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel25.setText("Должность");

        jCBpost.setToolTipText("Выберите должность сотрудника");
        jCBpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBpostActionPerformed(evt);
            }
        });

        try {
            phoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+996 -###-###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        phoneField.setToolTipText("Мобильный или рабочий телефон сотрудника");

        error.setForeground(new java.awt.Color(255, 51, 51));

        surnameField.setToolTipText("Ввод букв русского алфавита");
        surnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                surnameFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jCBpost, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(surnameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneField)
                                    .addComponent(addressField)
                                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(69, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel3.setBackground(java.awt.SystemColor.inactiveCaption);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 36)); // NOI18N
        jLabel4.setText("СОТРУДНИКИ ПРЕДПРИЯТИЯ");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel5.setText("Поиск");

        searchField.setToolTipText("Поиск чувствителен к регистру");
        searchField.setBorder(null);
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/file.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel4.setBackground(java.awt.SystemColor.inactiveCaption);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if (error.getText().isEmpty()) {
            DateFormat sysDate = new SimpleDateFormat("yyyy-MM-dd");
            String data = sysDate.format(jXDatePicker1.getDate());
            if (surnameField.getText().isEmpty() || phoneField.getText().isEmpty()
                    || addressField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Заполните поля");
            } else {
                try {
                    databaseConnection.insert("employee(name_employee,date_recruitment, number_phone,adress, id_position)",
                            "'" + surnameField.getText() + "','" + data + "','" + phoneField.getText() + "','"
                            + addressField.getText() + "','" + checkPost(jCBpost.getSelectedItem().toString()) + "'");
                    JOptionPane.showMessageDialog(null, "Запись добавлена");
                   
                    Update_table();
                    Clear_field();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Запись существует");
                }
            }
        }

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jCBpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBpostActionPerformed

    private void jTableEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpMouseClicked
        jButtonUpd.setEnabled(true);
        jButtonDel.setEnabled(true);
        jButtonAdd.setEnabled(false);
        try {
            int row = jTableEmp.getSelectedRow();
            String tableClick = (jTableEmp.getModel().getValueAt(row, 0).toString());
            resultSet = databaseConnection.select("*", "employee", "id_employee = " + tableClick);
            if (resultSet.next()) {
                String add1 = resultSet.getString("id_employee");
                idLabel.setText(add1);
                idLabel.setVisible(false);
                String add2 = resultSet.getString("name_employee");
                surnameField.setText(add2);
                Date add3 = resultSet.getDate("date_recruitment");
                jXDatePicker1.setDate(add3);
                String add4 = resultSet.getString("number_phone");
                phoneField.setText(add4);
                String add5 = resultSet.getString("adress");
                addressField.setText(add5);
                String add6 = resultSet.getString("id_position");
                jCBpost.setSelectedItem(checkPostId(add6));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jTableEmpMouseClicked

    private void jButtonDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelActionPerformed
        try {
            databaseConnection.delete("employee", "id_employee = " + idLabel.getText());
            JOptionPane.showMessageDialog(null, "Запись удалена");
            Clear_field();

        } catch (Exception e) {
            System.out.println(e.toString());

        }
        Update_table();
    }//GEN-LAST:event_jButtonDelActionPerformed

    private void jButtonUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdActionPerformed
        DateFormat sysDate = new SimpleDateFormat("yyyy-MM-dd");
        String data = sysDate.format(jXDatePicker1.getDate());
        try {
            String valueId = idLabel.getText();
            String valuesurName = surnameField.getText();
            String valuepost = checkPost(jCBpost.getSelectedItem().toString());
            String valuePhone = phoneField.getText();
            String valueAddress = addressField.getText();
            String valueData = data;
            databaseConnection.update("employee", "name_employee = '" + valuesurName +"',number_phone = '" + valuePhone + "',date_recruitment = '" + valueData + "',adress = '" + valueAddress + "',id_position = '" + valuepost + "'", "id_employee = " + valueId);
            JOptionPane.showMessageDialog(null, "Запись обновлена");
            Clear_field();
            Update_table();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Запись существует");
            jButtonUpd.setEnabled(true);
        }

    }//GEN-LAST:event_jButtonUpdActionPerformed

    private void surnameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_surnameFieldKeyReleased
        if (surnameField.getText().isEmpty()) {
            error.setText("");
        } else {
            String s = surnameField.getText();
            error.setText(valid.isLetter(s));
        }
    }//GEN-LAST:event_surnameFieldKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Clear_field();
        error.setText("");
        jButtonUpd.setEnabled(false);
        jButtonDel.setEnabled(false);
        jButtonAdd.setEnabled(true);
        jTableEmp.getSelectionModel().clearSelection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed

    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTableEmp.getModel());
        jTableEmp.setRowSorter(sorter);
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

    }//GEN-LAST:event_searchFieldKeyReleased
    private String checkPostId(String id) {
        String post;
        try {
            resultSet = databaseConnection.select("*", "position", "id_position = " + id);
            if (resultSet.next() == true) {
                post = resultSet.getString("name_position");

            } else {
                post = null;
            }
            return post;
        } catch (Exception e) {
            post = null;

            return post;
        }
    }

    private String checkPost(String post) {
        String id;
        try {
            resultSet = databaseConnection.select("*", " position", "name_position = '" + post + "'");
            if (resultSet.next()) {
                id = resultSet.getString("id_position");
            } else {
                id = null;
            }
            return id;
        } catch (SQLException e) {

            return null;
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
            java.util.logging.Logger.getLogger(EmployForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new EmployForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel error;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDel;
    private javax.swing.JButton jButtonUpd;
    private javax.swing.JComboBox<String> jCBpost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmp;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JFormattedTextField phoneField;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField surnameField;
    // End of variables declaration//GEN-END:variables

    private void Clear_field() {
        idLabel.setText("");
        surnameField.setText("");
        phoneField.setText("");
        addressField.setText("");
    }
}
