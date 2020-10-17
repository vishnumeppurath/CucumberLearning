package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {
    public static List<String> getSelectOptionsValue(Select select){
        List<WebElement> selectOptoins=select.getOptions();
        List<String> options=new ArrayList<>();
        for (WebElement item:selectOptoins) {
            options.add(item.getText());

        }
        return options;
    }
}
