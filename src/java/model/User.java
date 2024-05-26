/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class User {
    private int id;
    private String email;
    private String password;
    private String address;
    private String phone;

    public User(int id, String email, String password, String address, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public User(String email, String password, String address, String phone) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", address=" + address + ", phone=" + phone + '}';
    }
    
}
