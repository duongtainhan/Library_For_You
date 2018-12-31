package android.dienty.library_for_you;

public class CONST {
    //Name of pages
    public static final class NAME_PAGE{
        //VIET NAM PAGES
        public static final String VN_EXPRESS = "VN EXPRESS";
        public static final String DAN_TRI = "DÂN TRÍ";
        public static final String HAI_TU_GIO = "24H";
        public static final String KENH_14 = "KÊNH 14";
        public static final String VIETNAM_NET = "VIETNAM.NET";
        public static final String NGOI_SAO = "NGÔI SAO";
        public static final String GENK = "GENK";
        //INTERTIONAL PAGES
        public static final String NYTIMES = "THE NEW YORK TIMES";
        public static final String WASHINGTON_POST = "THE WASHINGTON POST";
        public static final String LA_TIMES = "LOS ANGELES TIMES";
        public static final String DAILY_MAIL = "MAIL ONLINE";
        public static final String HUFF_POST = "HUFFPOST";
        public static final String WSJ = "WSJ";
    }

    //Intent
    public static final class INTENT{
        public static final String PAGE_SELECTED = "PAGE_SELECTED";
        public static final String KEY_SEARCH = "KEY_SEARCH";
        public static final String VIDEO_ID = "VIDEO_ID";
        public static final String LINK = "LINK";

    }
    //TypePage
    public static final class TYPE_PAGE
    {
        public static final String VIET_NAM = "VIET_NAM";
        public static final String INTERNATIONAL = "INTERNATIONAL";
    }
    //DATA
    public static final class DATA
    {
        public static final class length{
            public static final int vn_express = 18;
            public static final int dan_tri = 26;
            public static final int hai_tu_gio = 25;
            public static final int kenh_14 = 11;
            public static final int vietnam_net = 17;
            public static final int ngoi_sao = 24;
            public static final int genk = 7;
        }
        public static final class url
        {
            public static final String vn_express[]={
                    "https://vnexpress.net/rss/tin-moi-nhat.rss",
                    "https://vnexpress.net/rss/thoi-su.rss",
                    "https://vnexpress.net/rss/the-gioi.rss",
                    "https://vnexpress.net/rss/kinh-doanh.rss",
                    "https://vnexpress.net/rss/startup.rss",
                    "https://vnexpress.net/rss/giai-tri.rss",
                    "https://vnexpress.net/rss/the-thao.rss",
                    "https://vnexpress.net/rss/phap-luat.rss",
                    "https://vnexpress.net/rss/giao-duc.rss",
                    "https://vnexpress.net/rss/suc-khoe.rss",
                    "https://vnexpress.net/rss/gia-dinh.rss",
                    "https://vnexpress.net/rss/du-lich.rss",
                    "https://vnexpress.net/rss/khoa-hoc.rss",
                    "https://vnexpress.net/rss/so-hoa.rss",
                    "https://vnexpress.net/rss/oto-xe-may.rss",
                    "https://vnexpress.net/rss/cong-dong.rss",
                    "https://vnexpress.net/rss/tam-su.rss",
                    "https://vnexpress.net/rss/cuoi.rss"
            };
            public static final String dan_tri[]={
                    "https://dantri.com.vn/trangchu.rss",
                    "https://dantri.com.vn/suc-khoe.rss",
                    "https://dantri.com.vn/xa-hoi.rss",
                    "https://dantri.com.vn/giai-tri.rss",
                    "https://dantri.com.vn/giao-duc-khuyen-hoc.rss",
                    "https://dantri.com.vn/the-thao.rss",
                    "https://dantri.com.vn/the-gioi.rss",
                    "https://dantri.com.vn/kinh-doanh.rss",
                    "https://dantri.com.vn/o-to-xe-may.rss",
                    "https://dantri.com.vn/suc-manh-so.rss",
                    "https://dantri.com.vn/tinh-yeu-gioi-tinh.rss",
                    "https://dantri.com.vn/chuyen-la.rss",
                    "https://dantri.com.vn/viec-lam.rss",
                    "https://dantri.com.vn/nhip-song-tre.rss",
                    "https://dantri.com.vn/tam-long-nhan-ai.rss",
                    "https://dantri.com.vn/phap-luat.rss",
                    "https://dantri.com.vn/ban-doc.rss",
                    "https://dantri.com.vn/dien-dan.rss",
                    "https://dantri.com.vn/tuyen-sinh.rss",
                    "https://dantri.com.vn/blog.rss",
                    "https://dantri.com.vn/van-hoa.rss",
                    "https://dantri.com.vn/du-hoc.rss",
                    "https://dantri.com.vn/du-lich.rss",
                    "https://dantri.com.vn/doi-song.rss",
                    "https://dantri.com.vn/khoa-hoc-cong-nghe.rss",
                    "https://dantri.com.vn/sea-games-28.rss"
            };
            public static final String hai_tu_gio[]={
                    "https://www.24h.com.vn/upload/rss/trangchu24h.rss",
                    "https://www.24h.com.vn/upload/rss/tintuctrongngay.rss",
                    "https://www.24h.com.vn/upload/rss/bongda.rss",
                    "https://www.24h.com.vn/upload/rss/worldcup2018.rss",
                    "https://www.24h.com.vn/upload/rss/anninhhinhsu.rss",
                    "https://www.24h.com.vn/upload/rss/thoitrang.rss",
                    "https://www.24h.com.vn/upload/rss/thoitranghitech.rss",
                    "https://www.24h.com.vn/upload/rss/taichinhbatdongsan.rss",
                    "https://www.24h.com.vn/upload/rss/amthuc.rss",
                    "https://www.24h.com.vn/upload/rss/lamdep.rss",
                    "https://www.24h.com.vn/upload/rss/phim.rss",
                    "https://www.24h.com.vn/upload/rss/giaoducduhoc.rss",
                    "https://www.24h.com.vn/upload/rss/bantrecuocsong.rss",
                    "https://www.24h.com.vn/upload/rss/canhacmtv.rss",
                    "https://www.24h.com.vn/upload/rss/thethao.rss",
                    "https://www.24h.com.vn/upload/rss/phithuongkyquac.rss",
                    "https://www.24h.com.vn/upload/rss/congnghethongtin.rss",
                    "https://www.24h.com.vn/upload/rss/oto.rss",
                    "https://www.24h.com.vn/upload/rss/thitruongtieudung.rss",
                    "https://www.24h.com.vn/upload/rss/dulich24h.rss",
                    "https://www.24h.com.vn/upload/rss/suckhoedoisong.rss",
                    "https://www.24h.com.vn/upload/rss/cuoi24h.rss",
                    "https://www.24h.com.vn/upload/rss/tintucquocte.rss",
                    "https://www.24h.com.vn/upload/rss/doisongshowbiz.rss",
                    "https://www.24h.com.vn/upload/rss/giaitri.rss"
            };
            public static final String kenh_14[]={
                    "https://kenh14.vn/trang-chu.rss",
                    "https://kenh14.vn/tv-show.rss",
                    "https://kenh14.vn/cine.rss",
                    "https://kenh14.vn/musik.rss",
                    "https://kenh14.vn/fashion.rss",
                    "https://kenh14.vn/doi-song.rss",
                    "https://kenh14.vn/xa-hoi.rss",
                    "https://kenh14.vn/the-gioi.rss",
                    "https://kenh14.vn/tram-yeu.rss",
                    "https://kenh14.vn/la-cool.rss",
                    "https://kenh14.vn/hoc-duong.rss"
            };
            public static final String vietnam_net[]={
                    "http://vietnamnet.vn/rss/home.rss",
                    "http://vietnamnet.vn/rss/tin-moi-nong.rss",
                    "http://vietnamnet.vn/rss/tin-noi-bat.rss",
                    "http://vietnamnet.vn/rss/phap-luat.rss",
                    "http://vietnamnet.vn/rss/cong-nghe.rss",
                    "http://vietnamnet.vn/rss/kinh-doanh.rss",
                    "http://vietnamnet.vn/rss/giao-duc.rss",
                    "http://vietnamnet.vn/rss/giai-tri.rss",
                    "http://vietnamnet.vn/rss/suc-khoe.rss",
                    "http://vietnamnet.vn/rss/the-thao.rss",
                    "http://vietnamnet.vn/rss/doi-song.rss",
                    "http://vietnamnet.vn/rss/thoi-su.rss",
                    "http://vietnamnet.vn/rss/the-gioi.rss",
                    "http://vietnamnet.vn/rss/bat-dong-san.rss",
                    "http://vietnamnet.vn/rss/ban-doc.rss",
                    "http://vietnamnet.vn/rss/tuanvietnam.rss",
                    "http://vietnamnet.vn/rss/goc-nhin-thang.rss"
            };
            public static final String ngoi_sao[]={
                    "https://ngoisao.net/rss/hau-truong.rss",
                    "https://ngoisao.net/rss/ben-le.rss",
                    "https://ngoisao.net/rss/thoi-cuoc.rss",
                    "https://ngoisao.net/rss/phong-cach.rss",
                    "https://ngoisao.net/rss/thu-gian.rss",
                    "https://ngoisao.net/rss/cuoi-hoi.rss",
                    "https://ngoisao.net/rss/showbiz-viet.rss",
                    "https://ngoisao.net/rss/chau-a.rss",
                    "https://ngoisao.net/rss/hollywood.rss",
                    "https://ngoisao.net/rss/khoe-dep.rss",
                    "https://ngoisao.net/rss/24h.rss",
                    "https://ngoisao.net/rss/chuyen-la.rss",
                    "https://ngoisao.net/rss/hinh-su.rss",
                    "https://ngoisao.net/rss/thuong-truong.rss",
                    "https://ngoisao.net/rss/thoi-trang.rss",
                    "https://ngoisao.net/rss/lam-dep.rss",
                    "https://ngoisao.net/rss/trac-nghiem.rss",
                    "https://ngoisao.net/rss/an-choi.rss",
                    "https://ngoisao.net/rss/dan-choi.rss",
                    "https://ngoisao.net/rss/cuoi.rss",
                    "https://ngoisao.net/rss/game.rss",
                    "https://ngoisao.net/rss/choi-blog.rss",
                    "https://ngoisao.net/rss/thi-anh.rss",
                    "https://ngoisao.net/rss/miss.rss"
            };
            public static final String genk[]={
                    "http://gamek.vn/trang-chu.rss",
                    "http://gamek.vn/mmo.rss",
                    "http://gamek.vn/thi-truong.rss",
                    "http://gamek.vn/pc-console.rss",
                    "http://gamek.vn/esport.rss",
                    "http://gamek.vn/mobile-social.rss",
                    "http://gamek.vn/gaming-gear.rss",
                    "http://gamek.vn/manga-film.rss"
            };
        }
        public static final class title
        {
            public static final String zing_news[]={
                    "Tin mới ",
                    "Thời sự",
                    "Thế giới",
                    "Kinh doanh",
                    "Pháp luật",
                    "Xuất bản",
                    "Thể thao",
                    "Công nghệ",
                    "Ô tô – Xe máy",
                    "Giải trí",
                    "Âm nhạc",
                    "Phim ảnh",
                    "Thời trang",
                    "Sống trẻ",
                    "Giáo dục",
                    "Du lịch",
                    "Sức khoẻ"
            };
            public static final String vn_express[]={
                    "Tin mới",
                    "Thời sự",
                    "Thế giới",
                    "Kinh doanh",
                    "Start up",
                    "Giải trí",
                    "Thể thao",
                    "Pháp luật",
                    "Giáo dục",
                    "Sức khỏe",
                    "Gia đình",
                    "Du lịch",
                    "Khóa học",
                    "Số hóa",
                    "Xe",
                    "Cộng đồng",
                    "Tâm sự",
                    "Cười"
            };
            public static final String dan_tri[]={
                    "Trang chủ",
                    "Sức khỏe",
                    "Xã hội",
                    "Giải trí",
                    "Khuyến học",
                    "Thể thao",
                    "Thế giới",
                    "Kinh doanh",
                    "Xe",
                    "Sức mạnh số",
                    "Giới tính",
                    "Chuyện lạ",
                    "Việc làm",
                    "Nhịp sống trẻ",
                    "Nhân ái",
                    "Pháp luật",
                    "Bạn đọc",
                    "Diễn đạt",
                    "Tuyển sinh",
                    "Blog",
                    "Văn hóa",
                    "Du học",
                    "Du lịch",
                    "Đời sống",
                    "Khoa học",
                    "Sea game"
            };
            public static final String hai_tu_gio[]={
                    "Trang chủ",
                    "Trong ngày",
                    "Bóng đá",
                    "World cup",
                    "An ninh",
                    "Thời trang",
                    "Hi-tech",
                    "Tài chính",
                    "Ẩm thực",
                    "Làm đẹp",
                    "Phim",
                    "Giáo dục",
                    "Bạn trẻ",
                    "Ca nhạc",
                    "Thể thao",
                    "Phi thường",
                    "Công nghệ",
                    "Ô tô",
                    "Thị trường",
                    "Du lịch",
                    "Sức khỏe",
                    "Cười 24",
                    "Thế giới",
                    "Đời sống",
                    "Giải trí"
            };
            public static final String kenh_14[]={
                    "Trang chủ",
                    "TV Show",
                    "Cine",
                    "Musik",
                    "Fashion",
                    "Đời sống",
                    "Xã hội",
                    "Thế giới",
                    "Trạm yêu",
                    "Cool",
                    "Học đường"
            };
            public static final String vietnam_net[]={
                    "Trang chủ",
                    "Tin mới nóng",
                    "Tin nổi bật",
                    "Pháp luật",
                    "Công nghệ",
                    "Kinh doanh",
                    "Giáo dục",
                    "Giải trí",
                    "Sức khỏe",
                    "Thể thao",
                    "Đời sống",
                    "Thời sự",
                    "Thế giới",
                    "Bất động sản",
                    "Bạn đọc",
                    "Tuần việt nam",
                    "Góc nhìn thẳng"
            };
            public static final String ngoi_sao[]={
                    "Hậu trường",
                    "Bên lề",
                    "Thời cuộc",
                    "Phong cách",
                    "Thư giản",
                    "Cưới hỏi",
                    "Showbiz Việt",
                    "Châu Á",
                    "HollyWood",
                    "Khỏe đẹp",
                    "24h",
                    "Chuyện lạ",
                    "Hình sự",
                    "Thương trường",
                    "Thời trang",
                    "Làm đẹp",
                    "Trắc nghiệm",
                    "Ăn chơi",
                    "Dân chơi",
                    "Cười",
                    "Game",
                    "Blog",
                    "Thi ảnh",
                    "Miss"
            };
            public static final String genk[]={
                    "Trang chủ",
                    "MMO",
                    "Thị trường",
                    "PC Console",
                    "Esport",
                    "Mobile",
                    "Gaming Gear",
                    "Manga Film"
            };
        }
    }
}
