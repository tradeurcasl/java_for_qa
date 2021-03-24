package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;


public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            int before = app.getGroupHelper().getGroupCount();
            app.getGroupHelper().initGroupModification();
            app.getGroupHelper().fillGroupForm(new GroupData("TestEdit", null, null));
            app.getGroupHelper().submitGroupModification();
            app.getNavigationHelper().gotoGroupPage();
            int after = app.getGroupHelper().getGroupCount();
            Assert.assertEquals(after, before);
        }
    }
}
