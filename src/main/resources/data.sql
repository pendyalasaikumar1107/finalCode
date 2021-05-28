DROP TABLE IF EXISTS Profilestatus;
DROP TABLE IF EXISTS Evaluatorassigned;
DROP TABLE IF EXISTS Evaluator;
DROP TABLE IF EXISTS PROFILE;



CREATE TABLE Profile(id INT PRIMARY KEY, vendor VARCHAR(250), name VARCHAR(250),mobileno BIGINT,location VARCHAR(250),experience FLOAT(2),skill1 VARCHAR(250),skill2 VARCHAR(250),date DATE);

INSERT INTO Profile (id, vendor, name, mobileno, location, experience, skill1, skill2, date) 
VALUES (1967214,'TCS', 'ramesh' , '1111111111','Chennai','2.00','java','angular','2021-05-10'),
	(100000, 'outside' , 'rohan' , '2222222222','HYD','3.10','Angular','python','2021-05-09'),
	(1967219, 'TCS' , 'saikumar' , '3333333333','HYD','3.10','Angular','python','2021-05-09'),
	(1967215, 'TCS' , 'suresh' , '4444444444','HYD','6','Angular','python','2021-04-10'),
	(1967229, 'TCS' , 'beaulah' , '5555555555','HYD','4','Angular','python','2021-04-19'),
	(1967216, 'TCS' , 'paras' , '6666666666','HYD','3.10','Angular','python','2021-04-20'),
	(1967218, 'TCS' , 'shiva' , '7777777777','HYD','1','Angular','python','2021-05-09'),
	(1324376, 'TCS' , 'sachin' , '8888888888','HYD','2','Angular','python','2021-05-09'),
	(1324356, 'TCS' , 'dhawan' , '9876588888','HYD','2','Angular','python','2021-05-27'),
	(1967212, 'TCS' , 'suraj' , '9999999999','HYD','1','Angular','python','2021-05-09');





CREATE TABLE Evaluator(evalid INT PRIMARY KEY, evalname VARCHAR(250) , mobileno BIGINT NOT NULL, mail VARCHAR(250));
INSERT INTO Evaluator(evalid, evalname, mobileno, mail) 
VALUES (1,'beaulah', '687339409','dixcy.ms'),
	(2, 'paras' ,'2347944392','paras.gupta'),
	(3, 'saikumar' ,'2347944392','sai.kumar'),
	(4, 'rohan' ,'2347944392','rohan.ahuja');
	


CREATE TABLE Evaluatorassigned(id INT PRIMARY KEY, evalname VARCHAR(250) , evalid INT);
INSERT INTO Evaluatorassigned (id,evalname,evalid)
VALUES (1967215, 'rohan', 4),(1967216, 'beaulah', 1);



CREATE TABLE Profilestatus(id INT PRIMARY KEY, status VARCHAR(250) , comments VARCHAR(250), evalname VARCHAR(20));
INSERT INTO Profilestatus VALUES(100000,'hired','good','rohan'),(1967219,'not hired','Too junior','beaulah');
