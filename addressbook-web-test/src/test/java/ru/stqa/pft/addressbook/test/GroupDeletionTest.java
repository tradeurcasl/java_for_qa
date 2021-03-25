package ru.stqa.pft.addressbook.test;

import ru.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Set;
import org.testng.annotations.BeforeMethod;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("Test1"));
        }
    }
    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }
    }
