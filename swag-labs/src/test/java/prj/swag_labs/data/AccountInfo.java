package prj.swag_labs.data;

import prj.swag_labs.utils.YamlUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;


public class AccountInfo {
    private String username;
    private String password;

    static List<AccountInfo> accounts;

    public static final String ACCOUNTS_YAML = "accounts.yaml";

    static {
        try {
            accounts = YamlUtils.readAccountFile(ACCOUNTS_YAML);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(ACCOUNTS_YAML + " doesn't exist!");
        }
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
