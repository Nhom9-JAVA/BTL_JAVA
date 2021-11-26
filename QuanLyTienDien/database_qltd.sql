use master 
go
create database qltd
GO
use qltd
go


create table ThongTinCaNhan(
	HoTen nvarchar(1500) not null,
	CMT char(12) not null primary key,
	NgaySinh date not null,
	DiaChi nvarchar(1500) not null,
	GioiTinh nchar(3) not null,
	DienThoai char(10) not null
)


create table NhanVien(
	MaNV integer identity(1,1) primary key,
	CMT char(12) not null,
	constraint FK_NV_ThongTin foreign key(CMT)
		references ThongTinCaNhan(CMT) on update cascade on delete cascade,
	TaiKhoan char(32) not null,
	MatKhau char(32) not null
)

create table LoaiHinhDV(
	MaLSD integer identity(1,1) primary key,
	TenLSD nvarchar(1500) not null,
	TuDM integer not null,
	DenDM integer not null,
	DonGia money not null,
	ThueVAT integer not null
)
create table KhachHang(
	MaKH integer identity(1,1) primary key,
	CMT char(12) not null,
	constraint FK_KH_ThongTin foreign key(CMT)
		references ThongTinCaNhan(CMT) on update cascade on delete cascade,
	NgayBDSD date not null,
	TenLSD nvarchar(1500) not null,
)

create table DienKe(
	MaDK integer identity(1,1) primary key,
	MaKH integer not null,
	constraint FK_DienKe_KH foreign key(MaKH)
		references KhachHang(MaKH) on update cascade on delete cascade,
	NamThang date not null,
	CSC integer not null,
	CSM integer not null
)

create table DSCongNo(
	MaDSCN integer identity(1,1) primary key,
	MaKH integer not null,
	constraint FK_CongNo_KH foreign key(MaKH)
		references KhachHang(MaKH) on update cascade on delete cascade,
	NamThang date not null,
	GhiChu nvarchar(1000) not null
)

create table HoaDon(
	MaHD integer identity(1,1) primary key,
	MaKH integer not null,
	constraint FK_HD_KH foreign key(MaKH)
		references KhachHang(MaKH) on update cascade on delete cascade,
	MaDK integer not null,
	TieuThu integer not null,
	ThanhTien money not null,
	NgayLap date not null
)

create table LichSuGiaoDich(
	MaGD integer identity(1,1) primary key,
	MaHD integer not null,
	constraint FK_LS_HD foreign key(MaHD)
		references HoaDon(MaHD) on update cascade on delete cascade,
	ThoiGianDG date not null,
	GhiChu nvarchar(1000) not null
)




insert into ThongTinCaNhan values
(N'Nguyễn Văn Tiến','123454675431','11/13/2000',N'Tx.Tào Xuyên - Tp.Thanh Hóa','Nam','0377528370'),
(N'Quách Phương Thảo','126547890376','11/13/2000',N'Tx.Tào Xuyên - Tp.Thanh Hóa','Nam','0377528370'),
(N'Nguyễn Gia Thịnh','345632784856','11/13/2000',N'Tx.Tào Xuyên - Tp.Thanh Hóa','Nam','0377528370'),
(N'Nguyễn Xuân Thu','564783905831','11/13/2000',N'Tx.Tào Xuyên - Tp.Thanh Hóa','Nam','0377528370')


insert into NhanVien values
('123454675431','admin','admin'),
('126547890376','thao','thao'),
('345632784856','thinh','thinh'),
('564783905831','thu','thu')

