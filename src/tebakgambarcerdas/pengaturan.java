/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tebakgambarcerdas;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class pengaturan extends javax.swing.JFrame {

    public pengaturan() {
        initComponents();
        setLocationRelativeTo(null);
        playing();
        Controller(true);
    }

    Clip karim;
    AudioInputStream ecin;

    public void playing() {
        try {
            ecin = AudioSystem.getAudioInputStream(new File("src//music//MAIN.wav"));
            karim = AudioSystem.getClip();
            karim.open(ecin);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public void Controller(boolean atur) {
        if (atur == true) {
            karim.loop(Clip.LOOP_CONTINUOUSLY);
        } else if (atur == false) {
            karim.stop();
        }
    }

    public void klik(int musicx) {
        File music = new File("");
        try {
            if (musicx == 1) {
                music = new File("src//music//klikSelect.wav");
            } else if (musicx == 2) {
                music = new File("src//music//klikb.wav");
            } else if (musicx == 3) {
                music = new File("src//music//klikutama.wav");
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(music);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        off = new javax.swing.JButton();
        on = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        off.setBorder(null);
        off.setContentAreaFilled(false);
        off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offActionPerformed(evt);
            }
        });
        getContentPane().add(off, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 160, 160));

        on.setBorder(null);
        on.setContentAreaFilled(false);
        on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onActionPerformed(evt);
            }
        });
        getContentPane().add(on, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 140, 160));

        keluar.setBorder(null);
        keluar.setContentAreaFilled(false);
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 610, 220, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakgambarcerdas/ui/son1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onActionPerformed
        Controller(true);
        off.setVisible(true);
        on.setVisible(false);
    }//GEN-LAST:event_onActionPerformed

    private void offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offActionPerformed
        Controller(false);
        on.setVisible(true);
        off.setVisible(false);
    }//GEN-LAST:event_offActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        this.dispose();//window main menunya ke minimize
        new Main().setVisible(true);// tampilan mulaiGame muncul
    }//GEN-LAST:event_keluarActionPerformed

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
            java.util.logging.Logger.getLogger(pengaturan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengaturan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengaturan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengaturan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengaturan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton keluar;
    private javax.swing.JButton off;
    private javax.swing.JButton on;
    // End of variables declaration//GEN-END:variables
}
