package utilities;

import constants.TestConfig;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static pageobjects.TestBase.*;

public class ScreenshotTaker {
    public static void takeIfFailed(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM HH.MM.ss");
            String fileName = format.format(new Date());
            File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(TestConfig.SCREENSHOT_PATH + fileName + ".png"));
        }
    }
}
