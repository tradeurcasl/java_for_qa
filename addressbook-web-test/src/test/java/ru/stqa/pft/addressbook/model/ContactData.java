package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String homenumber;
    private final String mobile;
    private final String worknumber;
    private final String fax;
    private final String email;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String aday;
    private final String address2;
    private final String phone2;
    private final String notes;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homenumber, String mobile, String worknumber, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String address2, String phone2, String notes) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homenumber = homenumber;
        this.mobile = mobile;
        this.worknumber = worknumber;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getMiddlename() {
        return middlename;
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
    public String getCompany() {
        return company;
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
    public String getWorknumber() {
        return worknumber;
    }
    public String getFax() {
        return fax;
    }
    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
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

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }


    public String getNotes() {
        return notes;
    }
}

