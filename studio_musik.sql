-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 15, 2026 at 11:37 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studio_musik`
--

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` varchar(50) NOT NULL,
  `nama_band` varchar(100) NOT NULL,
  `tanggal` varchar(50) NOT NULL,
  `jam` varchar(50) NOT NULL,
  `harga_dasar` double NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `tipe_ruangan` varchar(100) DEFAULT '-',
  `fasilitas_tambahan` varchar(100) DEFAULT '-'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `nama_band`, `tanggal`, `jam`, `harga_dasar`, `kategori`, `tipe_ruangan`, `fasilitas_tambahan`) VALUES
('001', 'D\'Sultandz', '25-10-2026', '14:00', 150000, 'Reguler', 'Studio Standard', '-'),
('002', 'Dewa 17', '30-10-2026', '19:00', 300000, 'VIP', '-', 'AC & Sound Premium');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
