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
values('�����E', '�Ѯv', '2022-07-22', '�����[ĳ��Jennifer�Ѯv�H�A�������Ƥj���l���ì����ҵ{�D�D�A�åH���ȫ��оǬ��ҵ{�]�p���ج[�A���Ħa���ǥͮ��]�b�㦳�N�q���^�y�ǲߤ��C�ѩ�s�a�̱����v�T�A��ڮȦ氣�F���H�̼��S��f�r���¯٥~�A�]������·Ъ��ˬ̹j���ӥO�H�o�B�C
    ���ȤW�ͧL�]�O�i�H���������C
    �Ѯv�H�W���Ȧ欰�����ҵ{���ʡA�������ФF�X�ӹ�Ϊ��������ѵ��ǥͧ@����{�W�e���u��A�z�L�u��y��(authentic material)���ĤJ�A�����ȧ�K���{��ͬ������ҡA�H���ɽҵ{����ΩʡC�H��H�@�d�������������ǥͥH�p�դ覡�W�e�X�ۤv���ì��@��C�C�ǥͪ��Q���n���_�����A�i�H�ݥX�j�a�ܧ�J�b�o�˨㦳�ت��ʨåB�H�ѨM���D���ɦV�����ȷ��A��Jennifer�Ѯv�@�����U�̪����ⴣ�ѤF���u�����ҡA���\�a�E���X�ǥͶ�����ܡA�v�@�޾ɵ�����ĳ�C
    �b�o�ӧ����º骺���ȫ��оǪ��Ұ󤤡A�y�����Ѥ��O�оǪ����I�A�ӬO�z�L�ǥͦۤv�ʤⰵ�A�åH�ۨ����y����O�Υ������ѥh�����X���ΥB�ŦX�ݨD����T�A����X�Ź϶i�@�B�������ȡC���ȫ��оǰ��F����ۦѮv���оǯ�O�A�P�ɤ]���P�ǥͫܤj���ǲߦۥD�A�b�������Ȫ��L�{���O�|�D�J�x�����A�]�����ʳ]�p���ɵ{���n�Ԫ��A���Ȫ�����]�i�H��Ѧ��\�h²�����B�J�A���U�ǥͲֿn�ǲ߭^�y�����N�P�C
    �a�[����[ĳ�ҡA�Ѯv���ҵ{�]�p�ޤH�J�ӡA���Ѯv�Ʊ�Q�Τ@�`�Ҫ��ɶ����ǥͧ������ȡA�ڰ��F��ĳ�N������Ȫ��ɵ{�Ԫ����~�A�]�N�Ȧ椤���ӦҼ{�쪺�u�`�B�Ѯ�B��q���]�����X�A�γ\�N�o�ǲӸ`�ĤJ�|�����ȧ󦳱a�J�P��[�K���u��C
', 'C:\PICS\PJ.jpg');

--�|�b�s�Wuserid ��FK JOIN��ϥΪ̪�� �ݰQ��
--�M�G��Q�����\��: ���g�B�[�ݼơB���ҡB�d��

drop table article

select * from article
