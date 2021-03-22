package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String address;
    private final String homenumber;
    private final String mobile;
    private final String email;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String aday;
    private final String notes;
    private final String group;

    public ContactData(String firstname, String lastname, String nickname, String title, String address, String homenumber, String mobile, String email, String homepage, String bday, String bmonth, String byear, String aday, String group, String notes) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.address = address;
        this.homenumber = homenumber;
        this.mobile = mobile;
        this.email = email;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.notes = notes;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAday() {
        return aday;
    }

    public String getNotes() {
        return notes;
    }

    public String getGroup() {
        return group;
    }
}

