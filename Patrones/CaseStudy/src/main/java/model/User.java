package model;

public class User {
    protected int id;
    protected String name;
    protected String lastname;
    protected String identification;
    protected String email;
    protected String birthdate;
    protected boolean status;

    public User(int id, String name, String lastname, String identification, String email, String birthdate, boolean status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.email = email;
        this.birthdate = birthdate;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname; }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

}
