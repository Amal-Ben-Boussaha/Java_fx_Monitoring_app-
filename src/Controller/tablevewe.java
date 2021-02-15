package Controller;

import javafx.collections.ObservableList;

/**
 *
 * @author Amal Ben Boussaha
 */
public class tablevewe {

    static void setItems(ObservableList<tablevewe> data) {
    }

    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

private String email;
private String password;
private String type;

    public tablevewe(String email, String password, String type) {
        this.email = email;
        this.password = password;
        this.type = type;
    }
}
