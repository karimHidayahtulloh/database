package tebakgambarcerdas;

//import connection.data_base;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; //otomatis - errorModule
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level; //otomatis - errorModule
import java.util.logging.Logger; //otomatis - errorModule
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class bahas extends javax.swing.JFrame {

//    data_base model;
    boolean jawabanmu; //untuk kondisi jawaban yg diklik nanti dibandingkan dengan kondisi yg benar
    int level = 1;
    int waktu = 20;
    int nilai = 0;
    JButton listJawaban[];
    String nama = null;
    int indeksSoal;
    Timer timer = new Timer(750, new Listener());
    //-- -----------------------------------------------------------
    //-- ----           deklarasi soal dan jawaban              ----
    //-- -----------------------------------------------------------
    public String[] persoalan
            = {"src/review/v1.jpg",
                "src/review/v2.jpg",
                "src/review/v3.jpg",
                "src/review/v4.jpg",
                "src/review/v5.jpg",
                "src/review/v6.jpg",
                "src/review/v7.jpg",
                "src/review/v8.jpg",
                "src/review/v9.jpg",
                "src/review/v10.jpg",
                "src/review/v11.jpg",
                "src/review/v12.jpg",
                "src/review/v13.jpg",
                "src/review/v14.jpg",
                "src/review/v15.jpg",
                "src/review/v16.jpg",
                "src/review/v17.jpg",
                "src/review/v18.jpg",
                "src/review/v19.jpg",
                "src/review/v20.jpg",
                "src/review/v21.jpg",
                "src/review/v22.jpg",
                "src/review/v23.jpg",
                "src/review/v24.jpg",
                "src/review/v25.jpg",
                "src/review/v26.jpg",
                "src/review/v27.jpg",
                "src/review/v28.jpg",
                "src/review/v29.jpg",
                "src/review/v30.jpg"};
    public String[] jawaban = {
        "", "", "", "", "",
        "", "", "", "", "",
        "", "", "", "", "",
        "", "", "", "", "",
        "", "", "", "", "",
        "", "", "", "", ""};
    public boolean[] statusA = {
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true, true, true};

    public bahas() {
        this.jawaban = new String[]{
            "", "", "", "", "",
            "", "", "", "", "",
            "", "", "", "", "",
            "", "", "", "", "",
            "", "", "", "", "",
            "", "", "", "", ""};
        initComponents();
        indeksSoal = 0; //soal awal
        listJawaban = new JButton[]{a};
        daftarTulisanJawaban(indeksSoal);
        setLocationRelativeTo(null); //otomatis di tengah
        timingnya();
    }

    private void timingnya() {
        timer.start();
        levelCounter.setText(String.format("%d", level));

    }

    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            waktu = (waktu - 1);
            if (waktu == 0 || a.isSelected()) {

                if (level == 30 && waktu == 0 || level == 30 && a.isSelected()) {
                    a.setSelected(false);
                    try {
                        masukkanSkor(); // mestinya ini aja
                    } catch (IOException ex) {
                        Logger.getLogger(bahas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else { //ketika levelnya masih belum sampai akhir
                    a.setSelected(false);
//                    b.setSelected(false);
//                    c.setSelected(false);
//                    d.setSelected(false);
                    waktu = 30;
                    level++;
                    indeksSoal++;
                    daftarTulisanJawaban(indeksSoal);
                    levelCounter.setText(String.format("%d", level));

                }
            }

        }
    }

    private void timingnyaDiStop() {
        timer.stop();
    }

    private void timingnyaMainLagi() {
        timer.start();
    }

    private void daftarTulisanJawaban(int indeksSoal) {
        tempatSoal.setIcon(new ImageIcon(persoalan[indeksSoal]));
        listJawaban[0].setText(jawaban[indeksSoal]);
    }

    private void cekBenarkah(boolean tampungjawab, boolean[] status) {
        if (tampungjawab == status[indeksSoal]) {
            nilai += waktu + 5;
        } else {
            nilai += 0; //nilai ndak berubah
        }
    }

    private void masukkanSkor() throws IOException {
        JOptionPane.showMessageDialog(this, "Pembahasan selesai");
        this.dispose();
        new Main().setVisible(true);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        a = new javax.swing.JButton();
        levelCounter = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tempatSoal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 545));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        btnHome.setText("HOME");
        btnHome.setAlignmentX(0.5F);
        btnHome.setBorder(new javax.swing.border.MatteBorder(null));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 120, 40));

        a.setBackground(new java.awt.Color(255, 255, 255));
        a.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        a.setBorder(null);
        a.setBorderPainted(false);
        a.setContentAreaFilled(false);
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        jPanel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, 200, 50));

        levelCounter.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        levelCounter.setForeground(new java.awt.Color(255, 255, 255));
        levelCounter.setText("4");
        jPanel1.add(levelCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 50, 30));

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bacaan Ke -");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 150, -1));

        tempatSoal.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.add(tempatSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//-- ketika tombol Home ditekan --
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
//        timingnyaDiStop();
        int inginKeluar;// 0 = (YES) exit ke main menu , 1 = (NO)tidak jadi //default netbeansnya
        inginKeluar = JOptionPane.showConfirmDialog(this, "Anda yakin ingin mengakhiri Pembahasan / Materi?", "Konfirmasi Kembali", 0);
        if (inginKeluar == 0) //kalo bener mau keluar, skoring muncul (masukkanSkor)
        {
            try {
                masukkanSkor();

            } catch (IOException ex) {
                Logger.getLogger(bahas.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            timingnyaMainLagi();
        }
    }//GEN-LAST:event_btnHomeActionPerformed
//-- ketika opsi A ditekan --
    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        a.setSelected(true); //ketika diklik maka status tombol a itu terseleksi (ada biru2 dipinggirannya)
        //digunakan untuk tanda lanjut ke level berikutnya
        jawabanmu = true; //jawaban yg diklik diubah jadi boolean bernilai true
        cekBenarkah(jawabanmu, statusA);

    }//GEN-LAST:event_aActionPerformed

///-- ketika opsi C ditekan --    
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
            java.util.logging.Logger.getLogger(MulaiGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MulaiGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MulaiGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MulaiGame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bahas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a;
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel levelCounter;
    private javax.swing.JLabel tempatSoal;
    // End of variables declaration//GEN-END:variables

}


/* *********************************************
hal yang belum ditambahkan:
1. subrutin untuk penskoran >>>>    sudah ditambahkan (6/6)
2. subrutin untuk mengklik jawaban itu benar >>>    sudah ditambahkan (6/6)
3. subrutin untuk linking dari skor soal ke daftar skor di main menu  >>>>      sudah ditambahkan(11/6)
*******************************************************************
 */
