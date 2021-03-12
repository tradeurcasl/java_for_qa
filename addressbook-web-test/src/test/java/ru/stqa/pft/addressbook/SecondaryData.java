package ru.stqa.pft.addressbook;

public class SecondaryData {
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

        public SecondaryData(String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String address2, String phone2, String notes) {
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