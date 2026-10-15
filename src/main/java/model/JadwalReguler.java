/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class JadwalReguler extends Jadwal {
    private String tipeRuangan;

    public JadwalReguler(String idJadwal, String namaBand, String tanggal, String jam, double hargaDasar, String tipeRuangan) {
        super(idJadwal, namaBand, tanggal, jam, hargaDasar);
        this.tipeRuangan = tipeRuangan;
    }

    public String getTipeRuangan() { return tipeRuangan; }
    public void setTipeRuangan(String tipeRuangan) { this.tipeRuangan = tipeRuangan; }

    @Override
    public double hitungTotalSewa() {
        return getHargaDasar();
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== JADWAL REGULER ===");
        System.out.println("ID Jadwal    : " + getIdJadwal());
        System.out.println("Nama Band    : " + getNamaBand());
        System.out.println("Tanggal      : " + getTanggal());
        System.out.println("Jam Latihan  : " + getJam());
        System.out.println("Tipe Ruangan : " + tipeRuangan);
        System.out.println("Total Sewa   : Rp" + hitungTotalSewa());
        System.out.println("-----------------------------------");
    }
}
