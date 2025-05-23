import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private static int numcode = 1;
    private String nameTeacher;
    private String codeTeacher;
    private String gender;
    private LocalDate birthDay;
    private int experienceYear;
    private List<String> major;
    private List<String> level;

    public Teacher(String nameTeacher, String gender, LocalDate birthDay, int experienceYear) {
        this.nameTeacher = nameTeacher;
        this.gender = gender;
        this.birthDay = birthDay;
        this.experienceYear = experienceYear;
        this.major = new ArrayList<>();
        this.level = new ArrayList<>();
        this.codeTeacher = generateCodeTeacher();
    }
    private String generateCodeTeacher(){
        return String.format("TC%05d", numcode++);
    }

    public void addMajor(String mj){
        this.major.add(mj);
    }
    public void addLevel(String lv){
        this.level.add(lv);
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(String codeTeacher) {
        this.codeTeacher = codeTeacher;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public List<String> getMajor() {
        return major;
    }

    public void setMajor(List<String> major) {
        this.major = major;
    }

    public List<String> getLevel() {
        return level;
    }

    public void setLevel(List<String> level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "nameTeacher='" + nameTeacher + '\'' +
                ", codeTeacher='" + codeTeacher + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDay=" + birthDay +
                ", experienceYear=" + experienceYear +
                ", major=" + major +
                ", level=" + level +
                '}';
    }
}
