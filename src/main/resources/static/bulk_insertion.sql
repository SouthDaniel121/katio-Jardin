USE Katio;

INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES ('Gabriel', 'García Márquez', 'Colombia', '1940-03-03');
    

INSERT INTO Authors
    SET Name = 'Jorge', Lastname = 'Isaacs', Country = 'Colombia', Birthdate = '1836-04-01' 


INSERT INTO Authors
    VALUES ('Germán', 'Castro-Caycedo', 'Colombia', '1940-03-03');


INSERT INTO Books VALUES 
    (0, 'Cien años de soledad', '8420471836', '978-8420471839', '1967-06-05', 'RAE Obra Académica', 'Realismo Mágico', '800', 1),
    (0, 'Huellas', '9584277278', '978-958427275', '2019-01-01', '1ra edicion', 'Crónica', '800', 3),
    (0, 'María', '14802722922', '978-148027292', '1867-01-01', '1ra edicion', 'Romancticismo', '800', 2)


INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES ('Silvia', 'Moreno Garcia', 'Mexico', '1981-04-25');
    
   INSERT INTO Books VALUES 
    (0, 'Mexico Gothic', '8420471836', '978-05256620785', '2020-06-30', 'Del Rey', 'Horror Gótico', '800', 4)