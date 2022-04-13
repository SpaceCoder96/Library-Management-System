#DROP TABLE usercredentials;

CREATE TABLE usercredentials(
	username VARCHAR(45),
    passkey VARCHAR(45));

INSERT INTO usercredentials(username,passkey)
VALUES
	('Alex','alex123'),
    ('Peter','peter123'),
    ('Brian','brian123'),
    ('Joe','Joe123');