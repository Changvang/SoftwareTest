CREATE TABLE Nations(
	ROT INT NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	AREA VARCHAR(20) NOT NULL,
	CONSTRAINT Nations_PK PRIMARY KEY(NAME) 
)


CREATE TABLE TeamMember(
	ID VARCHAR(15) NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	ROLES VARCHAR(15) NOT NULL,
	CONSTRAINT TeamMember_PK PRIMARY KEY (ID),
	NATIONS VARCHAR(20) NOT NULL REFERENCES dbo.Nations(NAME),
)

--ASIAN NATION TEAM
INSERT INTO	dbo.Nations	VALUES  ( 1,'JAPPAN','ASIAN'); 
INSERT INTO	dbo.Nations	VALUES  ( 2,'KOREA','ASIAN');
INSERT INTO	dbo.Nations	VALUES  ( 3,'SAUDI ARABIA','ASIAN');
INSERT INTO	dbo.Nations	VALUES  ( 4,'AUSTRALIA','ASIAN'); 
INSERT INTO	dbo.Nations	VALUES  ( 5,'VIET NAM','ASIAN'); 
INSERT INTO	dbo.Nations	VALUES  ( 6,'CHINA','ASIAN'); 

--AMERICAN NATION TEAM
INSERT INTO	dbo.Nations	VALUES  ( 1,'COSTA RICA','AMERICAN'); 
INSERT INTO	dbo.Nations	VALUES  ( 2,'PANAMA','AMERICAN');
INSERT INTO	dbo.Nations	VALUES  ( 3,'HONDURAS','AMERICAN');
INSERT INTO	dbo.Nations	VALUES  ( 4,'BELIZE','AMERICAN'); 

--TEAM MEMBER
--JAPPAN
INSERT INTO dbo.TeamMember VALUES  ( 'JP01','Moriyasu Hajime','COACH','JAPPAN');
INSERT INTO dbo.TeamMember VALUES  ( 'JP02','Teguramori Makoto','ASS-COACH','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP03','Hayakawa Naoki','ASS-COACH','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP04','Hamano Yukiya','ASS-COACH','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP05','Hamano Takesi','MEDICAL','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP06','Kawashima Eiji','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP07','nda Shichi','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP08','Schmidt Daniel','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP09','Nagatomo Yuto','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP10','Sakai Hiroki','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP11','Tomiyasu Takehiro','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP12','Teguramori Makoto','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP13','Hayakawa Naoki','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP14','Ueda Naomichi','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP15','Hamano Takesi','PLAYERL','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP16','Hatanaka Shinnosuke','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP17','Anzai Koki','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP18','Haraguchi Genki','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP19','Shibasaki Gaku','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP20','Hamano Takesi','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP21','Moriyasu Hajime','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP22','Nakajima Shoya','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP23','Hayaka1wa Naoki','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP24','Ito Junya','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP25','Hashimoto Kento','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP26','Kubo Takefusa','PLAYER','JAPPAN'); 
INSERT INTO dbo.TeamMember VALUES  ( 'JP27','Teguramori Makoto','PLAYER','JAPPAN'); 

--KOREA

INSERT INTO dbo.TeamMember VALUES  ( 'KR01','KoreaPlayer01','COACH','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR02','KoreaPlayer02','ASS-COACH','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR03','KoreaPlayer03','ASS-COACH','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR04','KoreaPlayer04','ASS-COACH','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR05','KoreaPlayer05','MEDICAL','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR06','KoreaPlayer06','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR07','KoreaPlayer07','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR08','KoreaPlayer08','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR09','KoreaPlayer09','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR10','KoreaPlayer10','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR11','KoreaPlayer11','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR12','KoreaPlayer12','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR13','KoreaPlayer13','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR14','KoreaPlayer14','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR15','KoreaPlayer15','PLAYERL','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR16','KoreaPlayer16','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR17','KoreaPlayer17','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR18','KoreaPlayer18','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR19','KoreaPlayer19','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR20','KoreaPlayer20','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR21','KoreaPlayer21','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR22','KoreaPlayer22','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR23','KoreaPlayer23','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR24','KoreaPlayer24','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR25','KoreaPlayer25','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR26','KoreaPlayer26','PLAYER','KOREA'); 
INSERT INTO dbo.TeamMember VALUES  ( 'KR27','KoreaPlayer27','PLAYER','KOREA'); 


