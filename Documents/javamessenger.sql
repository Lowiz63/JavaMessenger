-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2017 at 05:51 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javamessenger`
--

-- --------------------------------------------------------

--
-- Table structure for table `conversation`
--

CREATE TABLE `conversation` (
  `pseudoS` varchar(10) NOT NULL,
  `pseudoR` varchar(10) NOT NULL,
  `idMessage` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `idMessage` varchar(200) NOT NULL,
  `contenu` varchar(500) NOT NULL,
  `date` varchar(12) NOT NULL,
  `PseudoAuteur` varchar(10) NOT NULL,
  `pseudoDest` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `pseudo` varchar(10) NOT NULL,
  `mdp` varchar(15) NOT NULL,
  `adresse` varchar(60) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `statut` varchar(50) NOT NULL DEFAULT 'HORS_LIGNE'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`nom`, `prenom`, `pseudo`, `mdp`, `adresse`, `tel`, `statut`) VALUES
('Pereira', 'loann', 'lolo63', '123456', '41 avenue bidule', '0605040302', 'HORS_LIGNE'),
('Laurichesse', 'Ludovic', 'ludoM5', 'bmw', '12 rue du machin', '063357232', 'HORS_LIGNE'),
('jeanjean', 'michel', 'michou', '123', '123 av jean', '123456789', 'HORS_LIGNE'),
('Dupret', 'Michel', 'mimidu52', '1234', 'rue du truc', '0605040302', 'HORS_LIGNE'),
('Atelais', 'Sylvain', 'Myn4s', 'yolo', 'rue du rageux', '6666666666', 'HORS_LIGNE'),
('Durant', 'Nicolas', 'nico63', '12345', '10 rue du boucher clermont ferrand', '600000000', 'HORS_LIGNE'),
('Yzavard', 'Thomas', 'thomza', 'toto', '56 av clem', '456789789', 'HORS_LIGNE'),
('Burto', 'Thibault', 'titi53', '1234', 'avenue du moande', '0102030405', 'HORS_LIGNE'),
('Tarbier', 'Elodie', 'youpy23', 'abcde', '52 av liberation Clermont ferrand', '412121212', 'HORS_LIGNE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `conversation`
--
ALTER TABLE `conversation`
  ADD KEY `FK_Receiver` (`pseudoR`),
  ADD KEY `FK_Sender` (`pseudoS`),
  ADD KEY `FK_Message` (`idMessage`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`idMessage`),
  ADD KEY `FK_Auteur` (`PseudoAuteur`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`pseudo`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `conversation`
--
ALTER TABLE `conversation`
  ADD CONSTRAINT `FK_Message` FOREIGN KEY (`idMessage`) REFERENCES `message` (`idMessage`),
  ADD CONSTRAINT `FK_Receiver` FOREIGN KEY (`pseudoR`) REFERENCES `user` (`pseudo`),
  ADD CONSTRAINT `FK_Sender` FOREIGN KEY (`pseudoS`) REFERENCES `user` (`pseudo`);

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK_Auteur` FOREIGN KEY (`PseudoAuteur`) REFERENCES `user` (`pseudo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
