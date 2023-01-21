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


}
