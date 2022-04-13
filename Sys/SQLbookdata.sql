#DROP TABLE bookdata;

CREATE TABLE bookdata(
	bookname VARCHAR(45),
    author VARCHAR(45),
    bookstatus VARCHAR(45),
    store VARCHAR(45),
    issuedate VARCHAR(45),
    returndate VARCHAR(45),
    issuedto VARCHAR(45),
    genre VARCHAR(45),
    bookcode VARCHAR(45),
    authorcode VARCHAR(45),
    published VARCHAR(45),
    authorborn VARCHAR(45),
    authordied VARCHAR(45));

INSERT INTO bookdata(bookname,author,bookstatus,store,genre,bookcode,authorcode,published,authorborn,authordied)
VALUES
	('Death on the Nile','Agatha Christie','1','A2','Mystery','0001','0001','1937','15 September 1890','12 January 1976 (aged 85)'),
    ('Murder on the Orient Express','Agatha Christie','1','A2','Mystery','0002','0001','1934','15 September 1890','12 January 1976 (aged 85)'),
    ('The Immortals of Meluha','Amish Tripathi','1','A3','Fiction','0003','0002','2010','18 October 1974 (age 47)','N.A.'),
    ('The DaVinci Code','Dan Brown','1','A2','Mystery','0004','0003','2003','22 June 1964 (age 57)','N.A.'),
    ('Angels and Demons','Dan Brown','1','A2','Mystery','0005','0003','2000','22 June 1964 (age 57)','N.A.'),
    ('The Great Gatsby','F. Scott Fitzgerald','1','A1','Classic','0006','0004','1925','24 September 1896','21 December 1940 (aged 44)'),
    ('1984','George Orwell','1','A1','Classic','0007','0005','1949','25 June 1903','21 January 1950 (aged 46)'),
    ('Animal Farm','George Orwell','1','A1','Classic','0008','0005','1945','25 June 1903','21 January 1950 (aged 46)'),
    ('As a Man Thinketh','James Allen','1','B1','Self Help','0009','0006','1903','28 November 1864','24 January 1912 (aged 47)'),
    ('Pride and Prejudice','Jane Austen','1','A1','Classic','0010','0007','1813','16 December 1775','18 July 1817 (aged 41)'),
    ('Gulliver’s Travels','Jonathon Swift','1','A3','Fiction','0011','0008','1726','30 November 1667','19 October 1745 (aged 77)'),
    ('The Power of Your Subconious Mind','Joseph Murphy','1','B1','Self Help','0012','0009','1963','20 May 1898','16 December 1981'),
    ('Around the World in Eighty Days','Jules Verne','1','A3','Fiction','0013','0010','1973','8 February 1828','24 March 1905 (aged 77)'),
    ('War and Peace','Leo Tolstoy','1','A1','Classic','0014','0011','1869','9 September 1828','20 November 1910 (aged 82)'),
    ('The Shining','Stephen King','1','B2','Horror','0015','0012','1977','September 21, 1947 (age 74)','N.A.'),
    ('Macbeth','William Shakespeare','1','A1','Classic','0016','0013','1622','26 April 1564(Baptised)','23 April 1616 (aged 52)'),
    ('Othello','William Shakespeare','1','A1','Classic','0017','0013','1623','26 April 1564(Baptised)','23 April 1616 (aged 52)');