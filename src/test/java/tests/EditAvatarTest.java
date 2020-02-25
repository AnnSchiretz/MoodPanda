package tests;

import org.testng.annotations.Test;

public class EditAvatarTest extends BaseTest {
    @Test
    public void editAvatar(){
        avatar.changeAvatar(2);
    }
}
