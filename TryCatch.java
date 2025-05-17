

public class TryCatch {
    public static void main(String[] args) {
//        checkAge(15);
        try {
            validate(-10); // Gây ra Exception
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
//    public static void checkAge (int Age){
//        if (Age < 18){
//            throw new IllegalArgumentException("Chua du tuoi");
//        }
//        System.out.println("Du tuoi");
//    }

    public static void validate(int number) throws Exception {
        if (number < 0) {
            throw new Exception("Số không được âm");
        }
        System.out.println("Số hợp lệ");
    }
}
