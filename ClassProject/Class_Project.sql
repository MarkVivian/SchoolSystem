DROP DATABASE IF EXISTS StudentSystem;
CREATE DATABASE StudentSystem;
USE StudentSystem;

CREATE TABLE LoginDetails(
	StudentId INT AUTO_INCREMENT PRIMARY KEY,
	StudentReg VARCHAR(30),
    StudentPassword VARCHAR(30)
);

INSERT INTO LoginDetails VALUES(
	DEFAULT,
	"EB1.1234.12",
	"1234"
),(
	DEFAULT,
	"EB2.5678.34",
	"5678"
),(
	DEFAULT,
	"EB3.9123.34",
	"9123"
),(
	DEFAULT,
    "Admin",
    "Admin"
);

CREATE INDEX idx_StudentReg ON LoginDetails(StudentReg);

CREATE TABLE StudentDetails(
	StudentId INT PRIMARY KEY,
    FOREIGN KEY(StudentId) REFERENCES LoginDetails(StudentId) ON DELETE CASCADE ON UPDATE CASCADE,
    StudentName VARCHAR(30),
    StudentReg VARCHAR(30),
    FOREIGN KEY(StudentReg) REFERENCES LoginDetails(StudentReg) ON UPDATE CASCADE ON DELETE CASCADE,
    StudentProgramme VARCHAR(30)
);

INSERT INTO StudentDetails VALUES(
	1,
	"John Doe",
    "EB1.1234.12",
    "Computer Science"
),(
	2,
	"Martin Luther",
    "EB2.5678.34",
    "Teaching"
),(
	3,
	"Barack Obama",
    "EB3.9123.34",
    "Architecture"
),(
	4,
    "Admin",
	"Admin",
    "Law"
);

CREATE TABLE StudentCourse(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    StudentId INT,
    FOREIGN KEY(StudentId) REFERENCES LoginDetails(StudentId) ON UPDATE CASCADE ON DELETE CASCADE,
	CourseName VARCHAR(30),
    CourseCode VARCHAR(30),
    CourseId INT
);

INSERT INTO StudentCourse VALUES(
DEFAULT,
1,
"Statistics",
"MATH 122",
122
),(
DEFAULT,
2,
"English",
"ENG 234",
234
),(
DEFAULT,
3,
"Computer Programming",
"COSC 100",
100
),(
DEFAULT,
4,
"Hospitality",
"HOP 987",
987
),
(
DEFAULT,
4,
"Statistics",
"MATH 122",
122
),(
DEFAULT,
1,
"English",
"ENG 234",
234
),(
DEFAULT,
2,
"Computer Programming",
"COSC 100",
100
),(
DEFAULT,
3,
"Hospitality",
"HOP 987",
987
),
(
DEFAULT,
3,
"Statistics",
"MATH 122",
122
),(
DEFAULT,
4,
"English",
"ENG 234",
234
),(
DEFAULT,
1,
"Computer Programming",
"COSC 100",
100
),(
DEFAULT,
2,
"Hospitality",
"HOP 987",
987
),
(
DEFAULT,
2,
"Statistics",
"MATH 122",
122
),(
DEFAULT,
3,
"English",
"ENG 234",
234
),(
DEFAULT,
4,
"Computer Programming",
"COSC 100",
100
),(
DEFAULT,
1,
"Hospitality",
"HOP 987",
987
),
(
DEFAULT,
1,
"Propability",
"MATH 134",
134
),(
DEFAULT,
2,
"HIV.AIDS",
"ZOOL 383",
383
),(
DEFAULT,
3,
"Computer networking",
"COSC 111",
111
),(
DEFAULT,
4,
"Medicine",
"MED 222",
222
);

CREATE TABLE BookInfo(
	BookId INT AUTO_INCREMENT PRIMARY KEY,
    BookTitle VARCHAR(30),
    BookEdition VARCHAR(30),
    BookVersion VARCHAR(30),
	yearPublished VARCHAR(30)
);

INSERT INTO BookInfo VALUES(
DEFAULT,
"Percy Jackson",
""
),(
DEFAULT,
),(
DEFAULT,
),(
DEFAULT,
);

CREATE TABLE LibraryDetails(
	TitleId INT PRIMARY KEY,
	FOREIGN KEY(TitleId) REFERENCES BookInfo(BookId) ON DELETE CASCADE ON UPDATE CASCADE,
    TitleCount INT,
    Borrowed BOOLEAN,
    Returned BOOLEAN,
    StudentId INT
);
