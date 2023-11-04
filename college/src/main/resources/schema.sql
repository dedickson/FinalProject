DROP TABLE IF EXISTS student_course;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS student;


CREATE TABLE student (
student_id int NOT NULL AUTO_INCREMENT,
first_name varchar(60) NOT NULL,
last_name varchar(60) NOT NULL,
year varchar (12) NOT NULL,
major varchar (40) NOT NULL,
PRIMARY KEY (student_id)
);

CREATE TABLE professor (
professor_id int NOT NULL AUTO_INCREMENT,
first_name varchar(60) NOT NULL,
last_name varchar(60) NOT NULL,
department varchar(60) NOT NULL,
PRIMARY KEY(professor_id)
);

CREATE TABLE course (
course_id int NOT NULL AUTO_INCREMENT,
course_name varchar(128) NOT NULL,
professor_id int NOT NULL,
PRIMARY KEY (course_id),
FOREIGN KEY (professor_id) REFERENCES professor (professor_id) ON DELETE CASCADE
);

CREATE TABLE student_course (
student_id int NOT NULL,
course_id int NOT NULL,
FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE CASCADE,
FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE
);
