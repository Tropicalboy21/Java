package model;

public class Profesor extends User {

    private String department;

    public Profesor(int id, String name, String lastname, String identification, String email, String birthdate, String department, boolean status){
        super(id, name, lastname, identification, email, birthdate, status);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
