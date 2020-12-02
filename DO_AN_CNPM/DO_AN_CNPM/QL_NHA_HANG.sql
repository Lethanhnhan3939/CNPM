use master
drop database QL_NHA_HANG
create database QL_NHA_HANG
GO
use QL_NHA_HANG

create table MONAN(
	idMonAn int primary key identity(1,1),
	tenMonAn nvarchar(256),
	donvitinh nvarchar(10),
	loai bit,	--0: thức ăn; 1: nước uống
	gia int,
	trangthai int default 1
)

CREATE TABLE BAN(
	id [int],
	[trangthai] [int] NULL,
	[tenmon] [nvarchar](255) NULL,
	[soluong] [int] NULL,
	[gia] [int] NULL,
	[ghichu] [nvarchar](256) NULL,
	[thanhtien] [int] NULL,
	[giogoi] [time](7) NULL
)

create table DATBAN(
	idBan int primary key identity(1,1),
	thoigian datetime,
	tenKH nvarchar(256),
	sdt varchar(256)
)


create table NHANVIEN(
	idNV int primary key identity(1,1),
	tenNV nvarchar(256),
	sdt varchar(10),
	ngaysinh date,
	diachi nvarchar(256),
	gioitinh bit,	--0: nam	;	1: nữ
	CMND varchar(10),
	loaiNV bit, --PHÂN LOẠI NHÂN VIÊN PARTTIME=0 || FULLTIME=1
	chucvu nvarchar(256),
	luong int,	--ĐỐI VỚI PARTTIME SẼ LÀ LƯƠNG CƠ BẢN, FULLTIME LÀ LƯƠNG CỨNG
	ngayvaolam date,
	trangthai bit default 0	--0:unblock	;	1: blocked
)

create table LUONG(
	idNV int foreign key references NHANVIEN(idNV),
	luongthang int NOT NULL,			--luongthang=MONTH(GETDATE())
	nam int NOT NULL,
	tongluong float,
	tongthoigian float,					--lấy thời gian từ bảng lương theo tháng trong (luongthang) và YEAR(GETDATE())
	tamung int,
	--phucap int default(0),
	--phat int default(0),
	ghichu nvarchar(256) NULL
)

create table BANGLUONG(
	idNV int foreign key references NHANVIEN(idNV),
	timevao datetime,
	timera datetime,
	ghichu nvarchar(256)
)

create table ACCOUNT(
	username varchar(256) primary key,
	pwd varchar(256),
	owner int foreign key references NHANVIEN(idNV),
	permission_level int,
	pwd_history datetime
)

create table HOADON(
	idHD int primary key identity(1,1),
	idNV int foreign key references NHANVIEN(idNV),
	tongtien int,
	ngay datetime
	--bổ sung khách hàng
)

create table CTHOADON(
	idHD int foreign key references HOADON(idHD),
	idMonAn int foreign key references MONAN(idMonAn),
	soluong int
)

create table NCC(
	idNCC int primary key identity(1,1),
	tenNCC nvarchar(256),
	sdt varchar(256)
)

create table NGUYENLIEU(
	idNL int primary key identity(1,1),
	tenNL nvarchar(256),
	gia int,
	idNCC int foreign key references NCC(idNCC),
	donvitinh nvarchar(10)
)

create table CONGTHUCNAU(
	id int primary key identity,
	idMonAn int foreign key references MONAN(idMonAn),
	idNL int foreign key references NGUYENLIEU(idNL),
	khoiluong int,
	donvitinh nvarchar (50)
)

create table PHIEUTHU(
	idPT int primary key identity(1,1),
	ngaythu date,
	tongtien int
)

create table PHIEUCHI(
	idPC int primary key identity(1,1),
	thoigian datetime,
	tongtien int,
	ghichu nvarchar(256) NULL
)

create table CTPHIEUCHI(
	idPC int foreign key references PHIEUCHI(idPC),
	idNL int foreign key references NGUYENLIEU(idNL) NULL,
	soluong int,
)

