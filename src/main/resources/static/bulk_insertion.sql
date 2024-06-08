USE Katio;

INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES ('Gabriel', 'García Márquez', 'Colombia', '1940-03-03');
    

INSERT INTO Authors
    SET Name = 'Jorge', Lastname = 'Isaacs', Country = 'Colombia', Birthdate = '1836-04-01';


INSERT INTO Authors
    VALUES (0, 'Germán', 'Castro-Caycedo', 'Colombia', '1940-03-03');


INSERT INTO Books VALUES 
    (0, 'Cien años de soledad', '8420471836', '978-8420471839', '1967-06-05', 'RAE Obra Académica', 'Realismo Mágico', '800', 1),
    (0, 'Huellas', '9584277278', '978-958427275', '2019-01-01', '1ra edicion', 'Crónica', '800', 3),
    (0, 'María', '14802722922', '978-148027292', '1867-01-01', '1ra edicion', 'Romancticismo', '800', 2);


INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES ('Silvia', 'Moreno Garcia', 'Mexico', '1981-04-25');
    
INSERT INTO Books VALUES 
    (0, 'Mexico Gothic', '8420471836', '978-05256620785', '2020-06-30', 'Del Rey', 'Horror Gótico', '800', 4);


INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES 
    ('Irene', 'Vallejo', 'España', '1979=06-06' ),
    ('Sarah', 'Maas', 'EEUU', '1986-03-05' ),
    ('Mario', 'Mendoza', 'Colombia', '1964-01-10' ),
    ('Hector', 'Abad Faciolince', 'Colombia', '1958-10-01' ),
    ('Laura', 'Restrepo', 'Colombia', '1950-01-01' ),
    ('Piedad', 'Bonnet', 'Colombia', '1951-01-01' ),
    ('Fernando', 'Vallejo', 'Colombia', '1942-10-24' ),
    ('Antonio', 'Caballero', 'Colombia', '1945-05-15' ),
    ('William', 'Ospina', 'Colombia', '1954-03-02' ),
    ('Juan Gabriel', 'Vasquez', 'Colombia', '1973-01-01' ),
    ('Santiago', 'Gamboa', 'Colombia', '1965-01-01' ),
    ('Angela', 'Becerra',  'Colombia', '1957-07-17' ),
    ('Stephen', 'King', 'EEUU', '1947-09-21' ),
    ('Anne', 'Rice', 'EEUU', '1941-10-04' ),
    ('Jeff', 'Vandermeer', 'EEUU', '1968-07-07' ),
    ('Liu', 'Cixin', 'China', '1963-06-30' ),
    ('Fyodor', 'Dostoevsky', 'Rusia', '1821-11-11' ),
    ('Leo', 'Tolstoy', 'Rusia', '1928-09-09' ),
    ('Anton', 'Chekhov', 'Rusia', '1860-01-29' ),
    ('Isac', 'Asimov', 'Rusia', '1920-01-02' ),
    ('Rudyard', 'Kipling', 'India', '1865-12-30' ),
    ('Jon Ronald Reuel', 'Tolkien', 'Surafrica', '1892-01-03' ),
    ('Clive Staples', 'Lewis', 'Reino Unido', '1898-11-29' ),
    ('George Raymond Richard', 'Martin', 'EEUU', '1948-09-20' ),
    ('Frank', 'Herbert', 'EEUU', '1920-10-08' ),
    ('Albert', 'Camus', 'France', '1913-11-07' ),
    ('Margaret', 'Atwood', 'Canada', '1939-11-18' ),
    ('Mary', 'Shelley', 'Inglaterra', '1797-08-30' ),
    ('Agatha', 'Christie', 'Inglaterra', '1890-09-15' ),
    ('Ursula K', 'Le Guin', 'EEUU', '1929-10-21' );
    
    
