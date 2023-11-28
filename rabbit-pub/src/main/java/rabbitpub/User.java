package rabbitpub;

import java.io.Serializable;

public record User(
    String firstName,
    String lastName,
    String email
) implements Serializable {}

//    public User() {
//    }
//
//    public User(String firstName, String lastName, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
//
//public record UserDto(
//        UUID id,
//        String username,
//        String email,
//        List<String> roles,
//        UUID memberId,
//        String accessToken
//) implements Serializable {
//    public UserDto setAccessToken(String accessToken) {
//        return new UserDto(id, username, email, roles, memberId, accessToken);
//    }
//}
