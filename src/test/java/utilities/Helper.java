package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    //screenshot when the TC fail
    public static void captureScreenshot(WebDriver driver,String screenshotName)
    {
        Path destination = Paths.get("./screenshots",screenshotName+".png");
        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream out= new FileOutputStream(destination.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
