package com.tpa.toyproject_api.Login.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("sang777", "eunsang", "asdzxc789"));
        userList.add(new User("ksg1885", "sangkyu", "123456"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public LoginResponse handleLogin(@RequestBody LoginRequest loginRequest) {
        String userId = loginRequest.getUserId();
        String userPassword = loginRequest.getUserPassword();

        // 사용자 인증
        for (User user : userList) {
            if (user.getUserId().equals(userId) && user.getUserPassword().equals(userPassword)) {
                return new LoginResponse("success", "Login success", user.getUserName());
            }
        }

        return new LoginResponse("fail", "Invalid credentials", null);
    }

    static class User {
        private String userId;
        private String userName;
        private String userPassword;

        public User(String userId, String userName, String userPassword) {
            this.userId = userId;
            this.userName = userName;
            this.userPassword = userPassword;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
    }

    static class LoginRequest {
        private String userId;
        private String userPassword;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
    }

    static class LoginResponse {
        private String status;
        private String message;
        private String userName;

        public LoginResponse(String status, String message, String userName) {
            this.status = status;
            this.message = message;
            this.userName = userName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