insert into ThongTinCaNhan(HoTen,CMT, NgaySinh, DiaChi, GioiTinh, DienThoai) values
(N'Nguyễn Phú Cầm','187587167567','05/11/2000', N'Thái Hòa - Nghệ An',N'Nam','0342966077'),
(N'Lê Thị Lan Anh','187587985678','05/29/2000', N'Sầm Sơn - Thanh Hóa',N'Nữ','0167409379'),
(N'Nguyễn Lương Bằng','187587145789','06/01/2000', N'Thường Tín - Hà Nội',N'Nam', '0965438973'),
(N'Vũ Duy Chiến','187587853123','08/27/1999', N'Tiên Lữ - Hưng Yên',N'Nam','0979909641'),
(N'Nguyễn Đức Cường','187569563456','03/18/1999', N'Lục Ngạn - Bắc Giang',N'Nam','0868879891'),
(N'Đồng Quang Đại','156325874234','03/20/2000', N'Kim Thành - Hải Dương',N'Nam','0168716166'),
(N'Đặng Tuấn Đạt','145625638123','09/12/1999', N'Nam Trực - Nam Định',N'Nam','0912203815'),
(N'Nguyễn Thị Hương Giang','154896582543', '10/18/1999', N'Lục Ngạn - Bắc Giang',N'Nữ','0164474387'),
(N'Vũ Quỳnh Hảo','156985265987','10/13/2000', N'Trực Ninh - Nam Định',N'Nữ','0833367436'),
(N'Nguyễn Trung Minh Hiếu', '623652569221', '09/12/1999',N'Hoài Đức - Hà Nội',N'Nam','0972654058'),
(N'Công ty TNHH Công nghệ Nhất Việt', '446623133467','06/26/2000', N'Cầu Giấy - Hà Nội',N'Nam','0917566789')


insert into KhachHang (CMT,NgayBDSD,TenLSD) values 
('187587167567','03/20/2021',N'Giá bán điện sinh hoạt'),
('187587985678','03/20/2021',N'Giá bán điện sinh hoạt'),
('187587145789','03/20/2021',N'Giá bán điện sinh hoạt'),
('187587853123','03/20/2021',N'Giá bán điện sinh hoạt'),
('187569563456','03/20/2021',N'Giá bán điện sinh hoạt'),
('156325874234','03/20/2021',N'Giá bán điện sinh hoạt'),
('145625638123','03/20/2021',N'Giá bán điện sinh hoạt'),
('154896582543','03/20/2021',N'Giá bán điện sinh hoạt'),
('156985265987','03/20/2021',N'Giá bán điện sinh hoạt'),
('623652569221','03/20/2021',N'Giá bán điện sinh hoạt'),
('446623133467','03/20/2021',N'Giá điện kinh doanh dịch vụ')


INSERT INTO LoaiHinhDV (TenLSD,TuDM, DenDM, DonGia, ThueVAT) VALUES
(N'Giá bán điện sinh hoạt', 0, 50, 1678, 10),
(N'Giá bán điện sinh hoạt', 50, 100, 1734, 10),
(N'Giá bán điện sinh hoạt', 100, 200, 2014, 10),
(N'Giá bán điện sinh hoạt', 200, 300, 2536, 10),
(N'Giá bán điện sinh hoạt', 300, 400, 2834, 10),
(N'Giá bán điện sinh hoạt', 400, 9999, 2927, 10),
(N'Giá điện kinh doanh dịch vụ', 0, 9999, 2666, 10),
(N'Giá điện sản xuất', 0, 9999, 1685, 10),
(N'Giá điện cơ quan hành chính', 0, 9999, 1902, 10);

--INSERT INTO HoaDon(MaKH, MaDK, TieuThu, ThanhTien, NgayLap) VALUES
--(11,1, 562, 1648121, '03/20/2021'),
--( 3,2, 214, 448254, '03/20/2021'),
--( 4,3, 124, 240830, '02/20/2021'),
--( 5,4, 142, 280707, '01/20/2021')

INSERT INTO DienKe (MaKH,NamThang, CSC, CSM) VALUES
(1, '04/10/2021', 0, 562),
( 2, '04/10/2021', 0, 254),
(3, '04/10/2021', 0, 214),
( 4, '04/10/2021', 0, 124),
( 5, '04/10/2021', 0, 142),
( 6, '04/10/2021', 0, 230),
( 7, '04/10/2021', 0, 0),
(8, '04/10/2021', 0, 0),
( 9, '04/10/2021', 0, 0),
(10, '04/10/2021', 0, 256),
(11, '04/10/2021', 0, 152);

