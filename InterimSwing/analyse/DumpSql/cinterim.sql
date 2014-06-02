-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 02 Juin 2014 à 15:06
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `cinterim`
--
CREATE DATABASE `cinterim` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cinterim`;

-- --------------------------------------------------------

--
-- Structure de la table `adresses`
--

CREATE TABLE IF NOT EXISTS `adresses` (
  `id_adresse` int(11) NOT NULL AUTO_INCREMENT,
  `rue` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `ville` varchar(45) NOT NULL,
  PRIMARY KEY (`id_adresse`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `adresses`
--

INSERT INTO `adresses` (`id_adresse`, `rue`, `code`, `ville`) VALUES
(2, 'place 13', '7000', 'Mons');

-- --------------------------------------------------------

--
-- Structure de la table `annonces`
--

CREATE TABLE IF NOT EXISTS `annonces` (
  `id_annonce` int(11) NOT NULL AUTO_INCREMENT,
  `secteur` varchar(45) NOT NULL,
  `fonction` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `id_metier` int(11) NOT NULL,
  `id_contact` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_annonce`),
  KEY `fk_annonces_metiers1_idx` (`id_metier`),
  KEY `fk_annonces_contacts1_idx` (`id_contact`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `annonces`
--

-- --------------------------------------------------------

--
-- Structure de la table `contacts`
--

CREATE TABLE IF NOT EXISTS `contacts` (
  `id_contact` int(11) NOT NULL AUTO_INCREMENT,
  `entreprise` varchar(45) NOT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `commune` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_contact`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `contacts`
--


-- --------------------------------------------------------

--
-- Structure de la table `logins`
--

CREATE TABLE IF NOT EXISTS `logins` (
  `id_login` int(11) NOT NULL AUTO_INCREMENT,
  `id_role` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `token` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_login`),
  KEY `fk_logins_roles1_idx` (`id_role`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `logins`
--

INSERT INTO `logins` (`id_login`, `id_role`, `username`, `password`, `email`, `token`) VALUES
(2, 2, 'admin', 'admin', 'keyser.so@hotmail.com', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `metiers`
--

CREATE TABLE IF NOT EXISTS `metiers` (
  `id_metier` int(11) NOT NULL AUTO_INCREMENT,
  `metier` varchar(45) NOT NULL,
  PRIMARY KEY (`id_metier`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5232202 ;

--
-- Contenu de la table `metiers`
--

INSERT INTO `metiers` (`id_metier`, `metier`) VALUES
(1111105, 'Aide-ménager'),
(1121101, 'Technicien de surface'),
(3232101, 'Analyste informatique'),
(3232102, 'Développeur informatique'),
(3232103, 'Web développeur'),
(3232104, 'Sp&eacute;cialiste de r&eacute;seau'),
(5232101, 'Technicien de maintenance en informatique'),
(5232201, 'Technicien de maintenance en matériel ');

-- --------------------------------------------------------

--
-- Structure de la table `rdvs`
--

CREATE TABLE IF NOT EXISTS `rdvs` (
  `id_rdv` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_contact` int(11) NOT NULL,
  `date` date NOT NULL,
  `description` text,
  `dir` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_rdv`,`id_user`,`id_contact`),
  KEY `fk_users_has_contacts_contacts1_idx` (`id_contact`),
  KEY `fk_users_has_contacts_users_idx` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `rdvs`
--

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `roles`
--

INSERT INTO `roles` (`id_role`, `role`) VALUES
(1, 'user'),
(2, 'superviseur');

-- --------------------------------------------------------

--
-- Structure de la table `user_a_comme_metier`
--

CREATE TABLE IF NOT EXISTS `user_a_comme_metier` (
  `id_user` int(11) NOT NULL,
  `id_metier` int(11) NOT NULL,
  `cv` varchar(200) NOT NULL,
  PRIMARY KEY (`id_user`,`id_metier`),
  KEY `fk_users_has_metiers_metiers1_idx` (`id_metier`),
  KEY `fk_users_has_metiers_users1_idx` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user_a_comme_metier`
--


-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_adresse` int(11) NOT NULL,
  `id_login` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `tel` varchar(15) NOT NULL,
  `id_superviseur` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `fk_users_users1_idx` (`id_superviseur`),
  KEY `fk_users_adresses1_idx` (`id_adresse`),
  KEY `fk_users_logins1_idx` (`id_login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id_user`, `id_adresse`, `id_login`, `nom`, `prenom`, `tel`, `id_superviseur`) VALUES
(1, 2, 2, 'admin', 'admin', '000000000', NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `annonces`
--
ALTER TABLE `annonces`
  ADD CONSTRAINT `fk_annonces_contacts1` FOREIGN KEY (`id_contact`) REFERENCES `contacts` (`id_contact`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_annonces_metiers1` FOREIGN KEY (`id_metier`) REFERENCES `metiers` (`id_metier`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `logins`
--
ALTER TABLE `logins`
  ADD CONSTRAINT `fk_logins_roles1` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `rdvs`
--
ALTER TABLE `rdvs`
  ADD CONSTRAINT `fk_users_has_contacts_contacts1` FOREIGN KEY (`id_contact`) REFERENCES `contacts` (`id_contact`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_users_has_contacts_users` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `user_a_comme_metier`
--
ALTER TABLE `user_a_comme_metier`
  ADD CONSTRAINT `fk_users_has_metiers_metiers1` FOREIGN KEY (`id_metier`) REFERENCES `metiers` (`id_metier`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_users_has_metiers_users1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_adresses1` FOREIGN KEY (`id_adresse`) REFERENCES `adresses` (`id_adresse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_users_logins1` FOREIGN KEY (`id_login`) REFERENCES `logins` (`id_login`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_users_users1` FOREIGN KEY (`id_superviseur`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
