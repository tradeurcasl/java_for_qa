package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import java.util.List;
import java.util.HashSet;
import java.util.Comparator;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      List<GroupData> before = app.getGroupHelper().getGroupList();
      GroupData group = new GroupData(0,"Test1", null, null);
      app.getGroupHelper().createGroup(group);
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size() + 1);
      before.add(group);
      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }
}
