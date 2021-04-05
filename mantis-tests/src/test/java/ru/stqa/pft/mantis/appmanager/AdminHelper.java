package ru.stqa.pft.mantis.appmanager;


import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class AdminHelper extends HelperBase{
    public AdminHelper (ApplicationManager app) {
        super(app);
    }
    public void finish(String confirmationLink, UserData users, String newPassword) {
        wd.get(confirmationLink);
        type(By.name("realname"), users.getRealname());
        type(By.name("password"), newPassword);
        type(By.name("password_confirm"), newPassword);
        click(By.cssSelector("span.bigger-110"));
    }

        public void reset(UserData users){
            click(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", users.getId())));
            click(By.xpath("//form[@id = 'manage-user-reset-form']//input[@type='submit']"));
        }

        public void login(String username, String password) {
            wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
            type(By.name("username"),username);
            click(By.xpath("//form[@id = 'login-form']//input[@type='submit']"));
            type(By.name("password"), password);
            click(By.xpath("//form[@id = 'login-form']//input[@type='submit']"));
        }

        public void manageUsers() {
            wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        }
    }