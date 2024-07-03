USE Katio;

INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES 
    ('Irene', 'Vallejo', 'España', '1979-06-06'),
    ('Sarah', 'Maas', 'EEUU', '1986-03-05'),
    ('Mario', 'Mendoza', 'Colombia', '1964-01-10'),
    ('Hector', 'Abad Faciolince', 'Colombia', '1958-10-01'),
    ('Laura', 'Restrepo', 'Colombia', '1950-01-01'),
    ('Piedad', 'Bonnet', 'Colombia', '1951-01-01'),
    ('Fernando', 'Vallejo', 'Colombia', '1942-10-24'),
    ('Antonio', 'Caballero', 'Colombia', '1945-05-15'),
    ('William', 'Ospina', 'Colombia', '1954-03-02'),
    ('Juan Gabriel', 'Vasquez', 'Colombia', '1973-01-01'),
    ('Santiago', 'Gamboa', 'Colombia', '1965-01-01'),
    ('Angela', 'Becerra', 'Colombia', '1957-07-17'),
    ('Stephen', 'King', 'EEUU', '1947-09-21'),
    ('Anne', 'Rice', 'EEUU', '1941-10-04'),
    ('Jeff', 'Vandermeer', 'EEUU', '1968-07-07'),
    ('Liu', 'Cixin', 'China', '1963-06-30'),
    ('Fyodor', 'Dostoevsky', 'Rusia', '1821-11-11'),
    ('Leo', 'Tolstoy', 'Rusia', '1828-09-09'),
    ('Anton', 'Chekhov', 'Rusia', '1860-01-29'),
    ('Isaac', 'Asimov', 'Rusia', '1920-01-02'),
    ('Rudyard', 'Kipling', 'India', '1865-12-30'),
    ('Jon Ronald Reuel', 'Tolkien', 'Surafrica', '1892-01-03'),
    ('Clive Staples', 'Lewis', 'Reino Unido', '1898-11-29'),
    ('George Raymond Richard', 'Martin', 'EEUU', '1948-09-20'),
    ('Frank', 'Herbert', 'EEUU', '1920-10-08'),
    ('Albert', 'Camus', 'France', '1913-11-07'),
    ('Margaret', 'Atwood', 'Canada', '1939-11-18'),
    ('Mary', 'Shelley', 'Inglaterra', '1797-08-30'),
    ('Agatha', 'Christie', 'Inglaterra', '1890-09-15'),
    ('Ursula K', 'Le Guin', 'EEUU', '1929-10-21');
    
    
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
    (0, 'Aceptación', '0374104116', '978-0374104116', '2014-09-02', 'FSG Originals', 'Horror', '800', 19),    
    (0, 'La era de la Supernova', '1250306036', '978-1250306036', '2019-10-22', 'Tor Books', 'Ciencia Ficcion', '800', 20),    
    (0, 'Los tres cuerpos', '6073158898', '978-6073158898', '2017-01-20', 'Debolsillo', 'Ciencia Ficcion', '800', 20),    
    (0, 'El maestro y Margarita', '8491050412', '978-8491050412', '2016-10-30', 'Navona', 'Ficción', '800', 21),    
    (0, 'Crimen y Castigo', '1549570538', '978-1549570538', '2018-09-12', 'Independently published', 'Ficcion', '800', 22),    
    (0, 'Los hermanos Karamazov', '0525566550', '978-0525566550', '2020-05-26', 'Vintage Espanol', 'Ficcion', '800', 22),    
    (0, 'Ana Karenina', '8491050420', '978-8491050429', '2017-03-24', 'Navona', 'Ficcion', '800', 23),    
    (0, 'Guerra y Paz', '1549570538', '978-1549570538', '2018-09-12', 'Independently published', 'Ficcion', '800', 23),    
    (0, 'El jardin secreto', '1508454357', '978-1508454359', '2018-02-10', 'Independently published', 'Ficcion', '800', 24),    
    (0, 'Fundación', '6073198925', '978-6073198929', '2021-05-18', 'Edhasa', 'Ciencia Ficcion', '800', 25),    
    (0, 'Yo, Robot', '8491050416', '978-8491050416', '2016-10-30', 'Navona', 'Ciencia Ficcion', '800', 25),    
    (0, 'El hombre invisible', '0525566500', '978-0525566500', '2020-05-26', 'Vintage Espanol', 'Ciencia Ficcion', '800', 25),    
    (0, 'Mowgli', '6073161197', '978-6073161197', '2018-11-20', 'Alma', 'Ficción', '800', 26),    
    (0, 'El libro de la selva', '8491050411', '978-8491050412', '2016-10-30', 'Navona', 'Ficcion', '800', 26),    
    (0, 'El Hobbit', '6073134117', '978-6073134117', '2015-08-25', 'Random House', 'Fantasia', '800', 27),    
    (0, 'El Silmarillion', '6073198929', '978-6073198929', '2021-05-18', 'Minotauro', 'Fantasia', '800', 27),    
    (0, 'Narnia', '6073144534', '978-6073144534', '2016-10-30', 'Destino', 'Fantasia', '800', 28),    
    (0, 'Juego de Tronos', '6073148904', '978-6073148904', '2020-05-26', 'Penguin Random House', 'Fantasia', '800', 29),    
    (0, 'Tormenta de espadas', '0525566505', '978-0525566505', '2020-05-26', 'Vintage Espanol', 'Fantasia', '800', 29),    
    (0, 'Dune', '6073158873', '978-6073158873', '2017-01-20', 'Random House', 'Ciencia Ficcion', '800', 30),    
    (0, 'El extranjero', '6073198916', '978-6073198916', '2021-05-18', 'Edhasa', 'Ficcion', '800', 31),    
    (0, 'La peste', '6073158866', '978-6073158866', '2017-01-20', 'Debolsillo', 'Ficcion', '800', 31),    
    (0, 'El cuento de la criada', '8491050410', '978-8491050410', '2016-10-30', 'Navona', 'Ficcion', '800', 32),    
    (0, 'Frankenstein', '6073198917', '978-6073198917', '2021-05-18', 'Minotauro', 'Horror', '800', 33),    
    (0, 'Diez negritos', '6073158867', '978-6073158867', '2017-01-20', 'Debolsillo', 'Misterio', '800', 34),    
    (0, 'Asesinato en el Orient Express', '6073198918', '978-6073198918', '2021-05-18', 'Minotauro', 'Misterio', '800', 34),    
    (0, 'La mano izquierda de la oscuridad', '6073198919', '978-6073198919', '2021-05-18', 'Minotauro', 'Ciencia Ficcion', '800', 35);


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

INSERT INTO Genres (Name) VALUES
('Novela'), ('Comedia'), ('Realismo Mágico'),
('Noveleta'), ('Cuento'), ('Educación'),
('Química'), ('Física'), ('Matemática');