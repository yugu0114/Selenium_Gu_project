package yandex.webelements;

import org.openqa.selenium.WebDriver;
import yandex.constants.YandexStartPageConsts;

/**
 * Created by 1 on 20.06.2017.
 */
public class YandexBasePage {

    public YandexBasePage(WebDriver webDriver){
        if (!webDriver.getCurrentUrl().contains(YandexStartPageConsts.YANDEX_DOMAIN)) {
            throw new IllegalStateException("This is not the yandex page");
        }
    }
}