INSERT INTO DSCongNo (MaKH,NamThang, GhiChu) VALUES
( 11, '04/10/2021', N'Chưa nộp tiền'),
( 6, '04/10/2021', N'Chưa nộp tiền'),
( 1, '04/10/2021', N'Chưa nộp tiền'),
( 2, '04/10/2021', N'Chưa nộp tiền'),
( 3, '04/10/2021', N'Chưa nộp tiền'),
( 4, '04/10/2021', N'Chưa nộp tiền'),
( 5, '04/10/2021', N'Chưa nộp tiền'),
( 7, '04/10/2021', N'Chưa nộp tiền'),
( 8, '04/10/2021', N'Chưa nộp tiền'),
( 9, '04/10/2021', N'Chưa nộp tiền'),
( 10, '04/10/2021', N'Chưa nộp tiền')



--INSERT INTO LichSuGiaoDich(MaHD,ThoiGianDG,GhiChu) VALUES
--( 6, '2021-05-13', N'Thanh toán thành công hóa đơn 1 ngày 10-04-2021')
--( 2, '04/10/2021', N'Thanh toán thành công hóa đơn 2 ngày 10-04-2021'),
--(3,'04/10/2021', N'Thanh toán thành công hóa đơn 3 ngày 10-04-2021'),
--( 4, '04/10/2021', N'Thanh toán thành công hóa đơn 4 ngày 10-04-2021'),
--(5, '04/10/2021', N'Thanh toán thành công hóa đơn 5 ngày 10-04-2021');

select * from DienKe
select * from HoaDon
delete from HoaDon
SELECT * FROM DienKe WHERE MaKH = 3;
select *from NhanVien
select * from ThongTinCaNhan
delete from LichSuGiaoDich
select * from LichSuGiaoDich
select *from DSCongNo
delete from DSCongNo
SELECT NgayLap, SUM(ThanhTien) AS 'ThanhTien' FROM HoaDon WHERE MONTH(HoaDon.NgayLap)=3 AND YEAR(HoaDon.NgayLap) = 2021 GROUP BY NgayLap ORDER BY NgayLap DESC
SELECT *  FROM HoaDon WHERE NgayLap = '2021-5-13' AND MaKH =3
SELECT MONTH(NgayLap) AS 'ThangLap', YEAR(NgayLap) AS 'NamLap',NgayLap FROM HoaDon WHERE MaKH = 3
SELECT * FROM KhachHang INNER JOIN DienKe ON KhachHang.MaKH = DienKe.MaKH WHERE MaKH = 4
SELECT * FROM LoaiHinhDV WHERE TenLSD = N'Giá bán điện sinh hoạt'
SELECT MaHD, KhachHang.MaKH,MaDK,TieuThu, ThanhTien, NgayLap FROM khachHang 
			INNER JOIN HoaDon ON HoaDon.MaKH = KhachHang.MaKH 
			INNER JOIN DienKe ON DienKe.MaKH = KhachHang.MaKH 
select * from LichSuGiaoDich
SELECT MaHD, KhachHang.MaKH,TieuThu, ThanhTien, NgayLap FROM HoaDon INNER JOIN KhachHang ON KhachHang.MaKH = HoaDon.MaKH
SELECT MaDK, KhachHang.MaKH, NamThang, CSC, CSM FROM KhachHang
			INNER JOIN DienKe ON DienKe.MaKH = KhachHang.MaKH 
			INNER JOIN ThongTinCaNhan ON ThongTinCaNhan.CMT = KhachHang.CMT
SELECT MaKH, HoTen,KhachHang.CMT,NgaySinh,DiaChi,GioiTinh,DienThoai, NgayBDSD, TenLSD FROM KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT