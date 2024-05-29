CREATE TABLE Echipa (
                        idEchipa INT PRIMARY KEY,
                        numeEchipa VARCHAR(100) NOT NULL,
                        abreviereEchipa VARCHAR(10) NOT NULL
);

CREATE TABLE Jucator (
                         idJucator INT PRIMARY KEY,
                         idEchipa INT,
                         nume VARCHAR(100) NOT NULL,
                         prenume VARCHAR(100) NOT NULL,
                         numarTricou INT NOT NULL,
                         varsta INT NOT NULL,
                         FOREIGN KEY (idEchipa) REFERENCES Echipa(idEchipa)
);

CREATE TABLE Atacant (
                         idJucator INT PRIMARY KEY,
                         viteza INT NOT NULL,
                         sut INT NOT NULL,
                         dribling INT NOT NULL,
                         pase INT NOT NULL,
                         ovr DOUBLE NOT NULL,
                         pozitie VARCHAR(50) NOT NULL,
                         FOREIGN KEY (idJucator) REFERENCES Jucator(idJucator)
);

CREATE TABLE Aparator (
                          idJucator INT PRIMARY KEY,
                          viteza INT NOT NULL,
                          pase INT NOT NULL,
                          aparare INT NOT NULL,
                          fizic INT NOT NULL,
                          ovr DOUBLE NOT NULL,
                          pozitie VARCHAR(50) NOT NULL,
                          FOREIGN KEY (idJucator) REFERENCES Jucator(idJucator)
);

CREATE TABLE Mijlocas (
                          idJucator INT PRIMARY KEY,
                          viteza INT NOT NULL,
                          sut INT NOT NULL,
                          dribling INT NOT NULL,
                          pase INT NOT NULL,
                          aparare INT NOT NULL,
                          ovr DOUBLE NOT NULL,
                          pozitie VARCHAR(50) NOT NULL,
                          FOREIGN KEY (idJucator) REFERENCES Jucator(idJucator)
);

CREATE TABLE Portar (
                        idJucator INT PRIMARY KEY,
                        ovr DOUBLE NOT NULL,
                        FOREIGN KEY (idJucator) REFERENCES Jucator(idJucator)
);