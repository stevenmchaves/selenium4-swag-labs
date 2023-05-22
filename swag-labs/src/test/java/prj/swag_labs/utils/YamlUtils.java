package prj.swag_labs.utils;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import prj.swag_labs.data.AccountInfo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static prj.swag_labs.data.AccountInfo.ACCOUNTS_YAML;

public class YamlUtils {

    public static List<AccountInfo> readAccountFile(String filePath) throws IllegalArgumentException {
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

    public static void main(String[] args) {
        for (AccountInfo account : YamlUtils.readAccountFile(ACCOUNTS_YAML)) {
            System.out.println(account);
        }
    }
}