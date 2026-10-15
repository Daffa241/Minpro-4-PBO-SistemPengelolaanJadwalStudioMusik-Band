/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
import config.Koneksi;
import java.sql.*;
import java.util.ArrayList;

public class JadwalDAO {

    public ArrayList<Jadwal> getAllJadwal() {
        ArrayList<Jadwal> daftar = new ArrayList<>();
        String query = "SELECT * FROM jadwal";
        
        try (Connection conn = Koneksi.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
            while (rs.next()) {
                String id = rs.getString("id_jadwal");
                String nama = rs.getString("nama_band");
                String tanggal = rs.getString("tanggal");
                String jam = rs.getString("jam");
                double harga = rs.getDouble("harga_dasar");
                String kategori = rs.getString("kategori");
                
                if (kategori.equalsIgnoreCase("Reguler")) {
                    String ruang = rs.getString("tipe_ruangan");
                    daftar.add(new JadwalReguler(id, nama, tanggal, jam, harga, ruang));
                } else if (kategori.equalsIgnoreCase("VIP")) {
                    String fasilitas = rs.getString("fasilitas_tambahan");
                    daftar.add(new JadwalVIP(id, nama, tanggal, jam, harga, fasilitas));
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data dari database.");
        }
        return daftar;
    }

    public boolean insertJadwal(Jadwal j, String kategori, String detail) {
        String query = "INSERT INTO jadwal (id_jadwal, nama_band, tanggal, jam, harga_dasar, kategori, tipe_ruangan, fasilitas_tambahan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, j.getIdJadwal());
            pstmt.setString(2, j.getNamaBand());
            pstmt.setString(3, j.getTanggal());
            pstmt.setString(4, j.getJam());
            pstmt.setDouble(5, j.getHargaDasar());
            pstmt.setString(6, kategori);
            
            if (kategori.equalsIgnoreCase("Reguler")) {
                pstmt.setString(7, detail);
                pstmt.setString(8, "-");
            } else {
                pstmt.setString(7, "-");
                pstmt.setString(8, detail);
            }
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal memasukkan data ke database.");
            return false;
        }
    }

    public boolean updateJadwal(String id, String nama, String tanggal, String jam, double harga) {
        String query = "UPDATE jadwal SET nama_band = ?, tanggal = ?, jam = ?, harga_dasar = ? WHERE id_jadwal = ?";
        
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, nama);
            pstmt.setString(2, tanggal);
            pstmt.setString(3, jam);
            pstmt.setDouble(4, harga);
            pstmt.setString(5, id);
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal memperbarui data di database.");
            return false;
        }
    }

    public boolean updateJadwal(String id, String nama, String tanggal, String jam) {
        String query = "UPDATE jadwal SET nama_band = ?, tanggal = ?, jam = ? WHERE id_jadwal = ?";
        
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, nama);
            pstmt.setString(2, tanggal);
            pstmt.setString(3, jam);
            pstmt.setString(4, id);
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal memperbarui data di database.");
            return false;
        }
    }

    public boolean deleteJadwal(String id) {
        String query = "DELETE FROM jadwal WHERE id_jadwal = ?";
        
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Gagal menghapus data dari database.");
            return false;
        }
    }

    public Jadwal getJadwalById(String id) {
        String query = "SELECT * FROM jadwal WHERE id_jadwal = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String idJadwal = rs.getString("id_jadwal");
                String nama = rs.getString("nama_band");
                String tanggal = rs.getString("tanggal");
                String jam = rs.getString("jam");
                double harga = rs.getDouble("harga_dasar");
                String kategori = rs.getString("kategori");
                
                if (kategori.equalsIgnoreCase("Reguler")) {
                    String ruang = rs.getString("tipe_ruangan");
                    return new JadwalReguler(idJadwal, nama, tanggal, jam, harga, ruang);
                } else {
                    String fasilitas = rs.getString("fasilitas_tambahan");
                    return new JadwalVIP(idJadwal, nama, tanggal, jam, harga, fasilitas);
                }
            }
        } catch (SQLException e) {
            System.out.println("Pencarian data gagal.");
        }
        return null;
    }
}