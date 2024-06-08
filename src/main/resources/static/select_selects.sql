/**************
* Author: Lucho Robles
* Date: 2024-03-23
* Join for books starting with Authors LastName
**************/
SELECT 
	bk.id as 'Id_Book', bk.Name as 'Book_Name', bk.ISBN13, au.Name as 'Authors name', au.Lastname as 'Authors last name', CONCAT(au.Name, ' ', au.Lastname) as 'Author'
FROM Authors au

JOIN Books bk ON bk.author_id = au.id

WHERE 
	au.Lastname = 'Garcia Marquez'; -- == .equals


/**************
* Author: Lucho Robles
* Date: 2024-03-23
* Join for books starting with Authors LastName using wildcard.
**************/
SELECT 
	bk.id as 'Id_Book', bk.Name as 'Book_Name', bk.ISBN13, au.Name as 'Authors name', au.Lastname as 'Authors last name', CONCAT(au.Name, ' ', au.Lastname) as 'Author'
FROM Authors au

JOIN Books bk ON bk.author_id = au.id

WHERE 
	au.Lastname LIkE '%Garcia%'; -- Contains, donde el porcentaje equivale a espacio. % == Wildcard

/**
Author: Lucho Robles
Date: 2024-05-22
Tabla cruzada con Join de autores y libros.
*/
SELECT bk.id, bk.name, au.id, CONCAT(au.name, au.lastname) as Author 

FROM Books_authors ba

JOIN Books bk ON bk.id = ba.book_id
JOIN Authors au ON au.id = ba.author_id


/*Buscar por rango.*/
SELECT * FROM Books 
WHERE Published 
	BETWEEN ('2018-01-01') AND ('2024-12-31')
	ORDER BY Published ASC