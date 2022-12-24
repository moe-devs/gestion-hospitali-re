-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2022 at 02:24 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gesrdv`
--

-- --------------------------------------------------------

--
-- Table structure for table `catalogue`
--

CREATE TABLE `catalogue` (
  `idcatalogue` int(11) NOT NULL,
  `lib` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `catalogue`
--

INSERT INTO `catalogue` (`idcatalogue`, `lib`) VALUES
(1, 'Cardiologie et angéiologie'),
(2, 'Dermatologie'),
(3, 'Anti-inflammatoires'),
(4, 'Allergologie'),
(5, 'Cancérologie et hématologie'),
(6, 'Infectiologie - Parasitologie'),
(7, 'Immunologie'),
(8, 'Métabolisme et nutrition'),
(9, 'Anesthésie, réanimation'),
(10, 'Antalgiques');

-- --------------------------------------------------------

--
-- Table structure for table `consultation`
--

CREATE TABLE `consultation` (
  `idconsultation` int(11) NOT NULL,
  `idpatient` int(11) NOT NULL,
  `idmedecin` int(11) NOT NULL,
  `pression` int(11) NOT NULL,
  `poids` float NOT NULL,
  `coeur` int(11) NOT NULL,
  `idmedicament` int(11) NOT NULL,
  `observation` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `consultation`
--

INSERT INTO `consultation` (`idconsultation`, `idpatient`, `idmedecin`, `pression`, `poids`, `coeur`, `idmedicament`, `observation`) VALUES
(1, 1, 2, 11, 72, 69, 7, 'sick'),
(2, 2, 1, 12, 60, 62, 1, 'drink water'),
(3, 1, 1, 12, 72, 65, 28, 'br9 m3a r3d'),
(4, 4, 1, 62, 72, 69, 5, 'chrb lma');

-- --------------------------------------------------------

--
-- Table structure for table `medecin`
--

CREATE TABLE `medecin` (
  `idmedecin` int(11) NOT NULL,
  `idspecialite` int(11) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `date_embauche` date DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `addresse` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `medecin`
--

INSERT INTO `medecin` (`idmedecin`, `idspecialite`, `genre`, `nom`, `prenom`, `date_embauche`, `date_naissance`, `addresse`, `telephone`) VALUES
(1, 1, 'Homme', 'TOTO', 'grande', '2000-05-16', '2022-05-10', 'Dar', '0622678910'),
(2, 7, 'Homme', 'Dolly', 'peane', '1999-09-15', '2022-05-02', 'B13', '0617801102');

-- --------------------------------------------------------

--
-- Table structure for table `medicament`
--

CREATE TABLE `medicament` (
  `idmedicament` int(11) NOT NULL,
  `libmedicament` varchar(255) DEFAULT NULL,
  `idcatalogue` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `medicament`
--

INSERT INTO `medicament` (`idmedicament`, `libmedicament`, `idcatalogue`) VALUES
(1, 'DUPILUMAB', 4),
(2, 'HYPOSTAMINE', 4),
(3, 'HYPOSULFENE', 4),
(4, 'ALDALIX', 1),
(5, 'ALDACTONE', 1),
(6, 'ADRENALINE RENAUDIN', 1),
(7, 'AMOROLFINE ARROW', 2),
(8, 'AERIUS', 2),
(9, 'IRRISEDERMYL', 2),
(10, 'IPRAFEINE', 3),
(11, 'TOPREC', 3),
(12, 'PREDNISOLONE RPG', 3),
(13, 'SPINAFOL 400', 5),
(14, 'AFINITOR', 5),
(15, 'SELINEXOR ', 5),
(16, 'CUBICIN', 6),
(17, 'DAPTOMYCINE MEDAC', 6),
(18, 'FOMICYT', 6),
(19, 'MACROLIN\r\n', 7),
(20, 'PEGASYS', 7),
(21, 'ILARIS', 7),
(22, 'RENUTRYL 500', 8),
(23, 'ZYMAD', 8),
(24, 'CETORNAN', 8),
(25, 'ANTASOL 135', 9),
(26, 'EMLA', 9),
(27, 'DIPRIVAN', 9),
(28, 'PARACETAMOL', 10),
(29, 'DOLIPRANE', 10),
(30, 'NUBAIN', 10);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `idpatient` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL DEFAULT 'Default',
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `cin` varchar(255) NOT NULL,
  `date_naissance` date NOT NULL,
  `addresse` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `profession` varchar(255) NOT NULL,
  `cnss` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`idpatient`, `genre`, `nom`, `prenom`, `cin`, `date_naissance`, `addresse`, `tel`, `profession`, `cnss`) VALUES
(1, 'Homme', 'Nait', 'Ibrahim', 'EX123', '2001-10-26', 'Sidi Maarouf', '0622723040', 'Developer', 234),
(2, 'Femme', 'Sea', 'EL', 'AS32', '1999-07-07', 'ANFA', '0606060710', 'Accountant', 789),
(4, 'Homme', 'hasnaoui', 'oussama', 'be455', '2000-11-16', 'resistance', '0606061616', 'steward', 2632);

-- --------------------------------------------------------

--
-- Table structure for table `rdv`
--

CREATE TABLE `rdv` (
  `idrdv` int(11) NOT NULL,
  `idmedecin` int(11) DEFAULT NULL,
  `idpatient` int(11) DEFAULT NULL,
  `daterdv` date DEFAULT NULL,
  `heurerdv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rdv`
--

INSERT INTO `rdv` (`idrdv`, `idmedecin`, `idpatient`, `daterdv`, `heurerdv`) VALUES
(1, 1, 4, '2022-05-24', '04:20'),
(2, 1, 2, '2022-05-19', '09:00'),
(3, 1, 4, '2022-05-24', '04:00');

-- --------------------------------------------------------

--
-- Table structure for table `specialite`
--

CREATE TABLE `specialite` (
  `idspecialite` int(11) NOT NULL,
  `lib` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `specialite`
--

INSERT INTO `specialite` (`idspecialite`, `lib`) VALUES
(1, 'cardiologie'),
(2, 'chirurgie'),
(3, 'Dermatologie'),
(4, 'Gériatrie'),
(5, 'Oncologie'),
(6, 'Pediatrie'),
(7, 'Allergologie');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `iduser` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `groupid` int(11) NOT NULL,
  `idmed` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`iduser`, `login`, `password`, `groupid`, `idmed`) VALUES
(5, 'Med', 'azerty123', 1, 1),
(7, 'Admin', 'azerty123', 0, NULL),
(8, 'Sec', 'azerty123', 2, NULL),
(9, 'Med2', 'azerty123', 1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`idcatalogue`);

--
-- Indexes for table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`idconsultation`),
  ADD KEY `fk_pat_obs` (`idpatient`),
  ADD KEY `fk_med_obs` (`idmedicament`),
  ADD KEY `fk_con` (`idmedecin`);

--
-- Indexes for table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`idmedecin`),
  ADD KEY `fk_specialite` (`idspecialite`);

--
-- Indexes for table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`idmedicament`),
  ADD KEY `fk_med` (`idcatalogue`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`idpatient`);

--
-- Indexes for table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`idrdv`),
  ADD KEY `idmedecin` (`idmedecin`),
  ADD KEY `idpatient` (`idpatient`);

--
-- Indexes for table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`idspecialite`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`iduser`),
  ADD KEY `fk_medec` (`idmed`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `idcatalogue` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `idconsultation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `idmedecin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `medicament`
--
ALTER TABLE `medicament`
  MODIFY `idmedicament` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `idpatient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `idrdv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `specialite`
--
ALTER TABLE `specialite`
  MODIFY `idspecialite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `fk_con` FOREIGN KEY (`idmedecin`) REFERENCES `medecin` (`idmedecin`),
  ADD CONSTRAINT `fk_med_obs` FOREIGN KEY (`idmedicament`) REFERENCES `medicament` (`idmedicament`),
  ADD CONSTRAINT `fk_pat_obs` FOREIGN KEY (`idpatient`) REFERENCES `patient` (`idpatient`);

--
-- Constraints for table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `fk_specialite` FOREIGN KEY (`idspecialite`) REFERENCES `specialite` (`idspecialite`);

--
-- Constraints for table `medicament`
--
ALTER TABLE `medicament`
  ADD CONSTRAINT `fk_med` FOREIGN KEY (`idcatalogue`) REFERENCES `catalogue` (`idcatalogue`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_medec` FOREIGN KEY (`idmed`) REFERENCES `medecin` (`idmedecin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
