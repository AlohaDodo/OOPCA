-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2025 at 02:05 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `animals`
--

-- --------------------------------------------------------

--
-- Table structure for table `animals`
--

CREATE TABLE `animals` (
  `ID` int(11) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Breed` varchar(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Age` int(11) NOT NULL,
  `Neutered` tinyint(1) NOT NULL,
  `Health` varchar(30) NOT NULL,
  `Admitted` date NOT NULL,
  `Gender` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `animals`
--

INSERT INTO `animals` (`ID`, `Type`, `Breed`, `Name`, `Age`, `Neutered`, `Health`, `Admitted`, `Gender`) VALUES
(1, 'Dog', 'Cockapoo', 'Teddy', 1, 0, 'Good', '2025-01-10', 'Boy'),
(2, ' Cat', 'British Short Hair', 'Mickey', 4, 0, 'Good', '2025-01-02', 'Boy'),
(3, 'Cat', 'Ragdoll', 'Topsy', 3, 0, 'Bad', '2025-02-03', 'Girl'),
(4, 'Dog', 'Labrador', 'Schnappi', 7, 0, 'Bad', '2025-01-29', 'Boy'),
(5, 'Cat', 'Bombay', ' Wojtek', 2, 0, 'Good', '2025-01-10', 'Boy');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
