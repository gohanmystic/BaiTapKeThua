USE [QuanLyNguoi]
GO
/****** Object:  Table [dbo].[Khoa]    Script Date: 17/07/2017 9:30:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khoa](
	[MaKhoa] [nvarchar](50) NOT NULL,
	[TenKhoa] [nvarchar](50) NULL,
 CONSTRAINT [PK_Khoa] PRIMARY KEY CLUSTERED 
(
	[MaKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 17/07/2017 9:30:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [bit] NULL,
	[QueQuan] [nvarchar](50) NULL,
	[HeSoLuong] [float] NULL,
	[MaKhoa] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 17/07/2017 9:30:13 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien](
	[MaSV] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [bit] NULL,
	[QueQuan] [nvarchar](50) NULL,
	[DTB] [float] NULL,
	[MaKhoa] [nvarchar](50) NULL,
 CONSTRAINT [PK_SinhVien] PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa]) VALUES (N'Tin', N'Tin')
GO
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa]) VALUES (N'Toan', N'Toan')
GO
INSERT [dbo].[Khoa] ([MaKhoa], [TenKhoa]) VALUES (N'Van', N'Van')
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [GioiTinh], [QueQuan], [HeSoLuong], [MaKhoa]) VALUES (N'nv1', N'Van Tung Son', CAST(0x531B0B00 AS Date), 1, N'Quang Nam', 2.7000000476837158, N'Van')
GO
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [GioiTinh], [QueQuan], [HeSoLuong], [MaKhoa]) VALUES (N'nv2', N'Nguyen Van Nui', CAST(0x1A1C0B00 AS Date), 0, N'Quang Binh', 2, N'Van')
GO
INSERT [dbo].[SinhVien] ([MaSV], [HoTen], [NgaySinh], [GioiTinh], [QueQuan], [DTB], [MaKhoa]) VALUES (N'sv1', N'Tran Quoc Vu', CAST(0xB81F0B00 AS Date), 1, N'Thua Thien Hue', 9.6000003814697266, N'Tin')
GO
INSERT [dbo].[SinhVien] ([MaSV], [HoTen], [NgaySinh], [GioiTinh], [QueQuan], [DTB], [MaKhoa]) VALUES (N'sv2', N'Nguyen GDraSon Tung', CAST(0x2E190B00 AS Date), 0, N'Ba Ria Vung Tau', 4.5999999046325684, N'Toan')
GO
