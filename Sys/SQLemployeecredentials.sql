#DROP TABLE employeecredentials;

CREATE TABLE employeecredentials(
	empid VARCHAR(45),
    passkey VARCHAR(45));

INSERT INTO employeecredentials(empid,passkey)
VALUES
	('Terry','terry123'),
    ('Lois','lois123'),
    ('Tony','tony123');