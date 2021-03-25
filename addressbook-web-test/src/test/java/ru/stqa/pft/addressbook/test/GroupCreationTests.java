package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import java.util.List;
import java.util.HashSet;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      List<GroupData> before = app.getGroupHelper().getGroupList();
      GroupData group = new GroupData(0,"Test1", null, null);
      app.getGroupHelper().createGroup(group);
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size() + 1);
      int max = 0;
      for (GroupData g : after) {
        if (g.getId() > max) {
          max = g.getId();
        }
      }
      group.setId(max);
      before.add(group);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
