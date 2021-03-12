package ru.stqa.pft.addressbook;

public class PhonesData {
    private final String homenumber;
    private final String mobile;
    private final String worknumber;
    private final String fax;

    public PhonesData(String homenumber, String mobile, String worknumber, String fax) {
        this.homenumber = homenumber;
        this.mobile = mobile;
        this.worknumber = worknumber;
        this.fax = fax;
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
}
