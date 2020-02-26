package steps;

import io.qameta.allure.Step;
import pages.AvatarPage;
import pages.MyUpdatesPage;

public class AvatarSteps  {
    MyUpdatesPage page;
    AvatarPage avatar;
    public AvatarSteps (){
    avatar = new AvatarPage();
    }

    @Step("change avatar in settings")
    public AvatarSteps changeAvatar(int imgNumber){
        avatar.openPage()
                .changeImg(imgNumber);
        return this;
    }

}
