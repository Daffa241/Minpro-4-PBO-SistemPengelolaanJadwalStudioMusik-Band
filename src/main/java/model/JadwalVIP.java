/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class JadwalVIP extends Jadwal implements DapatDiskon {
    private String fasilitasTambahan;

    public JadwalVIP(String idJadwal, String namaBand, String tanggal, String jam, double hargaDasar, String fasilitasTambahan) {
        super(idJadwal, namaBand, tanggal, jam, hargaDasar);
        this.fasilitasTambahan = fasilitasTambahan;
    }

    public String getFasilitasTambahan() { return fasilitasTambahan; }
    public void setFasilitasTambahan(String fasilitasTambahan) { this.fasilitasTambahan = fasilitasTambahan; }

    @Override
    public double hitungDiskon(double persentase) {
        return getHargaDasar() * (persentase / 100);
    }

    @Override
    public double hitungTotalSewa() {
        return getHargaDasar() - hitungDiskon(10);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== JADWAL VIP ===");
        System.out.println("ID Jadwal    : " + getIdJadwal());
        System.out.println("Nama Band    : " + getNamaBand());
        System.out.println("Tanggal      : " + getTanggal());
        System.out.println("Jam Latihan  : " + getJam());
        System.out.println("Fasilitas    : " + fasilitasTambahan);
        System.out.println("Harga Dasar  : Rp" + getHargaDasar());
        System.out.println("Total Sewa   : Rp" + hitungTotalSewa() + " (Diskon VIP 10%)");
        System.out.println("-----------------------------------");
    }
}