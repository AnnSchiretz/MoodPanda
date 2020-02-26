package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class EditAvatarTest extends BaseTest {
    @Test
    public void editAvatar(){
        avatar.changeAvatar(2);
    }
}