-------------------------NHAP DU LIEU--------------------------------------------------
insert into MONAN(tenMonAn,donvitinh,loai,gia) 
	values  (N'Cơm chiên dương châu',N'đĩa',0,40000),
			(N'Bò cốt lết',N'đĩa',0,65000),
			(N'Bò hầm ngũ vị hương',N'đĩa',0,80000),
			(N'Hải sâm xào nấm đông cô cải thìa',N'đĩa',0,95000),
			(N'Heneiken',N'chai',1,25000),
			(N'Gà Quay Ngũ Vị-Bánh Bao',N'dĩa',0,500000),
			(N'Sting',N'chai',1,13000),
			(N' Trà Xanh Không Độ',N'chai',1,10000),
			(N'Stwister Sữa Cam',N'chai',1,12000),
			(N'Nước Suối',N'chai',1,8000)


insert into NHANVIEN(tenNV,sdt,ngaysinh,diachi,gioitinh,CMND,loaiNV,chucvu,luong,ngayvaolam) 
	values  (N'Nguyễn Công Phú','0123456789','1999/02/19',N'102 Trần Hưng Đạo',0,'12345678',0,N'Phục vụ',20000,'2019/07/19'),
			(N'Tran Cong Phu','0987654321','1997/01/04',N'111 Ly Thuong Kiet',0,'12045678',0,N'Thu ngân',25000,'2019/07/19'),
			(N'Nguyen Nhu Nhut','0927345678','2000/10/1',N'731 Tran Hung Dao, Q5, TpHCM',0,'02045678',0,N'Phục vụ',18000,'2019/07/19'),
			(N'Le Thi Phi Yen','0987567390','1990/4/26',N'23/5 Nguyen Trai, Q5, TpHCM',1,'92045678',1,N'Quản lý',5000000,'2019/07/19'),
			(N'Nguyễn Trần Nhật','01235879','2000/11/2',N'235 Trường Sa',0,'32145687',0,N'Thu Ngân',25000,'2019/5/25'),
			(N'Ngô Quốc Trọng','09535874','1997/2/8',N'545 Hoàng Sa',0,'312589722',0,N'Phục vụ',18000,'2/11/2019'),
			(N'Lê Ngọc Thiên Nhã','01258749','2000/1/5',N'575 3/2',1,'312348759',0,N'Phục vụ',20000,'2019/3/11'),
			(N'Nguyễn Lý Kiến Hoa','0759865248','1999/6/25',N'236 An Dương Vương',1,'312354879',0,N'Phục vụ',20000,'2019/6/3'),
			(N'Trang Thái Hà Ngân','0895784596','1998/10/29',N'26 Ngô Quyền',1,'312349865',0,N'Phục vụ',20000,'2019/1/30'),
			(N'Phạm Ái','090265987','2000/4/12',N'159 Lý Chính Thắng',1,'',0,N'Phục vụ',20000,'2019/3/22')

insert into LUONG(idNV,luongthang,nam,tongluong,tongthoigian,tamung,ghichu) 
	values  (1,11,2019,2000000,100,0,NULL),
			(1,9,2020,2000000,100,0,NULL),
			(2,9,2019,2250000,90,0,NULL),
			(3,11,2019,940000,80,500000,N'tạm ứng ngày 14/9'),
			(4,11,2019,5000000,110,0,NULL),
			(5,9,2019,2250000,90,0,NULL),
			(6,9,2019,1800000,100,0,NULL),
			(7,9,2019,2000000,100,0,NULL),
			(8,9,2019,2000000,100,0,NULL),
			(9,9,2019,2000000,100,0,NULL),
			(10,9,2019,2000000,100,0,NULL)

insert into BANGLUONG(idNV,timevao,timera) 
	values  (1,'2020-09-19T07:00:00','2020-09-19T20:00:00'),
			(1,'2020-09-20T07:00:00','2020-09-20T20:00:00'),
			(2,'2019-09-19T07:00:00','2019-09-19T20:00:00'),
			(3,'2019-11-19T07:00:00','2019-11-19T20:00:00'),
			(4,'2019-11-19T07:00:00','2019-11-19T20:00:00'),
			(5,'2019-09-19T07:00:00','2019-09-19T20:00:00'),
			(6,'2019-09-20T07:00:00','2019-09-20T20:00:00'),
			(7,'2019-09-19T07:00:00','2019-09-19T20:00:00'),
			(7,'2019-09-18T07:00:00','2019-09-19T17:00:00'),
			(9,'2019-09-19T07:00:00','2019-09-19T20:00:00'),
			(10,'2019-09-19T07:00:00','2019-09-19T20:00:00'),
			(1,'2019-11-19T07:00:00','2019-11-19T20:00:00')

