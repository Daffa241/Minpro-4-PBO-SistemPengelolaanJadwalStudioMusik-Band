/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ASUS
 */
import model.Jadwal;
import model.JadwalDAO;
import java.util.ArrayList;

public class StudioController {
    private JadwalDAO jadwalDAO = new JadwalDAO();

    public void tambahJadwal(Jadwal jadwal, String kategori, String detail) {
        jadwalDAO.insertJadwal(jadwal, kategori, detail);
    }

    public ArrayList<Jadwal> getDaftarJadwal() {
        return jadwalDAO.getAllJadwal();
    }

    public Jadwal cariJadwalBerdasarkanId(String idJadwal) {
        return jadwalDAO.getJadwalById(idJadwal.trim());
    }

    public boolean ubahJadwal(String idJadwal, String namaBaru, String tanggalBaru, String jamBaru) {
        return jadwalDAO.updateJadwal(idJadwal, namaBaru, tanggalBaru, jamBaru);
    }

    public boolean ubahJadwal(String idJadwal, String namaBaru, String tanggalBaru, String jamBaru, double hargaBaru) {
        return jadwalDAO.updateJadwal(idJadwal, namaBaru, tanggalBaru, jamBaru, hargaBaru);
    }

    public boolean hapusJadwal(String idJadwal) {
        return jadwalDAO.deleteJadwal(idJadwal);
    }
}