INSERT INTO Books VALUES 
    (0, 'Sin remedio', '3161484100', '978-3161484100', '1984-01-01', 'Alfaguara', 'Ficción', '800', 12),    
    (0, 'Delirio', '9587041453', '9789587041453', '2004-01-01', 'Alfaguara', 'Ficcion', '800', 9),    
    (0, 'Infinito en un junco', '8417860790', '9788417860790', '2019-01-01', 'Siruela', '800', '800', 5),    
    (0, 'El olvido que seremos', '8420426402', '978-8420426402', '2017-10-06', 'Alfaguara', 'Novela Histórica', '800', 8),    
    (0, 'El país de la canela', '8439738831', '978-8439738831', '2020-08-22', 'Random House', 'Novela Histórica', '800', 13),    
    (0, 'Lo que no tiene nombre', '6287659216', '978-6287659216', '2024-03-19', 'Alfaguara', 'Ficcion', '800', 10),    
    (0, 'El ruido de las cosas al caer', '6073137515', '978-6073137515', '2015-12-29', 'Debolsillo', 'Ficcion', '800', 14),    
    (0, 'El síndrome de Ulises', '9584211903', '978-9584211903', '2005-03-30', 'Planeta', 'Ficcion', '800', 15),    
    (0, 'La puta de Babilonia', '6073158855', '978-6073158855', '2018-01-30', 'Debolsillo', 'Ficcion', '800', 11),    
    (0, 'Memorias de un sinvergüenza de siete suelas', '9504932611', '978-9504932611', '2012-01-01', 'Planeta', 'Ficcion', '800', 16),    
    (0, 'Satanás', '9584273543', '978-9584273543', '2018-01-01', 'Planeta DeAgostini Comic', 'Novela gráfica', '800', 7),    
    (0, 'It (Eso)', '0525566267', '978-0525566267', '2019-01-27', 'Vintage Espanol', 'Horror', '800', 17),    
    (0, 'El Resplandor', '0593311233', '978-0593311233', '2005-08-25', 'Vintage', 'Horror', '800', 17),    
    (0, 'Cujo', '1501192241', '978-1501192241', '2018-02-20', 'Scribner', 'Horror', '800', 17),    
    (0, 'Trono de Cristal', '8890981547', '979-8890981547', '2022-05-13', 'Alfaguara', 'Fantasia', '800', 6),    
    (0, 'Entrevista con el Vampiro', '6073198929', '978-6073198929', '2021-05-18', 'B de Bolsillo', 'Ficcion Horror Gótico', '800', 18),    
    (0, 'Anniquilación', '0374104092', '978-0374104092', '2014-02-04', 'FSG Originals', 'Horror', '800', 19),    
    (0, 'Autoridad', '0374104108', '978-0374104108', '2014-05-06', 'FSG Originals', 'Horror', '800', 19),    
    (0, 'Aceptación', '374104115', '978-0374104115', '2014-09-02', 'FSG Originals', 'Horror', '800', 19),    
    (0, 'Frankenstein: o el prometeo moderno', 'N/A', 'N/A', '1818-01-01', 'Lackinton Hughes, Harding, Mavor & Jones', 'Horror Gótico', '832.7', 32),    
    (0, 'Historia de Colombia y sus oligarquias', '9584268754', '978-9584268754', '2019-01-01', 'Crítica', 'Historia Crónica', '800', 12),    
    (0, 'El problema de los tres cuerpos', '8466659734', '978-8466659734', '2016-11-02', 'Nova', 'Ciencia Ficción', '800', 20),    
    (0, 'El Bosque Oscuro', '978-8413146454', '978-8413146454', '2024-05-21', 'Nova', 'Ciencia Ficcion', '800', 20),    
    (0, 'El fin de la muerte', '8417347017', '978-8417347017', '2018-08-21', 'Nova', 'Ciencia Ficcion', '800', 20),    
    (0, 'Crimen y Castigo', '8872132677', '979-8872132677', '1866-12-01', 'Independiente', 'Ficcion', '800', 21),    
    (0, 'Las obras de Leo Tolstoy', '1016243247', '978-1016243247', '2022-10-27', 'Legare', 'Ficcion', '800', 22),    
    (0, 'Historias Cortas', '9389717105', '978-9389717105', '2019-01-12', 'Fingerprint', 'Ficcion', '800', 23),    
    (0, 'Trilogía Fundación', '8499083209', '978-8499083209', '2023-03-23', 'Debolsillo', 'Ciencia Ficción', '800', 24),    
    (0, 'El libro de la selva', '8467871029', '978-8467871029', '1894-01-01', 'Anaya', 'Ficcion', '800', 25),    
    (0, 'El señor de los anillos', '8445013830', '978-8445013830', '2023-11-02', 'Booket', 'Fantasia Epica', '800', 26),    
    (0, 'Juego de tronos', '1644736135', '978-1644736135', '2022-06-21', 'Vintage', 'Fantasia epica', '800', 28),    
    (0, 'Duna', '6073194648', '978-6073194648', '2020-11-17', 'Nova', 'Ciencia Ficción', '800', 29),    
    (0, 'El extranjero', '1518660016', '978-1518660016', '2015-10-16', 'Nova', 'Ficcion', '800', 30),    
    (0, 'El cuento de la criada', '8498388015', '978-8498388015', '2017-06-17', 'Salamandra', 'Ficcion', '800', 31),    
    (0, 'Asesinato en el Orient Express', '6070743986', '978-6070743986', '2022-02-15', 'Planeta', 'Ficcion', '800', 33),    
    (0, 'Cuentos de Terramar', '8467437560', '978-8467437560', '2007-01-01', 'Planeta', 'Fantasia Epica', '800', 34);    


