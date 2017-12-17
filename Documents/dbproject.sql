-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 17 déc. 2017 à 12:52
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `dbproject`
--

-- --------------------------------------------------------

--
-- Structure de la table `conversation`
--

DROP TABLE IF EXISTS `conversation`;
CREATE TABLE IF NOT EXISTS `conversation` (
  `pseudoS` varchar(10) NOT NULL,
  `pseudoR` varchar(10) NOT NULL,
  `idMessage` varchar(200) NOT NULL,
  KEY `FK_Receiver` (`pseudoR`),
  KEY `FK_Sender` (`pseudoS`),
  KEY `FK_Message` (`idMessage`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `idMessage` varchar(200) NOT NULL,
  `contenu` varchar(500) NOT NULL,
  `date` varchar(12) NOT NULL,
  `PseudoAuteur` varchar(10) NOT NULL,
  `pseudoDest` varchar(10) NOT NULL,
  PRIMARY KEY (`idMessage`),
  KEY `FK_Auteur` (`PseudoAuteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `pseudo` varchar(10) NOT NULL,
  `mdp` varchar(15) NOT NULL,
  `adresse` varchar(60) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `statut` varchar(50) NOT NULL DEFAULT 'HORS_LIGNE',
  `port` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pseudo`),
  UNIQUE KEY `port` (`port`)
) ENGINE=InnoDB AUTO_INCREMENT=5010 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`nom`, `prenom`, `pseudo`, `mdp`, `adresse`, `tel`, `statut`, `port`) VALUES
('Pereira', 'loann', 'lolo63', '123456', '41 avenue bidule', '0605040302', 'HORS_LIGNE', 5001),
('Laurichesse', 'Ludovic', 'ludoM5', 'bmw', '12 rue du machin', '063357232', 'HORS_LIGNE', 5002),
('jeanjean', 'michel', 'michou', '123', '123 av jean', '123456789', 'HORS_LIGNE', 5003),
('Dupret', 'Michel', 'mimidu52', '1234', 'rue du truc', '0605040302', 'HORS_LIGNE', 5004),
('Atelais', 'Sylvain', 'Myn4s', 'yolo', 'rue du rageux', '6666666666', 'HORS_LIGNE', 5005),
('Durant', 'Nicolas', 'nico63', '12345', '10 rue du boucher clermont ferrand', '600000000', 'HORS_LIGNE', 5006),
('Yzavard', 'Thomas', 'thomza', 'toto', '56 av clem', '456789789', 'HORS_LIGNE', 5007),
('Burto', 'Thibault', 'titi53', '1234', 'avenue du moande', '0102030405', 'HORS_LIGNE', 5008),
('Tarbier', 'Elodie', 'youpy23', 'abcde', '52 av liberation Clermont ferrand', '412121212', 'HORS_LIGNE', 5009);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
