package Groups;

import org.testng.annotations.Test;

public class GroupsTest {
    @Test(groups = {"b"})
    public void b_test1(){
        System.out.println("In b_test1");
    }

    @Test(groups = {"b"})
    public void b_test2(){
        System.out.println("In b_test2");
    }

    @Test
    public void c_test3(){
        System.out.println("In c_test3");
    }
}
