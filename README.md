# Sistem Manajemen Jadwal Studio Musik


Nama: Daffa Rizqi Fadhillah

NIM: 2509116068

Kelas: B


## 1 Deskripsi Singkat Program
Program Sistem Manajemen Jadwal Studio Musik versi Minpro 4 adalah pengembangan aplikasi konsol berbasis Java yang mengimplementasikan arsitektur MVC dan DAO Pattern. Aplikasi ini dirancang untuk mengelola penjadwalan penyewaan studio musik kategori Reguler dan VIP secara profesional dengan menghubungkan aplikasi Java ke database MySQL menggunakan JDBC dan pengaman query PreparedStatement, sehingga seluruh data jadwal tersimpan secara aman dan permanen.

---

## 2 Penjelasan Struktur Package

<img width="326" height="451" alt="image" src="https://github.com/user-attachments/assets/163d69b7-8df3-4e94-945e-cde00a932286" />

Proyek ini diorganisasikan ke dalam beberapa package untuk menerapkan pemisahan tugas secara rapi:
* config: Berisi kelas Koneksi.java yang bertanggung jawab sebagai jembatan koneksi antara program Java dan database MySQL menggunakan DriverManager.
* model: Berisi kelas-kelas entitas berbasis PBO abstract class, interface, dan subclass, serta kelas JadwalDAO.java yang bertindak sebagai pengelola interaksi database CRUD.
* controller: Berisi kelas StudioController.java yang bertugas menjembatani komunikasi antara lapisan antarmuka view dan logika data model atau DAO.
* view: Berisi kelas StudioView.java untuk menangani antarmuka pengguna berbasis teks di konsol Command-Line Interface, termasuk proses input data dan validasi.
* main: Berisi kelas Main.java sebagai titik awal utama saat program pertama kali dijalankan.

---

## 3 Penjelasan Alur Program
1. Saat program dijalankan dari Main.java, objek StudioController dan StudioView diinisialisasi, serta koneksi ke database studio_musik dipersiapkan melalui kelas Koneksi.
   
   <img width="255" height="141" alt="image" src="https://github.com/user-attachments/assets/5b183930-ebd0-4d3b-8ee3-35914ad788de" />

2. Menu Utama: Pengguna disajikan pilihan menu interaktif di konsol, meliputi:
   * Menambah jadwal baru Reguler atau VIP.
     
     <img width="329" height="314" alt="image" src="https://github.com/user-attachments/assets/c8ed080a-d55c-4359-a9aa-70572881862b" />

   * Menampilkan seluruh daftar jadwal dari database.
     
     <img width="307" height="446" alt="image" src="https://github.com/user-attachments/assets/bdd186e3-5dc3-4258-8579-ae486eeaf505" />

   * Menampilkan ringkasan jadwal.
     
     <img width="363" height="228" alt="image" src="https://github.com/user-attachments/assets/a8441753-b5d0-4a97-9954-861cf12114d4" />

   * Mengubah data jadwal yang sudah ada.
     
     <img width="322" height="278" alt="image" src="https://github.com/user-attachments/assets/a5cde055-ba43-479e-b0c1-23fc50987c37" />

   * Menghapus jadwal berdasarkan ID.
     
     <img width="309" height="207" alt="image" src="https://github.com/user-attachments/assets/8803543a-02eb-47ef-af0d-48bd835e4796" />

3. Eksekusi Data: Ketika pengguna memilih aksi seperti menambah atau mengambil data, StudioView meneruskan permintaan ke StudioController, yang kemudian memanggil metode di JadwalDAO untuk mengeksekusi perintah SQL INSERT, SELECT, UPDATE, atau DELETE ke database MySQL secara aman menggunakan PreparedStatement.

<img width="927" height="494" alt="image" src="https://github.com/user-attachments/assets/90981754-2fa0-430e-8755-ee808fdbccd8" />

---

## 4 Penjelasan Penerapan Encapsulation dan Inheritance

  <img width="215" height="91" alt="image" src="https://github.com/user-attachments/assets/06097101-7a15-4ab5-8022-7eaffd7e5dc0" />

* Encapsulation: Diterapkan pada kelas-kelas entitas seperti Jadwal.java, JadwalReguler.java, dan JadwalVIP.java di mana atribut data seperti idJadwal, namaBand, tanggal, jam, dan hargaDasar dideklarasikan dengan hak akses private. Atribut tersebut hanya dapat diakses atau dimodifikasi melalui method publik getter dan setter.

  <img width="215" height="91" alt="image" src="https://github.com/user-attachments/assets/beec049f-11ca-46b8-8a77-b5bdf590f8b8" />

* Inheritance: Diterapkan pada hierarki kelas entitas. Kelas Jadwal bertindak sebagai superclass induk yang mewariskan atribut dan method dasarnya kepada subclass anak yaitu JadwalReguler dan JadwalVIP, sehingga menghindari duplikasi kode.

---

## 5 Penjelasan Penerapan Polymorphism dan Abstraction
* Abstraction: Kelas Jadwal didefinisikan sebagai abstract class yang memiliki method abstrak hitungTotalSewa() dan tampilkanInfo(), mewajibkan setiap kelas turunan untuk mengimplementasikan detail logikanya sendiri. Selain itu, digunakan juga interface DapatDiskon yang diimplementasikan pada kelas JadwalVIP.

  <img width="379" height="32" alt="image" src="https://github.com/user-attachments/assets/ddff73a3-5b1a-4526-8f19-276a8480601a" />

* Polymorphism: Diterapkan melalui mekanisme method overriding. Meskipun method yang dipanggil sama seperti hitungTotalSewa() atau tampilkanInfo(), perilakunya akan menyesuaikan bentuk objek aslinya apakah itu objek JadwalReguler atau JadwalVIP.
  
  <img width="379" height="32" alt="image" src="https://github.com/user-attachments/assets/721bbb15-f1a5-432d-815b-980f90689039" />

---

## 6 Penjelasan Penerapan JDBC

  <img width="431" height="125" alt="image" src="https://github.com/user-attachments/assets/80552399-1092-43ae-8948-3fb70f541a61" />

* JDBC: Digunakan untuk menghubungkan aplikasi berbasis Java dengan sistem manajemen basis data MySQL menggunakan library mysql-connector-j.

  <img width="659" height="400" alt="image" src="https://github.com/user-attachments/assets/5a4257c3-6cbe-4fe1-8979-0a1a4de003d7" />

* Koneksi DriverManager: Kelas Koneksi memanfaatkan DriverManager.getConnection() untuk membuka sesi komunikasi ke database studio_musik.

  <img width="1425" height="518" alt="image" src="https://github.com/user-attachments/assets/935c8941-56e4-4c5f-8849-676d1732886a" />

* Keamanan PreparedStatement: Di dalam kelas JadwalDAO, operasi penyimpanan INSERT dan pembaruan UPDATE menggunakan PreparedStatement dengan parameter tanda tanya. Hal ini berfungsi untuk mencegah celah keamanan SQL Injection sekaligus memastikan parameter data dimasukkan secara aman ke dalam database.
