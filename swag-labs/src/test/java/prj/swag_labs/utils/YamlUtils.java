package prj.swag_labs.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import prj.swag_labs.data.AccountInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static prj.swag_labs.data.AccountInfo.ACCOUNTS_YAML;

public class YamlUtils {

    public static List<AccountInfo> readAccountFile(String filePath) throws FileNotFoundException {
        List<AccountInfo> accounts = new ArrayList<>();
        ClassLoader classLoader = YamlUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filePath);
        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + filePath);
        }
        Constructor constructor = new Constructor(AccountInfo.class);
        Yaml yaml = new Yaml(constructor);
        for (Object object : yaml.loadAll((inputStream))) {
            if (object instanceof AccountInfo) {
                accounts.add((AccountInfo) object);
            } else {
                System.out.println(object.toString() + " is an invalid Account");
            }
        }
        return accounts;
    }

    public static void main(String[] args) throws FileNotFoundException {
        for (AccountInfo account : YamlUtils.readAccountFile(ACCOUNTS_YAML)) {
            System.out.println(account);
        }
    }
}