INSERT INTO Audiobooks VALUES
    (0, 'Cuentos de Terramar', '8467437560', '978-8467437560', '2007-01-01', 'Planeta', 'Fantasia Epica', 1, 10000, 'PATH', 34),    
    (0, 'Juego de tronos', '1644736135', '978-1644736135', '2022-06-21', 'Vintage', 'Fantasia epica', 1, 10000, 'PATH', 28),    
    (0, 'Duna', '6073194648', '978-6073194648', '2020-11-17', 'Nova', 'Ciencia Ficción', 1, 10000, 'PATH', 29),    
    (0, 'El extranjero', '1518660016', '978-1518660016', '2015-10-16', 'Nova', 'Ficcion', 1, 10000, 'PATH', 30),    
    (0, 'El cuento de la criada', '8498388015', '978-8498388015', '2017-06-17', 'Salamandra', 'Ficcion', 1, 10000, 'PATH', 31),    
    (0, 'Asesinato en el Orient Express', '6070743986', '978-6070743986', '2022-02-15', 'Planeta', 'Ficcion', 1, 10000, 'PATH', 33);    

INSERT INTO Narrator VALUES
    (0, 'Ana', 'De Armas', 'Femenino', '1'),
    (0, 'Henry', 'Cavill', 'Masculino', '2'),
    (0, 'Steven', 'Spielberg', 'Masculino', '2'),
    (0, 'Ana', 'Sawai', 'Femenino', '5');


INSERT INTO Books Values
(0, "Antologia del Cuento Colombiano", "3146780987", "978-3146780987", "2021-01-01", "Secretos para contar", "Ficción", "800")

INSERT INTO Books_Authors (Book_id, Author_id) VALUES
  (48, 1),
  (48, 2),
  (48, 3),
  (48, 9),
  (48, 8),
  (48, 10)

INSERT INTO Books_Authors (Book_id, Author_id) VALUES
    (1,1), (2,3), (3,2), (4,1), (5,1),
    (6,1), (7,1), (8,3), (9,3), (10,3),
    (11,4), (12,9), (13,10), (14,5), (15,8),
    (16,12), (17,10), (18,13), (19,15), (20,14),
    (21,16), (22,7), (23,17), (24,17), (25,17),
    (26,6), (27,18), (28,19), (29,19), (30,19),
    (31,32), (32,12), (33,20), (34,20), (35,20),
    (36,21), (37,22), (38,23), (39,24), (40,25),
    (41,26), (42,28), (43,29), (44,30), (45,31),
    (46,33), (47,34), (48,1), (48,2), (48,3),
    (48, 7), (48, 10), (48, 15), (48, 12);
