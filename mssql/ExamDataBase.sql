Drop Table IF Exists Subject
CREATE TABLE Subject
(
SubjectID int NOT NULL IDENTITY(1,1) CONSTRAINT SubjectID_pk PRIMARY KEY,
SubjectName nvarchar(100) NOT NULL,

);
INSERT INTO subject(SubjectName)
VALUES (N'數學'),
	   (N'英文'),
	   (N'國文');
select * from subject;


Drop Table IF Exists Education
CREATE TABLE Education
(
EducationID int NOT NULL IDENTITY(1,1) CONSTRAINT EducationID_pk PRIMARY KEY,
EducationLevel nvarchar(100) NOT NULL,
);
INSERT INTO Education(EducationLevel)
VALUES (N'國中'),
	   (N'高中'),	  
	   (N'成人');
select * from Education;


Drop Table IF Exists Examination
CREATE TABLE Examination
(
ExamID int NOT NULL IDENTITY(1,1),
SubjectName int NOT NULL CONSTRAINT SubjectName_fk REFERENCES Subject(SubjectID),
EducationLevel int NOT NULL CONSTRAINT EducationLevel_fk REFERENCES Education(EducationID),
ExamName nvarchar(100) NOT NULL,
ExamDate Date  NOT NULL,
CONSTRAINT SubjectName_EducationLevel_PK PRIMARY KEY(ExamID)
);

INSERT INTO Examination(SubjectName,EducationLevel,ExamName,ExamDate)
VALUES
	(1,1,N'國中數學-因式分解','2010-02-1'),
	(1,1,N'國中數學-一元二次方程式','2010-03-5'),
	(1,1,N'國中數學-負數與數線','2010-03-5'),
	(1,1,N'國中數學-指數與科學符號','2010-03-5'),
	(1,1,N'國中數學-整數加減','2010-03-5'),
	(1,2,N'高中數學-指對數函數','2010-02-1'),
	(1,2,N'高中數學-三角函數','2010-02-1'),
	(1,2,N'高中數學-平面向量','2010-02-1'),
	(1,2,N'高中數學-矩陣','2010-02-1'),
	(1,3,N'大學數學-導數','2010-03-1'),
	(1,3,N'大學數學-積分','2010-03-1'),
	(1,3,N'大學數學-偏導數','2010-03-1'),
	(2,1,N'國中英文-未來式','2010-04-1'),
	(2,1,N'國中英文-祈使句','2010-04-1'),
	(2,1,N'國中英文-時間介系詞','2010-04-1'),
	(2,2,N'高中英文-關係子句','2010-05-1'),
	(2,2,N'高中英文-現在完成式','2010-05-1'),
	(2,2,N'高中英文-動名詞','2010-05-1'),
	(2,3,N'多益解析','2010-06-1'),
	(2,3,N'多益題庫','2010-06-1'),
	(2,3,N'多益金色證書','2010-06-1'),
	(3,1,N'國中國文-空城計 羅貫中','2010-07-1'),
	(3,1,N'國中國文-張釋之執法 司馬遷','2010-07-1'),
	(3,1,N'國中國文-定伯賣鬼 曹丕','2010-07-1'),
	(3,2,N'高中國文-岳陽樓記','2010-08-1'),
	(3,2,N'高中國文-莊子選庖丁解牛','2010-08-1'),
	(3,2,N'高中國文-黑與白-虎鯨','2010-08-1'),
	(3,3,N'大學國文-老子選','2010-09-1')
select * from Examination;
--考卷編號、科目、程度、考卷名稱、年度


select * from subject;
select * from Education;
select * from Examination where year(ExamDate) = '2012';


--按鈕: 上傳、刪除、修改、查詢(會員)

--題型(是非、單選)、

insert into Examination(SubjectName, EducationLevel,ExamName, ExamDate )
values(1,1,'國中數學3','2010-12-13')


delete from Examination
where SubjectName = (select SubjectID from Subject where SubjectName = '數學') 
  and EducationLevel = (select EducationID from Education where EducationLevel = '國中')
  and ExamName = '國中數學3';

  update Examination set ExamDate= '2012',ExamName = '高中數學1' ;
  where SubjectName = (select SubjectID from Subject where SubjectName = '數學') 
  and EducationLevel = (select EducationID from Education where EducationLevel = '高中')
  and ExamName = '高中數學1' ;

  UPDATE Examination
  SET SubjectName=1 ,EducationLevel=1,ExamDate='2012', ExamName='國中數學33333' 
  WHERE ExamID= 1;


SELECT E.ExamID,S.SubjectName, ED.EducationLevel,E.ExamName, E.ExamDate
FROM Examination E JOIN Subject S on E.SubjectName = S.SubjectID
				   JOIN Education ED on E.EducationLevel = ED.EducationID

Where  S.SubjectName = '數學' and ED.EducationLevel = '成人'


delete from Examination where ExamID = 2

Drop Table IF Exists Question
CREATE TABLE Question
(
QuNumber int NOT NULL IDENTITY(1,1),
QuCateSub varchar(100) NOT NULL  CONSTRAINT QuCateSub_fk REFERENCES subject(subject_name),
QuCateEdu varchar(100) NOT NULL  CONSTRAINT QuCateEdu_fk REFERENCES Education(EducationLevel),
QuScore int NOT NULL ,
Content varchar(2000) NOT NULL,
Answer varchar(4),
);

INSERT INTO Question(QuCateSub,QuCateEdu,QuScore,Content,Answer)
VALUES('Math','Junior highschool','4','5x5','25');
select * from Question;

select * from Question;