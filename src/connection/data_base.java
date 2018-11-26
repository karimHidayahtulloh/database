///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package connection;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import connection.connection;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.text.ParseException;
//
///**
// *
// * @author USER
// */
//public class data_base {
//
////    private Statement stm;
////    private ResultSet rs;
////    private String jobs, nama;
////    connection konek;
//    private connection kontol;
//    Connection con;
//    Statement stm;
//
//    public data_base() throws SQLException {
////        this.konek = new connection();
//
//        con = kontol.Connection();
//        stm = con.createStatement();
//    }
//// koneksi cn = new koneksi();
////        ResultSet data = cn.getResult("select * from public.data_user;");
////        System.out.println(data.getRow());
////        while(data.next()){
////            System.out.println(data.getString(3)+data.getString(4));
//
//    
//            String query = "insert into user_name from db_game_si.user";
////            "username" nama tabel, dan "db_game_si" nama skemanya
//            
//    
//
//    public void insert (String user_name, Integer skor) throws SQLException, ParseException {
//        String myQuery = "INSERT INTO db_game_si.user (user_name, skor)"
//                + " VALUES (?, ?)";
////                (id_nasabah,  nama, tanggal_masuk, pekerjaan, jenis_kelamin, alamat, no_hp)"
////                + " VALUES (?, ?, ?, ?, 'Laki-laki', ?, ?)";
//        PreparedStatement prstm = con.prepareStatement(myQuery);
//        
//        prstm.setString(1, user_name);
//        prstm.setInt(2, skor);
////        prstm.setString(3, data[2]);
////        prstm.setString(4, data[3]);
//////        prstm.setString(5, data[4]);
////        prstm.setString(5, data[5]);
////        prstm.setInt(6, Integer.valueOf(data[6]));
//        prstm.executeUpdate();
//
//    }
//}
