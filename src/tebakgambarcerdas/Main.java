package tebakgambarcerdas;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
//        setLocationRelativeTo(null);
//        playing();
//        Controller(true);
//        initComponents();
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension frameSize = getSize();
//        setLocation(new Point((screenSize.width - frameSize.width) / 2,
//                (screenSize.height - frameSize.width) / 2));
    }

//    Clip karim;
//    AudioInputStream ecin;
//
//    public void playing() {
//        try {
//            ecin = AudioSystem.getAudioInputStream(new File("src//music//MAIN.wav"));
//            karim = AudioSystem.getClip();
//            karim.open(ecin);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
//        }
//    }
//
//    public void Controller(boolean atur) {
//        if (atur == true) {
//            karim.loop(Clip.LOOP_CONTINUOUSLY);
//        } else if (atur == false) {
//            karim.stop();
//        }
//    }
//
//    public void klik(int musicx) {
//        File music = new File("");
//        try {
//            if (musicx == 1) {
//                music = new File("src//music//klikSelect.wav");
//            } else if (musicx == 2) {
//                music = new File("src//music//klikb.wav");
//            } else if (musicx == 3) {
//                music = new File("src//music//klikutama.wav");
//            }
//            AudioInputStream audioIn = AudioSystem.getAudioInputStream(music);
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioIn);
//            clip.start();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
//        }
//    }
//
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        keluar = new javax.swing.JButton();
        main = new javax.swing.JButton();
        tentang = new javax.swing.JButton();
        skor = new javax.swing.JButton();
        pengaturan = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TEBAK GAMBAR CERDAS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        keluar.setBackground(new java.awt.Color(255, 255, 255));
        keluar.setContentAreaFilled(false);
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, 260, 80));

        main.setBackground(new java.awt.Color(220, 255, 183));
        main.setContentAreaFilled(false);
        main.setSelected(true);
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 250, 90));

        tentang.setBackground(new java.awt.Color(255, 255, 255));
        tentang.setContentAreaFilled(false);
        tentang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tentangActionPerformed(evt);
            }
        });
        getContentPane().add(tentang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 260, 90));

        skor.setBackground(new java.awt.Color(255, 255, 255));
        skor.setContentAreaFilled(false);
        skor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skorActionPerformed(evt);
            }
        });
        getContentPane().add(skor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 260, 90));

        pengaturan.setBackground(new java.awt.Color(255, 255, 255));
        pengaturan.setContentAreaFilled(false);
        pengaturan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengaturanActionPerformed(evt);
            }
        });
        getContentPane().add(pengaturan, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, 250, 90));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakgambarcerdas/ui/menu.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        int inginKeluar;// 0 = (YES) exit ke main menu , 1 = (NO)tidak jadi //default netbeansnya
        inginKeluar = JOptionPane.showConfirmDialog(this, "Anda yakin ingin mengakhiri permainan?", "Konfirmasi Kembali", 0);
        
        if (inginKeluar == 0) //kalo bener mau keluar, skoring muncul (masukkanSkor)
        {
          System.exit(0);  
        } else {
            int kembali = 0;
//            this.dispose();
//            new Main().setVisible(true);
        }
//        System.exit(0); //KELUAR GAME 
    }//GEN-LAST:event_keluarActionPerformed

    private void tentangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tentangActionPerformed
        this.dispose();//window main menunya ke minimize
        new tentang().setVisible(true);// tampilan mulaiGame muncul
    }//GEN-LAST:event_tentangActionPerformed

    private void skorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skorActionPerformed
        try {//disuruh nambain try-catch sama netbeans nya

            new skor().setVisible(true); //tampilan skor muncul
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();//window main menunya ke minimize
    }//GEN-LAST:event_skorActionPerformed

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed
        this.dispose();//window main menunya ke minimize
        new MulaiGame().setVisible(true);// tampilan mulaiGame muncul
    }//GEN-LAST:event_mainActionPerformed

    private void pengaturanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengaturanActionPerformed
        this.dispose();
        new pengaturan().setVisible(true);
    }//GEN-LAST:event_pengaturanActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton keluar;
    private javax.swing.JButton main;
    private javax.swing.JButton pengaturan;
    private javax.swing.JButton skor;
    private javax.swing.JButton tentang;
    // End of variables declaration//GEN-END:variables
}
