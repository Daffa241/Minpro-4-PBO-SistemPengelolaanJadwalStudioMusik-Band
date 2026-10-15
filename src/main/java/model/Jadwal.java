/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public abstract class Jadwal {
    private String idJadwal;
    private String namaBand;
    private String tanggal;
    private String jam;
    private double hargaDasar;

    public Jadwal(String idJadwal, String namaBand, String tanggal, String jam, double hargaDasar) {
        this.idJadwal = idJadwal;
        this.namaBand = namaBand;
        this.tanggal = tanggal;
        this.jam = jam;
        this.hargaDasar = hargaDasar;
    }

    public String getIdJadwal() { return idJadwal; }
    public void setIdJadwal(String idJadwal) { this.idJadwal = idJadwal; }

    public String getNamaBand() { return namaBand; }
    public void setNamaBand(String namaBand) { this.namaBand = namaBand; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public String getJam() { return jam; }
    public void setJam(String jam) { this.jam = jam; }

    public double getHargaDasar() { return hargaDasar; }
    public void setHargaDasar(double hargaDasar) { this.hargaDasar = hargaDasar; }

    public abstract double hitungTotalSewa();
    public abstract void tampilkanInfo();

    public void tampilkanInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println("[" + idJadwal + "] " + namaBand + " | Tgl: " + tanggal + " | Jam: " + jam);
        } else {
            tampilkanInfo();
        }
    }
}
