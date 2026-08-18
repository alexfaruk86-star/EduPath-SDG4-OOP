package model;

public abstract class User {

    private String id;
    private String name;
    private String password;


    public User(String id, String name, String password) {

        this.id = id;
        this.name = name;
        this.password = password;

    }


    // Getter methods

    public String getId() {

        return id;

    }


    public String getName() {

        return name;

    }


    public String getPassword() {

        return password;

    }


    // Setter methods

    public void setName(String name) {

        this.name = name;

    }


    public void setPassword(String password) {

        this.password = password;

    }


    // Abstract method

    public abstract void displayDashboard();

}