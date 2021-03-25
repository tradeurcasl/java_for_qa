package ru.stqa.pft.addressbook.test;

import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;


public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("8","Test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
        app.getNavigationHelper().returnToHomePage();
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        app.getNavigationHelper().returnToHomePage();
    }

}