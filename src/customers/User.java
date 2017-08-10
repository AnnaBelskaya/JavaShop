package customers;

public class User {
    private int id;
    private String name;
    private String email;
    private String date;
    private boolean subs;

    public User() {
        id = 0;
        name = "";
        email = "";
        date = "";
        subs = false;
    }

    public User(int id, String name, String email, String date, boolean subs) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.subs = subs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSubs() {
        return subs;
    }

    public void setSubs(boolean subs) {
        this.subs = subs;
    }
}
