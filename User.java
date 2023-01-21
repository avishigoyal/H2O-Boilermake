import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private String state;
    private String county;

    public User(String username, String password, String email, String state, String county) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
        this.county = county;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCounty(String county) {
        this.county = county;
    }

}
