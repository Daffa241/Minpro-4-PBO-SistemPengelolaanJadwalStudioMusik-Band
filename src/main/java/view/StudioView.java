/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */
import controller.StudioController;
import model.Jadwal;
import model.JadwalReguler;
import model.JadwalVIP;
import java.util.Scanner;

public class StudioView {
    private StudioController controller;
    private Scanner scanner;

    public StudioView(StudioController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void jalankan() {
        int pilihan = -1;
        do {
            System.out.println("\n=== SISTEM JADWAL STUDIO MUSIK ===");
            System.out.println("1. Tambah Jadwal");
            System.out.println("2. Tampilkan Semua Jadwal");
            System.out.println("3. Tampilkan Ringkasan Jadwal");
            System.out.println("4. Ubah Data Jadwal");
            System.out.println("5. Hapus Jadwal");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Pilihan harus berupa angka menu yang sesuai.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    menuTambah();
                    break;
                case 2:
                    menuTampilkan(false);
                    break;
                case 3:
                    menuTampilkan(true);
                    break;
                case 4:
                    menuUbah();
                    break;
                case 5:
                    menuHapus();
                    break;
                case 0:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Menu yang kamu pilih tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    private void menuTambah() {
        System.out.println("\n--- TAMBAH JADWAL ---");
        System.out.print("ID Jadwal: ");
        String id = inputTidakBolehKosong("ID Jadwal");

        if (controller.cariJadwalBerdasarkanId(id) != null) {
            System.out.println("ID ini sudah terpakai di database, gunakan ID lain.");
            return;
        }

        System.out.print("Nama Band: ");
        String nama = inputTidakBolehKosong("Nama Band");
        System.out.print("Tanggal (DD-MM-YYYY): ");
        String tanggal = inputTidakBolehKosong("Tanggal");
        System.out.print("Jam Latihan: ");
        String jam = inputTidakBolehKosong("Jam Latihan");
        double harga = inputHarga();

        System.out.print("Pilih Kategori (1. Reguler | 2. VIP): ");
        String tipe = scanner.nextLine().trim();

        if (tipe.equals("1")) {
            System.out.print("Tipe Ruangan: ");
            String ruang = inputTidakBolehKosong("Tipe Ruangan");
            controller.tambahJadwal(new JadwalReguler(id, nama, tanggal, jam, harga, ruang), "Reguler", ruang);
            System.out.println("Jadwal reguler berhasil disimpan ke database!");
        } else if (tipe.equals("2")) {
            System.out.print("Fasilitas Tambahan: ");
            String fasilitas = inputTidakBolehKosong("Fasilitas Tambahan");
            controller.tambahJadwal(new JadwalVIP(id, nama, tanggal, jam, harga, fasilitas), "VIP", fasilitas);
            System.out.println("Jadwal VIP berhasil disimpan ke database!");
        } else {
            System.out.println("Kategori tidak valid, proses dibatalkan.");
        }
    }

    private void menuTampilkan(boolean ringkas) {
        System.out.println("\n--- DAFTAR JADWAL DATABASE ---");
        if (controller.getDaftarJadwal().isEmpty()) {
            System.out.println("Belum ada data jadwal yang tersimpan di database.");
        } else {
            for (Jadwal j : controller.getDaftarJadwal()) {
                j.tampilkanInfo(ringkas);
            }
        }
    }

    private void menuUbah() {
        System.out.println("\n--- UBAH JADWAL ---");
        System.out.print("Masukkan ID Jadwal yang ingin diubah: ");
        String id = scanner.nextLine().trim();

        Jadwal j = controller.cariJadwalBerdasarkanId(id);
        if (j == null) {
            System.out.println("Data jadwal tidak ditemukan di database.");
            return;
        }

        System.out.print("Nama Band Baru: ");
        String nama = inputTidakBolehKosong("Nama Band");
        System.out.print("Tanggal Baru (DD-MM-YYYY): ");
        String tanggal = inputTidakBolehKosong("Tanggal");
        System.out.print("Jam Baru: ");
        String jam = inputTidakBolehKosong("Jam Latihan");

        System.out.print("Ubah harga sewa dasar juga? (y/n): ");
        String respon = scanner.nextLine().trim();

        if (respon.equalsIgnoreCase("y")) {
            double harga = inputHarga();
            controller.ubahJadwal(id, nama, tanggal, jam, harga);
        } else {
            controller.ubahJadwal(id, nama, tanggal, jam);
        }
        System.out.println("Data jadwal berhasil diperbarui di database!");
    }

    private void menuHapus() {
        System.out.println("\n--- HAPUS JADWAL ---");
        System.out.print("Masukkan ID Jadwal yang ingin dihapus: ");
        String id = scanner.nextLine().trim();

        if (controller.hapusJadwal(id)) {
            System.out.println("Jadwal berhasil dihapus dari database!");
        } else {
            System.out.println("Data jadwal tidak ditemukan.");
        }
    }

    private String inputTidakBolehKosong(String namaField) {
        while (true) {
            String input = scanner.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.print(namaField + " tidak boleh kosong atau cuma spasi. Masukkan lagi: ");
        }
    }

    private double inputHarga() {
        while (true) {
            System.out.print("Harga Sewa Dasar: ");
            try {
                double harga = Double.parseDouble(scanner.nextLine().trim());
                if (harga >= 0) return harga;
                System.out.println("Harga tidak boleh bernilai negatif.");
            } catch (NumberFormatException e) {
                System.out.println("Masukkan nominal angka yang sesuai.");
            }
        }
    }
}