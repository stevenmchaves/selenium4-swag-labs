package prj.swag_labs.data;

import prj.swag_labs.utils.YamlUtils;

import java.util.List;

/**
 * Data Object Class used to get data from YAML file
 */
public class AccountInfo {
    private String username;
    private String password;

    private String account;

    static List<AccountInfo> accounts;

    public static final String ACCOUNTS_YAML = "accounts.yaml";

    static {
        accounts = YamlUtils.readAccountFile(ACCOUNTS_YAML);
    }

    /**
     * Looks through the list of users that are known and returns the account
     * that matches the given username
     * @param username String of username trying to find
     * @return AccountInfo object or null
     */
    public static AccountInfo findAccount(String accountName) {
        AccountInfo accountInfo = null;
        for (AccountInfo account : accounts) {
            if (account.account.equals(accountName)) {
                accountInfo = account;
                break;
            }
        }
        return accountInfo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
                ", account='" + account + '\'' +
                '}';
    }
}
