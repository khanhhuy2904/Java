import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyen Van A", "Nam", LocalDate.of(2003, 5, 21), "CNTT"));
        students.add(new Student("Tran Thi B", "Nữ", LocalDate.of(2004, 8, 15), "Kinh tế"));
        students.add(new Student("Nguyen Van C", "Nam", LocalDate.of(2002, 1, 10), "Toán"));
        students.add(new Student("Le Thi D", "Nữ", LocalDate.of(2003, 3, 12), "Văn"));
        students.add(new Student("Pham Van E", "Nam", LocalDate.of(2004, 4, 22), "Hóa"));
        students.add(new Student("Hoang Thi F", "Nữ", LocalDate.of(2005, 6, 30), "Lý"));
        students.add(new Student("Tran Van G", "Nam", LocalDate.of(2002, 7, 18), "Sinh"));
        students.add(new Student("Nguyen Thi H", "Nữ", LocalDate.of(2003, 8, 25), "GDCD"));
        students.add(new Student("Le Van I", "Nam", LocalDate.of(2004, 9, 5), "Tin học"));
        students.add(new Student("Pham Thi J", "Nữ", LocalDate.of(2005, 10, 14), "Kinh tế"));
        students.add(new Student("Hoang Van K", "Nam", LocalDate.of(2002, 11, 20), "Ngoại ngữ"));
        students.add(new Student("Tran Thi L", "Nữ", LocalDate.of(2004, 12, 28), "Quản trị"));

        List<Teacher> teachers = new ArrayList<>();
        Teacher gv1 = new Teacher("Nguyen Thi A", "Nữ", LocalDate.of(1980, 5, 10), 15);
        gv1.addMajor("Công nghệ thông tin");
        gv1.addMajor("Khoa học dữ liệu");
        gv1.addLevel("Tiến sĩ");
        gv1.addLevel("Phó giáo sư");
        teachers.add(gv1);

        Teacher gv2 = new Teacher("Nguyen Thi B", "Nữ", LocalDate.of(1990, 9, 10), 15);
        gv2.addMajor("Toán");
        gv2.addMajor("Sử");
        gv2.addLevel("Thạc sĩ");
        gv2.addLevel("Giáo sư");
        teachers.add(gv2);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Lập trình Java", 50, 3));
        subjects.add(new Subject("Cơ sở dữ liệu", 60, 4));
        subjects.add(new Subject("Giới thiệu lập trình", 40, 2));
        subjects.add(new Subject("Hệ điều hành", 50, 4));
        subjects.add(new Subject("Mạng máy tính", 45, 3));
        subjects.add(new Subject("Phân tích thiết kế hệ thống", 55, 3));
        subjects.add(new Subject("Khoa học dữ liệu", 40, 3));
        subjects.add(new Subject("Trí tuệ nhân tạo", 50, 4));
        subjects.add(new Subject("Kiểm thử phần mềm", 35, 3));
        subjects.add(new Subject("Quản lý dự án", 60, 4));
        subjects.add(new Subject("Lập trình web", 50, 3));
        subjects.add(new Subject("Lập trình di động", 45, 3));


        while (running) {
            System.out.println("=== Quản lý môn học ===");
            System.out.println("1. Danh sách học sinh");
            System.out.println("2. Xem thông tin chi tiết học sinh");
            System.out.println("3. Tạo mới học sinh");
            System.out.println("4. Chỉnh sửa thông tin học sinh");
            System.out.println("5. Xóa học sinh");
            System.out.println("6. Danh sách giáo viên");
            System.out.println("7. Xem thông tin chi tiết giáo viên");
            System.out.println("8. Tạo mới giáo viên");
            System.out.println("9. Chỉnh sửa thông tin giáo viên");
            System.out.println("10. Xóa giáo viên");
            System.out.println("11. Danh sách môn học");
            System.out.println("12. Xem thông tin chi tiết môn học");
            System.out.println("13. Tạo mới môn học");
            System.out.println("14. Chỉnh sửa thông tin môn học");
            System.out.println("15. Xóa môn học");
            System.out.println("16. Thêm giáo viên vào môn học");
            System.out.println("17. Thêm sinh viên vào môn học");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");


            int choose = sc.nextInt();
            sc.nextLine(); // bỏ qua dòng newline sau khi nhập số

            switch (choose){
                case 1:
                    if(students.isEmpty()){
                        System.out.println("Danh sách học sinh trống.");
                    }else {
                        System.out.println("=== Danh sách học sinh ===");
                        for (Student s: students){
                            System.out.println(s);
                        }
                    }

                    break;
                case 2:
                    System.out.print("Nhập mã học sinh cần xem: ");
                    String codeStudent = sc.nextLine();
                    boolean found = false;

                    for(Student s: students){
                        if (s.getCodeStudent().equalsIgnoreCase(codeStudent)){//không phân biệt chữ hoa, thường
                            System.out.println("Thông tin chi tiết học sinh");
                            System.out.println(s);
                            found = true;
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Không tìm thấy học sinh với mã: " + codeStudent);
                    }
                    break;
                case 3:
                    System.out.println("Tạo mới học sinh");

                    System.out.print("Tên học sinh: ");
                    String tenHS = sc.nextLine();

                    System.out.print("Giới tính: ");
                    String gtHS = sc.nextLine();

                    System.out.print("Ngày sinh (định dạng yyyy-mm-dd): ");
                    String ngaySinhStr = sc.nextLine();
                    LocalDate ngaySinhHS;
                    try{
                        ngaySinhHS = LocalDate.parse(ngaySinhStr);
                    }catch (Exception e){
                        System.out.println("Ngày sinh không hợp lệ. Huỷ tạo học sinh.");
                        break;
                    }

                    System.out.print("Nhập chuyên ngành: ");
                    String chuenNganh = sc.nextLine();

                    Student newStudent = new Student(tenHS, gtHS, ngaySinhHS, chuenNganh);
                    students.add(newStudent);

                    System.out.println("Đã tạo học sinh thành công:");
                    System.out.println(newStudent);

                    break;
                case 4:
                    System.out.print("Nhập mã học sinh muốn sửa: ");
                    String codeSua = sc.nextLine();

                    Student hsCanSua = null;
                    for (Student s : students) {
                        if(s.getCodeStudent().equalsIgnoreCase(codeSua)){
                            hsCanSua = s;
                            break;
                        }
                    }
                    if(hsCanSua == null){
                        System.out.println("Không tìm thấy học sinh với mã: " + codeSua);
                        break;
                    }

                    System.out.println("Nhập thông tin mới cho học sinh (bỏ trống nếu không muốn đổi):");
                    System.out.print("Tên học sinh: ");
                    String tenMoi = sc.nextLine();
                    if(!tenMoi.isEmpty()){
                        hsCanSua.setNameStudent(tenMoi);
                    }

                    System.out.print("Giới tính: ");
                    String gtMoi = sc.nextLine();
                    if(!gtMoi.isEmpty()){
                        hsCanSua.setGender(gtMoi);
                    }

                    System.out.print("Ngay sinh (định dạng yyyy-mm-dd): ");
                    String ngaySinhMoiStr = sc.nextLine();
                    if (!ngaySinhMoiStr.isEmpty()) {
                        try {
                            LocalDate ngaySinhMoi = LocalDate.parse(ngaySinhMoiStr);
                            hsCanSua.setBirthDay(ngaySinhMoi);
                        } catch (Exception e) {
                            System.out.println("Ngày sinh không hợp lệ. Giữ nguyên ngày cũ.");
                        }
                    }

                    System.out.print("Chuyên ngành: ");
                    String chuyenNganhMoi = sc.nextLine();
                    if(!chuyenNganhMoi.isEmpty()){
                        hsCanSua.setMajor(chuyenNganhMoi);
                    }

                    System.out.println("Cập nhật học sinh thành công!");
                    System.out.println(hsCanSua);

                    break;
                case 5:
                    System.out.println("Nhập mã học sinh cần xoá: ");
                    String maCanXoa = sc.nextLine();
                    Student hsCanXoa = null;

                    for (Student s : students) {
                        if(s.getCodeStudent().equalsIgnoreCase(maCanXoa)){
                            hsCanXoa = s;
                            break;
                        }
                    }
                    if(hsCanXoa == null){
                        System.out.println("Không tìm thấy học sinh với mã: " + maCanXoa);
                    }else {
                        System.out.println("Bạn có chắc muốn xoá học sinh: " + hsCanXoa + "  Yes/No");
                        String luaChon = sc.nextLine();
                        if(luaChon.equalsIgnoreCase("Yes"))
                        {
                            students.remove(hsCanXoa);
                            System.out.println("Xoá học sinh thành công!");
                        }
                    }
                    
                    break;
                case 6:
                    if (teachers.isEmpty()) {
                        System.out.println("Danh sách giáo viên trống.");
                    } else {
                        System.out.println("=== Danh sách giáo viên ===");
                        for (Teacher t : teachers) {
                            System.out.println(t);
                        }
                    }
                    break;
                case 7:
                    System.out.print("Nhập mã giáo viên cần xem: ");
                    String maGV = sc.nextLine();
                    boolean foundt = false;

                    for(Teacher s: teachers){
                        if (s.getCodeTeacher().equalsIgnoreCase(maGV)){//không phân biệt chữ hoa, thường
                            System.out.println("Thông tin chi tiết giáo viên");
                            System.out.println(s);
                            foundt = true;
                            break;
                        }
                    }
                    if (!foundt){
                        System.out.println("Không tìm thấy giáo viên với mã: " + maGV);
                    }
                    break;
                case 8:
                    System.out.println("Tạo mới giáo viên");


                    System.out.print("Tên giáo viên: ");
                    String tenGV = sc.nextLine();

                    System.out.print("Giới tính: ");
                    String gtGV = sc.nextLine();

                    System.out.print("Ngày sinh (định dạng yyyy-mm-dd): ");
                    String ngaySinhStrGV = sc.nextLine();
                    LocalDate ngaySinhGV;
                    try{
                        ngaySinhGV = LocalDate.parse(ngaySinhStrGV);
                    }catch (Exception e){
                        System.out.println("Ngày sinh không hợp lệ. Huỷ tạo giáo viên.");
                        break;
                    }

                    System.out.print("Kinh nghiệm: ");
                    int namKinhNghiemGV;
                    try {
                        namKinhNghiemGV = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Dữ liệu không hợp lệ. Hủy tạo giáo viên.");
                        break;
                    }



                    Teacher newTeacher = new Teacher(tenGV, gtGV, ngaySinhGV, namKinhNghiemGV);
                    System.out.println("Nhập các chuyên ngành (gõ 'x' để dừng):");
                    while (true) {
                        System.out.print("→ Nhập chuyên ngành: ");
                        String chuyenNganh = sc.nextLine();
                        if (chuyenNganh.equalsIgnoreCase("x")) break;
                        newTeacher.addMajor(chuyenNganh);
                    }


                    System.out.println("Nhập các cấp bậc (gõ 'x' để dừng):");
                    while (true) {
                        System.out.print("→ Nhập cấp bậc: ");
                        String capBac = sc.nextLine();
                        if (capBac.equalsIgnoreCase("x")) break;
                        newTeacher.addLevel(capBac);
                    }
                    teachers.add(newTeacher);

                    System.out.println("Đã tạo giáo viên thành công:");
                    System.out.println(newTeacher);

                    break;
                case 9:
                    System.out.println("=== Chỉnh sửa thông tin giáo viên ===");
                    System.out.print("Nhập mã giáo viên cần chỉnh sửa: ");
                    String maGVCu = sc.nextLine();
                    Teacher gvCanSua = null;
                    for (Teacher t : teachers) {
                        if (t.getCodeTeacher().equalsIgnoreCase(maGVCu)) {
                            gvCanSua = t;
                            break;
                        }
                    }
                    if (gvCanSua == null) {
                        System.out.println("Không tìm thấy giáo viên với mã: " + maGVCu);
                        break;
                    }

                    System.out.println("Nhập thông tin mới (bỏ trống để giữ nguyên):");

                    System.out.print("Tên giáo viên: ");
                    String tenGVMoi = sc.nextLine();
                    if (!tenGVMoi.isEmpty()) gvCanSua.setNameTeacher(tenGVMoi);

                    System.out.print("Giới tính: ");
                    String gtGVMoi = sc.nextLine();
                    if (!gtGVMoi.isEmpty()) gvCanSua.setGender(gtGVMoi);

                    System.out.print("Ngày sinh [yyyy-MM-dd]: ");
                    String ngaySinhMoiStrGV = sc.nextLine();
                    if (!ngaySinhMoiStrGV.isEmpty()) {
                        try {
                            LocalDate ngaySinhMoi = LocalDate.parse(ngaySinhMoiStrGV);
                            gvCanSua.setBirthDay(ngaySinhMoi);
                        } catch (Exception e) {
                            System.out.println("Ngày sinh không hợp lệ. Giữ nguyên ngày cũ.");
                        }
                    }

                    System.out.print("Số năm kinh nghiệm: ");
                    String expStr = sc.nextLine();
                    if (!expStr.isEmpty()) {
                        try {
                            int exp = Integer.parseInt(expStr);
                            gvCanSua.setExperienceYear(exp);
                        } catch (Exception e) {
                            System.out.println("Số năm kinh nghiệm không hợp lệ. Giữ nguyên.");
                        }
                    }

                    System.out.println("Cập nhật chuyên ngành (gõ 'x' để dừng):");
                    gvCanSua.getMajor().clear(); // xoá danh sách cũ
                    while (true) {
                        System.out.print("→ Nhập chuyên ngành: ");
                        String cn = sc.nextLine();
                        if (cn.equalsIgnoreCase("x")) break;
                        gvCanSua.addMajor(cn);
                    }

                    // Nhập lại danh sách cấp bậc
                    System.out.println("Cập nhật cấp bậc (gõ 'x' để dừng):");
                    gvCanSua.getLevel().clear();
                    while (true) {
                        System.out.print("→ Nhập cấp bậc: ");
                        String cb = sc.nextLine();
                        if (cb.equalsIgnoreCase("x")) break;
                        gvCanSua.addLevel(cb);
                    }
                    System.out.println("Đã cập nhật thông tin giáo viên:");
                    System.out.println(gvCanSua);

                    break;
                case 10:
                    System.out.println("=== Xoá giáo viên ===");
                    System.out.print("Nhập mã giáo viên cần xoá: ");
                    String maGVCanXoa = sc.nextLine();

                    Teacher gvCanXoa = null;
                    for (Teacher t : teachers) {
                        if (t.getCodeTeacher().equalsIgnoreCase(maGVCanXoa)) {
                            gvCanXoa = t;
                            break;
                        }
                    }

                    if (gvCanXoa == null) {
                        System.out.println("Không tìm thấy giáo viên với mã: " + maGVCanXoa);
                    } else {

                        System.out.println("Bạn có chắc muốn xoá giáo viên: " + gvCanXoa + "  Yes/No");
                        String luaChon = sc.nextLine();
                        if(luaChon.equalsIgnoreCase("Yes"))
                        {
                            teachers.remove(gvCanXoa);
                            System.out.println("Xoá giáo viên thành công!");
                        }
                    }
                    break;
                case 11:
                    System.out.println("=== Danh sách môn học ===");
                    if (subjects.isEmpty()) {
                        System.out.println("Chưa có môn học nào trong danh sách.");
                    } else {
                        for (Subject subject : subjects) {
                            System.out.println(subject.getCodeSubject() + " - " + subject.getNameSubject()
                                    + " | Tín chỉ: " + subject.getCredit()
                                    + " | Số lượng tối đa: " + subject.getMaxStudent());
                        }
                    }

                    break;
                case 12:
                    System.out.println("=== Xem thông tin chi tiết môn học ===");
                    System.out.print("Nhập mã môn học cần xem: ");
                    String maMH = sc.nextLine();

                    boolean foundm = false;
                    for (Subject subject : subjects) {
                        if (subject.getCodeSubject().equalsIgnoreCase(maMH)) {
                            System.out.println("Thông tin chi tiết môn học:");
                            System.out.println("Mã môn: " + subject.getCodeSubject());
                            System.out.println("Tên môn: " + subject.getNameSubject());
                            System.out.println("Số tín chỉ: " + subject.getCredit());
                            System.out.println("Số lượng sinh viên tối đa: " + subject.getMaxStudent());
                            foundm = true;
                            break;
                        }
                    }

                    if (!foundm) {
                        System.out.println("Không tìm thấy môn học với mã: " + maMH);
                    }
                    break;
                case 13:
                    System.out.println("=== Tạo mới môn học ===");

                    System.out.print("Tên môn học: ");
                    String tenMon = sc.nextLine();

                    System.out.print("Số tín chỉ: ");
                    int soTinChi;
                    try {
                        soTinChi = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Số tín chỉ không hợp lệ. Hủy tạo môn học.");
                        break;
                    }

                    System.out.print("Số lượng sinh viên tối đa: ");
                    int soLuongToiDa;
                    try {
                        soLuongToiDa = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Số lượng sinh viên không hợp lệ. Hủy tạo môn học.");
                        break;
                    }

                    Subject newSubject = new Subject(tenMon, soLuongToiDa, soTinChi);
                    subjects.add(newSubject);

                    System.out.println("Đã tạo môn học thành công:");
                    System.out.println(newSubject);
                    break;
                case 14:
                    System.out.println("=== Chỉnh sửa thông tin môn học ===");
                    System.out.print("Nhập mã môn học cần chỉnh sửa: ");
                    String maMonCanSua = sc.nextLine();

                    Subject monHocCanSua = null;
                    for (Subject subject : subjects) {
                        if (subject.getCodeSubject().equalsIgnoreCase(maMonCanSua)) {
                            monHocCanSua = subject;
                            break;
                        }
                    }


                    if (monHocCanSua == null) {
                        System.out.println("Không tìm thấy môn học với mã: " + maMonCanSua);
                        break;
                    }
                    if (monHocCanSua.getTeacher() != null && !monHocCanSua.getStudentList().isEmpty()) {
                        System.out.println("Không thể sửa môn học vì đã có giáo viên hoặc học sinh.");
                        break;
                    }

                    System.out.println("Nhập thông tin mới (bỏ trống để giữ nguyên):");

                    System.out.print("Tên môn học: ");
                    String tenMoiMH = sc.nextLine();
                    if (!tenMoiMH.isEmpty()) monHocCanSua.setNameSubject(tenMoiMH);

                    System.out.print("Số tín chỉ: ");
                    String tinChiStr = sc.nextLine();
                    if (!tinChiStr.isEmpty()) {
                        try {
                            int tinChi = Integer.parseInt(tinChiStr);
                            monHocCanSua.setCredit(tinChi);
                        } catch (Exception e) {
                            System.out.println("Số tín chỉ không hợp lệ. Giữ nguyên.");
                        }
                    }

                    System.out.print("Số lượng sinh viên tối đa: ");
                    String soLuongStr = sc.nextLine();
                    if (!soLuongStr.isEmpty()) {
                        try {
                            int soLuong = Integer.parseInt(soLuongStr);
                            monHocCanSua.setMaxStudent(soLuong);
                        } catch (Exception e) {
                            System.out.println("Số lượng sinh viên không hợp lệ. Giữ nguyên.");
                        }
                    }

                    System.out.println("Đã cập nhật thông tin môn học:");
                    System.out.println("Mã môn: " + monHocCanSua.getCodeSubject());
                    System.out.println("Tên môn: " + monHocCanSua.getNameSubject());
                    System.out.println("Số tín chỉ: " + monHocCanSua.getCredit());
                    System.out.println("Số lượng tối đa: " + monHocCanSua.getMaxStudent());
                    break;
                case 15:
                    System.out.println("=== Xoá môn học ===");
                    System.out.print("Nhập mã môn học cần xoá: ");
                    String maMonCanXoa = sc.nextLine();


                    Subject monHocCanXoa = null;
                    for (Subject subject : subjects) {
                        if (subject.getCodeSubject().equalsIgnoreCase(maMonCanXoa)) {
                            monHocCanXoa = subject;
                            break;
                        }
                    }



                    if (monHocCanXoa == null) {
                        System.out.println("Không tìm thấy môn học với mã: " + maMonCanXoa);
                    }
                    if (monHocCanXoa.getTeacher() != null && !monHocCanXoa.getStudentList().isEmpty()) {
                    System.out.println("Không thể xóa môn học vì đã có giáo viên hoặc học sinh.");
                    break;
                    } else {
                        System.out.print("Bạn có chắc muốn xoá môn học: " + monHocCanXoa + " (Yes/No)");
                        String luachon = sc.nextLine();
                        if(luachon.equalsIgnoreCase("Yes")){
                            subjects.remove(monHocCanXoa);
                            System.out.println("Đã xoá môn học thành công:");
                            System.out.println("Mã môn: " + monHocCanXoa.getCodeSubject());
                            System.out.println("Tên môn: " + monHocCanXoa.getNameSubject());
                        }
                    }
                    break;
                case 16:
                    System.out.println("=== Thêm giáo viên vào môn học ===");

                    System.out.print("Nhập mã môn học: ");
                    String maMon = sc.nextLine();

                    Subject monHoc = null;
                    for (Subject s : subjects) {
                        if (s.getCodeSubject().equalsIgnoreCase(maMon)) {
                            monHoc = s;
                            break;
                        }
                    }

                    if (monHoc == null) {
                        System.out.println("Không tìm thấy môn học với mã: " + maMon);
                        break;
                    }

                    if (monHoc.getTeacher() != null) {
                        System.out.println("Môn học này đã có giáo viên: " + monHoc.getTeacher().getNameTeacher());
                        break;
                    }

                    System.out.print("Nhập mã giáo viên cần thêm: ");
                    String maGV16 = sc.nextLine();

                    Teacher giaoVien = null;
                    for (Teacher t : teachers) {
                        if (t.getCodeTeacher().equalsIgnoreCase(maGV16)) {
                            giaoVien = t;
                            break;
                        }
                    }

                    if (giaoVien == null) {
                        System.out.println(" Không tìm thấy giáo viên với mã: " + maGV16);
                        break;
                    }

                    //Đếm số môn mà giáo viên đang dạy
                    int soMonDangDay = 0;
                    for(Subject s : subjects ){
                        if(s.getTeacher().getNameTeacher().equalsIgnoreCase(giaoVien.getNameTeacher())){
                            soMonDangDay++;
                        }
                    }

                    if (soMonDangDay >= 3) {
                        System.out.println("Giáo viên này đã dạy đủ 3 môn học.");
                        break;
                    }


                    monHoc.setTeacher(giaoVien);
                    System.out.println("Đã thêm giáo viên thành công:");
                    System.out.println("→ Môn học: " + monHoc.getNameSubject());
                    System.out.println("→ Giáo viên: " + giaoVien.getNameTeacher());
                    break;

                case 17:
                    System.out.println("=== Thêm học sinh vào môn học ===");
                    System.out.print("Nhập mã môn học: ");
                    String maMon17 = sc.nextLine();

                    // Tìm môn học theo mã
                    Subject monHoc17 = null;
                    for (Subject subject : subjects) {
                        if (subject.getCodeSubject().equalsIgnoreCase(maMon17)) {
                            monHoc17 = subject;
                            break;
                        }
                    }

                    if (monHoc17 == null) {
                        System.out.println("Không tìm thấy môn học với mã: " + maMon17);
                        break;
                    }

                    // Kiểm tra số lượng học sinh tối đa
                    if (monHoc17.getStudentList().size() >= monHoc17.getMaxStudent()) {
                        System.out.println("Môn học đã đủ số lượng học sinh.");
                        break;
                    }

                    System.out.print("Nhập mã học sinh để thêm (gõ 'x' để dừng): ");
                    while (true) {
                        String maHS = sc.nextLine();
                        if (maHS.equalsIgnoreCase("x")) break;

                        // Tìm học sinh theo mã
                        Student student = null;
                        for (Student s : students) {
                            if (s.getCodeStudent().equalsIgnoreCase(maHS)) {
                                student = s;
                                break;
                            }
                        }

                        if (student == null) {
                            System.out.println("Không tìm thấy học sinh với mã: " + maHS);
                            continue;
                        }


//                        // Kiểm tra tổng số tín chỉ của sinh viên
//                        int totalCredits = student.getCredits(); // Giả sử bạn đã có phương thức này
//                        if (totalCredits + monHoc.getCredit() > 20) {
//                            System.out.println("Học sinh sẽ vượt quá 20 tín chỉ.");
//                            continue;
//                        }

                        // Thêm học sinh vào môn học
                        monHoc17.addStudent(student);
                        System.out.println("Đã thêm học sinh: " + student.getNameStudent());
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }
}