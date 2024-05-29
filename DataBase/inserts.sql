INSERT INTO Echipa (idEchipa, numeEchipa, abreviereEchipa) VALUES
                                                               (1, 'FC Steaua București', 'STB'),
                                                               (2, 'CFR Cluj', 'CFR'),
                                                               (3, 'Universitatea Craiova', 'CRA'),
                                                               (4, 'FC Dinamo București', 'DIN'),
                                                               (5, 'FC Rapid București', 'RAP'),
                                                               (6, 'FC Viitorul Constanța', 'VTC'),
                                                               (7, 'Astra Giurgiu', 'AST'),
                                                               (8, 'FC Botoșani', 'BOT'),
                                                               (9, 'Sepsi OSK Sfântu Gheorghe', 'OSK');

-- FC Steaua Bucuresti
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (1, 1, 'Tătărușanu', 'Ciprian', 1, 34);
INSERT INTO Portar (idJucator, ovr) VALUES
                                                                                  (1, 75.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (2, 1, 'Chiricheș', 'Vlad', 6, 31),
                                                                                  (3, 1, 'Benzar', 'Romario', 2, 29),
                                                                                  (4, 1, 'Bălașa', 'Mihai', 3, 30),
                                                                                  (5, 1, 'Tosca', 'Alin', 5, 28);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (2, 70, 65, 78, 72, (70+65+78+72)/4.0, 'CENTRU'),
                                                                                 (3, 75, 70, 72, 68, (75+70+72+68)/4.0, 'BANDA_DREAPTA'),
                                                                                 (4, 68, 65, 75, 70, (68+65+75+70)/4.0, 'CENTRU'),
                                                                                 (5, 72, 68, 74, 71, (72+68+74+71)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (6, 1, 'Stanciu', 'Nicolae', 10, 28),
                                                                                  (7, 1, 'Tănăr', 'Alexandru', 8, 27),
                                                                                  (8, 1, 'Nedelcu', 'Dragoș', 14, 26);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (6, 80, 75, 78, 80, 65, (80+75+78+80+65)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (7, 70, 68, 75, 72, 70, (70+68+75+72+70)/5.0, 'CENTRU'),
                                                                                         (8, 65, 60, 65, 68, 75, (65+60+65+68+75)/5.0, 'DEFENSIV');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (9, 1, 'Tănase', 'Florin', 11, 27),
                                                                                  (10, 1, 'Man', 'Dennis', 7, 23),
                                                                                  (11, 1, 'Coman', 'Florinel', 9, 22);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (9, 85, 80, 82, 70, (85+80+82+70)/4.0, 'VARF'),
                                                                               (10, 90, 75, 85, 72, (90+75+85+72)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (11, 88, 78, 83, 70, (88+78+83+70)/4.0, 'EXTREMA_STANGA');


-- CFR Cluj
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
    (12, 2, 'Arlauskis', 'Giedrius', 1, 34);
INSERT INTO Portar (idJucator, ovr) VALUES
    (12, 76.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (13, 2, 'Camora', 'Ionuț', 6, 34),
                                                                                  (14, 2, 'Vinicius', 'Camora', 2, 34),
                                                                                  (15, 2, 'Burcă', 'Cătălin', 4, 27),
                                                                                  (16, 2, 'Susic', 'Damjan', 5, 28);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (13, 71, 65, 76, 73, (71+65+76+73)/4.0, 'CENTRU'),
                                                                                 (14, 73, 68, 74, 70, (73+68+74+70)/4.0, 'BANDA_DREAPTA'),
                                                                                 (15, 70, 64, 78, 71, (70+64+78+71)/4.0, 'CENTRU'),
                                                                                 (16, 72, 66, 73, 72, (72+66+73+72)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (17, 2, 'Bordeianu', 'Ovidiu', 10, 31),
                                                                                  (18, 2, 'Itu', 'Cătălin', 8, 27),
                                                                                  (19, 2, 'Chipciu', 'Alexandru', 14, 31);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (17, 75, 70, 78, 76, 68, (75+70+78+76+68)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (18, 72, 68, 74, 72, 70, (72+68+74+72+70)/5.0, 'CENTRU'),
                                                                                         (19, 73, 68, 75, 73, 68, (73+68+75+73+68)/5.0, 'CENTRU');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (20, 2, 'Deac', 'Ciprian', 11, 35),
                                                                                  (21, 2, 'Păun', 'Bogdan', 7, 27),
                                                                                  (22, 2, 'Rondon', 'Salomon', 9, 32);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (20, 78, 76, 80, 74, (78+76+80+74)/4.0, 'VARF'),
                                                                               (21, 74, 72, 78, 75, (74+72+78+75)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (22, 80, 78, 79, 72, (80+78+79+72)/4.0, 'VARF');


-- Universitatea Craiova
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
    (23, 3, 'Pigliacelli', 'Nicola', 1, 29);
INSERT INTO Portar (idJucator, ovr) VALUES
    (23, 74.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (24, 3, 'Vlădoiu', 'Răzvan', 6, 27),
                                                                                  (25, 3, 'Acka', 'Tomas', 2, 27),
                                                                                  (26, 3, 'Golofca', 'Elvir', 4, 30),
                                                                                  (27, 3, 'Tiago Ferreira', 'Alex', 5, 30);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (24, 75, 70, 76, 74, (75+70+76+74)/4.0, 'CENTRU'),
                                                                                 (25, 72, 68, 74, 70, (72+68+74+70)/4.0, 'BANDA_DREAPTA'),
                                                                                 (26, 70, 64, 72, 71, (70+64+72+71)/4.0, 'CENTRU'),
                                                                                 (27, 73, 66, 73, 72, (73+66+73+72)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (28, 3, 'Mateiu', 'Alexandru', 10, 30),
                                                                                  (29, 3, 'Cicâldău', 'Alexandru', 8, 24),
                                                                                  (30, 3, 'Vatajelu', 'Bănel', 14, 29);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (28, 74, 68, 75, 76, 68, (74+68+75+76+68)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (29, 75, 70, 78, 74, 70, (75+70+78+74+70)/5.0, 'CENTRU'),
                                                                                         (30, 72, 66, 72, 73, 68, (72+66+72+73+68)/5.0, 'CENTRU');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (31, 3, 'Cicâldău', 'Alexandru', 11, 24),
                                                                                  (32, 3, 'Mateiu', 'Alexandru', 7, 30),
                                                                                  (33, 3, 'Ivan', 'Nicușor', 9, 28);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (31, 78, 76, 80, 74, (78+76+80+74)/4.0, 'VARF'),
                                                                               (32, 74, 72, 78, 75, (74+72+78+75)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (33, 80, 78, 79, 72, (80+78+79+72)/4.0, 'VARF');


-- FC Dinamo București
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
    (34, 4, 'Straton', 'Alexandru', 1, 28);
INSERT INTO Portar (idJucator, ovr) VALUES
    (34, 72.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (35, 4, 'Klimavicius', 'Valentin', 6, 28),
                                                                                  (36, 4, 'Marin', 'Marius', 2, 29),
                                                                                  (37, 4, 'Sorescu', 'Denis', 4, 26),
                                                                                  (38, 4, 'Bejan', 'Andrei', 5, 27);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (35, 73, 68, 76, 74, (73+68+76+74)/4.0, 'CENTRU'),
                                                                                 (36, 72, 68, 75, 70, (72+68+75+70)/4.0, 'BANDA_DREAPTA'),
                                                                                 (37, 70, 64, 72, 71, (70+64+72+71)/4.0, 'CENTRU'),
                                                                                 (38, 72, 66, 73, 72, (72+66+73+72)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (39, 4, 'Nistor', 'Dan', 10, 31),
                                                                                  (40, 4, 'Benzar', 'Deian', 8, 24),
                                                                                  (41, 4, 'Fabbrini', 'Diego', 14, 30);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (39, 74, 68, 75, 76, 68, (74+68+75+76+68)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (40, 75, 70, 78, 74, 70, (75+70+78+74+70)/5.0, 'CENTRU'),
                                                                                         (41, 72, 66, 72, 73, 68, (72+66+72+73+68)/5.0, 'CENTRU');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (42, 4, 'Montini', 'Antonio', 11, 29),
                                                                                  (43, 4, 'Dokovic', 'Mateo', 7, 26),
                                                                                  (44, 4, 'Vlad', 'Florin', 9, 28);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (42, 78, 76, 80, 74, (78+76+80+74)/4.0, 'VARF'),
                                                                               (43, 74, 72, 78, 75, (74+72+78+75)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (44, 80, 78, 79, 72, (80+78+79+72)/4.0, 'VARF');


-- FC Rapid București
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
    (45, 5, 'Drăghia', 'Eduard', 1, 30);
INSERT INTO Portar (idJucator, ovr) VALUES
    (45, 73.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (46, 5, 'Ramos', 'Josué', 6, 26),
                                                                                  (47, 5, 'Bâră', 'Cosmin', 2, 25),
                                                                                  (48, 5, 'Ivan', 'Paul', 4, 28),
                                                                                  (49, 5, 'Bordeianu', 'Andrei', 5, 27);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (46, 73, 68, 76, 74, (73+68+76+74)/4.0, 'CENTRU'),
                                                                                 (47, 72, 68, 75, 70, (72+68+75+70)/4.0, 'BANDA_DREAPTA'),
                                                                                 (48, 70, 64, 72, 71, (70+64+72+71)/4.0, 'CENTRU'),
                                                                                 (49, 72, 66, 73, 72, (72+66+73+72)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (50, 5, 'Costin', 'Ionuț', 10, 29),
                                                                                  (51, 5, 'Voicu', 'Laurențiu', 8, 24),
                                                                                  (52, 5, 'Păun', 'Bogdan', 14, 30);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (50, 74, 68, 75, 76, 68, (74+68+75+76+68)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (51, 75, 70, 78, 74, 70, (75+70+78+74+70)/5.0, 'CENTRU'),
                                                                                         (52, 72, 66, 72, 73, 68, (72+66+72+73+68)/5.0, 'CENTRU');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (53, 5, 'Dumitru', 'Vlad', 11, 29),
                                                                                  (54, 5, 'Roman', 'Andrei', 7, 26),
                                                                                  (55, 5, 'Bărbuț', 'George', 9, 28);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (53, 78, 76, 80, 74, (78+76+80+74)/4.0, 'VARF'),
                                                                               (54, 74, 72, 78, 75, (74+72+78+75)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (55, 80, 78, 79, 72, (80+78+79+72)/4.0, 'VARF');


-- FC Viitorul Constanța
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
    (56, 6, 'Căbuz', 'Valentin', 1, 27);
INSERT INTO Portar (idJucator, ovr) VALUES
    (56, 72.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (57, 6, 'Boboc', 'Radu', 6, 25),
                                                                                  (58, 6, 'Gheorghe', 'Radu', 2, 26),
                                                                                  (59, 6, 'Mladen', 'Ilie', 4, 29),
                                                                                  (60, 6, 'Țîru', 'Romario', 5, 28);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (57, 73, 68, 76, 74, (73+68+76+74)/4.0, 'CENTRU'),
                                                                                 (58, 72, 68, 75, 70, (72+68+75+70)/4.0, 'BANDA_DREAPTA'),
                                                                                 (59, 70, 64, 72, 71, (70+64+72+71)/4.0, 'CENTRU'),
                                                                                 (60, 72, 66, 73, 72, (72+66+73+72)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (61, 6, 'Căpușă', 'Radu', 10, 29),
                                                                                  (62, 6, 'Iancu', 'Cătălin', 8, 24),
                                                                                  (63, 6, 'Dobrosavlevici', 'Iosif', 14, 30);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (61, 74, 68, 75, 76, 68, (74+68+75+76+68)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (62, 75, 70, 78, 74, 70, (75+70+78+74+70)/5.0, 'CENTRU'),
                                                                                         (63, 72, 66, 72, 73, 68, (72+66+72+73+68)/5.0, 'CENTRU');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (64, 6, 'Houri', 'Nasser', 11, 29),
                                                                                  (65, 6, 'Matan', 'Alexandru', 7, 26),
                                                                                  (66, 6, 'Balan', 'Gabriel', 9, 28);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (64, 78, 76, 80, 74, (78+76+80+74)/4.0, 'VARF'),
                                                                               (65, 74, 72, 78, 75, (74+72+78+75)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (66, 80, 78, 79, 72, (80+78+79+72)/4.0, 'VARF');


-- Astra Giurgiu
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
    (67, 7, 'Ureche', 'Andrei', 1, 28);
INSERT INTO Portar (idJucator, ovr) VALUES
    (67, 71.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (68, 7, 'Sousa', 'Kehinde', 6, 27),
                                                                                  (69, 7, 'Alves', 'Valmir', 2, 28),
                                                                                  (70, 7, 'Bejan', 'Cristian', 4, 26),
                                                                                  (71, 7, 'David Bruno', 'Ferreira', 5, 28);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (68, 73, 68, 76, 74, (73+68+76+74)/4.0, 'CENTRU'),
                                                                                 (69, 72, 68, 75, 70, (72+68+75+70)/4.0, 'BANDA_DREAPTA'),
                                                                                 (70, 70, 64, 72, 71, (70+64+72+71)/4.0, 'CENTRU'),
                                                                                 (71, 72, 66, 73, 72, (72+66+73+72)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (72, 7, 'Busuladzic', 'Nemanja', 10, 30),
                                                                                  (73, 7, 'Dumitru', 'Andrei', 8, 25),
                                                                                  (74, 7, 'Simion', 'Alexandru', 14, 31);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (72, 74, 68, 75, 76, 68, (74+68+75+76+68)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (73, 75, 70, 78, 74, 70, (75+70+78+74+70)/5.0, 'CENTRU'),
                                                                                         (74, 72, 66, 72, 73, 68, (72+66+72+73+68)/5.0, 'CENTRU');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (75, 7, 'Radunović', 'Branislav', 11, 29),
                                                                                  (76, 7, 'Ioniță', 'Valentin', 7, 26),
                                                                                  (77, 7, 'Balaure', 'Gabriel', 9, 28);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (75, 78, 76, 80, 74, (78+76+80+74)/4.0, 'VARF'),
                                                                               (76, 74, 72, 78, 75, (74+72+78+75)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (77, 80, 78, 79, 72, (80+78+79+72)/4.0, 'VARF');


-- FC Botoșani
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
    (78, 8, 'Fraisl', 'Sebastian', 1, 29);
INSERT INTO Portar (idJucator, ovr) VALUES
    (78, 71.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (79, 8, 'Chindriș', 'Mihai', 6, 29),
                                                                                  (80, 8, 'Bancu', 'Răzvan', 2, 29),
                                                                                  (81, 8, 'Țîră', 'Andrei', 4, 26),
                                                                                  (82, 8, 'Plămadă', 'Vlad', 5, 26);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (79, 73, 68, 76, 74, (73+68+76+74)/4.0, 'CENTRU'),
                                                                                 (80, 72, 68, 75, 70, (72+68+75+70)/4.0, 'BANDA_DREAPTA'),
                                                                                 (81, 70, 64, 72, 71, (70+64+72+71)/4.0, 'CENTRU'),
                                                                                 (82, 72, 66, 73, 72, (72+66+73+72)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (83, 8, 'Patache', 'Olimpiu', 10, 28),
                                                                                  (84, 8, 'Haruț', 'Andrei', 8, 25),
                                                                                  (85, 8, 'Oaida', 'Cosmin', 14, 30);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (83, 74, 68, 75, 76, 68, (74+68+75+76+68)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (84, 75, 70, 78, 74, 70, (75+70+78+74+70)/5.0, 'CENTRU'),
                                                                                         (85, 72, 66, 72, 73, 68, (72+66+72+73+68)/5.0, 'CENTRU');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (86, 8, 'Roman', 'Andrei', 11, 29),
                                                                                  (87, 8, 'Keyta', 'Olivian', 7, 26),
                                                                                  (88, 8, 'Aloisio', 'Borges', 9, 28);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (86, 78, 76, 80, 74, (78+76+80+74)/4.0, 'VARF'),
                                                                               (87, 74, 72, 78, 75, (74+72+78+75)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (88, 80, 78, 79, 72, (80+78+79+72)/4.0, 'VARF');


-- Sepsi OSK Sfântu Gheorghe
-- Keeper
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
    (89, 9, 'Fejer', 'Roland', 1, 28);
INSERT INTO Portar (idJucator, ovr) VALUES
    (89, 71.0);

-- Defenders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (90, 9, 'Velev', 'Plamen', 6, 29),
                                                                                  (91, 9, 'Arapis', 'Alexandru', 2, 29),
                                                                                  (92, 9, 'Tincu', 'Andrei', 4, 26),
                                                                                  (93, 9, 'Pinto', 'Paulo', 5, 26);

INSERT INTO Aparator (idJucator, viteza, pase, aparare, fizic, ovr, pozitie) VALUES
                                                                                 (90, 73, 68, 76, 74, (73+68+76+74)/4.0, 'CENTRU'),
                                                                                 (91, 72, 68, 75, 70, (72+68+75+70)/4.0, 'BANDA_DREAPTA'),
                                                                                 (92, 70, 64, 72, 71, (70+64+72+71)/4.0, 'CENTRU'),
                                                                                 (93, 72, 66, 73, 72, (72+66+73+72)/4.0, 'BANDA_STANGA');

-- Midfielders
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (94, 9, 'Vașvari', 'Marko', 10, 28),
                                                                                  (95, 9, 'Velev', 'Martin', 8, 25),
                                                                                  (96, 9, 'Ioan', 'Adrian', 14, 30);

INSERT INTO Mijlocas (idJucator, viteza, sut, dribling, pase, aparare, ovr, pozitie) VALUES
                                                                                         (94, 74, 68, 75, 76, 68, (74+68+75+76+68)/5.0, 'CENTRU_OFENSIV'),
                                                                                         (95, 75, 70, 78, 74, 70, (75+70+78+74+70)/5.0, 'CENTRU'),
                                                                                         (96, 72, 66, 72, 73, 68, (72+66+72+73+68)/5.0, 'CENTRU');

-- Attackers
INSERT INTO Jucator (idJucator, idEchipa, nume, prenume, numarTricou, varsta) VALUES
                                                                                  (97, 9, 'Fulop', 'Roland', 11, 29),
                                                                                  (98, 9, 'Hadnagy', 'Bence', 7, 26),
                                                                                  (99, 9, 'Velev', 'Ivaylo', 9, 28);

INSERT INTO Atacant (idJucator, viteza, sut, dribling, pase, ovr, pozitie) VALUES
                                                                               (97, 78, 76, 80, 74, (78+76+80+74)/4.0, 'VARF'),
                                                                               (98, 74, 72, 78, 75, (74+72+78+75)/4.0, 'EXTREMA_DREAPTA'),
                                                                               (99, 80, 78, 79, 72, (80+78+79+72)/4.0, 'VARF');