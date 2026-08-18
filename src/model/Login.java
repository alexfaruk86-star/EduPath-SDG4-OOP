package model;

public class Login {

    public static User authenticate(
            String id,
            String password,
            User[] users) {

        for (User user : users) {

            if (user.getId().equals(id)
                    && user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }
}