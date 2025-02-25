package model;

public class Student extends User{

    private String career;

    public Student(int id, String name, String lastname, String identification, String email, String birthdate, String career, boolean status) {
        super(id, name, lastname, identification, email, birthdate, status);
        this.career = career;
    }


    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
