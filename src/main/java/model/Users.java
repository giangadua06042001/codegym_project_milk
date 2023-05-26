package model;

public class Users {
    private String id;
    private String userName;
    private String password;
    private String fullName;
    private String address;
    private String u_id;
    private String citizenIdentification;

    public Users(String id, String userName, String password, String fullName, String address, String u_id, String citizenIdentification) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.u_id = u_id;
        this.citizenIdentification = citizenIdentification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getCitizenIdentification() {
        return citizenIdentification;
    }

    public void setCitizenIdentification(String citizenIdentification) {
        this.citizenIdentification = citizenIdentification;
    }
}
