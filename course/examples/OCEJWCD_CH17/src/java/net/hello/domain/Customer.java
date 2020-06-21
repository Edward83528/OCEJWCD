package net.hello.domain;

public class Customer implements java.io.Serializable {
    
    private String name;
    private String address;
    private String phone;
    private boolean notify;

    public Customer() {
    }

    public Customer(String name, String address, String phone, boolean notify) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.notify = notify;
    }
    
    public String getInfo() {
        return name + ", " + phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }
    
}
