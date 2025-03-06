CREATE TABLE 'DONOR' (
     `ID` int(4) NOT NULL,
    `FIRST_NAME` varchar(30) NOT NULL,
    `SECOND_NAME` varchar(30) NOT NULL,
    `TELENUMBER` varchar(11) NOT NULL,
    PRIMARY KEY (ID)
    );

CREATE TABLE `ANIMAL` (
    `ID` int(4) NOT NULL,
    `TYPE` varchar(30) NOT NULL,
    `BREED` varchar(30) NOT NULL,
    `NAME` varchar(30) NOT NULL,
    `AGE` int(11) NOT NULL,
    `NEUTERED` tinyint(1) NOT NULL,
    `HEALTH` varchar(30) NOT NULL,
    `ADMITTED` date NOT NULL,
    `GENDER` varchar(30) NOT NULL,
    `DONOR_ID` int(4) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (DONOR_ID) REFERENCES DONORS(ID)
) ;

INSERT INTO `ANIMAL` (`ID`, `TYPE`, `BREED`, `NAME`, `AGE`, `NEUTERED`, `HEALTH`, `ADMTTED`, `GENDER`) VALUES
(1, 'Dog', 'Cockapoo', 'Teddy', 1, 0, 'Good', '2025-01-10', 'Boy'),
(2, 'Cat', 'British Short Hair', 'Mickey', 4, 0, 'Good', '2025-01-02', 'Boy'),
(3, 'Cat', 'Ragdoll', 'Topsy', 3, 0, 'Bad', '2025-02-03', 'Girl'),
(4, 'Dog', 'Labrador', 'Schnappi', 7, 0, 'Bad', '2025-01-29', 'Boy'),
(5, 'Cat', 'Bombay', ' Wojtek', 2, 0, 'Good', '2025-01-10', 'Boy'),
(6, 'Dog', 'Labrador', 'Pudding', 3, 1, 'Good', '2025-28-02', 'Girl'),
(7, 'Dog', 'Bulldog', 'Jack', 2, 0, 'Good', '2025-28-02', 'Boy'),
(8, 'Cat', 'Siamese', 'Snow', 1, 1, 'Bad', '2025-02-03', 'Girl'),
(9, 'Dog', 'Husky', 'Tasha', 3, 1, 'Good', '2025-10-02', 'Girl'),
(10, 'Dog', 'Golden Retriever', 'Lucy' , 4, 0, 'Good', '2025-24-02', 'Girl');


INSERT INTO `DONOR` (`ID`, `FIRST_NAME`,`SECOND_NAME`, `TELENUMBER`) VALUES
(1, 'John', 'OSullivan', '0871234567'),
(2, 'Mary', 'McCarthy', '0852345678'),
(3, 'Patrick', 'OBrien', '0861112233'),
(4, 'Siobhan', 'Murphy', '0872223344'),
(5, 'Michael', 'Doyle', '0833334455'),
(6, 'Emma', 'OConnell', '0841234567'),
(7, 'Sean', 'Fitzpatrick', '0851112222'),
(8, 'Aisling', 'Byrne', '0872345678'),
(9, 'Liam', 'Gallagher', '0861234890'),
(10, 'Niamh', 'Kennedy', '0891234567');