insert into NCC(tenNCC,sdt) 
	values	(N'Vissan',0999999999),
			(N'Acecook',0111111111),
			(N'C.P VIỆT NAM',0919191919),
			(N'Cocacola',0222222222),
			(N'T.P Hoàng Đông',0926854255),
			(N'T.P Hòa Bình',0302569874),
			(N'T.P Đại Thuận',01255897455),
			(N'Rau Quả Tiền Giang ',0919789654),
			(N'T.P San Hà',01232521488),
			(N'N.S Lâm Đồng',081652541)

insert into NGUYENLIEU(tenNL,gia,idNCC,donvitinh) 
	values	(N'Thịt bò Kobe',1000000,3,N'Kg'),
			(N'Thịt nạc vai bò',300000,1,N'Kg'),
			(N'Hạt nêm Knor',35000,2,N'Kg'),
			(N'Nước ngọt',280000,4,N'Thùng'),
			(N'Gà đông lạnh',200000,9,N'con'),
			(N'bắp cải',20000,10,N'Kg'),
			(N'cải đỏ',20000,10,N'Kg'),
			(N'chanh',25000,8,N'Kg'),
			(N'bột bánh bao',17000,7,N'Kg'),
			(N'dầu ăn',230000,2,N'Thùng')

insert into PHIEUTHU(ngaythu,tongtien) 
	values	('2019/09/09',245000),
			('2019/09/10',345000),
			('2019/09/15',145000),
			('2019/09/19',205000),
			('2019/09/07',145000),
			('2019/09/08',145000),
			('2019/09/13',145000),
			('2019/09/17',500000),
			('2019/09/20',345000),
			('2019/09/21',245000)

insert into PHIEUCHI(thoigian,tongtien,ghichu) 
	values	('2019-09-09T07:07:00',445000,NULL),
			('2019-09-09T07:35:01',1345000,NULL),
			('2019-09-11T07:35:01',605000,NULL),
			('2019-09-12T07:30:00',1220000,NULL),
			('2019-09-13T07:30:00',350000,NULL),
			('2019-09-14T07:05:00',910000,NULL),
			('2019-09-15T07:15:00',400000,NULL),
			('2019-09-16T07:20:00',845000,NULL),
			('2019-09-17T07:10:00',310000,NULL),
			('2019-09-18T07:02:00',75000,NULL)

insert into CTPHIEUCHI(idPC,idNL,soluong) 
	values	(1,4,5),
			(1,3,10),
			(2,9,2),
			(2,2,1),
			(3,4,5),
			(4,3,10),
			(5,8,2),
			(6,7,1),
			(7,10,5),
			(8,5,10),
			(9,1,2),
			(10,6,1)

insert into ACCOUNT(username,pwd,permission_level) 
	values	('phong','phong',1)



--xếp hạng món ăn ưa thích
select idMonAn,count(*) SL from CTHOADON where idMonAn IN (select idMonAn from MONAN) GROUP BY idMonAn


select idMonAn,count(*) SL, rank () OVER (ORDER BY count(*) DESC) HẠNG from CTHOADON CT, HOADON HD 
	where CT.idHD=HD.idHD AND CT.idMonAn IN (select idMonAn from MONAN) AND MONTH(HD.ngay)=10 GROUP BY idMonAn

--XUẤT HD CỦA NGÀY CHỈ ĐỊNH
select CAST(HD.ngay AS DATE) NGAY, SUM(HD.tongtien) DOANH_THU from HOADON HD WHERE CAST(HD.ngay AS DATE)='09-09-2019' GROUP BY HD.ngay

--XUẤT TẤT CẢ NGÀY
select CAST(HD.ngay AS DATE) NGAY, SUM(HD.tongtien) DOANH_THU from HOADON HD WHERE HD.ngay IN(SELECT ngay FROM HOADON) GROUP BY HD.ngay

--xuất doanh thu từng tháng trong năm	
select month(ngay),sum(tongtien) from HOADON where month(ngay) in (select month(ngay) from HOADON WHERE YEAR(NGAY)=2019) group by month(ngay)

CREATE PROCEDURE SelectAllCustomers @City nvarchar(30), @PostalCode nvarchar(10)
AS
SELECT * FROM Customers WHERE City = @City AND PostalCode = @PostalCode
GO;