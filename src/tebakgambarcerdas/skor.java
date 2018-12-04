package tebakgambarcerdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import javax.swing.JTable;

public class skor extends javax.swing.JFrame {

    String[] hskor;
    Stack x = new Stack();
    File scoreFile = new File("topskor.skor");

    public skor() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        ambilNilai(x);
        urutSkor(hskor);
        masukTabel(tabelSkor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSkor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabelSkor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NAMA", "SKOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelSkor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelSkor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelSkor.setEnabled(false);
        tabelSkor.setMaximumSize(new java.awt.Dimension(150, 80));
        tabelSkor.setMinimumSize(new java.awt.Dimension(150, 80));
        jScrollPane1.setViewportView(tabelSkor);
        if (tabelSkor.getColumnModel().getColumnCount() > 0) {
            tabelSkor.getColumnModel().getColumn(0).setResizable(false);
            tabelSkor.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Bebas Neue", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("5 pemain terbaik");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(156, 156, 156))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 440, 330));

        btnKembali.setText("KEMBALI");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 480, 500));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakgambarcerdas/ui/skor.jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
        new Main().setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelSkor;
    // End of variables declaration//GEN-END:variables
    public void ambilNilai(Stack x) throws FileNotFoundException, IOException {//disuruh nambai throw sama netbeans
        if (!scoreFile.exists()) { // jika tidak ada file di direktori project, maka akan otomatis dibuat
            try {
                scoreFile.createNewFile(); //
            } catch (Exception e) {
            }
        }
//        int i = 0;
        BufferedReader reader = new BufferedReader(new FileReader("topskor.skor"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            x.push(line);
//            System.out.println(x.get(i)); //cuma ngecek, bener masuk stack apa ndak
//            i++;
        }
//        System.out.println("");
        hskor = new String[x.size()];
        for (int j = 0; j < hskor.length; j++) {
            hskor[j] = x.pop().toString().toUpperCase();
        }
//        for (int j = 0; j < hskor.length; j++) { // cuma ngecek, stack yg sudah dipop masuk aray apa ndak
//            System.out.println(hskor[j]);
//        }
    }

    public void urutSkor(String[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1; j++) {
                //contoh: "TONO 25"    >>> panjangTulisan = 7; batasIndeks = 6
                //T O N O   2 5
                //--------------
                //0 1 2 3 4 5 6
                //yg diambil 25 aja,, caranya: panjangTulisan - 1
                //
                if (x[j].substring(x[j].length() - 3).compareTo(x[j + 1].substring(x[j + 1].length() - 3)) < 0) {
                    String temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
        System.out.println(""); //cuma ngecek apa urutannya sudah DESCENDING apa belum
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i].toUpperCase());
        }

    }

    public void masukTabel(JTable tabelSkor) {
        if (hskor.length > 0) { //kalo ada data di file maka masuk sini, kalo ndak ya tabelnya kosongan
            if (hskor.length <= 5) { // karena cuma 5besar, acuannya 5 teratas aja
                for (int i = 0; i < hskor.length; i++) {
                    for (int j = 0; j < tabelSkor.getColumnCount(); j++) {
                        tabelSkor.getModel().setValueAt(hskor[i].substring(0, hskor[i].length() - 3), i, 0);
                        tabelSkor.getModel().setValueAt(new Integer(hskor[i].substring(hskor[i].length() - 3)), i, 1);
                    }//kolom
                }//baris
            } else {
                for (int i = 0; i < tabelSkor.getRowCount(); i++) {
                    for (int j = 0; j < tabelSkor.getColumnCount(); j++) {
                        tabelSkor.getModel().setValueAt(hskor[i].substring(0, hskor[i].length() - 3), i, 0);
                        tabelSkor.getModel().setValueAt(new Integer(hskor[i].substring(hskor[i].length() - 3)), i, 1);
                    }//kolom
                }//baris
            }
        }//end if > 0

    }//end masukTabel
}
