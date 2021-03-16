package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1", "Test2","Test3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
