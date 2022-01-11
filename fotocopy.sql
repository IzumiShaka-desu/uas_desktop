-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Waktu pembuatan: 11 Jan 2022 pada 09.01
-- Versi server: 5.7.34
-- Versi PHP: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fotocopy`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama` varchar(1000) NOT NULL,
  `jenis` varchar(1000) NOT NULL,
  `quantity` int(20) NOT NULL,
  `ukuran` varchar(1000) NOT NULL,
  `harga` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `nama`, `jenis`, `quantity`, `ukuran`, `harga`) VALUES
(1, 'ito', 'jenis', 10, 'sd', '1000'),
(2, 'pulpen', 'atk', 20, 'buah', '1500');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_trans`
--

CREATE TABLE `detail_trans` (
  `id_trans` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `jumlah_belanja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_trans`
--

INSERT INTO `detail_trans` (`id_trans`, `id_barang`, `harga_barang`, `jumlah_belanja`) VALUES
(1, 1, 1000, 6),
(1, 2, 1500, 4),
(2, 1, 1000, 6),
(2, 2, 1500, 4),
(5, 1, 1000, 20),
(5, 2, 1500, 4),
(7, 1, 1000, 20),
(7, 2, 1500, 4),
(8, 1, 1000, 20),
(8, 2, 1500, 4),
(9, 1, 1000, 12),
(9, 2, 1500, 12),
(10, 1, 1000, 12),
(10, 2, 1500, 12),
(11, 2, 1500, 3),
(11, 1, 1000, 12),
(12, 2, 1500, 20),
(13, 2, 1500, 3),
(13, 1, 1000, 12),
(14, 1, 1000, 12),
(15, 1, 1000, 2);

--
-- Trigger `detail_trans`
--
DELIMITER $$
CREATE TRIGGER `decrementStock` AFTER INSERT ON `detail_trans` FOR EACH ROW BEGIN
    UPDATE barang
        SET barang.quantity = barang.quantity - new.jumlah_belanja
        WHERE barang.id_barang = new.id_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(1000) NOT NULL,
  `password` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_trans` int(11) NOT NULL,
  `nama_pel` varchar(255) NOT NULL,
  `tanggal_trans` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total_belanja` int(11) NOT NULL,
  `uang_bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_trans`, `nama_pel`, `tanggal_trans`, `total_belanja`, `uang_bayar`, `kembalian`) VALUES
(1, 'jksq', '2022-01-11 13:13:36', 12000, 0, 0),
(2, 'jksq', '2022-01-11 13:28:16', 12000, 0, 0),
(3, 'no name', '2022-01-11 14:42:06', 36000, 3600, 0),
(4, 'no name', '2022-01-11 14:42:33', 36000, 3600, 0),
(5, 'no name', '2022-01-11 14:44:28', 36000, 3600, 0),
(6, 'no name', '2022-01-11 14:44:50', 36000, 3600, 0),
(7, 'no name', '2022-01-11 14:45:24', 36000, 3600, 0),
(8, 'no name', '2022-01-11 14:45:42', 36000, 3600, 0),
(9, 'no name', '2022-01-11 14:59:33', 30000, 34000, 4000),
(10, 'no name', '2022-01-11 14:59:40', 30000, 34000, 4000),
(11, 'no name', '2022-01-11 15:02:05', 16500, 20000, 3500),
(12, 'no name', '2022-01-11 15:05:16', 30000, 200000, 170000),
(13, 'no name', '2022-01-11 15:12:51', 16500, 20000, 3500),
(14, 'susi', '2022-01-11 15:15:29', 12000, 20000, 8000),
(15, 'susi', '2022-01-11 15:59:33', 2000, 5000, 3000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `detail_trans`
--
ALTER TABLE `detail_trans`
  ADD KEY `id_trans` (`id_trans`),
  ADD KEY `id_barang` (`id_barang`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_trans`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_trans` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_trans`
--
ALTER TABLE `detail_trans`
  ADD CONSTRAINT `detail_trans_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detail_trans_ibfk_2` FOREIGN KEY (`id_trans`) REFERENCES `transaksi` (`id_trans`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
