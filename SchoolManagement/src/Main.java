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
                        System.out.println("Xoá học sinh thành công: ");
                        System.out.println(hsCanXoa);
                        }
                    }
                    
                    break;
                case 6:
                    System.out.println("Hiển thị danh sách giáo viên...");
                    // TODO: hiển thị danh sách giáo viên
                    break;
                case 7:
                    System.out.print("Nhập mã giáo viên cần xem: ");
                    String maGV = sc.nextLine();
                    System.out.println("Hiển thị thông tin chi tiết giáo viên: " + maGV);
                    // TODO: tìm và hiển thị giáo viên
                    break;
                case 8:
                    System.out.println("Tạo mới giáo viên...");
                    // TODO: tạo giáo viên mới
                    break;
                case 9:
                    System.out.println("Chỉnh sửa thông tin giáo viên...");
                    // TODO: chỉnh sửa thông tin giáo viên
                    break;
                case 10:
                    System.out.println("Xóa giáo viên...");
                    // TODO: xóa giáo viên
                    break;
                case 11:
                    System.out.println("Hiển thị danh sách môn học...");
                    // TODO: hiển thị danh sách môn học
                    break;
                case 12:
                    System.out.print("Nhập mã môn học cần xem: ");
                    String maMH = sc.nextLine();
                    System.out.println("Hiển thị thông tin chi tiết môn học: " + maMH);
                    // TODO: tìm và hiển thị môn học
                    break;
                case 13:
                    System.out.println("Tạo mới môn học...");
                    // TODO: tạo môn học mới
                    break;
                case 14:
                    System.out.println("Chỉnh sửa thông tin môn học...");
                    // TODO: chỉnh sửa môn học
                    break;
                case 15:
                    System.out.println("Xóa môn học...");
                    // TODO: xóa môn học
                    break;
                case 16:
                    System.out.println("Thêm giáo viên vào môn học...");
                    // TODO: thêm giáo viên vào môn
                    break;
                case 17:
                    System.out.println("Thêm học sinh vào môn học...");
                    // TODO: thêm nhiều học sinh vào môn
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