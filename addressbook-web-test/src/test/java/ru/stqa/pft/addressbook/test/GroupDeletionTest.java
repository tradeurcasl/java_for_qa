package ru.stqa.pft.addressbook.test;

import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;
import java.util.Comparator;
import org.testng.annotations.BeforeMethod;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("Test1"));
        }
    }
    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.remove(index);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
    }
