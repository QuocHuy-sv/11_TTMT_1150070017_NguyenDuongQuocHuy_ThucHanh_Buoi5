package com.example.nguyenduongquochuylab3.data;

import com.example.nguyenduongquochuylab3.R;
import java.util.*;

public class DataProvider {

    public static List<Category> getCategories() {
        List<Category> out = new ArrayList<>();
        out.add(new Category(1, "Con gái", R.drawable.ic_cat_girl));
        out.add(new Category(2, "Công sở", R.drawable.ic_cat_work));
        out.add(new Category(3, "Cực hài", R.drawable.ic_cat_fun));
        out.add(new Category(4, "Dân gian", R.drawable.ic_cat_folk));
        out.add(new Category(5, "Gia đình", R.drawable.ic_cat_family));
        out.add(new Category(6, "Giao thông", R.drawable.ic_cat_transport));
        out.add(new Category(7, "Học sinh", R.drawable.ic_cat_student));
        return out;
    }

    public static List<Joke> getJokes(int catId) {
        // Demo data – mỗi danh mục 10 truyện ngắn
        List<Joke> list = new ArrayList<>();
        switch (catId) {
            case 1: // Con gái
                list.add(new Joke("Việc học", "Lúc bé, một học trò kể chuyện:\nLớn lên mới biết, chuyện là do mẹ.\nLúc bé: thích được mẹ dẫn tới trường.\nLớn lên: thích mẹ đứng ngoài cổng.\nBiết chữ rồi: thích nghỉ học...\nLớn lên nữa: biết đi làm mới nhớ..."));
                list.add(new Joke("Đã lớn rồi", "Cô gái bảo mẹ: Con lớn rồi. Mẹ: Ừ, lớn thì rửa chén giùm mẹ nhé! – Con vẫn còn nhỏ mà mẹ!"));
                list.add(new Joke("Cũng như nhau", "Bạn gái hỏi: Anh thích em vì điều gì? – Vì em xinh. – Nếu em xấu thì? – Thì cũng như nhau thôi, vì khi yêu sẽ thấy xinh!"));
                list.add(new Joke("Rất lạnh", "Trời lạnh. Cô: Anh ôm em cho ấm. Anh: Ở gần tim anh luôn ấm!"));
                list.add(new Joke("Im lặng là vàng", "Cãi nhau mệt, cô nói: Im lặng là vàng. Chàng: Anh đang giữ vàng đây!"));
                list.add(new Joke("Bài học vỡ lòng", "Cô dạy bé: Con gái là phải dịu dàng. Bé trai: Thế con trai là phải nhường!"));
                list.add(new Joke("Chưa chà chứ đau", "Cô than: Vết thương lòng chưa chà đã đau. Anh: Để anh chà nhẹ..."));
                list.add(new Joke("1 xu và 1 phút", "Một xu và một phút – cái nào dài hơn? Đáp: Một phút vì trong ví hết xu nhưng thời gian vẫn còn!"));
                list.add(new Joke("Sao con chưa thả?", "Mẹ: Áo mới đẹp không? Con: Đẹp! – Sao con chưa thả tim? Con: Ở ngoài đời con thả nụ cười!"));
                list.add(new Joke("Cảm giác", "Cảm giác ăn hết nồi bánh chưng là thấy Tết đến rồi!"));
                break;

            case 2: // Công sở
                list.add(new Joke("Báo cáo ngắn gọn", "Sếp: Báo cáo phải ngắn. Nhân viên: Dạ, công việc: nhiều. Kết quả: đang làm."));
                list.add(new Joke("Đi trễ", "Hỏi: Sao anh đi trễ? – Vì em đồng hồ nhanh! – Đồng hồ nhanh sao trễ? – Em ngủ nướng!"));
                list.add(new Joke("Họp online", "Camera tắt, mic tắt. Sếp: Còn ai ở đó không? – Dạ có em và... con mèo!"));
                list.add(new Joke("Deadline", "Deadline như chiếc xe bus, trễ một lần là muốn bám đuôi cả tháng."));
                list.add(new Joke("Email", "Gửi nhầm email cho sếp, tốc độ tắt wifi đạt chuẩn Olympic."));
                list.add(new Joke("Cà phê công sở", "Họp 9 giờ, 9 rưỡi mới xong pha cà phê."));
                list.add(new Joke("Làm từ xa", "Làm từ xa: xa bàn làm việc nhất có thể."));
                list.add(new Joke("Sinh nhật", "Sinh nhật phòng ban: ăn bánh nhiều hơn kế hoạch."));
                list.add(new Joke("Văn hoá thumbs-up", "Reply ‘👍’ là đã hoàn thành 80% nhiệm vụ giao tiếp."));
                list.add(new Joke("Xin nghỉ", "Lý do xin nghỉ: trời mưa – kẹt trong chiếc chăn."));
                break;

            case 3: // Cực hài
                for (int i = 1; i <= 10; i++)
                    list.add(new Joke("Câu chuyện cười " + i, "Một ngày đẹp trời... và chiếc bụng cười lăn."));
                break;

            case 4: // Dân gian
                list.add(new Joke("Thần đèn", "Ước gì? – Ước thêm ước nữa!"));
                list.add(new Joke("Cây khế", "Ăn khế trả vàng, trả vàng trả lại nụ cười."));
                // … thêm vài câu
                for (int i=3;i<=10;i++) list.add(new Joke("Giai thoại dân gian " + i, "Kể chuyện xưa mà mới."));
                break;

            case 5: // Gia đình
                list.add(new Joke("Cơm nhà", "Ba: Cơm ngon không? Con: Con chỉ thấy ngon khi mẹ nấu ạ!"));
                for (int i=2;i<=10;i++) list.add(new Joke("Chuyện nhà " + i, "Nhà là nơi cười nhiều nhất."));
                break;

            case 6: // Giao thông
                for (int i=1;i<=10;i++) list.add(new Joke("Chuyện đường " + i, "Kẹt xe nhưng không kẹt tiếng cười."));
                break;

            case 7: // Học sinh
                list.add(new Joke("Kiểm tra miệng", "Cô: Em thuộc bài chưa? – Dạ thuộc ạ, nhưng ở nhà."));
                list.add(new Joke("Nghỉ học", "Trời mưa to, học sinh: Chúng em học cách chống nước!"));
                for (int i=3;i<=10;i++) list.add(new Joke("Chuyện lớp " + i, "Nhất quỷ, nhì ma, thứ ba học trò."));
                break;
        }
        return list;
    }
}
