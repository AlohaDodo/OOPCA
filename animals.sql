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
)

--
-- Dumping data for table `animals`
--

INSERT INTO `animals` (`ID`, `Type`, `Breed`, `Name`, `Age`, `Neutered`, `Health`, `Admitted`, `Gender`) VALUES
(1, 'Dog', 'Cockapoo', 'Teddy', 1, 0, 'Good', '2025-01-10', 'Boy'),
(2, ' Cat', 'British Short Hair', 'Mickey', 4, 0, 'Good', '2025-01-02', 'Boy'),
(3, 'Cat', 'Ragdoll', 'Topsy', 3, 0, 'Bad', '2025-02-03', 'Girl'),
(4, 'Dog', 'Labrador', 'Schnappi', 7, 0, 'Bad', '2025-01-29', 'Boy'),
(5, 'Cat', 'Bombay', ' Wojtek', 2, 0, 'Good', '2025-01-10', 'Boy');
