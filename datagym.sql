-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Bulan Mei 2024 pada 05.00
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datagym`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `datagym`
--

CREATE TABLE `datagym` (
  `nama` varchar(20) NOT NULL,
  `alat` varchar(30) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `sewa` int(11) NOT NULL,
  `totalbiaya` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `datagym`
--

INSERT INTO `datagym` (`nama`, `alat`, `telepon`, `sewa`, `totalbiaya`) VALUES
('may', 'barbel 100 kg', '087722112', 3, 150000),
('rayosdesol', 'tali tambang kapal', '08221112', 1, 50000),
('devi', 'lompat tail', '087132415', 2, 100000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
