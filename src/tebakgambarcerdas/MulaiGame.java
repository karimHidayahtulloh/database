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
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level; //otomatis - errorModule
import java.util.logging.Logger; //otomatis - errorModule
import javax.annotation.Generated;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MulaiGame extends javax.swing.JFrame {

//    data_base model;
    boolean jawabanmu; //untuk kondisi jawaban yg diklik nanti dibandingkan dengan kondisi yg benar
    int level = 1;
    int cekIndex;
    int waktu = 3, counRandom = 1;
    int nilai = 0;
    JButton listJawaban[];
    String nama = null;
    int indeksSoal;
    Timer timer = new Timer(750, new Listener());
    int[] solutionArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    //-- -----------------------------------------------------------
    //-- ----           deklarasi soal dan jawaban              ----
    //-- -----------------------------------------------------------
    public String[] persoalan = {"src/tanya/1.jpg",
        "src/tanya/2.jpg",
        "src/tanya/3.jpg",
        "src/tanya/4.jpg",
        "src/tanya/5.jpg",
        "src/tanya/6.jpg",
        "src/tanya/7.jpg",
        "src/tanya/8.jpg",
        "src/tanya/9.jpg",
        "src/tanya/10.jpg",
        "src/tanya/11.jpg",
        "src/tanya/12.jpg",
        "src/tanya/13.jpg",
        "src/tanya/14.jpg",
        "src/tanya/15.jpg",
        "src/tanya/16.jpg",
        "src/tanya/17.jpg",
        "src/tanya/18.jpg",
        "src/tanya/19.jpg",
        "src/tanya/20.jpg",
        "src/tanya/21.jpg",
        "src/tanya/22.jpg",
        "src/tanya/23.jpg",
        "src/tanya/24.jpg",
        "src/tanya/25.jpg",
        "src/tanya/26.jpg",
        "src/tanya/27.jpg",
        "src/tanya/28.jpg",
        "src/tanya/29.jpg",
        "src/tanya/30.jpg"};

    public String[] jawabanA
            = {"A. Cut Nyak Dhien", "A. Soeharto", "A. R. Dewi Sartika", "A. H.O.S. Cokroaminoto ", "A. Fatmawati",
                "A. Jendral Soedirman", "A. R. A. Kartini", "A. Sutan Syahrir", "A. R. Dewi Sartika", "A. Pattimura",
                "A. Moh. Yamin", "A. Pattimura", "A. Ir. Soekarno", "A. Pangeran Antasari", "A. Sultan Ali Mughayat Syah",
                "A. I Gusti Ngurah Rai", "A. Pattimura", "A. Teuku Umar", "A. Ir. Soekarno", "A. Sutan Syahrir",
                "A. R.A KARTINI", "A. HASYIM ASY’ARI", "A. HASYIM ASY’ARI", "A. AHMAD DAHLAN", "A. MOHAMMAD HOESNI THAMRIN",
                "A. HASYIM ASY’ARI", "A. AHMAD DAHLAN", "A. KH. MAS MANSYUR", "A. SULTAN MAHMUD BADARUDDIN II", "A. MOHAMMAD HOESNI THAMRIN"};
    public String[] jawabanB
            = {"B. R.A Kartini", "B. Ir. Soekarno", "B. R.A Kartini", "B. Abdul Muis", "B. Cut Nyak Meutia",
                "B. Bung Tomo", "B. Cut Nyak Dhien", "B. Tuanku Imam Bonjol", "B. Dewi Ratna", "B. Tuanku Imam Bonjol",
                "B. Pangeran Diponegoro", "B. Pangeran Diponegoro", "B. Jendral Soedirman", "B. Dewi Ratna", "B.  Sultan  Hasanuddin",
                "B. I Gusti Bagus Saputra", "B. Sultan Iskandar Muda", "B. Jendral Soedirman", "B. Jendral Soedirman", "B. Jendral Soedirman",
                "B. MARIA WALANDA MARAMIS", "B. MOHAMMAD HOESNI THAMRIN", "B. KH. MAS MANSYUR", "B. HOS COKROAMINOTO", "B. KH. MAS MANSYUR",
                "B. AHMAD DAHLAN", "B. AGUS SALIM", "B. DR. SOEPOMO", "B. MARIA WALANDA MARAMIS", "B. MARIA WALANDA MARAMIS"};
    public String[] jawabanC
            = {"C. Fatmawati", "C. Drs. Moh. Hatta", "C. Cut Nyak Dhien", "C. KI Hajar Dewantoro", "C. Cut Nyak Dhien",
                "C. Drs. Moh. Hatta", "C. Cut Nyak Meutia ", "C. Drs. Moh. Hatta", "C. R. A. Kartini", "C. Moh. Yamin",
                "C. Pattimura", "C. Pangeran Antasari", "C. Sultan Hamengkubuwono", "C. Pangeran Diponegoro", "C. Ir. Soekarno",
                "C. Gusti Ngurah Agung", "C. Drs. Moh. Hatta", "C. Sultan Hamengkubuwono", "C. Pangeran Diponegoro", "C. Pattimura",
                "C. DEWI SARTIKA", "C. KH. MAS MANSYUR", "C. AHMAD DAHLAN", "C. MOHAMMAD HOESNI THAMRIN", "C. AHMAD DAHLAN",
                "C. KH. MAS MANSYUR", "C. MOHAMMAD HOESNI THAMRIN", "C. AGUS SALIM", "C. MOHAMMAD HOESNI THAMRIN", "A. SULTAN MAHMUD BADARUDDIN II"};
    public String[] jawabanD
            = {"D. Imam Bonjol", "D. R.A Kartini", "D. Ir. Soekarno", "D. Soeharto", "D. Dewi Sartika",
                "D. Imam Bonjol", "D. KI Hajar Dewantoro", "D. Soeharto", "D. Cut Nyak Meutia", "D. Fatmawati",
                "D. Tuanku Imam Bonjol", "D. Ir. Soekarno", "D. Abdul Muis", "D. Dewi Sartika", "D. Sultan Hamengkubuwono",
                "D. I Gusti Mangunkusumo", "D. KI Hajar Dewantoro", "D. Abdul Muis", "D. Achmad Soebardjo", "D. Ir. Soekarno",
                "D. FATMAWATI", "D. AHMAD DAHLAN", "D. KH. MAS MANSYUR", "D. HASYIM ASY’ARI", "D. DR. SOEPOMO",
                "D. DR. SOEPOMO", "D. DEWI SARTIKA", "D. MOHAMMAD HOESNI THAMRIN", "D. KH. MAS MANSYUR", "D. DR. MOH SALEH"};
    //---------------------------------------------------------------
    // urutan jawaban per indeksSoal -->       
    //    soal ke:                0    1     2     3     4
    //                            a ,  b  ,  a  ,  c  ,  d
    //---------------------------------------------------------------
    public boolean[] statusA
            = {false, false, false, false, true,
                false, false, false, true, false,
                true, false, false, false, false,
                true, false, true, false, false,
                false, false, true, false, false,
                false, false, false, true};
    public boolean[] statusB
            = {true, true, false, false, false,
                true, false, false, false, true,
                false, false, true, false, true,
                false, true, false, false, false,
                true, false, false, true, false,
                false, true, false, false};
    public boolean[] statusC
            = {false, false, true, true, false,
                false, true, true, false, false,
                false, true, false, true, false,
                false, false, false, false, true,
                false, false, false, false, false,
                true, false, false, false};
    public boolean[] statusD
            = {false, false, false, false, false,
                false, false, false, false, false,
                false, false, false, false, false,
                false, false, false, true, false,
                false, true, false, false, true,
                false, false, true, false};
    //----------------------------------------------------------------
    // end of deklarasi soal dan jawaban
    //----------------------------------------------------------------

    /* ========================================
                    daftar subrutin  
    ==============================================*/
    //-- ------------------------------------------------
    //-- inisialisasi permainan
    public MulaiGame() {
        initComponents();
        shuffleArray(solutionArray);
        for (int i = 0; i < solutionArray.length; i++) {
            System.out.println(solutionArray[i] + " ");
            cekIndex = solutionArray[0];
        }
        skorCounter.setText(String.format("%d", nilai)); //cetak skor awal
        listJawaban = new JButton[]{a, b, c, d};
        daftarTulisanJawaban(cekIndex);
        setLocationRelativeTo(null); //otomatis di tengah
        timingnya();

    }

    //-- -----------------------------------------------------
    //membuat timer dengan kondisi2nya
    private void timingnya() {
        timer.start();
        timerCounter.setText(String.format("%d", waktu));
        levelCounter.setText(String.format("%d", level));
    }

    private class Listener implements ActionListener {

        // class Listener ini diperuntukkan timer, shg tiap delay_waktu (750ms)
        // akan mengerjakan tugas dibawah ini
        public void actionPerformed(ActionEvent e) {
            waktu = (waktu - 1);
            timerCounter.setText(String.format("%d", waktu)); //mengupdate tulisan timer 
            //ketika waktunya = 0, maka waktu kereset menjadi 20 dan ke level berikutnya,, atau
            //ketika jawaban diklik maka akan ganti ke level berikutnya dan waktu kereset menjadi 20 lagi
            //dan status pilihan jawaban dikembalikan ke nilai defaultnya (false, disini);;;;
            //dan skor akan berubah jika benar atau tetap jika salah (lihat cekBenarkah)
            if (waktu == 0 || a.isSelected() || b.isSelected() || c.isSelected() || d.isSelected()) {
                skorCounter.setText(String.format("%d", nilai)); // cetak skor
                //dibawah ini kondisi jika level sudah max (level 20)
                if (level == 20 && waktu == 0 || level == 20 && a.isSelected() || level == 20 && b.isSelected() || level == 20 && c.isSelected() || level == 20 && d.isSelected()) {
                    a.setSelected(false);
                    b.setSelected(false);
                    c.setSelected(false);
                    d.setSelected(false);
                    timingnyaDiStop();
                    //sama netbeans disuruh kasi try-catch
                    try {
                        masukkanSkor(); // mestinya ini aja
                    } catch (IOException ex) {
                        Logger.getLogger(MulaiGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else { //ketika levelnya masih belum sampai akhir
                    a.setSelected(false);
                    b.setSelected(false);
                    c.setSelected(false);
                    d.setSelected(false);
                    waktu = 3;
                    level++;
                    counRandom++;
                    cekIndex = solutionArray[counRandom - 1];
                    daftarTulisanJawaban(cekIndex - 1);
                    System.out.println(cekIndex - 1 + " Masuk indeks");
                    skorCounter.setText(String.format("%d", nilai));
                    timerCounter.setText(String.format("%d", waktu));
                    levelCounter.setText(String.format("%d", level));

                }
            }

        }
    }

    //-- -----------------------------------------------------
    //kondisi timer berhenti dan di resume
    private void timingnyaDiStop() {
        timer.stop();
    }

    private void timingnyaMainLagi() {
        timer.start();
    }

    //-- ------------------------------------------------------
    //memasukkan jawaban2 ke soal sesuai indeksSoal:
//    public int getAngkaRandom() {
//        int min = 0;
//        int result, FixResult = 0;
//        boolean cek = false;
//        int max = persoalan.length;
//        Random random = new Random();
//        result = min + random.nextInt(max);
//        System.out.println("di indexs: " + result);
//        return result;
//    }
    static void shuffleArray(int[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

//    public int runRandom() {
//        int get;
//        int[] tempArray = new int[counRandom];
//        get = getAngkaRandom();
//        for (int i = 0; i < tempArray.length; i++) {
//            if (tempArray == null) {
//                tempArray[i] = get;
//            } else {
//                if (tempArray[i] == get) {
//                    get = getAngkaRandom();
//                }
//            }
//        }
//        for (int i = 0; i < tempArray.length; i++) {
//            System.out.println(tempArray[i]);
//        }
//        return get;
//    }
    private void daftarTulisanJawaban(int indeksSoal) {
        tempatSoal.setIcon(new ImageIcon(persoalan[indeksSoal]));
        listJawaban[0].setText(jawabanA[indeksSoal]);
        listJawaban[1].setText(jawabanB[indeksSoal]);
        listJawaban[2].setText(jawabanC[indeksSoal]);
        listJawaban[3].setText(jawabanD[indeksSoal]);
    }

    //-- -------------------------------------------------------
    //subrutin untuk cek jawaban di klik
    private void cekBenarkah(boolean tampungjawab, boolean[] status) {
        if (tampungjawab == status[cekIndex - 1]) {
            nilai += waktu + 5;
        } else {
            nilai += 0; //nilai ndak berubah
        }
    }

    //-- ------------------------------------------------------
    //saat level sudah selesai atau keluar paksa dari game:
    private void masukkanSkor() throws IOException {
        JOptionPane.showMessageDialog(this, "Permainan selesai");
        try {
            do {
                nama = JOptionPane.showInputDialog(this, "Pesan woeeeeeeeeeeeey", null, JOptionPane.OK_OPTION);
            } while (nama.equals(""));
            JOptionPane.showMessageDialog(this, "Skor Anda = " + nilai);
//        try {
//            model.insert(nama, nilai);
//        } 
//        catch (SQLException | ParseException ex) {
//            Logger.getLogger(MulaiGame.class.getName()).log(Level.SEVERE, null, ex);
//        }
            tulisNilai();
            this.dispose();
            new bahas().setVisible(true);
        } catch (Exception rim) {
           JOptionPane.showMessageDialog(this, "Silahkan Masukkan nama jika akan keluar permainan");
        }

    }

    // tulis nilai di File text seperti txt
    public void tulisNilai() {
        File scoreFile = new File("topskor.skor"); //membuat file baru
        if (!scoreFile.exists()) { // jika tidak ada file di direktori project, maka akan otomatis dibuat
            try {
                scoreFile.createNewFile();
            } catch (Exception e) {
            }
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(scoreFile, true));
            if (nilai < 10) {
                writer.write(nama + " 0" + nilai);
                writer.newLine();
            } else {
                writer.write(nama + " " + nilai);
                writer.newLine();
            }
        } catch (Exception e) {
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        levelCounter = new javax.swing.JLabel();
        tempatSoal = new javax.swing.JLabel();
        a = new javax.swing.JButton();
        b = new javax.swing.JButton();
        c = new javax.swing.JButton();
        d = new javax.swing.JButton();
        timerCounter = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        skorCounter = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(989, 698));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(590, 470));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        levelCounter.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        levelCounter.setForeground(new java.awt.Color(255, 255, 255));
        levelCounter.setText("4");
        jPanel2.add(levelCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 50, 30));

        tempatSoal.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.add(tempatSoal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 610, 380));

        a.setBackground(new java.awt.Color(255, 255, 255));
        a.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        a.setText("jButton1");
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        jPanel2.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 340, 40));

        b.setBackground(new java.awt.Color(255, 255, 255));
        b.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        b.setText("jButton2");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
        jPanel2.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 350, 40));

        c.setBackground(new java.awt.Color(255, 255, 255));
        c.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        c.setText("jButton3");
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        jPanel2.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 340, 40));

        d.setBackground(new java.awt.Color(255, 255, 255));
        d.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        d.setText("jButton4");
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });
        jPanel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 500, 350, 40));

        timerCounter.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        timerCounter.setForeground(new java.awt.Color(255, 255, 255));
        timerCounter.setText("20");
        jPanel2.add(timerCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 870, 670));

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        skorCounter.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        skorCounter.setForeground(new java.awt.Color(255, 0, 0));
        skorCounter.setText("50");
        jPanel1.add(skorCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 80, -1));

        btnHome.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        btnHome.setAlignmentX(0.5F);
        btnHome.setBorder(new javax.swing.border.MatteBorder(null));
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 150, 50));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakgambarcerdas/ui/play.jpeg"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 710));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//-- ketika tombol Home ditekan --
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        timingnyaDiStop();
        int inginKeluar;// 0 = (YES) exit ke main menu , 1 = (NO)tidak jadi //default netbeansnya
        inginKeluar = JOptionPane.showConfirmDialog(this, "Anda yakin ingin mengakhiri permainan?", "Konfirmasi Kembali", 0);
        if (inginKeluar == 0) //kalo bener mau keluar, skoring muncul (masukkanSkor)
        {
            try {
                masukkanSkor();
            } catch (IOException ex) {
                Logger.getLogger(MulaiGame.class.getName()).log(Level.SEVERE, null, ex);
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
        // akan dibandingkan apakah yang kita jawab (jawabanmu) nilai nya sama dengan kunci
//        Icon btna = this.a.getSelectedIcon();
//        if (btna.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "nama tidak boleh kosong", "CAUTION", JOptionPane.INFORMATION_MESSAGE);
//            this.dispose();
//    }else { JOptionPane.showMessageDialog(this, "Selamat Datang di Game Save Indonesia", "CAUTION", JOptionPane.INFORMATION_MESSAGE); 
//        new Main().setVisible(true); ;}
//    } 
    }//GEN-LAST:event_aActionPerformed
//-- ketika opsi B ditekan --
    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        b.setSelected(true);
        jawabanmu = true;
        cekBenarkah(jawabanmu, statusB);
    }//GEN-LAST:event_bActionPerformed
//-- ketika opsi C ditekan --
    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        c.setSelected(true);
        jawabanmu = true;
        cekBenarkah(jawabanmu, statusC);
    }//GEN-LAST:event_cActionPerformed
//-- ketika opsi D ditekan --
    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        d.setSelected(true);
        jawabanmu = true;
        cekBenarkah(jawabanmu, statusD);
    }//GEN-LAST:event_dActionPerformed

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
            java.util.logging.Logger.getLogger(MulaiGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MulaiGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MulaiGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MulaiGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MulaiGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a;
    private javax.swing.JButton b;
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton c;
    private javax.swing.JButton d;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel levelCounter;
    private javax.swing.JLabel skorCounter;
    private javax.swing.JLabel tempatSoal;
    private javax.swing.JLabel timerCounter;
    // End of variables declaration//GEN-END:variables

}


/* *********************************************
hal yang belum ditambahkan:
1. subrutin untuk penskoran >>>>    sudah ditambahkan (6/6)
2. subrutin untuk mengklik jawaban itu benar >>>    sudah ditambahkan (6/6)
3. subrutin untuk linking dari skor soal ke daftar skor di main menu  >>>>      sudah ditambahkan(11/6)
*******************************************************************
 */
