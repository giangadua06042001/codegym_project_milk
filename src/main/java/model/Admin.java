package model;

public class Admin {private String id;
    private String name;
    private String password;
    private String fullName;
    private String address;
    private String u_id;

    public Admin(String id, String name, String password, String fullName, String address, String u_id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.u_id = u_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
