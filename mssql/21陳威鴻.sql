create table article
(
author nvarchar(10) not null,
role nvarchar (10) not null,
article_no int identity(1,1) not null,
publish_time datetime not null,
contents nvarchar (4000) not null,
seen int,
pictures varchar(8000),
)


insert into article(author, role, publish_time, contents, pictures)
values('陳威鴻', '老師', '2022-07-22', '本次觀議課Jennifer老師以譽為美國文化大熔爐的紐約為課程主題，並以任務型教學為課程設計的框架，有效地讓學生浸淫在具有意義的英語學習中。由於新冠疫情的影響，國際旅行除了讓人們暴露於病毒的威脅外，也受限於麻煩的檢疫隔離而令人卻步。
    但紙上談兵也是可以望梅止渴的。
    老師以規劃旅行為本次課程活動，首先介紹了幾個實用的網站提供給學生作為行程規畫的工具，透過真實語料(authentic material)的融入，讓任務更貼近於現實生活的情境，以提升課程的實用性。隨後以一千元美金為限讓學生以小組方式規畫出自己的紐約一日遊。學生的討論聲此起彼落，可以看出大家很投入在這樣具有目的性並且以解決問題為導向的任務當中，而Jennifer老師作為輔助者的角色提供了擬真的情境，成功地激盪出學生間的對話，逐一引導給予建議。
    在這個完全純粹的任務型教學的課堂中，語言知識不是教學的重點，而是透過學生自己動手做，並以自身的語言能力及先輩知識去探索出有用且符合需求的資訊，拼湊出藍圖進一步完成任務。任務型教學除了考驗著老師的教學能力，同時也給與學生很大的學習自主，在完成任務的過程中是會遭遇困難的，因此活動設計的時程須要拉長，任務的執行也可以拆解成許多簡易的步驟，幫助學生累積學習英語的成就感。
    縱觀整堂觀議課，老師的課程設計引人入勝，但老師希望利用一節課的時間讓學生完成任務，我除了建議將執行任務的時程拉長之外，也將旅行中應該考慮到的季節、天氣、交通等因素提出，或許將這些細節融入會讓任務更有帶入感更加貼近於真實。
', 'C:\PICS\PJ.jpg');

--會在新增userid 為FK JOIN到使用者表格 待討論
--專二後想做的功能: 按讚、觀看數、書籤、留言

drop table article

select * from article
